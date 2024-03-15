import java.util.ArrayList;

public class Game {
    private ArrayList<Ship> playerShips;
    private ArrayList<Ship> computerShips;

    private boolean isPlayerTurn;
    public Game() {
        this.playerShips = new ArrayList<>();
        this.computerShips = new ArrayList<>();
    }

    public void play() {
        Board.setBoardUI();
    }
}
