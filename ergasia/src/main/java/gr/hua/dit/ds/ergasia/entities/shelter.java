package gr.hua.dit.ds.ergasia.entities;

import jakarta.persistence.*;


import java.util.List;

@Table
@Entity
public class shelter extends user  {


    @Column
    private String location;

    @Column
    private String aprovalStatus;

    @Column
    private String contactInfo;





    public shelter(int id,String username, String name, String password, int age, String email ,String location, String aprovalStatus,String contactInfo) {
        super(id,username,name,password,age,email);
        this.location = location;
        this.aprovalStatus = aprovalStatus;
        this.contactInfo = contactInfo;

    }

    public shelter() {

    }

    public String getAprovalStatus() {
        return aprovalStatus;
    }

    public void setAprovalStatus(String aprovalStatus) {
        this.aprovalStatus = aprovalStatus;
    }

    @OneToMany(mappedBy = "shelter",  cascade = CascadeType.ALL)
    private List<pet> pets;

    @OneToMany(mappedBy = "shelter",  cascade = CascadeType.ALL)
    private List<AdoptionRequest> adoptionRequests;

    @Override
    public String toString() {
        return "shelter{" +
                "location='" + location + '\'' +
                ", aprovalStatus='" + aprovalStatus + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", pets=" + pets +
                ", adoptionRequests=" + adoptionRequests +
                "} " + super.toString();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<pet> getPets() {
        return pets;
    }

    public void setPets(List<pet> pets) {
        this.pets = pets;
    }

    public List<AdoptionRequest> getAdoptionRequests() {
        return adoptionRequests;
    }

    public void setAdoptionRequests(List<AdoptionRequest> adoptionRequests) {
        this.adoptionRequests = adoptionRequests;
    }
}
