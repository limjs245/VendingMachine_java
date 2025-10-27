package VendingMachine;

import VendingMachine.Model.User;

public class Controller {
    private static int State; // 0: start, 1: popUpAndAnimation, 2: drinkInfoPopUp, 3: end

    public Controller() {}

    public static int getState() { return State; }

    public static void setState(int state) { State = state; }

    public static void start() {
        setState(0);
        State();
    }

    public static void stop() {
        setState(3);
        State();
    }

    public static void nextState() {
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

    private static void State() {
        int state = getState();
        User user = new User();

        if (state == 0) {
            user.start();
        } else if (state == 1) {

        }  else if (state == 2) {

        }  else if (state == 3) {

        } else {
            stop();
        }
    }
}
