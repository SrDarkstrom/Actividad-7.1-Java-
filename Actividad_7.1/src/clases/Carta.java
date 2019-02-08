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
		
	}

	public Carta toclone() {
		Carta c = new Carta(this.valor,this.palo);
		return c;
	}
	
	@Override
	public String toString() {
		return "Carta [valor=" + valor + ", palo=" + palo + "]\n";
	}
	
	
}
