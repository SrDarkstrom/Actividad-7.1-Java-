package clases;

import enumerados.Valor;
import enumerados.Palo;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;


// POR AHORA HECHO
/**
 * La funcion de la case baraja es la de crear un array de objeto carta llamado baraja y barajar dicho array.
 * 
 * @author Pablo Cabello, Sergio Millan, Jose Angel Viyuela
 * @version 1.0
 * @since 2019-02-15
 */

public class Baraja {
	
	private Carta baraja[] = new Carta[40];
	/**
	 * El contructor crea la baraja con 10 cartas de cada palo usando el valor de los enumerados PALO y VALOR.
	 */
	public Baraja() {
		for(int i = 0; i < baraja.length; i++) {
			baraja[i] = new Carta(Valor.values()[i%10], Palo.values()[i/10]);
		}
	}
	
	/**
	 * La funcion de este metodo es la de mezclar la baraja, para ello se crea un objeto r de la clase random, despues mediante un blucle
	 * se crea un entero el cual es un entero de r entre 0-39 entonces crea una carta c donde la mete la carta de la baraja que este en esa
	 * posicion, despues en esa posicion introduce la carta que haya en la posicion del entero en la baraja y despues a la posicion de entero
	 * le mete la carta c creada antes.
	 * 
	 */
	public void barajarMedioNivel() {
		
		SecureRandom r = new SecureRandom();
		for (int i = 0; i < baraja.length; i++) {
			int entero = r.nextInt(baraja.length);
			Carta c = baraja[i];
			baraja[i] = baraja[entero];
			baraja[entero] = c;
		}
	}
	
	/**
	 * La funcion de este metodo es la de decir cuantas cartas quedan en la baraja en el momento que se precise.
	 */
	public int getCartasRestantes() {
		int num = 0;
		for (int i = 0;baraja[i] == null;i++) {
			num = i;
		}
		num = 39 - num;
		return num;
	}
	
	/**
	 * Muestra la baraja
	 * @return Devuelve la baraja
	 */
	public Carta[] getBaraja() {
		return baraja;
	}
	
	/**
	 * Devuelve el valor de la carta para luego poder sumar los puntos
	 * @param El parametro i es la posicion de la carta deseada en la mano de el jugador
	 * @return Devuelve el valor de la carta
	 */
	public Valor getValor(int i) {
		return this.baraja[i].getValor();
	}
	
	public String toString() {
		return "Baraja [" + Arrays.toString(baraja) + "]";
	}
}
