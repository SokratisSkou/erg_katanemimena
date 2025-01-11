package gr.hua.dit.ds.ergasia.entities;
import gr.hua.dit.ds.ergasia.entities.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class VisitSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Citizen interestedParty;

    @ManyToOne
    private shelter shelter;

    private String visitDate;
}