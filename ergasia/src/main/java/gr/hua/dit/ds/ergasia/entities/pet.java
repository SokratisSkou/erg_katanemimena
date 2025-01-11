package gr.hua.dit.ds.ergasia.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petId;
    private String name;
    private String type;
    private int age;
    private String healthStatus;
    private String approvalStatus;

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public int getId() {
        return petId;
    }

    public void setId(int id) {
        this.petId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public pet(int id, String name, String type,int age,String healthStatus,String approvalStatus) {
        this.petId = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.healthStatus = healthStatus;
        this.approvalStatus = approvalStatus;
    }
    @ManyToOne
    private shelter shelter;

    @ManyToOne
    private vet vet;

    @Override
    public String toString() {
        return "pet{" +
                "id=" + petId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
}
