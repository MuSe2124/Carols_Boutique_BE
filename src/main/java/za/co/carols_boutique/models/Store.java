package za.co.carols_boutique.models;

public class Store {
    
    private String id;
    private String name;
    private String location;
    private String password;

    public Store(String id, String name, String location, String password) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.password = password;
    }

    public Store(String name, String location, String password) {
        this.name = name;
        this.location = location;
        this.password = password;
    }

    public Store() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public Sale createSale(){
    return null;
    }

    @Override
    public String toString() {
        return "Store{" + "id=" + id + ", name=" + name + ", location=" + location + '}';
    }
    
    
}
