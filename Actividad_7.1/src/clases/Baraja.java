package clases;

import enumerados.Valor;
import enumerados.Palo;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;


// POR AHORA HECHO

public class Baraja {
	
	/**
	 * La funcion de la case baraja es la de crear y barajar la baraja del juego
	 * 
	 * @author Pablo Cabello, Sergio Millan, Jose Angel Viyuela
	 * @version 1.0
	 * @since 2019-02-15
	 */
	private Carta baraja[] = new Carta[40];
	
	public Baraja() {
		/**
		 * El contructor crea la baraja con 10 cartas de cada palo usando los enumerados PALO y VALOR
		 */
		for(int i = 0; i < baraja.length; i++) {
			baraja[i] = new Carta(Valor.values()[i%10], Palo.values()[i/10]);
		}
	}
	
	// No usado
	public void barajarAltoNivel() {
		Collections.shuffle(Arrays.asList(baraja));
	}
	
	public void barajarMedioNivel() {
		
		/**
		 * La funcion de este metodo es la de mezclar la baraja
		 * genera un r que es un numero aleatorio, la carta c se convierte en la primera carta de la baraja
		 * la primera carta se convierte en la carta aleatoria y la carta aleatoria se convierte en la carta c
		 *
		 */
		SecureRandom r = new SecureRandom();
		for (int i = 0; i < baraja.length; i++) {
			int entero = r.nextInt(baraja.length);
			Carta c = baraja[i];
			baraja[i] = baraja[entero];
			baraja[entero] = c;
		}
	}
	
	public int getCartasRestantes() {
		/**
		 * La funcion de este metodo es la de decir cuantas cartas quedan en la baraja en el momento que se precise
		 */
		int num = 0;
		for (int i = 0;baraja[i] == null;i++) {
			num = i;
		}
		num = 39 - num;
		return num;
	}
	
	public Carta[] getBaraja() {
		/**
		 * Muestra la baraja
		 * @return Devuelve la baraja
		 */
		return baraja;
	}
	
	public Valor getValor(int i) {
		/**
		 * Devuelve el valor de la carta para luego poder sumar los puntos
		 * @param El parametro i es la posicion de la carta deseada en la mano de el jugador
		 * @return Devuelve el valor de la carta
		 */
		return this.baraja[i].getValor();
	}
	
	public String toString() {
		return "Baraja [" + Arrays.toString(baraja) + "]";
	}
}
