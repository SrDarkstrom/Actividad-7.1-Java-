package enumerados;

public enum Valor{
	UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), SOTA(0.5), CABALLO(0.5), REY(0.5);
	
	double puntos;
	
	Valor (double valor){
		puntos = valor;
	}
	
	public double getPuntos() {
		return puntos;
	}

};
	

