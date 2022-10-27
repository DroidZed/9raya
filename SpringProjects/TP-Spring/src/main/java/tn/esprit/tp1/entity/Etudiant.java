package tn.esprit.tp1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "etudiant")
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;

    private String nom, prenom;

    @Enumerated(EnumType.ORDINAL)
    private Option option;

    @JsonIgnore
    @JoinColumn(name = "id_depart")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departement departement;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "etudiant_equipe",
            joinColumns = @JoinColumn(name = "id_etudiant"),
            inverseJoinColumns = @JoinColumn(name = "id_equipe")
    )
    private Set<Equipe> equipes;

    @OneToMany(mappedBy = "etudiant", fetch = FetchType.EAGER)
    private List<Contrat> contrats;
}
