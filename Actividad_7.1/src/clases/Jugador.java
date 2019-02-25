package clases;

import enumerados.Valor;

public class Jugador {
	private Carta mano[] = new Carta [14];
	private static Baraja baraja = new Baraja();
	private String nombre;
	private boolean banca,juega;
	
	public Jugador() {
		for (int i = 0; i < mano.length; i++) {
			mano[i] = new Carta();
		}
		setBanca(false);
	}
	
	public Jugador(String nombre, boolean banca) {
		juega = true;
		this.setNombre(nombre);
		this.banca = banca;
		for (int i = 0; i < mano.length; i++) {
			mano[i] = new Carta();
		}
	}
	
	public void repartoInicial() {
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
		return baraja.getCartasRestantes();
	}
	
	public int getCartasRestantes() {
		int num = 0;
		for (int i = 0;mano[i] == null;i++) {
			num = i;
		}
		num = 13 - num;
		return num;
	}
	
	public static boolean seHanPasadoTodos(Jugador jugadores[]) {
		boolean b = true;
		for (int i = 0;i < jugadores.length - 1 && b;i++) {
			if(jugadores[i].sumarPuntos() <= 7.5) {
				b = false;
			}
		}
		return b;
	}

	public static Baraja getBaraja() {
		return baraja;
	}

	public static void setBaraja(Baraja baraja) {
		Jugador.baraja = baraja;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isBanca() {
		return banca;
	}

	public void setBanca(boolean banca) {
		this.banca = banca;
	}
	
	public boolean isJuega() {
		return juega;
	}
	
	public void setJuega(boolean juega) {
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