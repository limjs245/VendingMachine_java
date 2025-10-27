package VendingMachine.Model;

import VendingMachine.Controller;

import java.util.ArrayList;
import java.util.List;

// 자판기 자체
// Main과 분리
// 하위 클래스 존재
// 하위 클래스 목록: Button
// 다른 파일로 분리하는게 불필요해 보여서 하위 클래스로 만듬
public class VendingMachine {
    private List<ModelChangeListener> listeners = new ArrayList<>();
    private Controller controller;

    public VendingMachine(Controller controller) {
        this.controller = controller;
    }

    public void addListener(ModelChangeListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners() {
        for (ModelChangeListener listener : listeners) {
            listener.onModelChange();
        }
    }
}