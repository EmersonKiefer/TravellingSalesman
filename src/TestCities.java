import java.util.ArrayList;

public class TestCities {

    private static ArrayList<City> cities = setup();

    public static ArrayList<City> setup() {
        cities = new ArrayList<>();
        cities.add(new City(273, 225));
        cities.add(new City(643, 437));
        cities.add(new City(235, 630));
        cities.add(new City(541, 737));
        cities.add(new City(248, 587));
        cities.add(new City(129, 185));
        cities.add(new City(369, 503));
        cities.add(new City(300, 797));
        cities.add(new City(555, 406));
        cities.add(new City(404, 214));
        cities.add(new City(302, 657));
        cities.add(new City(775, 438));
        cities.add(new City(315, 359));
        cities.add(new City(773, 75));
        cities.add(new City(129, 69));
        cities.add(new City(238, 13));
        cities.add(new City(520, 23));
        cities.add(new City(295, 299));
        cities.add(new City(794, 346));
        cities.add(new City(18, 457));
        cities.add(new City(348, 631));
        cities.add(new City(638, 157));
        cities.add(new City(189, 513));
        cities.add(new City(750, 587));
        return cities;
    }

    public static ArrayList<City> getCities() {
        ArrayList<City> temp = new ArrayList<>();
        for (City c : cities) {
            temp.add(new City(c));
        }
        return temp;
    }

    public static void addCity(City city) {
        cities.add(city);
    }

    public static void removeCity(City city) {
        cities.remove(city);
    }

    public static City getCity(int index) {
        return (City) cities.get(index);
    }

    public static int numberOfCities() {
        return cities.size();
    }


}