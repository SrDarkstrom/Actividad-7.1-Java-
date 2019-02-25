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
	
	// No usado
	public void barajarAltoNivel() {
		Collections.shuffle(Arrays.asList(baraja));
	}
	
	public void barajarMedioNivel() {
		SecureRandom r = new SecureRandom();
		for (int i = 0; i < baraja.length; i++) {
			int entero = r.nextInt(baraja.length);
			Carta c = baraja[i];
			baraja[i] = baraja[entero];
			baraja[entero] = c;
		}
	}
	
	public int getCartasRestantes() {
		int num = 0;
		for (int i = 0;baraja[i] == null;i++) {
			num = i;
		}
		num = 39 - num;
		return num;
	}
	
	public Carta[] getBaraja() {
		return baraja;
	}
	
	public Valor getValor(int i) {
		return this.baraja[i].getValor();
	}
	
	public String toString() {
		return "Baraja [" + Arrays.toString(baraja) + "]";
	}
}
