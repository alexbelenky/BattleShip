public class PlayerShips {
    private PlayerShip[] ships;

    public PlayerShips(PlayerShip playerShip1, PlayerShip playerShip2, PlayerShip playerShip3, PlayerShip playerShip4, PlayerShip playerShip5) {
        ships = new PlayerShip[5];
        ships[0] = playerShip1;
        ships[1] = playerShip2;
        ships[2] = playerShip3;
        ships[3] = playerShip4;
        ships[4] = playerShip5;
    }

    public PlayerShip[] getShips() {
        return ships;
    }

    public boolean isEmpty() {
        return ships[0] == null;
    }
}
