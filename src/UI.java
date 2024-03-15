public class UI {
    private static final String COLOR_BLUE = "\u001B[34m";
    private static final String COLOR_RED = "\u001B[31m";
    private static final String COLOR_GREEN = "\u001B[32m";
    private static final String COLOR_WHITE = "\u001B[38m";
    private static final String COLOR_GRAY = "\u001B[37m";
    private static final String COLOR_BLACK = "\u001B[30m";
    private static final String COLOR_RESET = "\u001B[0m";

    private static final String SOLID_SQUARE = "■";

    public static String getBlueSquare() {
        return COLOR_BLUE + SOLID_SQUARE + COLOR_RESET;
    }

    public static String getRedSquare() {
        return COLOR_RED + SOLID_SQUARE + COLOR_RESET;
    }

    public static String getGreenSquare() {
        return COLOR_GREEN + SOLID_SQUARE + COLOR_RESET;
    }

    public static String getWhiteSquare() {
        return COLOR_WHITE + SOLID_SQUARE + COLOR_RESET;
    }

    public static String getGraySquare() {
        return COLOR_GRAY + SOLID_SQUARE + COLOR_RESET;
    }

    public static String getBlackSquare() {
        return COLOR_BLACK + SOLID_SQUARE + COLOR_RESET;
    }
}
