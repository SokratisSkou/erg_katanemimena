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
    private String healthStatus="pending";

    @Column
    private String approvalStatus="pending";


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

    @ManyToOne
    @JoinColumn(name="citizen_id")
    private Citizen citizen;


    public pet(int id, String name, String type,int age,String healthStatus,String approvalStatus,vet vet,shelter shelter,Citizen citizen) {
        this.petId = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.healthStatus = healthStatus;
        this.approvalStatus = approvalStatus;
        this.vet = vet;
        this.shelter = shelter;
        this.citizen = citizen;
    }


    public shelter getShelter() {
        return shelter;
    }

    public int getshelterId() {return shelter.getId();}

    public void setShelter(shelter shelter) {
        this.shelter = shelter;
    }
    public void setShelterId(int shelterId) {this.shelter.setId(shelterId);}

    public gr.hua.dit.ds.ergasia.entities.vet getVet() {
        return vet;
    }

    public void setVet(gr.hua.dit.ds.ergasia.entities.vet vet) {
        this.vet = vet;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }


    @Override
    public String toString() {
        return "pet{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", healthStatus='" + healthStatus + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", shelter=" + shelter +
                ", vet=" + vet +
                ", citizen=" + citizen +
                '}';
    }
}
