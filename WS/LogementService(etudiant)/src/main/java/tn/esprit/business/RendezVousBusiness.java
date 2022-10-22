package tn.esprit.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import tn.esprit.entites.Logement;
import tn.esprit.entites.RendezVous;

public class RendezVousBusiness {
	private static final List<RendezVous> listeRendezVous = new ArrayList<RendezVous>();
	private static final LogementBusiness logementMetier = new LogementBusiness();

	public RendezVousBusiness() {
		listeRendezVous
				.add(new RendezVous(1, "31-10-2015", "15:30", logementMetier.getLogementsByReference(4), "55214078"));
		listeRendezVous
				.add(new RendezVous(2, "20-12-2015", "9:00", logementMetier.getLogementsByReference(1), "21300811"));
		listeRendezVous
				.add(new RendezVous(3, "17-09-2015", "9:15", logementMetier.getLogementsByReference(4), "98102102"));

	}

	public boolean addRendezVous(RendezVous rendezVous) {
		Logement logement = logementMetier.getLogementsByReference(rendezVous.getLogement().getReference());

		if (logement == null)
			return false;

		if (listeRendezVous.contains(rendezVous))
			return false;

		rendezVous.setLogement(logement);

		listeRendezVous.add(rendezVous);

		return true;

	}

	public boolean updateRendezVous(int idRendezVous, RendezVous rendezVous) {
		Optional<RendezVous> rdvOpt = listeRendezVous.stream().filter(r -> r.getId() == idRendezVous).findFirst();

		if (!rdvOpt.isPresent())
			return false;

		RendezVous rdv = rdvOpt.get();

		listeRendezVous.get(listeRendezVous.indexOf(rdv)).setDate(rendezVous.getDate());
		listeRendezVous.get(listeRendezVous.indexOf(rdv)).setHeure(rendezVous.getHeure());
		listeRendezVous.get(listeRendezVous.indexOf(rdv)).setNumTel(rendezVous.getNumTel());
		listeRendezVous.get(listeRendezVous.indexOf(rdv)).setId(rendezVous.getId());

		Logement logement = logementMetier.getLogementsByReference(rendezVous.getLogement().getReference());

		if (logement == null)
			return false;

		listeRendezVous.get(listeRendezVous.indexOf(rdv)).setLogement(logement);

		return true;

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
