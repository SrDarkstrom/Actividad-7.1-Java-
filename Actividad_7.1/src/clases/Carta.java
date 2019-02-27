package clases;

import enumerados.Valor;
import enumerados.Palo;

// POR AHORA ACABADA

public class Carta {
	
	/**
	 * Esta Clase crea todas las cartas
	 * 
	 * @author Pablo Cabello, Sergio Millan, Jose Angel Viyuela
	 * @version 1.0
	 * @since 2019-02-15
	 */
	private Valor valor;
	private Palo palo;

	public Carta(Valor valor, Palo palo) {
		/**
		 * Constructor con los parametros de los enumerados para crear las 40 cartas
		 * 
		 * @param valor es el valor que tendra la carta (as,caballo,etc...)
		 * @param palo es el palo que tendra la carta (oro,bastos,etc...)
		 */
		this.valor = valor;
		this.palo = palo;
	}

	public Carta() {
		/**
		 * Crea las carta con valor y palo null
		 */
		this.valor = null;
		this.palo = null;
	}

	public Carta toclone() {
		Carta c = new Carta(this.valor,this.palo);
		return c;
	}
	
	public Valor getValor() {
		/**
		 * Devuelve el valor de la carta
		 * @return Devuelve el valor de la carta
		 */
		return this.valor;
	}
	
	public Palo getPalo() {
		/**
		 * Devuelve el palo de la carta 
		 * @return Devuelve el palo de la carta
		 */
		return this.palo;
	}
	
	
	public double getPuntos() {
		/**
		 * Devuelve los puntos del jugador
		 * @return Devuelve los puntos del jugador
		 */
		return this.valor.getPuntos();
	}
	
	@Override
	public String toString() {
		return valor + " de " + palo + " \n";
	}
	
	
}
