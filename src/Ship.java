public class Ship {
    private final int length;
    private Coordinate coordinates;
    private boolean vertical; //true for vertical, false for horizontal

    public Ship(int length, Coordinate coordinates, boolean vertical) {
        this.length = length;
        this.coordinates = coordinates;
        this.vertical = vertical;
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

    public boolean isVertical() {
        return vertical;
    }

    public boolean isPresent(int firstCord, int secondCord) {
        if (vertical) {
            for (int i = 0; i < getLength(); i++) {
                if (firstCord == getFirstCoordinate() + i && secondCord == getSecondCoordinate()) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < getLength(); i++) {
                if (firstCord == getFirstCoordinate() && secondCord == getSecondCoordinate() + i) {
                    return true;
                }
            }
        }
        return false;
    }
}
