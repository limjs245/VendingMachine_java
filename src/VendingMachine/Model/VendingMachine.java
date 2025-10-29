package VendingMachine.Model;

import VendingMachine.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// 자판기 자체
// Main과 분리
// 하위 클래스 존재
// 하위 클래스 목록: Button
// 다른 파일로 분리하는게 불필요해 보여서 하위 클래스로 만듬
public class VendingMachine {
    private final List<ModelChangeListener> listeners = new ArrayList<>();
    private Controller controller;
    private int State; // 0: start 1: default, 2: dischargeDrink
    private final List<Integer> drinkStock =  new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    private final Inventory inventory;
    public int outDrinkNum;

    public VendingMachine(Controller controller) {
        this.controller = controller;
        this.inventory = new Inventory(this);
        this.State = 0;
        State();
    }

    private void State() {
        if (State == 0) {
            inventory.firstSetting();
            notifyListeners();
        } else if (State == 1) {
            notifyListeners();
        } else if (State == 2) {
            notifyListeners();
            try {
                TimeUnit.SECONDS.sleep(2);
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
            State = 2;
            State();
        }
    }
    private Map<String, String> getDrink(int drinkNum) {
        Map<String, String> drinkInfo = inventory.getDrink(drinkNum);
        setDrinkStock();
        outDrinkNum = drinkNum;
        State = 3;
        State();
        return drinkInfo;
    }
    public void setDrinkStock() {
        for (int i = 0; i < 10; i++) {
            drinkStock.set(i, inventory.getDrinkStock(i));
        }
    }
    public int getDrinkStock(int drinkNum) {
        setDrinkStock();
        return drinkStock.get(drinkNum);
    }
    public Map<String, String> getDrinkInfo(int drinkNum) { return inventory.getDrinkInfo(drinkNum); }
    public void addListener(ModelChangeListener listener) { listeners.add(listener); }
    public void notifyListeners() {
        for (ModelChangeListener listener : listeners) {
            listener.onModelChange();
        }
    }
    public int getState() { return State; }
}