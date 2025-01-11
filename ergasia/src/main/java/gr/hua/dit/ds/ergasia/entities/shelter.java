package gr.hua.dit.ds.ergasia.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@Entity
public class shelter extends user {
    private String location;
    private String aprovalStatus;


    public String getAprovalStatus() {
        return aprovalStatus;
    }

    public void setAprovalStatus(String aprovalStatus) {
        this.aprovalStatus = aprovalStatus;
    }

    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public shelter(int id, String UserName, String name, String password, int age, String location, String aprovalStatus) {
        super(id, UserName, name, password, age);
        this.location = location;
        this.aprovalStatus = aprovalStatus;

    }

    @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL)
    private List<pet> pets;

    @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL)
    private List<AdoptionRequest> adoptionRequests;

    @Override
    public String toString() {
        return "shelter{" +
                "location='" + location + '\'' +
                ", aprovalStatus='" + aprovalStatus + '\'' +
                ", pets=" + pets +
                ", adoptionRequests=" + adoptionRequests +
                "} " + super.toString();
    }
}
