package VendingMachine.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private final Scanner sc = new Scanner(System.in);
    private final List<ModelChangeListener> listeners = new ArrayList<ModelChangeListener>();

    public User() {}

    public void start() {
        notifyModelChange();
    }

    public void getInput() {
        notifyModelChange();
    }

    public void showDrinkInfo() {
        notifyModelChange();
    }

    public void closeScanner() {
        sc.close();
    }

    public void addListener(ModelChangeListener listener) { listeners.add(listener); }

    public void notifyModelChange() {
        for (ModelChangeListener listener : listeners) {
            listener.onModelChange();
        }
    }

    public String getMessage() {
        return sc.nextLine();
    }
}
