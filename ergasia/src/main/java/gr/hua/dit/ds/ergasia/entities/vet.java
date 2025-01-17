package gr.hua.dit.ds.ergasia.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class vet extends user{
    @Column
    private String ContactInfo;

    public vet(int id, String UserName, String name, String password, int age, String ContactInfo,String email) {
        super(id,UserName,name,password,age,email);
        this.ContactInfo = ContactInfo;
    }

    public vet() {

    }

    @OneToMany(mappedBy = "vet", cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private  List<pet> pets;


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
