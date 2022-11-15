package tn.esprit.testspring.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contrat")
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrat;

    private String matricule;

    @Temporal(TemporalType.DATE)
    private Date dateEffet;

    @Enumerated(EnumType.ORDINAL)
    private TypeContrat typeContrat;
}
