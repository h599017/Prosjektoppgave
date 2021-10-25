package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	public KortSamling() {
		samling = new Kort[MAKS_KORT];
	}

	public Kort[] getSamling() {

		return samling;

	}

	public int getAntalKort() {
		int antall = 0;
		for (int i = 0; i < samling.length; i++) {
			if (samling[i] != null) {
				antall += 1;
			}
		}
		return antall;
	}

	public boolean erTom() {
		boolean tom = false;
		if (samling[0] == null) {
			tom = true;
		}
		return tom;
	}

	public void leggTil(Kort kort) {
		for (int i = 0; i < samling.length; i++) {
			if (samling[i] == null) {
				samling[i] = kort;
				break;
			}
		}
	}

	public void leggTilAlle() {
		for (int i = 0; i < samling.length; i++) {
			samling[i] = null;
		}
		for (Kortfarge f : Kortfarge.values()) {
			for (int i = 1; i <= Regler.MAKS_KORT_FARGE; i++) {
				leggTil(new Kort(f, i));
			}
		}
	}

	public void fjernAlle() {
		for (int i = 0; i < samling.length; i++) {
			samling[i] = null;
		}
	}

	public Kort seSiste() {
		Kort siste = samling[samling.length - 1];
		if (samling[0] == null) {
			return null;
		}
		for (int i = 0; i < samling.length; i++) {
			if (samling[i] == null && i != 0) {
				siste = samling[i - 1];
				break;
			}
		}
		return siste;
	}

	public Kort taSiste() {
		Kort siste = samling[samling.length - 1];
		if (samling[0] == null) {
			return null;
		}
		if (getAntalKort() != samling.length) {
			for (int i = 0; i < samling.length; i++) {
				if (samling[i] == null && i != 0) {
					siste = samling[i - 1];
					samling[i - 1] = null;
					break;
				}
			}
		} else {
			samling[samling.length - 1] = null;
		}
		return siste;
	}

	public boolean har(Kort kort) {
		if (kort != null) {
			for (int i = 0; i < samling.length; i++) {
				if (kort.equals(samling[i])) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean fjern(Kort kort) {
		if (kort != null) {
			for (int i = 0; i < samling.length; i++) {
				if (kort.equals(samling[i])) {
					samling[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	public Kort[] getAllekort() {
		Kort[] alle = new Kort[getAntalKort()];
		for (int i = 0; i < getAntalKort(); i++) {
			alle[i] = samling[i];
		}
		return alle;
	}

}
