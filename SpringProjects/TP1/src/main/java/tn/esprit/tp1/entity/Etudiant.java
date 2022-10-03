package tn.esprit.tp1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "etudiant")
public class Etudiant  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;

    private String nom, prenom;

    @Enumerated(EnumType.ORDINAL)
    private Option option;

    @ManyToOne
    @JsonIgnore
    private Departement departement;

    @ManyToMany
    @JoinTable(
            name = "etudiant_equipe",
            joinColumns = @JoinColumn(name = "id_etudiant"),
            inverseJoinColumns = @JoinColumn(name = "id_equipe")
    )
    private Set<Equipe> equipes;

    @OneToMany(mappedBy = "etudiant")
    private List<Contrat> contrats;
}
