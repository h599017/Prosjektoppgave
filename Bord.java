package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.KortUtils;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.modell.Kort;


public class Bord {

	private KortSamling bunkeFra;
	private KortSamling bunkeTil;


	public Bord() {
		bunkeFra = new KortSamling();
		bunkeTil = new KortSamling();
		bunkeFra.leggTilAlle();
		KortUtils.stokk(bunkeFra);
	}

	public KortSamling getBunkeTil() {

		return bunkeTil;

	}

	public KortSamling getBunkeFra() {

		return bunkeFra;

	}

	public boolean bunketilTom() {
		return bunkeTil.erTom();
	}

	public boolean bunkefraTom() {
		return bunkeFra.erTom();
	}

	public int antallBunkeFra() {
		return bunkeFra.getAntalKort();
	}

	public int antallBunkeTil() {
		return bunkeTil.getAntalKort();
	}

	public void vendOversteFraBunke() {
		bunkeTil.leggTil(bunkeFra.taSiste());
	}

	public Kort taOversteFraBunke() {
		return bunkeFra.taSiste();
	}

	public Kort seOversteBunkeTil() {
		return bunkeTil.seSiste();
	}

	public void snuTilBunken() {
		Kort siste = bunkeTil.taSiste();
		for (int i = 0; i < 4 * Regler.MAKS_KORT_FARGE; i++) {
			if (bunkeTil.seSiste() != null) {
				bunkeFra.leggTil(bunkeTil.taSiste());
			}
		}
		KortUtils.stokk(bunkeFra);
		bunkeTil.leggTil(siste);
	}

	public void leggNedBunkeTil(Kort k) {
		bunkeTil.leggTil(k);
	}
}
