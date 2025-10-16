package VendingMachine;

// 자판기 자체
// Main과 분리
// 하위 클래스 존재
// 하위 클래스 목록: Button
// 다른 파일로 분리하는게 불필요해 보여서 하위 클래스로 만듬
public class VendingMachine {
    boolean isDrinkOut = false;
    boolean[][] drinkStockNotZero;

    VendingMachine(boolean isDrinkOut, boolean[][] drinkStockNotZero) {
        this.isDrinkOut = isDrinkOut;
        this.drinkStockNotZero = drinkStockNotZero;
    }

    void createBody() {
        final Button buttons = new Button(drinkStockNotZero);

        for (byte i = 0; i <= 14; i++) {
            for (byte j = 0; j <= 21; j++) {
                if (i >= 1 && i <= 13 && j >= 1 && j <= 20) {
                    if (((i >= 2 && i <= 4) || (i >= 8 && i <= 10)) && (j % 4 == 2 || j % 4 == 3)) {
                        System.out.print("🔷");
                    } else {
                        if (i == 6) {
                            if (j >= 2 && j <= 3) {
                                buttons.printButton((byte) 0, (byte) 0);
                            } else if (j >= 6 && j <= 7) {
                                buttons.printButton((byte) 0, (byte) 1);
                            } else if (j >= 10 && j <= 11) {
                                buttons.printButton((byte) 0, (byte) 2);
                            } else if (j >= 14 && j <= 15) {
                                buttons.printButton((byte) 0, (byte) 3);
                            } else if (j >= 18 && j <= 19) {
                                buttons.printButton((byte) 0, (byte) 4);
                            } else {
                                System.out.print("⬛");
                            }
                        } else if (i == 12) {
                            if (j >= 2 && j <= 3) {
                                buttons.printButton((byte) 1, (byte) 0);
                            } else if (j >= 6 && j <= 7) {
                                buttons.printButton((byte) 1, (byte) 1);
                            } else if (j >= 10 && j <= 11) {
                                buttons.printButton((byte) 1, (byte) 2);
                            } else if (j >= 14 && j <= 15) {
                                buttons.printButton((byte) 1, (byte) 3);
                            } else if (j >= 18 && j <= 19) {
                                buttons.printButton((byte) 1, (byte) 4);
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
                    if (isDrinkOut && i >= 21 && j >= 9 && j <= 11) {
                        System.out.print("🔷");
                    } else {
                        System.out.print("◼️");
                    }
                } else {
                    System.out.print("⬜");
                }
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    private static class Button {
        private final boolean[][] drinkStockNotZero;

        Button(boolean[][] drinkStockNotZero) {
            this.drinkStockNotZero = drinkStockNotZero;
        }

        void printButton(byte i, byte j) {
            try {
                if (drinkStockNotZero[i][j]) {
                    System.out.print("🔶");
                } else {
                    System.out.print("❌");
                }
            } catch (Exception e) {
                System.out.print("⬛");
            }
        }
    }
}