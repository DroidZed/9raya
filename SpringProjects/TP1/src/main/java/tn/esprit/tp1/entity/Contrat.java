package tn.esprit.tp1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contrat")
public class Contrat  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrat;

    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;

    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;

    @Enumerated(EnumType.ORDINAL)
    private Specialite specialite;

    private Boolean archive;

    @ManyToOne
    private Etudiant etudiant;
}
