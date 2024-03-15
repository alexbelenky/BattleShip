public class Ship {
    private final int length;
    private Coordinate[] coordinates;

    public Ship(int length) {
        this.length = length;
        this.coordinates = new Coordinate[length];
    }

    public void setCoordinates(Coordinate[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setCoordinate(int index, Coordinate coordinate) {
        this.coordinates[index] = coordinate;
    }

    public int getLength() {
        return length;
    }

    public Coordinate[] getCoordinates() {
        return coordinates;
    }


}
