package VendingMachine.View;

import VendingMachine.Model.ModelChangeListener;
import VendingMachine.Model.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineUI implements ModelChangeListener {
    private final VendingMachine machine;
    private final List<Integer> stocks = new ArrayList<>();
    private final List<String> drinkChars = new ArrayList<>();

    public VendingMachineUI(VendingMachine machine) {
        this.machine = machine;
        this.machine.addListener(this);
    }

    public void createBody(int outDrinkNum) {
        for (int i = 0; i <= 14; i++) {
            for (int j = 0; j <= 21; j++) {
                if (i >= 1 && i <= 13 && j >= 1 && j <= 20) {
                    if (i >= 2 && i <= 4) {
                        if (j == 2 || j == 3) {
                            System.out.print(drinkChars.get(0));
                        } else if (j == 6 || j == 7) {
                            System.out.print(drinkChars.get(1));
                        } else if (j == 10 || j == 11) {
                            System.out.print(drinkChars.get(2));
                        } else if (j == 14 || j == 15) {
                            System.out.print(drinkChars.get(3));
                        } else if (j == 18 || j == 19) {
                            System.out.print(drinkChars.get(4));
                        } else {
                            System.out.print("⬛");
                        }
                    } else if (i >= 8 && i <= 10) {
                        if (j == 2 || j == 3) {
                            System.out.print(drinkChars.get(5));
                        } else if (j == 6 || j == 7) {
                            System.out.print(drinkChars.get(6));
                        } else if (j == 10 || j == 11) {
                            System.out.print(drinkChars.get(7));
                        } else if (j == 14 || j == 15) {
                            System.out.print(drinkChars.get(8));
                        } else if (j == 18 || j == 19) {
                            System.out.print(drinkChars.get(9));
                        } else {
                            System.out.print("⬛");
                        }
                    } else {
                        if (i == 6) {
                            if (j >= 2 && j <= 3) {
                                System.out.print(display(0));
                            } else if (j >= 6 && j <= 7) {
                                System.out.print(display(1));
                            } else if (j >= 10 && j <= 11) {
                                System.out.print(display(2));
                            } else if (j >= 14 && j <= 15) {
                                System.out.print(display(3));
                            } else if (j >= 18 && j <= 19) {
                                System.out.print(display(4));
                            } else {
                                System.out.print("⬛");
                            }
                        } else if (i == 12) {
                            if (j >= 2 && j <= 3) {
                                System.out.print(display(5));
                            } else if (j >= 6 && j <= 7) {
                                System.out.print(display(6));
                            } else if (j >= 10 && j <= 11) {
                                System.out.print(display(7));
                            } else if (j >= 14 && j <= 15) {
                                System.out.print(display(8));
                            } else if (j >= 18 && j <= 19) {
                                System.out.print(display(9));
                            } else {
                                System.out.print("⬛");
                            }
                        } else {
                            System.out.print("⬛");
                        }
                    }
                } else {
                    System.out.print("⬜");
                }
            }
            System.out.println();
        }
        System.out.println("⬜⬜🍎🍎🍠🍠🦺🦺🍤🍤🧀🧀🍐🍐⬜⬜⬜◼️◼️◼️⬜⬜");
        System.out.println("⬜⬜🍎🍎🍠🍠🦺🦺🍤🍤🧀🧀🍐🍐⬜⬜⬜◼️◼️◼️⬜⬜");
        System.out.println("⬜⬜🍎🍎🍠🍠🦺🦺🍤🍤🧀🧀🍐🍐⬜⬜⬜⬜⬜⬜⬜⬜");
        System.out.println("⬜⬜🍎🍎🍠🍠🦺🦺🍤🍤🧀🧀🍐🍐⬜⬜⬜⬜⬜⬜⬜⬜");
        for (byte i = 19; i <= 24; i++) {
            for (byte j = 0; j <= 21; j++) {
                if (i >= 20 && i <= 22 && j >= 2 && j <= 19) {
                    if ((outDrinkNum != -1) && (i == 21 || i == 22) && (j >= 9 && j <= 11)) {
                        System.out.print(drinkChars.get(outDrinkNum));
                    } else {
                        System.out.print("⬛");
                    }
                } else {
                    System.out.print("⬜");
                }
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    private String display(int drinkNum) {
        int stock = stocks.get(drinkNum);
        if (stock <= 0) {
            return "⬛";
        } else {
            return "🔸";
        }
    }

    @Override
    public void onModelChange() {
        for (int i = 0; i <= 10; i++) {
            stocks.set(i, machine.getDrinkStock(i));
            drinkChars.set(i, machine.getDrinkInfo(i).get("char"));
        }
        int state = machine.getState();
        if (state == 0) {
            createBody(-1);
        } else if (state == 1) {
            createBody(-1);
        } else if (state == 2) {
            createBody(machine.outDrinkNum);
        }
    }
}