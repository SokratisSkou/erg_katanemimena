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
    @Column
    private Integer Id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    @Column(name = "visit_date", nullable = false)
    private LocalDate visitDate;

    @Column(name = "visit_time", nullable = false)
    private LocalTime visitTime;

    @Column(name = "status", nullable = false)
    private String status;

    public VisitSchedule(Integer id,LocalDate visitDate, LocalTime visitTime, Citizen citizen,String status) {
        Id = id;
        this.visitDate = visitDate;
        this.visitTime = visitTime;
        this.citizen = citizen;

        this.status = status;
    }

    public VisitSchedule() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
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

    @Override
    public String toString() {
        return "VisitSchedule{" +
                "id=" + Id +
                ", citizen=" + citizen +
                ", visitDate=" + visitDate +
                ", visitTime=" + visitTime +
                ", status='" + status + '\'' +
                '}';
    }
}