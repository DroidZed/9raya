package tn.esprit.tp1.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
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
    private Integer idEquipe;

    private String nomEquipe;

    @Enumerated(EnumType.ORDINAL)
    private Niveau niveau;

    @ManyToMany(mappedBy = "equipes", fetch = FetchType.EAGER)
    private Set<Etudiant> etudiants = new HashSet<>();

    @OneToOne(targetEntity = DetailEquipe.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_equipe")
    private DetailEquipe detailEquipe;
}
