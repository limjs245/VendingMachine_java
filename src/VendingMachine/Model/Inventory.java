package VendingMachine.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Inventory {
    private final Map<Integer, Integer> drinkStock = new HashMap<>();
    private VendingMachine machine;
    private final List<DrinkStorage> drinkStorages = new ArrayList<>();

    public Inventory(VendingMachine machine) {
        this.machine = machine;
        for (int i = 0; i < 10; i++) {
            DrinkStorage drinkStorage = new DrinkStorage();
            drinkStorages.add(drinkStorage);
        }
    }

    public void firstSetting() {
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            addDrinkStock(i, rand.nextInt(21));
        }
    }

    private Drink drink(int drinkNum) {
        return switch (drinkNum) {
            case 0 -> new Drink("Coca-Cola", "2100원","🔴", "Coca-Cola");
            case 1 -> new Drink("Lemonade", "1500원","🍋", "Snapple");
            case 2 -> new Drink("Fanta", "1800원","🍊", "Coca-Cola");
            case 3 -> new Drink("Evian", "2000원","💠", "Danone");
            case 4 -> new Drink("Teazen black tea iced tea peach", "1500원","🔺", "Teazen");
            case 5 -> new Drink("Gatorade", "2000원","🧊", "PepsiCo");
            case 6 -> new Drink("Monster", "2300원","🌵", "Monster Energy");
            case 7 -> new Drink("T.O.P The Black", "1400원","🫘", "T.O.P");
            case 8 -> new Drink("Welch's Grape Juice", "1500원","🍇", "Welch's");
            case 9 -> new Drink("Prune Juice", "2000원","🍆", "Taylor");
            default -> new Drink("???", "0원","?", "???");
        };
    }
    public void addDrinkStock(int drinkNum, int addCount) {
        Drink drink = drink(drinkNum);
        for (int i = 1; i <= addCount; i++) {
            drinkStorages.get(drinkNum).addDrink(drink);
        }
    }
    public Map<String, String> getDrink(int drinkNum) { return drinkStorages.get(drinkNum).getDrink().getDrinkInfo(); }
    public int getDrinkStock(int drinkNum) { return drinkStorages.get(drinkNum).getDrinksStock(); }
    public Map<String, String> getDrinkInfo(int drinkNum) { return drink(drinkNum).getDrinkInfo(); }
}
