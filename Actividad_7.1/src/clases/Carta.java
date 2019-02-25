package clases;

import enumerados.Valor;
import enumerados.Palo;

// POR AHORA ACABADA

public class Carta {
	private Valor valor;
	private Palo palo;

	public Carta(Valor valor, Palo palo) {
		this.valor = valor;
		this.palo = palo;
	}

	public Carta() {
		this.valor = null;
		this.palo = null;
	}

	public Carta toclone() {
		Carta c = new Carta(this.valor,this.palo);
		return c;
	}
	
	public Valor getValor() {
		return this.valor;
	}
	
	public Palo getPalo() {
		return this.palo;
	}
	
	
	public double getPuntos() {
		return this.valor.getPuntos();
	}
	
	@Override
	public String toString() {
		return valor + " de " + palo + " \n";
	}
	
	
}
