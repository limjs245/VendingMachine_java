package VendingMachine.UI;

public class PopUpUI {

    public String createPopUp(String popUpMessage, boolean isInput) {
        final byte leftPadding = (byte)((36 - popUpMessage.length()) / 2);

        System.out.println("⌈‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾⌉");
        System.out.println("|                                     |");
        System.out.print("|");

        for (int i = 0; i <= leftPadding; i++) System.out.print(" ");
        System.out.print(popUpMessage);
        for (int i = 0; i <= (35 - leftPadding - popUpMessage.length()); i++) System.out.print(" ");

        System.out.println("|");
        System.out.println("|                                     |");
        System.out.println("⌊_____________________________________⌋\n");

        if  (isInput) {
            System.out.print(": ");
            String input = sc.next();
            System.out.println();

            return input;
        } else {
            return "0";
        }
    }

    public void createDrinkPopUp(DrinkStorage drink) {
        final String name = drink.getDrinkName();
        final String price = drink.getPrice() + " 원";
        final String type = "타입: " + drink.getDrinkType();
        final String brand = "브랜드: " + drink.getDrinkBrand();
        final String expirationDate = "유통기한: " + drink.getExpirationDate();
        final String[] drinkInfo = new String[]{name, price, type, brand, expirationDate};

        final int leftPaddingOfName = (36 - name.length()) / 2;
        final int leftPaddingOfPrice = (36 - price.length()) / 2;
        final int leftPaddingOfType = (36 - type.length()) / 2;
        final int leftPaddingOfBrand = (36 - brand.length()) / 2;
        final int leftPaddingOfExpirationDate = (36 - expirationDate.length()) / 2;
        final int[] leftPadding = new int[]{leftPaddingOfName, leftPaddingOfPrice, leftPaddingOfType, leftPaddingOfBrand, leftPaddingOfExpirationDate};

        final int[] rightPadding = new int[]{(35 - leftPaddingOfName - name.length()), (35 - leftPaddingOfPrice - price.length() - 1), (35 - leftPaddingOfType - type.length() - 1), (35 - leftPaddingOfBrand - brand.length() - 2), (35 - leftPaddingOfExpirationDate - expirationDate.length() - 3)};

        System.out.println("⌈‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾⌉");

        for (int i = 0; i < drinkInfo.length; i++) {
            System.out.print("|");
            for (int j = 0; j <= leftPadding[i]; j++) System.out.print(" ");
            System.out.print(drinkInfo[i]);
            for (int j = 0; j <= rightPadding[i]; j++) System.out.print(" ");
            System.out.println("|");
        }

        System.out.println("⌊_____________________________________⌋\n");
    }
}
