package VendingMachine.Algorithm;

// 자판기 자체
// Main과 분리
// 하위 클래스 존재
// 하위 클래스 목록: Button
// 다른 파일로 분리하는게 불필요해 보여서 하위 클래스로 만듬
public class VendingMachine {
    private final int[] isDrinkOut;
    private final boolean[][] drinkStockNotZero;

    final DrinkStorage Cola = new DrinkStorage(1, "Coca-Cola", 2100, "🔴", "soda", "Coca-Cola", "2026.05.05");
    final DrinkStorage Lemonade = new DrinkStorage(2, "Lemonade", 1500, "🍋", "soda", "Snapple", "2026.08.15");
    final DrinkStorage OrangeSoda = new DrinkStorage(3, "Fanta", 1800, "🍊", "soda", "Coca-Cola", "2027.01.26");
    final DrinkStorage Water = new DrinkStorage(4, "Evian", 2000, "💠", "water", "Danone", "2026.04.30");
    final DrinkStorage IcedTea = new DrinkStorage(5, "Teazen black tea iced tea peach", 1500, "🔺", "iced tea", "Teazen", "2026.12.01");
    final DrinkStorage SportsDrink = new DrinkStorage(6, "Gatorade", 2000, "🧊", "sports drink", "PepsiCo", "2026.06.12");
    final DrinkStorage EnergyDrink = new DrinkStorage(7, "Monster", 2300, "🌵", "energy drink", "Monster Energy", "2026.06.03");
    final DrinkStorage Coffee = new DrinkStorage(8, "T.O.P The Black", 1400, "🫘", "coffee", "T.O.P", "2026.08.10");
    final DrinkStorage GrapeJuice = new DrinkStorage(9, "Welch's Grape Juice", 1500, "🍇", "soda", "Welch's", "2027.02.13");
    final DrinkStorage PruneJuice = new DrinkStorage(10, "Prune Juice", 2000, "🍆", "juice", "Taylor", "2026.02.16");

    private final DrinkStorage[] drinks = new DrinkStorage[]{Cola, Lemonade, OrangeSoda, Water, IcedTea, SportsDrink, EnergyDrink, Coffee, GrapeJuice, PruneJuice};

    public VendingMachine(int[] isDrinkOut, boolean[][] drinkStockNotZero) {
        this.isDrinkOut = isDrinkOut;
        this.drinkStockNotZero = drinkStockNotZero;
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
        PopUpWindow popUp = new PopUpWindow();
        popUp.createDrinkPopUp(getDrink(id));
    }

    private static class Button {
        private final boolean[][] drinkStockNotZero;

        Button(boolean[][] drinkStockNotZero) {
            this.drinkStockNotZero = drinkStockNotZero;
        }
    }
}