package VendingMachine.Model;

import VendingMachine.Controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserCommunicate {
    private final Controller controller;
    private final Scanner sc = new Scanner(System.in);
    private final List<PopUpChangeListener> listeners = new ArrayList<PopUpChangeListener>();
    private String message;
    private final ArrayList<String> messageList = new ArrayList<>(List.of(
            "Would you like to start?", // 0
            "Please set your starting balance.", // 1
            "Please choose an option.", // 2
            "Please insert money.", // 3
            "Please select a drink number.", // 4
            "Insufficient funds.", // 5
            "Invalid input.", // 6
            "Sold out.", // 7
            "Shutting down." // 8
    ));

    public UserCommunicate(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        String input = "";
        while (true) {
            setMessage(0);
            notifyModelChange();
            input = getInput();
            switch (input) {
                case "yes":
                    controller.nextState();
                    return;
                case "no":
                    controller.stop();
                    return;
                default:
                    error();
            }
        }
    }

    public String getInput() { return sc.nextLine(); }

    public void end() {
        setMessage(8);
        notifyModelChange();
        closeScanner();
    }

    public int pickDrink() {
        int input = -1;
        while (input < 1 || input > 10) {
            setMessage(4);
            notifyModelChange();
            String temp = getInput();

            if (temp.equals("e")) {
                input = 0;
                break;
            }

            try {
                input = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                error();
            }
        }
        return input - 1;
    }

    public void error() {
        setMessage(6);
        notifyModelChange();
    }

    public void soldOut() {
        setMessage(7);
        notifyModelChange();
    }

    private void closeScanner() {
        sc.close();
    }

    public void addListener(PopUpChangeListener listener) { listeners.add(listener); }

    public void notifyModelChange() {
        for (PopUpChangeListener listener : listeners) { listener.onPopUpChange(); }
    }

    public String getMessage() { return message; }

    private void setMessage(int messageNum) { message = messageList.get(messageNum); }
}
