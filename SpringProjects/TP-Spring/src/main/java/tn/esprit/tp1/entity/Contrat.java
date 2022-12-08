package tn.esprit.tp1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "contrat")
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_contrat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrat;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_debut_contrat")
    private Date dateDebutContrat;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_fin_contrat")
    private Date dateFinContrat;

    @Enumerated(EnumType.ORDINAL)
    private Specialite specialite;

    private Boolean archive;

    private Integer montantContrat;

    @JsonIgnore
    @JoinColumn(name = "id_etudiant")
    @ManyToOne(fetch = FetchType.LAZY)
    private Etudiant etudiant;
}
