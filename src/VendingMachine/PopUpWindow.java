package VendingMachine;

import java.util.Scanner;

public class PopUpWindow {
    Scanner sc = new Scanner(System.in);

    String popUpName = "";

    public PopUpWindow(String popUpName) {
        this.popUpName = popUpName;
    }

    String createPopUp(String popUpMessage, boolean isInput) {
        byte leftPadding = (byte)((36 - popUpMessage.length()) / 2);

        System.out.println("⌈‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾⌉");
        System.out.println("|                                     |");
        System.out.print("|");

        for (int i = 0; i <= leftPadding; i++) System.out.print(" ");
        System.out.print(popUpMessage);
        for (int i = 0; i <= (35 - leftPadding - popUpMessage.length()); i++) System.out.print(" ");

        System.out.println("|");
        System.out.println("|                                     |");
        System.out.println("⌊_____________________________________⌋\n");

        if  (isInput) {
            System.out.print(": ");
            String input = sc.next();
            System.out.println();

            return input;
        } else {
            return "0";
        }
    }
}
