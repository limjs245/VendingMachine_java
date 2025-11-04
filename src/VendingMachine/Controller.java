package VendingMachine;

import VendingMachine.Model.Balance;
import VendingMachine.Model.UserCommunicate;
import VendingMachine.Model.VendingMachine;
import VendingMachine.View.DrinkInfoPopUpUI;
import VendingMachine.View.PopUpUI;
import VendingMachine.View.VendingMachineUI;

import java.util.concurrent.TimeUnit;

public class Controller {
    private final VendingMachine machine;
    private final UserCommunicate userCommunicate;
    private final Balance balance;
    private int State; // 0: start, 1: popUp&Animation, 2: drinkInfoPopUp, 3: end

    public Controller() {
        this.machine = new VendingMachine(this);
        this.userCommunicate = new UserCommunicate(this);
        this.balance = new Balance(this);
        VendingMachineUI machineUI = new VendingMachineUI(machine);
        PopUpUI popUpUI = new PopUpUI(userCommunicate);
        DrinkInfoPopUpUI drinkInfoPopUpUI = new DrinkInfoPopUpUI(machine);
    }

    public int getState() { return State; }

    public void setState(int state) {
        State = state;
        State();
    }

    public void start() { setState(0); }

    public void stop() { setState(3); }

    public void nextState() {
        int state = getState();

        switch (state) {
            case 0:
                setState(1);
                break;
            case 1:
                timeSleep(1);
                setState(2);
                break;
            case 2:
                timeSleep(2);
                setState(1);
                break;
            default: setState(3);
        }
    }

    private void timeSleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void State() {
        int state = getState();

        if (state == 0) {
            machine.start();
            userCommunicate.start();
        } else if (state == 1) {
            machine.CallVendingMachine();
            int pickDrinkNum = userCommunicate.pickDrink();

            if (pickDrinkNum == -1) {
                stop();
                return;
            }

            if (machine.getDrinkStock(pickDrinkNum) > 0) {
                machine.getDrink(pickDrinkNum);
            } else {
                userCommunicate.soldOut();
                setState(1);
            }
        }  else if (state == 2) {
            machine.CallDrinkInfoPopUp();
        } else if (state == 3) {
            userCommunicate.end();
        } else {
            stop();
        }
    }
}
