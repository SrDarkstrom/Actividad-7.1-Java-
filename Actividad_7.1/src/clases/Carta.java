package clases;

import enumerados.Valor;
import enumerados.Palo;

/**
 * Esta Clase crea cartas mediante dos enumerados, VALOR y PALO.
 * 
 * @author Pablo Cabello, Sergio Millan, Jose Angel Viyuela
 * @version 1.0
 * @since 2019-02-15
 */

public class Carta {
	
	private Valor valor;
	private Palo palo;
	/**
	 * Constructor con los valores de los enumerados para crear las 40 cartas
	 * 
	 * @param valor es el valor que tendra la carta (as,caballo,etc...)
	 * @param palo es el palo que tendra la carta (oro,bastos,etc...)
	 */
	public Carta(Valor valor, Palo palo) {
		this.valor = valor;
		this.palo = palo;
	}

	/**
	 * Crea las carta con valor y palo null
	 */
	public Carta() {
		this.valor = null;
		this.palo = null;
	}

	public Carta toclone() {
		Carta c = new Carta(this.valor,this.palo);
		return c;
	}
	/**
	 * Devuelve el valor de la carta
	 * @return Devuelve el valor de la carta
	 */
	public Valor getValor() {
		return this.valor;
	}
	/**
	 * Devuelve el palo de la carta 
	 * @return Devuelve el palo de la carta
	 */
	public Palo getPalo() {
		return this.palo;
	}
	
	/**
	 * Devuelve los puntos del jugador
	 * @return Devuelve los puntos del jugador
	 */
	public double getPuntos() {
		return this.valor.getPuntos();
	}
	
	@Override
	public String toString() {
		return valor + " de " + palo + " \n";
	}
	
	
}
