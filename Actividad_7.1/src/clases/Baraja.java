package clases;

import enumerados.Valor;
import enumerados.Palo;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;


// POR AHORA HECHO

public class Baraja {
	private Carta baraja[] = new Carta[40];
	
	public Baraja() {
		for(int i = 0; i < baraja.length; i++) {
			baraja[i] = new Carta(Valor.values()[i%10], Palo.values()[i/10]);
		}
	}
	
	public void barajarAltoNivel() {
		Collections.shuffle(Arrays.asList(baraja));
	}
	
	public void barajarMedioNivel() {
		SecureRandom r = new SecureRandom();
		for (int i = 0; i < baraja.length; i++) {
			int entero = r.nextInt(baraja.length);
			Carta meme = baraja[i];
			baraja[i] = baraja[entero];
			baraja[entero] = meme;
		}
	}
	
	public Carta[] getBaraja() {
		return baraja;
	}

	public String toString() {
		return "Baraja [" + Arrays.toString(baraja) + "]";
	}
}
