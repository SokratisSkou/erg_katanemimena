package gr.hua.dit.ds.ergasia.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class AdoptionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Citizen citizen;

    @ManyToOne
    private pet pet;

    private String status; // e.g., "Pending", "Approved", "Rejected"
}