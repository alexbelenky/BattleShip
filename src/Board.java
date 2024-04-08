public class Board {
    private static PlayerShips playerShips;
    private Board() { }

    public static void setBoardUI() {
        setTargetBoardUI();
        setPlayerBoardUI(true);
        askShips();
        putShips();
    }

    //sets a 10 x 10 grid of green as places to target opponent ships
    private static void setTargetBoardUI() {
        System.out.println("  12345678910");
        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                    if (col == 0) {
                        System.out.print((((char)(row + 65)) + " "));
                    }  else {
                        System.out.print(UI.getGreenSquare());
                    }
                }
            System.out.println();
            }
        setBlackBar();
        }

    //sets a 10 x 10 grid of the blue sea and grey blocks as ships
    private static void setPlayerBoardUI(boolean start) {
        System.out.println("  12345678910");
        for (int row = 0; row < 10; row++) {
            System.out.print((char) (row + 'A') + " ");
            for (int col = 0; col < 10; col++) {
                if (!(start)) {
                    PlayerShip carrier = playerShips.getShips()[0];
                    PlayerShip battleship = playerShips.getShips()[1];
                    PlayerShip cruiser = playerShips.getShips()[2];
                    PlayerShip submarine = playerShips.getShips()[3];
                    PlayerShip destroyer = playerShips.getShips()[4];
                    if (
                        carrier.getFirstCoordinate() - 1 == row && ((carrier.getSecondCoordinate() + carrier.getLength() - 1 > col) && (carrier.getSecondCoordinate() < col + 2)) ||
                        battleship.getFirstCoordinate() - 1 == row && ((battleship.getSecondCoordinate() + battleship.getLength() - 1 > col) && (battleship.getSecondCoordinate() < col + 2)) ||
                        cruiser.getFirstCoordinate() - 1 == row && ((cruiser.getSecondCoordinate() + cruiser.getLength() - 1 > col) && (cruiser.getSecondCoordinate() < col + 2)) ||
                        submarine.getFirstCoordinate() - 1 == row && ((submarine.getSecondCoordinate() + submarine.getLength() - 1 > col) && (submarine.getSecondCoordinate() < col + 2)) ||
                        destroyer.getFirstCoordinate() - 1 == row && ((destroyer.getSecondCoordinate() + destroyer.getLength() - 1 > col) && (destroyer.getSecondCoordinate() < col + 2))
                    ) {
                        System.out.print(UI.getGraySquare());
                    } else {
                        System.out.print(UI.getBlueSquare());
                    }
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
        String battleship = UI.askQuestion("Where will you put your battleship? "); //size of 4
        String cruiser = UI.askQuestion("Where will you put your cruiser? "); //size of 3
        String submarine = UI.askQuestion("Where will you put your submarine? "); //size of 3
        String destroyer = UI.askQuestion("Where will you put your destroyer? "); //size of 3

        PlayerShip playerCarrier = new PlayerShip(5, new Coordinate(carrier.substring(0, 1), Integer.parseInt(carrier.substring(1))));
        PlayerShip playerBattleship = new PlayerShip(4, new Coordinate(battleship.substring(0, 1), Integer.parseInt(battleship.substring(1))));
        PlayerShip playerCruiser = new PlayerShip(3, new Coordinate(cruiser.substring(0, 1), Integer.parseInt(cruiser.substring(1))));
        PlayerShip playerSubmarine = new PlayerShip(3, new Coordinate(submarine.substring(0, 1), Integer.parseInt(submarine.substring(1))));
        PlayerShip playerDestroyer = new PlayerShip(2, new Coordinate(destroyer.substring(0, 1), Integer.parseInt(destroyer.substring(1))));
        playerShips = new PlayerShips(playerCarrier, playerBattleship, playerCruiser, playerSubmarine, playerDestroyer);
    }

    private static void putShips() {
        setPlayerBoardUI(false);
    }
}
