public class Ship {
    private final int length;
    private int[] coordinates;

    public Ship(int length) {
        this.length = length;
        this.coordinates = new int[length];
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setCoordinate(int index, int coordinate) {
        this.coordinates[index] = coordinate;
    }

    public int getLength() {
        return length;
    }

    public int[] getCoordinates() {
        return coordinates;
    }
}
