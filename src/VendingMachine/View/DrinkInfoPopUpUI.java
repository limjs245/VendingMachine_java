package VendingMachine.View;

import VendingMachine.Model.DrinkInfoPopUpListener;
import VendingMachine.Model.VendingMachine;

import java.util.Map;

public class DrinkInfoPopUpUI implements DrinkInfoPopUpListener {
    private final VendingMachine machine;
    public DrinkInfoPopUpUI(VendingMachine machine) {
        this.machine = machine;
        this.machine.addDrinkListener(this);
    }

    public void createDrinkPopUp(Map<String, String> drinkInfoMap) {
        final String name = drinkInfoMap.get("name");
        final String price = drinkInfoMap.get("price");
        final String brand = "브랜드: " + drinkInfoMap.get("brand");
        final String expirationDate = "유통기한: " + drinkInfoMap.get("expirationDate");
        final String[] drinkInfo = new String[]{name, price, brand, expirationDate};

        final int leftPaddingOfName = (36 - name.length()) / 2;
        final int leftPaddingOfPrice = (36 - price.length()) / 2;
        final int leftPaddingOfBrand = (36 - brand.length()) / 2;
        final int leftPaddingOfExpirationDate = (36 - expirationDate.length()) / 2;
        final int[] leftPadding = new int[]{leftPaddingOfName, leftPaddingOfPrice, leftPaddingOfBrand, leftPaddingOfExpirationDate};

        final int[] rightPadding = new int[]{(35 - leftPaddingOfName - name.length()), (35 - leftPaddingOfPrice - price.length() - 1), (35 - leftPaddingOfBrand - brand.length() - 2), (35 - leftPaddingOfExpirationDate - expirationDate.length() - 3)};

        System.out.println("\n⌈‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾⌉");

        for (int i = 0; i < drinkInfo.length; i++) {
            System.out.print("|");
            for (int j = 0; j <= leftPadding[i]; j++) System.out.print(" ");
            System.out.print(drinkInfo[i]);
            for (int j = 0; j <= rightPadding[i]; j++) System.out.print(" ");
            System.out.println("|");
        }

        System.out.println("⌊_____________________________________⌋\n");
    }

    @Override
    public void showDrinkInfoPopUp() {
        createDrinkPopUp(machine.drinkInfo);
    }
}
