package gr.hua.dit.ds.ergasia.entities;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Entity
@Table(name = "visit_schedule")

public class VisitSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "shelter_id")
    private shelter shelter;

    @Column(name = "visit_date", nullable = false)
    private LocalDate visitDate;

    @Column(name = "visit_time", nullable = false)
    private LocalTime visitTime;

    @Column(name = "status", nullable = false)
    private String status;

    public VisitSchedule(LocalDate visitDate, LocalTime visitTime, Citizen citizen, shelter shelter) {
        this.visitDate = visitDate;
        this.visitTime = visitTime;
        this.citizen = citizen;
        this.shelter = shelter;
        this.status = "Pending";
    }

    public VisitSchedule() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public gr.hua.dit.ds.ergasia.entities.shelter getShelter() {
        return shelter;
    }

    public void setShelter(gr.hua.dit.ds.ergasia.entities.shelter shelter) {
        this.shelter = shelter;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public LocalTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalTime visitTime) {
        this.visitTime = visitTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}