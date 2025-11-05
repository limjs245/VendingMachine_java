package VendingMachine.View;

import VendingMachine.Model.PopUpChangeListener;
import VendingMachine.Model.UserCommunicate;

public class PopUpUI implements PopUpChangeListener {
    private final UserCommunicate user;

    public PopUpUI(UserCommunicate user) {
        this.user = user;
        this.user.addListener(this);
    }

    public void createPopUp(String popUpMessage) {
        final int leftPadding = (36 - popUpMessage.length()) / 2;

        System.out.println("\n⌈‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾⌉");
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
    public void onPopUpChange() {
        createPopUp(user.getMessage());
    }
}
