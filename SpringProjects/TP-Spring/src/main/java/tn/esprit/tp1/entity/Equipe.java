package tn.esprit.tp1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "equipe")
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipe;

    private String nomEquipe;

    @Enumerated(EnumType.ORDINAL)
    private Niveau niveau;

    @ManyToMany(mappedBy = "equipes")
    private Set<Etudiant> etudiants;

    @OneToOne(mappedBy = "equipe")
    private DetailEquipe detailEquipe;

    @ManyToOne
    private Etudiant etudiant;
}
