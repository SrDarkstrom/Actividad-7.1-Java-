package clases;

import enumerados.Valor;

public class Jugador {
	/**
	 * Esta clase tiene la funcion de crear los jugadores ademas de establecer la reglas del juego
	 * 
	 * @author Pablo Cabello, Sergio Millan, Jose Angel Viyuela
	 * @version 1.0
	 * @since 2019-02-15
	 */
	private Carta mano[] = new Carta [14];
	private static Baraja baraja = new Baraja();
	private String nombre;
	private boolean banca,juega;
	
	public Jugador(String nombre, boolean banca) {
		/**
		 * Crea cada jugador con su mano de 14 cartas y establece su nombre y si es la banca o no
		 * @param Nombre establece el nombre de cada jugador
		 * @param banca dice si es la banca o no
		 */
		juega = true;
		this.setNombre(nombre);
		this.banca = banca;
		for (int i = 0; i < mano.length; i++) {
			mano[i] = new Carta();
		}
	}
	
	public void repartoInicial() {
		/**
		 * La funcion de este metodo es la de repartir la primera carta a cada jugador. Para ello busca en su mano el primer hueco disponible y le asigna una carta 
		 * de la baraja mezclada
		 */
		boolean sw = false;
		baraja.barajarMedioNivel();
		for (int i = 0; i < 40 && sw == false; i++) {
			if(mano[i] != null) {
				if(baraja.getBaraja()[i] != null) {
					mano[i] = baraja.getBaraja()[i];
					baraja.getBaraja()[i] = null;
					sw = true;
					break;
				}else {
				sw = false;
				}
			}
		}
	}
	
	public void robar(Jugador jugadores[]) {
		/**
		 * La funcion de este metodo es la de dar una carta a los jugadores en el caso de que estos decidan que la quieren, 
		 * para ello busca el hueco en la mano y le asigna una de las cartas restantes de la baraja.
		 * En el caso de la banca, despues de calcular la probabilidad, si es favorable, el método para robar es igual que 
		 * el de los jugadores.
		 * 
		 * @param jugadores sirve para saber que jugador esta robando en cada momento
		 */
		if (banca) {
				for (int i = 0;i < 14; i++) {
						if(mano[i].getPalo() == null && mano[i].getValor() == null) {
							mano[i] = baraja.getBaraja()[baraja.getBaraja().length - baraja.getCartasRestantes()];
							baraja.getBaraja()[baraja.getBaraja().length - baraja.getCartasRestantes()] = null;
							break;
						}
				}
		} else {
			for (int i = 0;i < 14; i++) {
				if(mano[i].getPalo() == null && mano[i].getValor() == null) {
					mano[i] = baraja.getBaraja()[baraja.getBaraja().length - baraja.getCartasRestantes()];
					baraja.getBaraja()[baraja.getBaraja().length - baraja.getCartasRestantes()] = null;
					break;
				}
			}
		}
	}
	
	public double sumarPuntos() {
		/**
		 * La funcion de este metodo es la de sumar los puntos de la mano de cada jugador. Para ello saca el valor 
		 * de todas las cartas en la mano de dicho jugador y los suma.
		 */
		double acum = 0;
		Valor valor = null;
		int i = 0;
		while(mano[i].getPalo() != null && mano[i].getValor() != null) {
			valor = mano[i].getValor();
			acum = acum + valor.getPuntos();
			i++;
		}
		return acum;
	}

	public static int mayorPuntacionLugar(Jugador jugadores[]) {
		/**
		 * La funcion de este metodo es la de decir que jugador es el que mas puntuacion tiene sin pasarse de 7.5.
		 * Una vez sumado y calculado devulve la posicion de dicho jugador en el array de jugadores.
		 * 
		 * @param jugadores sirve para comprobar todos los jugadores y saber que jugador es el que mas puntuacion tiene
		 * @return devuelve la posicion del jugador con la mayor puntucacion
		 */
		int mayorlugar = 0;
		double mayor = -50000;
		for (int i = 0; i < jugadores.length - 1; i++) {
			if(jugadores[i].sumarPuntos() > mayor && jugadores[i].sumarPuntos() <= 7.5) {
				mayorlugar = i;
				mayor = jugadores[i].sumarPuntos();
			}
		}
		return mayorlugar;
	}
	
	public static double mayorPuntuacion(Jugador jugadores[]) {
		double mayor;
		mayor = jugadores[Jugador.mayorPuntacionLugar(jugadores)].sumarPuntos();
		return mayor;
	}
	
	public double probabilidad(Jugador jugadores[], int tam) {
		/**
		 * La funcion de este metodo es la de calcular la probabilidad que tiene la banca de pasarse respecto al jugador con mayor puntuacion
		 * en el momento de su uso. Para calcularla primero hay que sumar la puntuacion de la banca y restarla a la puntuacion del jugador.
		 * Una vez obtenido el resto hay que ver que cartas le sirven para no pasarse, siempre que se encuentre una de esas cartas se suma 1 al contador.
		 * Una vez obtenidas todas las cartas posible se divide entre la baraja restante y se multiplica por 100 y esa es la probabilidad.
		 * 
		 * @param jugadores sirve para saber que jugador tiene mayor puntuacion
		 */
		double banca, resto, probabilidad;
		int cont = 0;
		Valor valor = null;
		
		banca = jugadores[tam].sumarPuntos();
		resto = Math.abs(Jugador.mayorPuntuacion(jugadores)-banca);
		
		if(resto == 0.5) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5) {
					cont++;
					}
				}
			}
		}
		if(resto == 1) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1) {
						cont++;
					}
				}
			}
		}
		if(resto == 1.5) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1) {
						cont++;
					}
				}
			}
		}
		if(resto == 2) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1 || valor.getPuntos() == 2) {
						cont++;
					}
				}
			}
		}
		if(resto == 2.5) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1 || valor.getPuntos() == 2) {
						cont++;
					}
				}
			}
		}
		if(resto == 3) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1 || valor.getPuntos() == 2 || valor.getPuntos() == 3) {
						cont++;
					}
				}
			}
		}
		if(resto == 3.5) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1 || valor.getPuntos() == 2 || valor.getPuntos() == 3) {
						cont++;
					}
				}	
			}
		}
		if(resto == 4) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1 || valor.getPuntos() == 2 || valor.getPuntos() == 3 || valor.getPuntos() == 4) {
						cont++;
					}
				}
			}
		}
		if(resto == 4.5) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1 || valor.getPuntos() == 2 || valor.getPuntos() == 3 || valor.getPuntos() == 4) {
						cont++;
					}
				}
			}
		}
		if(resto == 5) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1 || valor.getPuntos() == 2 || valor.getPuntos() == 3 || valor.getPuntos() == 4  || valor.getPuntos() == 5) {
						cont++;
					}
				}
			}
		}
		if(resto == 5.5) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1 || valor.getPuntos() == 2 || valor.getPuntos() == 3 || valor.getPuntos() == 4  || valor.getPuntos() == 5) {
						cont++;
					}
				}
			}
		}
		if(resto == 6) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1 || valor.getPuntos() == 2 || valor.getPuntos() == 3 || valor.getPuntos() == 4  || valor.getPuntos() == 5   || valor.getPuntos() == 6) {
						cont++;
					}
				}
			}
		}
		if(resto == 6.5) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1 || valor.getPuntos() == 2 || valor.getPuntos() == 3 || valor.getPuntos() == 4  || valor.getPuntos() == 5   || valor.getPuntos() == 6) {
						cont++;
					}
				}
			}
		}
		if(resto == 7) {
			for (int i = 0; i < 40; i++) {
				if(baraja.getBaraja()[i] != null) {
					valor = baraja.getValor(i);
					if(valor.getPuntos() == 0.5 || valor.getPuntos() == 1 || valor.getPuntos() == 2 || valor.getPuntos() == 3 || valor.getPuntos() == 4  || valor.getPuntos() == 5   || valor.getPuntos() == 6    || valor.getPuntos() == 7) {
						cont++;
					}
				}
			}
		}
		
		probabilidad = (cont/Jugador.baraja.getCartasRestantes())*100;
		
		return probabilidad;
	}
	
	public static int getCartasRestantesBaraja() {
		/**
		 * Devuelve cuantas cartas quedan en la baraja
		 */
		return baraja.getCartasRestantes();
	}
	
	public int getCartasRestantes() {
		/**
		 * La funcion de este metodo es la de devolver el numero de cartas restantes en la baraja
		 */
		int num = 0;
		for (int i = 0;mano[i] == null;i++) {
			num = i;
		}
		num = 13 - num;
		return num;
	}
	
	public static boolean seHanPasadoTodos(Jugador jugadores[]) {
		/**
		 * Este metodo comprueba si todos los jugadores se han pasado de 7.5 o no y devulve false en el caso de que no lo hayan hecho o true en 
		 * el caso de que si lo hayan hecho
		 */
		boolean b = true;
		for (int i = 0;i < jugadores.length - 1 && b;i++) {
			if(jugadores[i].sumarPuntos() <= 7.5) {
				b = false;
			}
		}
		return b;
	}

	public static Baraja getBaraja() {
		/**
		 * Devuelve la baraja
		 */
		return baraja;
	}

	public static void setBaraja(Baraja baraja) {
		/**
		 * Establece la baraja
		 */
		Jugador.baraja = baraja;
	}
	
	public String getNombre() {
		/**
		 * Devuelve el nombre
		 */
		return nombre;
	}

	public void setNombre(String nombre) {
		/**
		 * Establece el nombre
		 */
		this.nombre = nombre;
	}

	public boolean isBanca() {
		/**
		 * Devuelve si el jugador es la banca o no
		 */
		return banca;
	}

	public void setBanca(boolean banca) {
		/**
		 * Establece si el jugador es la banca o no
		 */
		this.banca = banca;
	}
	
	public boolean isJuega() {
		/**
		 * Devulve si el jugador sigue jugando o no
		 */
		return juega;
	}
	
	public void setJuega(boolean juega) {
		/**
		 * Establece si el jugador sigue jugando o no.
		 */
		this.juega = juega;
	}
	
	@Override
	public String toString() {
		String result = "Jugador " + nombre;
		
		for (int i = 0; i < mano.length; i++) {
			if (mano[i].getPalo() != null) {
				result += " Carta " + mano[i];
			}
		}
		
		return result;
	}

}