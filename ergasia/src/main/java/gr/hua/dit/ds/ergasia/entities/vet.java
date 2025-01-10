package gr.hua.dit.ds.ergasia.entities;

public class vet extends user{
    private String ContactInfo;
    public vet() {}
    public vet(long id, String UserName, String name, String password, int age, String ContactInfo) {
        super(id,UserName,name,password,age);
        this.ContactInfo = ContactInfo;
    }

    public String getContactInfo() {
        return ContactInfo;
    }

    public void setContactInfo(String contactInfo) {
        ContactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "vet{" +
                "ContactInfo='" + ContactInfo + '\'' +
                "} " + super.toString();
    }
}
