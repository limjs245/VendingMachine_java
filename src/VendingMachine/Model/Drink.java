package VendingMachine.Model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Drink {
    private final String drinkName;
    private final String drinkChar;
    private final String drinkBrand;
    private final Date expirationDate;

    public Drink(String drinkName, String drinkChar, String drinkBrand, Date expirationDate) {
        this.drinkName = drinkName;
        this.drinkChar = drinkChar;
        this.drinkBrand = drinkBrand;
        this.expirationDate = expirationDate;
    }

    public Map<String, String> getDrinkInfo() {
        Map<String, String> drinkInfo = new HashMap<>();
        drinkInfo.put("name", drinkName);
        drinkInfo.put("char", drinkChar);
        drinkInfo.put("brand", drinkBrand);
        drinkInfo.put("expirationDate", expirationDate.toString());
        return drinkInfo;
    }
}
