public class UI {
    private static String colorBlue = "\u001B[34m";
    private static String colorRed = "\u001B[31m";

    private static String colorGreen = "\u001B[32m";
    private static String colorReset = "\u001B[0m";

    private static String solidSquare = "■";

    public static String getBlueSquare() {
        return colorBlue + solidSquare + colorReset;
    }

    public static String getRedSquare() {
        return colorRed + solidSquare + colorReset;
    }

    public static String getGreenSquare() {
        return colorGreen + solidSquare + colorReset;
    }
}
