package VendingMachine;

// 신재윤

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Start start = new Start();

        while (true) {
            byte pickDrinkNumber = (byte)Integer.parseInt(start.openPopUp("pickDrink", "Which do you want to pick(number)", true));
            start.drinkDischarge(pickDrinkNumber);
        }
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

class Start {
    int[][] drinkStock = new int[2][5];

    Start() {
        PopUpWindow popup = new PopUpWindow("popup1");

        String answerOfStart = openPopUp("startPopUp", "START: yes | no", true);

        switch (answerOfStart) {
            case "yes", "YES":
                String stock = openPopUp("stockPopUp", "Drink Stock[,,,,,,,,,]", true);
                String[] stockArrayOfString = separationCommas(stock);

                if (stockArrayOfString.length != 10) {
                    openPopUp("Error", "Wrong Input or Error", false);
                    Start reStart = new Start();
                }

                try {
                    for (int i = 0; i < stockArrayOfString.length; i++) {
                        drinkStock[i / 5][i % 5] = Integer.parseInt(stockArrayOfString[i]);
                    }

                    updateVendingMachine(false);
                } catch (NumberFormatException e) {
                    openPopUp("Error", "Wrong Input or Error", false);
                    Start reStart = new Start();
                }
                break;
            case "no", "NO":
                break;
            default:
                openPopUp("Error", "Wrong Input or Error", false);
        }
    }

    String openPopUp(String popUpName, String popUpMessage, boolean isInput) {
        PopUpWindow popup = new PopUpWindow(popUpName);

        if (isInput) {
            return popup.createPopUp(popUpMessage, true);
        } else {
            popup.createPopUp(popUpMessage, false);
            return "0";
        }
    }

    String[] separationCommas(String input) {
        String[] commas = input.split(",");
        return commas;
    }

    void updateVendingMachine(boolean isDrinkOut) {
        VendingMachine VM = new VendingMachine();
        VM.drinkStockNotZero = new boolean[2][5];

        for (int i = 0; i < drinkStock.length; i++) {
            for (int j = 0; j < drinkStock[i].length; j++) {
                VM.drinkStockNotZero[i][j] = drinkStock[i][j] > 0;
            }
        }
        VM.isDrinkOut =  isDrinkOut;
        VM.createBody();
    }

    void drinkDischarge(byte drinkNumber) {
        if (drinkNumber <= 10) {
            if (drinkStock[(drinkNumber - 1) / 5][(drinkNumber - 1) % 5] > 0) {
                drinkStock[(drinkNumber - 1) / 5][(drinkNumber - 1) % 5] -= 1;

                updateVendingMachine(true);

                try {
                    TimeUnit.SECONDS.sleep(2); // 1초 동안 지연
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                updateVendingMachine(false);
            } else {
                openPopUp("Error", "Sold Out", false);
            }
        }
    }
}