package VendingMachine;

// 음료수 클래스
// 음료수들을 객체로 관리
// -> 여러 음료수 존재
public class Drink {
    // 변수 목록: id, 이름, 재고, 가격, 타입, 브랜드, 유통기한
    private final int drinkId;
    private final String drinkName;
    private final int price;
    private final String drinkChar;
    private final String drinkType;
    private final String drinkBrand;
    private final String expirationDate;

    // 기본 생성자
    Drink(int drinkId, String drinkName, int price, String drinkChar ,String drinkType, String drinkBrand, String expirationDate) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.price = price;
        this.drinkChar = drinkChar;
        this.drinkType = drinkType;
        this.drinkBrand = drinkBrand;
        this.expirationDate = expirationDate;
    }

    // 음료 정보를 반환하는 함수
    // 이름, 타입, 브랜드, 유통기한, 가격을 알려줌
    public int getDrinkId() {
        return drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getPrice() {
        return price;
    }

    public String getDrinkChar() {
        return drinkChar;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public String getDrinkBrand() {
        return drinkBrand;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    // 구입에 필요한 금액에 도달했는지 알려주는 함수
    // 충분하지 않으면 -1, 가격만큼의 금액이면 0, 더 충분하면 1을 반환
    // boolean 값으로는 3가지의 상태를 반환하지 못하기 때문에 byte를 씀
    public int isSufficientMoney(short money) {
        if(money == price) {
            return 0;
        } else if (money > price) {
            return 1;
        }

        return -1;
    }
}
