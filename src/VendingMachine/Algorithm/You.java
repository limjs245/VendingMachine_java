package VendingMachine.Algorithm;

// 김수민

// 고객 클래스
// 고객을 객체로 만들어서 관리
// 고객별로 다를 수 있게 만들기
public class You {
    int money = 0;

    // 기본 생성자
    You() {}

    // 돈을 얻었을 때
    void getMoney(int money) {
        this.money += money;
    }

    // 자판기에 지출했을 때
    void spendMoney(int money) {
        this.money -= money;
    }
}
