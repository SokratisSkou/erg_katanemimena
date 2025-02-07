package gr.hua.dit.ds.ergasia.entities;

import jakarta.persistence.*;


import java.util.List;

@Table
@Entity
public class shelter   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer Id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private String approvalStatus;

    @Column
    private String contactInfo;

    public shelter() {

    }



    @OneToMany(mappedBy = "shelter",  cascade = CascadeType.ALL)
    private List<pet> pets;

    @OneToMany(mappedBy = "shelter",  cascade = CascadeType.ALL)
    private List<AdoptionRequest> adoptionRequests;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
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

    public shelter(Integer id, String Name, String location, String approvalStatus, String contactInfo, List<pet> pets, List<AdoptionRequest> adoptionRequests) {
        Id = id;
        name = Name;
        this.location = location;
        this.approvalStatus = approvalStatus;
        this.contactInfo = contactInfo;
        this.pets = pets;
        this.adoptionRequests = adoptionRequests;
    }

    @Override
    public String toString() {
        return "shelter{" +
                "Id=" + Id +
                ", Name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", aprovalStatus='" + approvalStatus + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", pets=" + pets +
                ", adoptionRequests=" + adoptionRequests +
                '}';
    }
}
