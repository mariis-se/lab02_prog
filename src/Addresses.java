public class Addresses {
    private String city;
    private String street;
    private String house;
    private int floor;

    public Addresses(String city, String street, String house, int floor){
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;

    }

    public String getCity(){ return city; }
    public String getStreet() {return street;}
    public String getHouse() {return house;}
    public int getFloor() {return floor;}

    @Override
    public String toString(){
        return city + ", " + street + ", " + house + ", " + floor + " этажейй";
    }

    @Override
    public boolean equals(Object object){//точная проверка
        if (this == object) return true;
        if (object== null || getClass() != object.getClass()) return false;

        Addresses address = (Addresses) object;
        return floor == address.floor &&
                java.util.Objects.equals(city, address.city) &&
                java.util.Objects.equals(street, address.street) &&
                java.util.Objects.equals(house, address.house);
    }
    @Override
    public int hashCode() { //6 быстрая проверка
        return java.util.Objects.hash(city, street, house, floor);
    }
}
