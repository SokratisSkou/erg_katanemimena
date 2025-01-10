package gr.hua.dit.ds.ergasia.entities;

public class shelter extends user {
    private String location;




    public String getLocation() {
        return location;
    }







    public void setLocation(String location) {
        this.location = location;
    }







    public shelter(long id, String UserName, String name, String password, int age,String location) {
        super(id,UserName,name,password,age);
        this.location = location;

    }

    @Override
    public String toString() {
        return "shelter{" +
                "location='" + location + '\'' +
                "} " + super.toString();
    }
}
