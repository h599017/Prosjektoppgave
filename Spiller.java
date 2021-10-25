package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.KortUtils;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Abstrakt klasse som implementerer alle metodene i kontrakten (interfacet) ISpiller,
 * bortsett fra nesteHandling(). Dette er grunnen til at klassen er abstrakt.
 * For å lage "virkelige" spillere, må vi arve fra denne klassen og implementere
 * nesteHandling (fra ISpiller).
 * 
 * Klassen har objektvariablene hand (Hand), antalltrekk (heltall) og spiller
 * (Spillere). Den har to konstruktører. Se beskrivelse av disse.
 * 
 */
public abstract class Spiller implements ISpiller {

	private KortSamling hand; 
	
	private int antalltrekk; 
	
	private Spillere spiller;

	public Spiller() {
		hand = new KortSamling();
		antalltrekk = 0;
		spiller = Spillere.INGEN;
	}

	public Spiller(Spillere spiller) {
		hand = new KortSamling();
		this.spiller = spiller;
	}

	
	public int getAntallKort() {
		return hand.getAntalKort();
	}

	
	public KortSamling getHand() {
		return hand;
	}

	
	public int getAntallTrekk() {
		return antalltrekk;
	}

	
	public Spillere hvem() {
		return spiller;
	}

	
	public void setAntallTrekk(int t) {
		antalltrekk = t;
	}

	
	public boolean erFerdig() {
		boolean ferdig = false;
		if(hand.erTom()) {
			ferdig = true;
		}
		return ferdig;
	}

	
	public void leggTilKort(Kort kort) {
		hand.leggTil(kort);
	}

	
	public void fjernKort(Kort kort) {
		hand.fjern(kort);
	}

	
	public void fjernAlleKort() {
		hand.fjernAlle();
	}

	
	public void trekker(Kort kort) {
		hand.leggTil(kort);
		antalltrekk += 1;
	}
}
