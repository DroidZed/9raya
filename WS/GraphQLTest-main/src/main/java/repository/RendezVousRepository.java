package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import entite.Logement;
import entite.RendezVous;

public class RendezVousRepository {
	private final List<RendezVous> listeRendezVous;
	LogementRepository logementMetier = new LogementRepository();

	public RendezVousRepository() {
		listeRendezVous = new ArrayList<RendezVous>();
		listeRendezVous
				.add(new RendezVous(1, "31-10-2015", "15:30", logementMetier.getLogementsByReference(4), "55214078"));
		listeRendezVous
				.add(new RendezVous(2, "20-12-2015", "9:00", logementMetier.getLogementsByReference(1), "21300811"));
		listeRendezVous
				.add(new RendezVous(3, "17-09-2015", "9:15", logementMetier.getLogementsByReference(4), "98102102"));
	}

	public RendezVous addRendezVous(int id, String date, String heure, int refLog, String num) {

		Logement logement = logementMetier.getLogementsByReference(refLog);

		if (logement == null)
			return null;

		RendezVous rdv = new RendezVous(id, date, heure, logement, num);

		if (listeRendezVous.contains(rdv))
			return null;

		listeRendezVous.add(rdv);

		return rdv;

	}

	public RendezVous updateRendezVous(int id, String date, String heure, String num) {
		Optional<RendezVous> rdvOpt = listeRendezVous.stream().filter(r -> r.getId() == id).findFirst();

		if (!rdvOpt.isPresent())
			return null;

		RendezVous rdv = rdvOpt.get();

		listeRendezVous.get(listeRendezVous.indexOf(rdv)).setDate(date);
		listeRendezVous.get(listeRendezVous.indexOf(rdv)).setHeure(heure);
		listeRendezVous.get(listeRendezVous.indexOf(rdv)).setNumTel(num);

		Logement logement = logementMetier.getLogementsByReference(rdv.getLogement().getReference());

		if (logement == null)
			return null;

		listeRendezVous.get(listeRendezVous.indexOf(rdv)).setLogement(logement);

		return rdv;

	}

	public RendezVous getRendezVousById(int id) {
		return listeRendezVous.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
	}

	public boolean deleteRendezVous(int id) {

		RendezVous rdv = listeRendezVous.stream().filter(r -> r.getId() == id).findFirst().orElse(null);

		if (rdv == null)
			return false;

		listeRendezVous.remove(rdv);
		return true;
	}

	public List<RendezVous> getListeRendezVous() {
		return listeRendezVous;
	}

	public List<RendezVous> getListeRendezVousByLogementReference(int reference) {

		return listeRendezVous.stream().filter(r -> r.getLogement().getReference() == reference)
				.collect(Collectors.toList());
	}
}
