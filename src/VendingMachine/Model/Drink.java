package VendingMachine.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Drink {
    private final String drinkName;
    private final String price;
    private final String drinkChar;
    private final String drinkBrand;
    private final String expirationDate;
    private final Random rand = new Random();

    public Drink(String drinkName, String price, String drinkChar, String drinkBrand) {
        this.drinkName = drinkName;
        this.price = price;
        this.drinkChar = drinkChar;
        this.drinkBrand = drinkBrand;
        this.expirationDate = randomExpirationDate();
    }

    public Map<String, String> getDrinkInfo() {
        Map<String, String> drinkInfo = new HashMap<>();
        drinkInfo.put("name", drinkName);
        drinkInfo.put("price", price);
        drinkInfo.put("char", drinkChar);
        drinkInfo.put("brand", drinkBrand);
        drinkInfo.put("expirationDate", expirationDate);
        return drinkInfo;
    }

    private String randomExpirationDate() {
        int EYear = rand.nextInt(2027 - 2026 + 1) + 2026;
        int EMonth = rand.nextInt(12 - 1 + 1) + 1;
        int EDay = rand.nextInt(31 - 1 + 1) + 1;

        if (EMonth == 2 && (EDay == 29 || EDay == 30 ||  EDay == 31)) {
            EMonth += 1;
            EDay = switch (EDay) {
                case 29 -> 1;
                case 30 -> 2;
                case 31 -> 3;
                default -> 4;
            };
        } else if ((EMonth == 4 ||  EMonth == 6 || EMonth == 9 || EMonth == 11) && EDay == 31) {
            EMonth += 1;
            EDay = 1;
        }
        return EYear + "." + EMonth + "." + EDay;
    }
}
