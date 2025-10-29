package VendingMachine;

// 돈 계산 클래스
// 돈을 클래스로 만드려다가 돈 관련을 클래스로 만들었음
// 돈 자체를 객체로 관리
public class Balance {
    // 변수 목록: 각 단위별 보유 돈 배열, 보유 금액
    // 100원, 500원, 1000원, 5000원, 10000원, 50000원이 있음(배열 순서는 역순)
    // 돈이 아무리 많아도 + 100원이 아무리 많아도 21억개 있지는 않을테니 short(32767)로 제한
    //private 사용해서 외부에서 접근불가 addMoney와 같은 허가된 기능을 통해서 접근가능
    private short[] moneyArray = new short[6];
    private int totalMoney; // 자판기가 가지고 있는 돈도 short 범위를 넘어가니 int타입으로 지정

    //화폐단위 상수를 정의
    private static final int[] type = {50000, 10000, 5000, 1000, 500, 100};

    // 기본 생성자
    // 생성 시 돈 확인 및 분류
    Balance(int totalMoney) {
        this.totalMoney = totalMoney;
        moneyArray = split(totalMoney);
    }

    // 총 금액 계산
    // 돈 배열을 이용해서 총 금액(int) 반환
    int Calculate(short[] money) {
        return money[0] * 50000 +  money[1] * 10000 + money[2] * 5000 + money[3] * 1000 + money[4] * 500 + money[5] * 100;
    }

    // 총 금액으로 역계산
    // 총 금액을 이용해서 돈 배열(short[])반환
    //
    // 금액을 분류할 때에는 다음의 규칙을 따름
    //
    // 1. 더 큰 금액으로 분류할 수 있을 때에는 구태여 작은 금액으로 쪼개지 않는다.
    // 2. 총 금액은 1억원 미만이여야 한다.
    // 3. 총 금액은 적어도 100원으로 나누어 떨어져야 한다.
    //
    // => 2, 3번 경우일 때는 각각 -1, -2(오류) 반환
    short[] split(int money) {
        if (money > 100000000) { // 총 금액이 1억이 넘어가면 오류(-1) 반환
            return new short[] {-1};
        }

        short money_50000 = (short)(money / 50000);
        money %= 50000;
        short money_10000 =  (short)(money / 10000);
        money %= 10000;
        short money_5000 = (short)(money / 5000);
        money %= 5000;
        short money_1000 = (short)(money / 1000);
        money %= 1000;
        short money_500 = (short)(money / 500);
        money %= 500;
        short money_100 = (short)(money / 100);
        money %= 100;

        if (money != 0) { // 총 금액이 100원으로도 안 나누어 떨어지면 오류(-2) 반환
            return new short[] {-2};
        }

        return new short[] {money_50000, money_10000, money_5000, money_1000, money_500, money_100};
    }


     //자판기에 돈을 추가하는 메서드. (총액과 화폐 단위별 재고를 늘림)
     //amount 추가할 금액
     //추가 성공 시 true, 실패(금액 오류) 시 false
    public boolean addMoney(int amount) {
        if (amount <= 0) {
            System.out.println("0원 이하의 금액은 추가할 수 없습니다.");
            return false;
        }

        //추가할 금액을 화폐 단위별 개수로 분리
        short[] addedStock = split(amount);

        //오류 코드를 체크하는 로직 추가
        if (addedStock.length == 1) {
            if (addedStock[0] == -1) {
                System.out.println("금액 추가 오류: 1억 원을 초과하는 금액입니다.");
            } else if (addedStock[0] == -2) {
                System.out.println("금액 추가 오류: 100원 단위가 아닌 금액입니다.");
            }
            return false; // 오류가 발생했으므로 false 반환
        }

        //보유 재고 업데이트 (오류가 없었을 때만 실행)
        for (int i = 0; i < moneyArray.length; i++) {
            moneyArray[i] += addedStock[i];
        }

        //총액 업데이트
        this.totalMoney += amount;
        System.out.println(amount + "원이 자판기에 추가되었습니다.");
        return true;
    }

    // 요청된 금액만큼 잔돈을 거슬러주는 메소드.(재고를 차감)
    public short[] dispenseChange(int due) { //due: 거슬러 줄 금액
        if (due <= 0) {
            return new short[type.length]; // 0원이면 빈 배열 반환
        }

        if (due > totalMoney) {
            System.out.println("자판기 총 잔액(" + totalMoney + "원)이 부족합니다.");
            return null;
        }

        int remaining = due; //remaining: 현재 거슬러야 할 남은 금액
        short[] counts = new short[type.length]; //counts: 거슬러 줄 개수를 임시 기록할 배열

        // 1. 큰 단위부터 잔돈을 거슬러 줄 수 있는지 확인하며 차감 시도
        for (int i = 0; i < type.length; i++) {
            int unit = type[i];

            // 현재 단위로 최대한 거슬러 줄 수 있는 개수 (이론상)
            short maxCount = (short) (remaining / unit); //maxCount: 이론적 최대 개수

            // 2. 실제 자판기가 가진 재고와 비교하여 최종 개수 결정
            short finalCount = (short) Math.min(maxCount, moneyArray[i]); // finalCount는 count로 그대로 둬도 됨

            if (finalCount > 0) {
                // 3. 재고 임시 차감 및 기록
                moneyArray[i] -= finalCount;
                counts[i] = finalCount;
                remaining -= finalCount * unit;
            }
        }

        // 4. 잔돈을 완벽하게 거슬러주지 못한 경우 (화폐 조합 부족)
        if (remaining > 0) {
            for (int i = 0; i < type.length; i++) {
                moneyArray[i] += counts[i];
            }
            System.out.println("잔돈 조합 부족: " + due + "원을 거슬러 줄 수 없습니다.");
            return null;
        }

        // 5. 성공: 총액 업데이트 및 결과 반환
        totalMoney -= due;
        return counts;
    }
}