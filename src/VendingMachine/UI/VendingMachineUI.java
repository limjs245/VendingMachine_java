package VendingMachine.UI;

public class VendingMachineUI {
    private int outDrinkNum;

    VendingMachineUI() {
        createBody();
    }

    public void createBody() {

        for (byte i = 0; i <= 14; i++) {
            for (byte j = 0; j <= 21; j++) {
                if (i >= 1 && i <= 13 && j >= 1 && j <= 20) {
                    if (i >= 2 && i <= 4) {
                        if (j == 2 || j == 3) {
                            System.out.print("🧊");
                        } else if (j == 6 || j == 7) {
                            System.out.print("🧊");
                        } else if (j == 10 || j == 11) {
                            System.out.print("🧊");
                        } else if (j == 14 || j == 15) {
                            System.out.print("🧊");
                        } else if (j == 18 || j == 19) {
                            System.out.print("🧊");
                        } else {
                            System.out.print("⬛");
                        }
                    } else if (i >= 8 && i <= 10) {
                        if (j == 2 || j == 3) {
                            System.out.print("🧊");
                        } else if (j == 6 || j == 7) {
                            System.out.print("🧊");
                        } else if (j == 10 || j == 11) {
                            System.out.print("🧊");
                        } else if (j == 14 || j == 15) {
                            System.out.print("🧊");
                        } else if (j == 18 || j == 19) {
                            System.out.print("🧊");
                        } else {
                            System.out.print("⬛");
                        }
                    } else {
                        if (i == 6) {
                            if (j >= 2 && j <= 3) {
                                System.out.print("🔸");
                            } else if (j >= 6 && j <= 7) {
                                System.out.print("🔸");
                            } else if (j >= 10 && j <= 11) {
                                System.out.print("🔸");
                            } else if (j >= 14 && j <= 15) {
                                System.out.print("🔸");
                            } else if (j >= 18 && j <= 19) {
                                System.out.print("🔸");
                            } else {
                                System.out.print("⬛");
                            }
                        } else if (i == 12) {
                            if (j >= 2 && j <= 3) {
                                System.out.print("🔸");
                            } else if (j >= 6 && j <= 7) {
                                System.out.print("🔸");
                            } else if (j >= 10 && j <= 11) {
                                System.out.print("🔸");
                            } else if (j >= 14 && j <= 15) {
                                System.out.print("🔸");
                            } else if (j >= 18 && j <= 19) {
                                System.out.print("🔸");
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
                    if ((outDrinkNum != 0) && (i == 21 || i == 22) && (j >= 9 && j <= 11)) {
                        System.out.print("");
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
}