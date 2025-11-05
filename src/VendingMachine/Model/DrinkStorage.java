package VendingMachine.Model;

import java.util.Stack;

public class DrinkStorage {
    private final Stack<Drink> drinks = new Stack<>();
    public DrinkStorage() {}
    public void addDrink(Drink drink) { drinks.push(drink); }
    public Drink getDrink() { return drinks.pop(); }
    public int getDrinksStock() { return drinks.size(); }
}
