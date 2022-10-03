package tn.esprit.tp1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class ResponseObj  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
}
