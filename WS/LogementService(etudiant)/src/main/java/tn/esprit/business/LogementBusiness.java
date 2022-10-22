package tn.esprit.business;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import tn.esprit.entites.Logement;
import tn.esprit.entites.Type;

public class LogementBusiness {

	private static final List<Logement> logements = new ArrayList<Logement>();

	public LogementBusiness() {
		logements.add(
				new Logement(1, "27, Rue des roses", "El ghazela", "Ariana", Type.Studio, "cuisine equipee", 300f));
		logements.add(
				new Logement(5, "58, Rue des roses", "El ghazela", "Ariana", Type.EtageVilla, "cuisine equipee", 450f));
		logements.add(new Logement(2, "201, R�sidence Omrane4", "Riadh El Andalous", "Ariana", Type.Appartement,
				"chauffage central, ascenseur, climatisation", 700f));
		logements.add(new Logement(3, "540, R�sidence Les Tulipes", "El Aouina", "Ariana", Type.Appartement,
				"S+2, chauffage central, ascenseur, climatisation", 500f));
		logements.add(new Logement(4, "78, Rue des Oranges", "Bardo", "Tunis", Type.EtageVilla,
				"chauffage central, ascenseur, climatisation", 400f));
	}

	public List<Logement> getLogements() {
		return logements;
	}

	public Logement getLogementsByReference(int reference) {

		return logements.stream().filter(l -> l.getReference() == reference).findFirst().orElse(null);
	}

	public List<Logement> getLogementsByDeleguation(String deleguation) {

		return logements.stream().filter(l -> l.getDeleguation().equals(deleguation)).collect(Collectors.toList());
	}

	public List<Logement> getLogementsByGouvernorat(String gouvernorat) {

		return logements.stream().filter(l -> l.getGouvernorat().equals(gouvernorat)).collect(Collectors.toList());
	}

	public List<Logement> getLogementsByType(Type type) {

		return logements.stream().filter(l -> l.getType().equals(type)).collect(Collectors.toList());
	}

	public List<Logement> getLogementsByPrix(float prix) {

		return logements.stream().filter(l -> l.getPrix() <= prix).collect(Collectors.toList());
	}

}
