public class Ship {
    private final int length;
    private Coordinate coordinates;

    public Ship(int length, Coordinate coordinates) {
        this.length = length;
        this.coordinates = coordinates;
    }

    public void setCoordinate(int index, Coordinate coordinate) {
        this.coordinates = coordinate;
    }

    public int getLength() {
        return length;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public int getFirstCoordinate() {
        return coordinates.getFirstCoordinateI();
    }

    public int getSecondCoordinate() {
        return coordinates.getSecondCoordinate();
    }
}
