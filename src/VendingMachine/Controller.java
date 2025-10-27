package VendingMachine;

import VendingMachine.Model.Balance;
import VendingMachine.Model.UserCommunicate;
import VendingMachine.Model.VendingMachine;
import VendingMachine.View.DrinkUI;
import VendingMachine.View.PopUpUI;
import VendingMachine.View.VendingMachineUI;

public class Controller {
    private VendingMachine machine;
    private UserCommunicate userCommunicate;
    private Balance balance;
    private VendingMachineUI machineUI;
    private PopUpUI popUpUI;
    private DrinkUI drinkUI;
    private int State; // 0: start, 1: popUpAndAnimation, 2: drinkInfoPopUp, 3: end

    public Controller() {
        this.machine = new VendingMachine(this);
        this.userCommunicate = new UserCommunicate(this);
        this.balance = new Balance(this);
        this.machineUI = new VendingMachineUI(machine);
        this.popUpUI = new PopUpUI(userCommunicate);
        this.drinkUI = new DrinkUI();

    }

    public int getState() { return State; }

    public void setState(int state) { State = state; }

    public void start() {
        setState(0);
        StateManage();
    }

    public void stop() {
        setState(3);
        StateManage();
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

        StateManage();
    }

    private void StateManage() {
        int state = getState();

        if (state == 0) {
        } else if (state == 1) {
        }  else if (state == 2) {
        }  else if (state == 3) {
        } else {
            stop();
        }
    }
}
