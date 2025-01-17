package gr.hua.dit.ds.ergasia.entities;

import jakarta.persistence.*;

@Table
@Entity
public class pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer petId;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private int age;

    @Column
    private String healthStatus;

    @Column
    private String approvalStatus;


    public pet() {

    }

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
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private shelter shelter;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private vet vet;


    public pet(int id, String name, String type,int age,String healthStatus,String approvalStatus,vet vet,shelter shelter) {
        this.petId = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.healthStatus = healthStatus;
        this.approvalStatus = approvalStatus;
        this.vet = vet;
        this.shelter = shelter;
    }


    public shelter getShelter() {
        return shelter;
    }

    public void setShelter(shelter shelter) {
        this.shelter = shelter;
    }


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
