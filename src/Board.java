public class Board {
    private static PlayerShips playerShips;
    private static OpponentShips opponentShips;
    private Board() { }

    public static void setBoardUI() {
        opponentShips = new OpponentShips();
        setTargetBoardUI(true, false);
        setPlayerBoardUI(true);
        askShips();
        setTargetBoardUI(true, false);
        setPlayerBoardUI(false);
        attack();
//        test();
    }

    //sets a 10 x 10 grid of green as places to target opponent ships
    private static void setTargetBoardUI(boolean start, boolean hit) {
        System.out.println("  12345678910");
        for (int row = 0; row < 10; row++) {
            System.out.print((char) (row + 'A') + " ");
            for (int col = 0; col < 10; col++) {
                if (!start) {
                    if (hit) {
                        // Place red block if hit is true
                        System.out.print(UI.getRedSquare());
                    } else {
                        // Place white block if hit is false
                        System.out.print(UI.getWhiteSquare());
                    }
                } else {
                    // Place green block if neither hit nor start
                    System.out.print(UI.getGreenSquare());
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
        String carrier = UI.askQuestion("Where will you put your carrier? "); //size of 5
        boolean carrierD = "vertical".equalsIgnoreCase(UI.askQuestion("Vertical or horizontal?"));
        String battleship = UI.askQuestion("Where will you put your battleship? "); //size of 4
        boolean battleshipD = "vertical".equalsIgnoreCase(UI.askQuestion("Vertical or horizontal?"));
        String cruiser = UI.askQuestion("Where will you put your cruiser? "); //size of 3
        boolean cruiserD = "vertical".equalsIgnoreCase(UI.askQuestion("Vertical or horizontal?"));
        String submarine = UI.askQuestion("Where will you put your submarine? "); //size of 3
        boolean submarineD = "vertical".equalsIgnoreCase(UI.askQuestion("Vertical or horizontal?"));
        String destroyer = UI.askQuestion("Where will you put your destroyer? "); //size of 3
        boolean destroyerD = "vertical".equalsIgnoreCase(UI.askQuestion("Vertical or horizontal?"));

        PlayerShip playerCarrier = new PlayerShip(5, new Coordinate(carrier.substring(0, 1), Integer.parseInt(carrier.substring(1))), carrierD);
        PlayerShip playerBattleship = new PlayerShip(4, new Coordinate(battleship.substring(0, 1), Integer.parseInt(battleship.substring(1))), battleshipD);
        PlayerShip playerCruiser = new PlayerShip(3, new Coordinate(cruiser.substring(0, 1), Integer.parseInt(cruiser.substring(1))), cruiserD);
        PlayerShip playerSubmarine = new PlayerShip(3, new Coordinate(submarine.substring(0, 1), Integer.parseInt(submarine.substring(1))), submarineD);
        PlayerShip playerDestroyer = new PlayerShip(2, new Coordinate(destroyer.substring(0, 1), Integer.parseInt(destroyer.substring(1))), destroyerD);
        playerShips = new PlayerShips(playerCarrier, playerBattleship, playerCruiser, playerSubmarine, playerDestroyer);
    }

    private static void putShips(boolean hit) {
        setTargetBoardUI(false, hit);
        setPlayerBoardUI(false);
    }

    private static void attack() {
        String attack = UI.askQuestion("What coordinate shall we attack?");
        char firstCord = attack.charAt(0) ;
        firstCord -= 'A' + 1;
        int secondCord = attack.charAt(1);
        if (opponentShips.attacked(firstCord, secondCord)) {
            System.out.println("Hit!");
            putShips(true);
        } else {
            System.out.println("Miss!");
            putShips(false);
        }
    }

//    private static void test() {
//        OpponentShips a = new OpponentShips();
//        for (OpponentShip ship : a.getShips()) {
//            System.out.println(ship.getCoordinates());
//        }
//    }
}
