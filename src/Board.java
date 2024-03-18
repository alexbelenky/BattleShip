public class Board {
    private Board() { }

    public static void setBoardUI() {
        setTargetBoardUI();
        setPlayerBoardUI();
    }

    //sets a 10 x 10 grid of green as places to target opponent ships
    private static void setTargetBoardUI() {
        System.out.println("  12345678910");
        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                    if (col == 0) {
                        System.out.print((String.valueOf((char)(row + 65)) + " "));
                    }  else {
                        System.out.print(UI.getGreenSquare());
                    }
                }
            System.out.println();
            }
        setBlackBar();
        }

    //sets a 10 x 10 grid of the blue sea and grey blocks as ships (to be implemented)
    private static void setPlayerBoardUI() {
        System.out.println("  12345678910");
        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                    if (col == 0) {
                        System.out.print((String.valueOf((char)(row + 65)) + " "));
                    } else {
                        System.out.print(UI.getBlueSquare());
                    }
                }
            System.out.println();
        }
    }

    private static void setBlackBar() {
        for (int i = 0; i < 14; i++) {
            System.out.print(UI.getBlackSquare());
        }
        System.out.println();
    }
}
