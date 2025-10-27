package VendingMachine;

import VendingMachine.Model.User;

public class Controller {
    private int State; // 0: start, 1: popUpAndAnimation, 2: drinkInfoPopUp, 3: end

    public Controller() {}

    public int getState() { return State; }

    public void setState(int state) { State = state; }

    public void start() {
        setState(0);
        State();
    }

    public void stop() {
        setState(3);
        State();
    }

    public void nextState() {
        int state = getState();

        if (state == 2) {
            setState(1);
        } else if (state < 2) {
            setState(state + 1);
        } else {
            stop();
        }

        State();
    }

    private void State() {
        int state = getState();
        User user = new User();

        if (state == 0) {
            user.start();
        } else if (state == 1) {
            user.getInput();
        }  else if (state == 2) {
            user.showDrinkInfo();
        }  else if (state == 3) {
            user.closeScanner();
        } else {
            stop();
        }
    }
}
