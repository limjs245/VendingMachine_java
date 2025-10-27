package VendingMachine;

public class Controller {
    private int State; // 0: start, 1: popUp, 2: drinkOut, 3: drinkInfoPopUp, 4: end

    public Controller() {}

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }


}
