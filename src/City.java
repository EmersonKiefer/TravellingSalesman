public class City {
    // TODO: 12/1/17 THIS CLASS IS DONE
    private int x;
    private int y;
    private static int nextID;
    private int ID;

    // Constructs a randomly placed city
    public City() {
        this.x = (int) (Math.random() * 200);
        this.y = (int) (Math.random() * 200);
        this.ID = nextID;
        nextID++;
    }

    // Constructs a city at chosen x, y location
    public City(int x, int y) {
        this.x = x;
        this.y = y;
        this.ID = nextID;
        nextID++;
    }

    public City(City orig){
        this.x = orig.x;
        this.y = orig.y;
        this.ID = orig.ID;
    }

    // Gets city's x coordinate
    public int getX() {
        return this.x;
    }

    // Gets city's y coordinate
    public int getY() {
        return this.y;
    }

    // Gets the distance to given city
    public double distanceTo(City city) {
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));

        return distance;
    }

    @Override
    public String toString() {
        return "(x: " +getX() + ", " + "y: " + getY() + ")";
    }

    public int getID() {
        return ID;
    }
}
