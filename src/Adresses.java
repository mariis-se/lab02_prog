public class Adresses {
    private String city;
    private String street;
    private String house;
    private int floor;

    public Adresses(String city, String street, String house, int floor){
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
}
