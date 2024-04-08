import java.util.Random;

public class OpponentShips {
    private static OpponentShip[] ships;
    private static int hits;
    private static boolean allSunk;
    public OpponentShips() {
        ships = new OpponentShip[5];
        hits = 0;
        allSunk = false;
        setOpponentShips();
    }

    private void setOpponentShips() {
        for (int i = 5; i > 0; i--) {
            boolean vertical = (new Random().nextInt(2) + 1) == 1;
            String firstCord = "";
            int secondCord = 0;
            if (vertical) {
                firstCord = String.valueOf((((char)((new Random().nextInt(10 - i + 1) + 1) + 65))));
                secondCord = new Random().nextInt(10) + 1;
                if (i == 5) {
                    ships[0] = new OpponentShip(5, new Coordinate(firstCord, secondCord), true);
                } else if (i == 4) {
                    ships[1] = new OpponentShip(4, new Coordinate(firstCord, secondCord), true);
                } else if (i == 3 || i == 2) {
                    ships[5 - i] = new OpponentShip(3, new Coordinate(firstCord, secondCord), true);
                } else {
                    ships[4] = new OpponentShip(2, new Coordinate(firstCord, secondCord), true);
                }
            } else {
                firstCord = String.valueOf((((char)((new Random().nextInt(10) + 1) + 65))));
                secondCord = new Random().nextInt(10 - i + 1) + 1;
                if (i == 5) {
                    ships[0] = new OpponentShip(5, new Coordinate(firstCord, secondCord), false);
                } else if (i == 4) {
                    ships[1] = new OpponentShip(4, new Coordinate(firstCord, secondCord), false);
                } else if (i == 3 || i == 2) {
                    ships[5 - i] = new OpponentShip(3, new Coordinate(firstCord, secondCord), false);
                } else {
                    ships[4] = new OpponentShip(2, new Coordinate(firstCord, secondCord), false);
                }
            }
        }
    }

    public boolean attacked(int firstCord, int secondCord) {
        for (OpponentShip ship : ships) {
            if (ship.isPresent(firstCord, secondCord)) {
                hits++;
                if (hits >= 17) {
                    allSunk = true;
                    break;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public OpponentShip[] getShips() {
        return ships;
    }

    public boolean allShipsSunk() {
        return allSunk;
    }
}
