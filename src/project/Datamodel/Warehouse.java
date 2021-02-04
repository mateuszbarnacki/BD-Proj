package project.Datamodel;

public class Warehouse {
    private final int id;
    private final String name;
    private final String street;
    private final String city;
    private final String postcode;

    public Warehouse(int id, String... data){
        this.id = id;
        this.name = data[0];
        this.street = data[1];
        this.city = data[2];
        this.postcode = data[3];
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getStreet(){
        return this.street;
    }

    public String getCity(){
        return this.city;
    }

    public String getPostcode(){
        return this.postcode;
    }
}
