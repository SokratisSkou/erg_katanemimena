package gr.hua.dit.ds.ergasia.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class vet extends user{
    private String ContactInfo;

    public vet(int id, String UserName, String name, String password, int age, String ContactInfo) {
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
