package tn.esprit.tp1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detail_equipe")
public class DetailEquipe  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer salle;

    private String thematique;

    @OneToOne(targetEntity = Equipe.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Equipe equipe;
}
