package VendingMachine.Algorithm;

import java.util.concurrent.TimeUnit;

public class RUN {
    private final int[][] drinkStock = new int[2][5];
    private final PopUpWindow popup;

    public RUN(PopUpWindow popup) {
        this.popup = popup;
    }

    public boolean StartVendingMachine() {
        final String answerOfStart = openPopUp(popup, "START: yes | no", true);

        switch (answerOfStart) {
            case "yes", "YES":
                setDrinkStock();
                break;
            case "no", "NO":
                popup.closeScanner();
                return false;
            default:
                openPopUp(popup, "Wrong Input or Error-001", false);
                return StartVendingMachine();
        }
        return true;
    }

    private String[] setDrinkStock() {
        final String stock = openPopUp(popup, "DrinkStorage Stock[,,,,,,,,,]", true);
        String[] stockArrayOfString = stock.split(",");

        if (stockArrayOfString.length != 10) {
            openPopUp(popup, "Wrong Input or Error-002", false);
            stockArrayOfString = setDrinkStock();
        } else {
            try {
                for (int i = 0; i < stockArrayOfString.length; i++) {
                    drinkStock[i / 5][i % 5] = Integer.parseInt(stockArrayOfString[i]);
                }

                updateVendingMachine(new int[]{0, 0});
            } catch (Exception e) {
                openPopUp(popup, "Wrong Input or Error-003", false);
                setDrinkStock();
            }
        }
        return stockArrayOfString;
    }

    public String openPopUp(PopUpWindow popup, String popUpMessage, boolean isInput) {
        if (isInput) {
            return popup.createPopUp(popUpMessage, true);
        } else {
            popup.createPopUp(popUpMessage, false);
            return "0";
        }
    }

    private VendingMachine updateVendingMachine(int[] isDrinkOut) {
        boolean[][] drinkStockNotZero = new boolean[2][5];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                drinkStockNotZero[i][j] = drinkStock[i][j] > 0;
            }
        }

        VendingMachine VM = new VendingMachine(isDrinkOut, drinkStockNotZero);
        VM.createBody();
        return VM;
    }

    public boolean drinkDischarge(PopUpWindow popUp, String input) {
        if (input.equals("e")) {
            popUp.closeScanner();
            return false;
        } else {
            try {
                final int drinkNumber = Integer.parseInt(input);

                if (drinkNumber <= 10 && drinkNumber > 0) {
                    if (drinkStock[(drinkNumber - 1) / 5][(drinkNumber - 1) % 5] > 0) {
                        drinkStock[(drinkNumber - 1) / 5][(drinkNumber - 1) % 5] -= 1;
                        VendingMachine VM = updateVendingMachine(new int[]{1, drinkNumber});
                        TimeUnit.SECONDS.sleep(2);
                        updateVendingMachine(new int[]{0, 0});
                        TimeUnit.SECONDS.sleep(2);
                        VM.openDrinkInfo(drinkNumber);
                    } else {
                        openPopUp(popUp, "Sold Out", false);
                    }
                } else {
                    popUp.createPopUp("Press 1 to 10 drinks or 'e'", false);
                }
            } catch (Exception e) {
                popUp.createPopUp("Press 1 to 10 drinks or 'e'", false);
            }
        }
        return true;
    }
}
