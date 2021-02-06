package project.Datamodel;

public class Warehouse {
    private final String name;
    private final String street;
    private final String city;
    private final String postcode;

    public Warehouse(String... data){
        this.name = data[0];
        this.street = data[1];
        this.city = data[2];
        this.postcode = data[3];
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
