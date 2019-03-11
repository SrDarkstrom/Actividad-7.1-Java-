package enumerados;
/**
 * Este enumerado sirve para determinar el valor de cada carta y a su vez devolver cuanto vale cada carta
 * 
 * @author Pablo Cabello, Sergio Millan, Jose Angel Viyuela
 * @version 1.0
 * @since 2019-02-15
 *
 */

public enum Valor{
	UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), SOTA(0.5), CABALLO(0.5), REY(0.5);
	
	double puntos;
	
	/**
	 * Este es el constructor del enumerado.
	 * 
	 * @param se le introduce el valor de cada carta y se iguala a una variable llamada puntos.
	 */
	Valor (double valor){
		puntos = valor;
	}
	
	/**
	 * Devuelve el valor de la variable puntos.
	 */
	public double getPuntos() {
		return puntos;
	}

};
	

