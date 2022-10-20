package tn.esprit.tp1.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "detail_equipe")
public class DetailEquipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long salle;

    private String thematique;

    @OneToOne(targetEntity = Equipe.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Equipe equipe;
}
