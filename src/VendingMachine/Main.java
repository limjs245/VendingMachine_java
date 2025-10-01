package VendingMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VendingMachine VM = new VendingMachine();
        You customer = new You();
        int money = 0;

        System.out.print("가지고 싶은 돈 액수를 입력하세요: ");
        try {
            money = sc.nextShort();
        } catch (Exception e) {
            System.out.println("너무 큰 단위입니다.");
        }

        customer.getMoney(money);

        System.out.println(customer.money);
    }
}

// 남은 음료수 개수 보여주기(없을 때 x뜨기, 있으면 숫자 뜨기)
// 돈 받기(돈 입력 & 받은 돈 뜨기)
// 음료 나열해서 보여주기 & Light 점등하기
// 음료 선택 받기 & 선택받은 음료 띄우기)
// Light 끄기
// 음료 주기
// 잔돈 주기
// 남은 음료수 개수 수정하기

// 음료 정보 확인
// 상품 낙하 랜덤으로 잘못 낙하돼서 터지게 하기
//