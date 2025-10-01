package VendingMachine;

// 음료수 클래스
// 음료수들을 객체로 관리
// -> 여러 음료수 존재
public class Drink {
    // int -> short 또는 byte로 바꿈: 메모리 줄이기...
    // short: 32,767 보다 작은 값들이기 때문에 바꿈
    // byte: 127보다 작은 값들이기 때문에 바꿈
    // 변수 목록: id, 이름, 재고, 가격, 타입, 브랜드, 유통기한
    byte drinkId; // 127가지의 음료를 파는 자판기 없음
    String drinkName;
    byte stock; // 자판기가 감히 127개 이상의 재고를 가질리가 없음
    short price; // 3만원대 음료수 없음
    String drinkType;
    String drinkBrand;
    String expirationDate;

    // 기본 생성자
    Drink(byte drinkId, String drinkName, byte stock, short price,  String drinkType, String drinkBrand, String expirationDate) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.stock = stock;
        this.price = price;
        this.drinkType = drinkType;
        this.drinkBrand = drinkBrand;
        this.expirationDate = expirationDate;
    }

    // 음료 정보를 반환하는 함수
    // 이름, 타입, 브랜드, 유통기한, 가격을 알려줌
    String[] drinkInfo() {
        return new String[]{drinkName, drinkType, drinkBrand, expirationDate, String.valueOf(price)};
    }

    // 구입에 필요한 금액에 도달했는지 알려주는 함수
    // 충분하지 않으면 -1, 가격만큼의 금액이면 0, 더 충분하면 1을 반환
    // boolean 값으로는 3가지의 상태를 반환하지 못하기 때문에 byte를 씀
    byte isSufficientMoney(short money) {
        if(money == price) {
            return 0;
        } else if (money > price) {
            return 1;
        }

        return -1;
    }
}
