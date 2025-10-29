package VendingMachine.Model;

import VendingMachine.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserCommunicate {
    private final Controller controller;
    private final Scanner sc = new Scanner(System.in);
    private final List<ModelChangeListener> listeners = new ArrayList<ModelChangeListener>();
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
        setMessage(0);
        String input = getInput();

    }

    public String getInput() {
        notifyModelChange();
        return sc.nextLine();
    }

    public void closeScanner() {
        sc.close();
    }

    public void addListener(ModelChangeListener listener) { listeners.add(listener); }

    public void notifyModelChange() {
        for (ModelChangeListener listener : listeners) { listener.onModelChange(); }
    }

    public String getMessage() { return message; }

    private void setMessage(int messageNum) { message = messageList.get(messageNum); }
}
