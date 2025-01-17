package gr.hua.dit.ds.ergasia.entities;

import jakarta.persistence.*;

@Entity
@Table
public class AdoptionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "interested_party_id")
    private Citizen citizen;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private pet pet;
    @Column
    private String adminApprovalStatus; // "Pending", "Approved", "Rejected"

    @Column
    private String shelterApprovalStatus; // "Pending", "Approved", "Rejected"
    @Column
    private String status;// Final status: "Pending", "Approved", "Rejected"

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdminApprovalStatus() {
        return adminApprovalStatus;
    }

    public void setAdminApprovalStatus(String adminApprovalStatus) {
        this.adminApprovalStatus = adminApprovalStatus;
    }

    public String getShelterApprovalStatus() {
        return shelterApprovalStatus;
    }

    public void setShelterApprovalStatus(String shelterApprovalStatus) {
        this.shelterApprovalStatus = shelterApprovalStatus;
    }
    @ManyToOne
    @JoinColumn(name="shelter_id")
    private shelter shelter;


    @Override
    public String toString() {
        return "AdoptionRequest{" +
                "id=" + id +
                ", citizen=" + citizen +
                ", pet=" + pet +
                ", adminApprovalStatus='" + adminApprovalStatus + '\'' +
                ", shelterApprovalStatus='" + shelterApprovalStatus + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}