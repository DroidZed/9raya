package tn.esprit.tp1.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "equipe")
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;

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
