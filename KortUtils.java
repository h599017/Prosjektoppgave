package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	public static void sorter(KortSamling samling) {
		Kort[] ph = new Kort[samling.getAntalKort()];
		for (int i = 0; i < ph.length;) {
			ph[i] = samling.taSiste();
		}
		for (int i = 0; i < ph.length; i++) {
			for (int j = 0; j < ph.length; j++) {
				if (ph[i].compareTo(ph[j]) > 0) {
					Kort phkort = ph[j];
					ph[j] = ph[i];
					ph[i] = phkort;
				}
			}

		}
		for (int i = 0; i < ph.length;) {
			samling.leggTil(ph[i]);
		}
	}

	public static void stokk(KortSamling samling) {
		Random random = new Random();
		Kort[] ph = new Kort[samling.getAntalKort()];
		for (int i = 0; i < ph.length;) {
			int r = random.nextInt(ph.length);
			if (ph[r] == null) {
				ph[r] = samling.taSiste();
				i++;
			}
		}
		for (int i = 0; i < ph.length; i++) {
			samling.leggTil(ph[i]);
		}
	}
}
