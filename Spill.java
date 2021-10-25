package no.hvl.dat100.prosjekt.kontroll;

import java.util.ArrayList;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.KortUtils;

/**
 * Klassen har objektvariaber som er referanser til de spillerne, nord og syd
 * (type ISpiller). Den har ogsÂ en bunke man deler/trekker fra og en bunke man
 * spiller til.
 * 
 */
public class Spill {

	private ISpiller nord;
	private ISpiller syd;

	private Bord bord;

	public final static int ANTALL_KORT_START = Regler.ANTALL_KORT_START;

	public Spill() {
		bord = new Bord();
		nord = new NordSpiller(Spillere.NORD);
		syd = new SydSpiller(Spillere.SYD);

	}

	public Bord getBord() {
		return bord;
	}

	public ISpiller getSyd() {
		return syd;
	}

	public ISpiller getNord() {
		return nord;
	}

	/**
	 * Metoden oppretter to spillere, nord og syd. Det opprettes to bunker, fra og
	 * til. Alle kortene legges til fra. Bunken fra stokkes. Deretter deles det ut
	 * kort fra fra-bunken til nord og syd i henhold til regler. Til slutt tas
	 * øverste kortet fra fra-bunken og legges til til-bunken.
	 * 
	 * Nord har type RandomSpiller (som er forhåndefinert). Syd vil være spiller
	 * av en klasse laget av gruppen (implementeres i oppgave 3).
	 */
	public void start() {
		Spill spill = new Spill();
		spill.delutKort();
		bord.vendOversteFraBunke();
	}


	private void delutKort() {
		for (int i = 0; i < ANTALL_KORT_START; i++) {
			nord.leggTilKort(bord.taOversteFraBunke());
			syd.leggTilKort(bord.taOversteFraBunke());
		}
	}

	public Kort trekkFraBunke(ISpiller spiller) {
		if (bord.bunkefraTom()) {
			bord.snuTilBunken();
		}
		spiller.setAntallTrekk(spiller.getAntallTrekk()+1);
		return bord.taOversteFraBunke();
	}

	/**
	 * Gir neste handling for en spiller (spilt et kort, trekker et kort, forbi)
	 * 
	 * @param spiller spiller som handle.
	 * 
	 * @return handlingen som blir utført.
	 */
	public Handling nesteHandling(ISpiller spiller) {

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - END

	}

	/**
	 * Metoden spiller et kort. Den sjekker at spiller har kortet. Dersom det er
	 * tilfelle, fjernes kortet fra spilleren og legges til til-bunken. Metoden
	 * nulltiller også antall ganger spilleren har trukket kort.
	 * 
	 * @param spiller den som spiller.
	 * @param kort    kort som spilles.
	 * 
	 * @return true dersom spilleren har kortet, false ellers.
	 */
	public boolean leggnedKort(ISpiller spiller, Kort kort) {
		if(spiller.getHand().har(kort)) {
			spiller.getHand().fjern(kort);
			bord.leggNedBunkeTil(kort);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metode for å si forbi. Må nullstille antall ganger spilleren har trukket
	 * kort.
	 * 
	 * @param spiller spilleren som er i tur.
	 */
	public void forbiSpiller(ISpiller spiller) {

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	}

	/**
	 * Metode for å utføre en handling (trekke, spille, forbi). Dersom handling er
	 * kort, blir kortet også spilt.
	 * 
	 * @param spiller  spiller som utfører handlingen.
	 * @param handling handling som utføres.
	 * 
	 * @return kort som trekkes, kort som spilles eller null ved forbi.
	 */
	public Kort utforHandling(ISpiller spiller, Handling handling) {
		Kort kort = null;

		// Hint: del opp i de tre mulige handlinger og vurder
		// om noen andre private metoder i klassen kan brukes
		// til å implementere denne metoden

		throw new UnsupportedOperationException(TODO.method());

		// TODO - END
	}

}