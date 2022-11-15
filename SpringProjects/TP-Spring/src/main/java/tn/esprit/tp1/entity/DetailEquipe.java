package tn.esprit.tp1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetailEquipe;

    private Integer salle;

    private String thematique;

    @JsonIgnore
    @OneToOne(mappedBy = "detailEquipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Equipe equipe;
}
