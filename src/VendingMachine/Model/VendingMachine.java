package VendingMachine.Model;

import VendingMachine.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VendingMachine {
    private final List<MachineChangeListener> machineListeners = new ArrayList<>();
    private final List<DrinkInfoPopUpListener>  drinkInfoPopUpListeners = new ArrayList<>();
    private final Controller controller;
    private final List<Integer> drinkStock =  new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    private final Inventory inventory;
    public int outDrinkNum = -1;
    public Map<String, String> drinkInfo;

    public VendingMachine(Controller controller) {
        this.controller = controller;
        this.inventory = new Inventory(this);
        CallVendingMachine();
    }

    public void start() {
        inventory.firstSetting();
    }

    public void CallVendingMachine() { notifyMachineListeners(); }

    public void CallDrinkInfoPopUp() {
        notifyDrinkListeners();
        controller.nextState();
    }

    public void getDrink(int drinkNum) {
        drinkInfo = inventory.getDrink(drinkNum);
        setDrinkStock();
        outDrinkNum = drinkNum;
        CallVendingMachine();
        try {
            TimeUnit.SECONDS.sleep(1);
        }  catch (InterruptedException e) {
            e.printStackTrace();
        }
        outDrinkNum = -1;
        CallVendingMachine();
        controller.nextState();
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

    public void addMachineListener(MachineChangeListener listener) { machineListeners.add(listener); }

    public void notifyMachineListeners() {
        for (MachineChangeListener listener : machineListeners) {
            listener.onMachineChange();
        }
    }

    public void addDrinkListener(DrinkInfoPopUpListener listener) { drinkInfoPopUpListeners.add(listener); }

    public void notifyDrinkListeners() {
        for (DrinkInfoPopUpListener listener : drinkInfoPopUpListeners) {
            listener.showDrinkInfoPopUp();
        }
    }
}