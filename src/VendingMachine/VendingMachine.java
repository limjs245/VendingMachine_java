package VendingMachine;

import javax.imageio.event.IIOWriteWarningListener;

// 자판기 자체
// Main과 분리
// 하위 클래스 존재
// 하위 클래스 목록: Button
// 다른 파일로 분리하는게 불필요해 보여서 하위 클래스로 만듬
public class VendingMachine {
    private final int[] isDrinkOut;
    private final boolean[][] drinkStockNotZero;

    final Drink Cola = new Drink(1, "Coca-Cola", 2100, "🔴", "soda", "Coca-Cola", "2026.05.05");
    final Drink Lemonade = new Drink(2, "Lemonade", 1500, "🍋", "soda", "Snapple", "2026.08.15");
    final Drink OrangeSoda = new Drink(3, "Fanta", 1800, "🍊", "soda", "Coca-Cola", "2027.01.26");
    final Drink Water = new Drink(4, "Evian", 2000, "💠", "water", "Danone", "2026.04.30");
    final Drink IcedTea = new Drink(5, "Teazen black tea iced tea peach", 1500, "🔺", "iced tea", "Teazen", "2026.12.01");
    final Drink SportsDrink = new Drink(6, "Gatorade", 2000, "🧊", "sports drink", "PepsiCo", "2026.06.12");
    final Drink EnergyDrink = new Drink(7, "Monster", 2300, "🌵", "energy drink", "Monster Energy", "2026.06.03");
    final Drink Coffee = new Drink(8, "T.O.P The Black", 1400, "🫘", "coffee", "T.O.P", "2026.08.10");
    final Drink GrapeJuice = new Drink(9, "Welch's Grape Juice", 1500, "🍇", "soda", "Welch's", "2027.02.13");
    final Drink PruneJuice = new Drink(10, "Prune Juice", 2000, "🍆", "juice", "Taylor", "2026.02.16");

    private final Drink[] drinks = new Drink[]{Cola, Lemonade, OrangeSoda, Water, IcedTea, SportsDrink, EnergyDrink, Coffee, GrapeJuice, PruneJuice};

    VendingMachine(int[] isDrinkOut, boolean[][] drinkStockNotZero) {
        this.isDrinkOut = isDrinkOut;
        this.drinkStockNotZero = drinkStockNotZero;
    }

    public void createBody() {
        final Button buttons = new Button(drinkStockNotZero);
        final Drink drink = getDrink(isDrinkOut[1]);

        for (byte i = 0; i <= 14; i++) {
            for (byte j = 0; j <= 21; j++) {
                if (i >= 1 && i <= 13 && j >= 1 && j <= 20) {
                    if (i >= 2 && i <= 4) {
                        if (j == 2 || j == 3) {
                            System.out.print(Cola.getDrinkChar());
                        } else if (j == 6 || j == 7) {
                            System.out.print(Lemonade.getDrinkChar());
                        } else if (j == 10 || j == 11) {
                            System.out.print(OrangeSoda.getDrinkChar());
                        } else if (j == 14 || j == 15) {
                            System.out.print(Water.getDrinkChar());
                        } else if (j == 18 || j == 19) {
                            System.out.print(IcedTea.getDrinkChar());
                        } else {
                            System.out.print("⬛");
                        }
                    } else if (i >= 8 && i <= 10) {
                        if (j == 2 || j == 3) {
                            System.out.print(SportsDrink.getDrinkChar());
                        } else if (j == 6 || j == 7) {
                            System.out.print(EnergyDrink.getDrinkChar());
                        } else if (j == 10 || j == 11) {
                            System.out.print(Coffee.getDrinkChar());
                        } else if (j == 14 || j == 15) {
                            System.out.print(GrapeJuice.getDrinkChar());
                        } else if (j == 18 || j == 19) {
                            System.out.print(PruneJuice.getDrinkChar());
                        } else {
                            System.out.print("⬛");
                        }
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
                    if ((isDrinkOut[0] == 1) && (i == 21 || i == 22) && (j >= 9 && j <= 11)) {
                        System.out.print(drink.getDrinkChar());
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

    private Drink getDrink(int id) {
        Drink drink = drinks[0];
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i].getDrinkId() == id) {
                drink =  drinks[i];
            }
        }
        return drink;
    }

    public void openDrinkInfo(int id) {
        PopUpWindow popUp = new PopUpWindow();
        popUp.createDrinkPopUp(getDrink(id));
    }

    private static class Button {
        private final boolean[][] drinkStockNotZero;

        Button(boolean[][] drinkStockNotZero) {
            this.drinkStockNotZero = drinkStockNotZero;
        }

        private void printButton(byte i, byte j) {
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