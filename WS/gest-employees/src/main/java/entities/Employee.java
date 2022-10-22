package entities;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Employee {

	@XmlAttribute(name = "cin", required = true)
	private String cin;
	
	private String nom;

	private String prenom;
}
