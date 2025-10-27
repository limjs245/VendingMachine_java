package VendingMachine.Algorithm;

// 자판기 자체
// Main과 분리
// 하위 클래스 존재
// 하위 클래스 목록: Button
// 다른 파일로 분리하는게 불필요해 보여서 하위 클래스로 만듬
public class VendingMachine {
    private final int[] isDrinkOut;
    private final boolean[][] drinkStock;

    private final DrinkStorage[] drinks = new DrinkStorage[]{};

    public VendingMachine(int[] isDrinkOut, boolean[][] drinkStock) {
        this.isDrinkOut = isDrinkOut;
        this.drinkStock = drinkStock;
    }

    private DrinkStorage getDrink(int id) {
        DrinkStorage drink = drinks[0];
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i].getDrinkId() == id) {
                drink =  drinks[i];
            }
        }
        return drink;
    }

    public void openDrinkInfo(int id) {
        User popUp = new User();
        popUp.createDrinkPopUp(getDrink(id));
    }

    private static class Button {
        private final boolean[][] drinkStock;

        Button(boolean[][] drinkStock) {
            this.drinkStock = drinkStock;
        }
    }
}