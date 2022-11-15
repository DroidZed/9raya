package tn.esprit.testspring.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "beneficiaire")
public class Beneficiaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBen;

    private Integer cin;

    private String nom, prenom, profession;

    private Float salaire;

    @OneToMany(
            mappedBy = "beneficiaire",
            fetch = FetchType.LAZY
    )
    private Set<Assurance> assurances;
}
