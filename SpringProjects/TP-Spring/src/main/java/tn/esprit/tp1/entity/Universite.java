package tn.esprit.tp1.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "universite")
public class Universite implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniv;

    private String nomUniv;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Departement> departments;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private DetailEquipe detailEquipe;
}
