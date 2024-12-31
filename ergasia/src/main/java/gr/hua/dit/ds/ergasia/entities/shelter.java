package gr.hua.dit.ds.ergasia.entities;

public class shelter {
    private String location;
    private int id;
    private String email;
    private String name;

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public shelter(String location, int id, String email, String name) {
        this.location = location;
        this.id = id;
        this.email = email;
        this.name = name;
    }

    @Override
    public String toString() {
        return "selter{" +
                "location='" + location + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
