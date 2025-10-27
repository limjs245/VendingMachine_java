package VendingMachine.View;

import VendingMachine.Model.ModelChangeListener;
import VendingMachine.Model.User;

public class PopUpUI implements ModelChangeListener {
    private User user;

    public PopUpUI(User user) {
        this.user = user;
        this.user.addListener(this);
    }

    public void createPopUp(String popUpMessage) {
        final byte leftPadding = (byte)((36 - popUpMessage.length()) / 2);

        System.out.println("⌈‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾⌉");
        System.out.println("|                                     |");
        System.out.print("|");

        for (int i = 0; i <= leftPadding; i++) System.out.print(" ");
        System.out.print(popUpMessage);
        for (int i = 0; i <= (35 - leftPadding - popUpMessage.length()); i++) System.out.print(" ");

        System.out.println("|");
        System.out.println("|                                     |");
        System.out.println("⌊_____________________________________⌋\n");
    }

    @Override
    public void onModelChange() {
        String message = user.getMessage();
        createPopUp(message);
    }
}
