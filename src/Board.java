public class Board {
    private Board() { }

    public static void setBoardUI() {
        setTargetBoardUI();
        setPlayerBoardUI();
    }

    //sets a 10 x 10 grid of green as places to target opponent ships
    private static void setTargetBoardUI() {
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 12; col++) {
                if (row == 0 || row == 11) {
                    System.out.print(UI.getBlackSquare());
                } else {
                    if (col == 0 || col == 11) {
                        System.out.print(UI.getBlackSquare());
                    } else {
                        System.out.print(UI.getGreenSquare());
                    }
                }
            }
            System.out.println();
        }
    }

    //sets a 10 x 10 grid of the blue sea and grey blocks as ships (to be implemented)
    private static void setPlayerBoardUI() {
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 12; col++) {
                if (row == 0 || row == 11) {
                    System.out.print(UI.getBlackSquare());
                } else {
                    if (col == 0 || col == 11) {
                        System.out.print(UI.getBlackSquare());
                    } else {
                        System.out.print(UI.getBlueSquare());
                    }
                }
            }
            System.out.println();
        }
    }
}
