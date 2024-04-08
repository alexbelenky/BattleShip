import java.util.Random;

public class Board {
    private static PlayerShips playerShips;
    private static OpponentShips opponentShips;
    private static int[][] attackedOpponent; //0 for nothing, 1 for hit, 2 for miss
    private static int[][] attackedPlayer; //0 for nothing, 1 for hit
    private Board() { }

    public static void setBoardUI() {
        opponentShips = new OpponentShips();
        initializeSet();
        setTargetBoardUI(true, false, 0, 0);
        setPlayerBoardUI(true);
        askShips();
        setTargetBoardUI(true, false, 0, 0);
        setPlayerBoardUI(false);
        while (!(opponentShips.allShipsSunk())) {
            attack();
        }
        if (opponentShips.allShipsSunk()) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
//        test();
    }

    //sets a 10 x 10 grid of green as places to target opponent ships
    private static void setTargetBoardUI(boolean start, boolean hit, int firstCord, int secondCord) {
        System.out.println("  12345678910");
        for (int row = 0; row < 10; row++) {
            System.out.print((char) (row + 'A') + " ");
            for (int col = 0; col < 10; col++) {
                if (!start) {
                    if (attackedOpponent[row][col] == 2) {
                        System.out.print(UI.getWhiteSquare());  // Print white square for a miss
                    } else if (attackedOpponent[row][col] == 1) {
                        System.out.print(UI.getRedSquare());  // Print red square for a hit
                    } else {
                        System.out.print(UI.getGreenSquare());  // Print green square for other cells
                    }
                } else {
                    System.out.print(UI.getGreenSquare());  // Always print green squares in setup mode
                }
            }
            System.out.println();
        }
        System.out.println();
        setBlackBar();
    }

    //sets a 10 x 10 grid of the blue sea and grey blocks as ships
    private static void setPlayerBoardUI(boolean start) {
        System.out.println("  12345678910");
        for (int row = 0; row < 10; row++) {
            System.out.print((char) (row + 'A') + " ");
            for (int col = 0; col < 10; col++) {
                boolean isShipCell = false;
                if (!start) {
                    for (PlayerShip ship : playerShips.getShips()) {
                        int shipStartRow = ship.getFirstCoordinate() - 1;
                        int shipStartCol = ship.getSecondCoordinate() - 1;
                        int shipEndRow = shipStartRow + (ship.isVertical() ? ship.getLength() - 1 : 0);
                        int shipEndCol = shipStartCol + (!ship.isVertical() ? ship.getLength() - 1 : 0);

                        if (ship.isVertical()) {
                            if (col == shipStartCol && row >= shipStartRow && row <= shipEndRow) {
                                isShipCell = true;
                                break;
                            }
                        } else {
                            if (row == shipStartRow && col >= shipStartCol && col <= shipEndCol) {
                                isShipCell = true;
                                break;
                            }
                        }
                    }
                }
                if (!start && isShipCell) {
                    System.out.print(UI.getGraySquare());
                } else {
                    System.out.print(UI.getBlueSquare());
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void setBlackBar() {
        for (int i = 0; i < 14; i++) {
            System.out.print(UI.getBlackSquare());
        }
        System.out.println();
    }

    private static void askShips() {
        String carrier = UI.askQuestion("Where will you put your carrier? (ex. A1)"); //size of 5
        boolean carrierD = "v".equalsIgnoreCase(UI.askQuestion("Vertical or horizontal? (v for vertical, h for horizontal)"));
        String battleship = UI.askQuestion("Where will you put your battleship? "); //size of 4
        boolean battleshipD = "v".equalsIgnoreCase(UI.askQuestion("Vertical or horizontal?"));
        String cruiser = UI.askQuestion("Where will you put your cruiser? "); //size of 3
        boolean cruiserD = "v".equalsIgnoreCase(UI.askQuestion("Vertical or horizontal?"));
        String submarine = UI.askQuestion("Where will you put your submarine? "); //size of 3
        boolean submarineD = "v".equalsIgnoreCase(UI.askQuestion("Vertical or horizontal?"));
        String destroyer = UI.askQuestion("Where will you put your destroyer? "); //size of 2
        boolean destroyerD = "v".equalsIgnoreCase(UI.askQuestion("Vertical or horizontal?"));

        PlayerShip playerCarrier = new PlayerShip(5, new Coordinate(carrier.substring(0, 1), Integer.parseInt(carrier.substring(1))), carrierD);
        PlayerShip playerBattleship = new PlayerShip(4, new Coordinate(battleship.substring(0, 1), Integer.parseInt(battleship.substring(1))), battleshipD);
        PlayerShip playerCruiser = new PlayerShip(3, new Coordinate(cruiser.substring(0, 1), Integer.parseInt(cruiser.substring(1))), cruiserD);
        PlayerShip playerSubmarine = new PlayerShip(3, new Coordinate(submarine.substring(0, 1), Integer.parseInt(submarine.substring(1))), submarineD);
        PlayerShip playerDestroyer = new PlayerShip(2, new Coordinate(destroyer.substring(0, 1), Integer.parseInt(destroyer.substring(1))), destroyerD);
        playerShips = new PlayerShips(playerCarrier, playerBattleship, playerCruiser, playerSubmarine, playerDestroyer);
    }

    private static void putShips(boolean hit, int firstCord, int secondCord) {
        setTargetBoardUI(false, hit, firstCord, secondCord);
        setPlayerBoardUI(false);
    }

    private static void attack() {
        try {
            String attack = UI.askQuestion("What coordinate shall we attack?");
            int firstCord = attack.charAt(0);
            firstCord -= 'A' - 1;
            int secondCord = Integer.parseInt(attack.substring(1));
            if (opponentShips.attacked(firstCord, secondCord)) {
                System.out.println("Hit!");
                attackedOpponent[firstCord - 1][secondCord - 1] = 1;
                putShips(true, firstCord, secondCord);
                attack();
            } else {
                System.out.println("Miss!");
                attackedOpponent[firstCord - 1][secondCord - 1] = 2;
                putShips(false, firstCord, secondCord);
            }
        } catch (Exception e) {
            System.out.println("Invalid coordinate! Try again!");
            attack();
        }
    }

    private static void attacked() {
        int firstCord = 0;
        int secondCord = 0;
        boolean valid = false;
        while (!valid) {
            firstCord = new Random().nextInt(10) + 1;
            secondCord = new Random().nextInt(10);

        }
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (attackedPlayer[row][col] == 0) {
//                    if ()
                }
            }
        }
    }

    private static void initializeSet() {
        attackedOpponent = new int[10][10];
        attackedPlayer = new int[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                attackedOpponent[row][col] = 0;
                attackedPlayer[row][col] = 0;
            }
        }
    }

//    private static void test() {
//        initializeSet();
//        for (int[] ints : attackedOpponent) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println();
//        }
//    }
}
