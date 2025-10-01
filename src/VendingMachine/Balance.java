package VendingMachine;

// 돈 계산 클래스
// 돈을 클래스로 만드려다가 돈 관련을 클래스로 만들었음
// 돈 자체를 객체로 관리
public class Balance {
    // 변수 목록: 각 단위별 보유 돈 배열, 보유 금액
    // 100원, 500원, 1000원, 5000원, 10000원, 50000원이 있음(배열 순서는 역순)
    // 돈이 아무리 많아도 + 100원이 아무리 많아도 21억개 있지는 않을테니 short(32767)로 제한
    short[] moneyArray = new short[6];
    int totalMoney; // 자판기가 가지고 있는 돈도 short 범위를 넘어가니 int타입으로 지정

    // 기본 생성자
    // 생성 시 돈 확인 및 분류
    Balance(int totalMoney) {
        this.totalMoney = totalMoney;
        moneyArray = reverseCalculation(totalMoney);
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
    short[] reverseCalculation(int money) {
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
}