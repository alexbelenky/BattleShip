public class Coordinate {
    String firstCoordinate;
    int secondCoordinate;

    public Coordinate(String firstCoordinate, int secondCoordinate) {
        this.firstCoordinate = firstCoordinate.toUpperCase();
        this.secondCoordinate = secondCoordinate;
    }

    public String getFirstCoordinateS() { //as string
        return firstCoordinate;
    }

    public int getFirstCoordinateI() { //as int
        char coordinate = firstCoordinate.charAt(0);
        return coordinate - 'A' + 1;
    }

    public int getSecondCoordinate() {
        return secondCoordinate;
    }

    @Override
    public String toString() {
        return firstCoordinate + secondCoordinate;
    }
}
