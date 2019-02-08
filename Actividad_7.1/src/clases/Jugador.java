package clases;

import java.util.Arrays;

public class Jugador {
	private Carta mano[] = new Carta [14];
	private static Baraja monton = new Baraja();
	private String nombre;
	private boolean banca;
	
	public Jugador() {
		for (int i = 0; i < mano.length; i++) {
			mano[i] = new Carta();
		}
		setBanca(false);
	}
	
	public Jugador(String nombre, boolean banca) {
		this.setNombre(nombre);
		this.banca = banca;
		for (int i = 0; i < mano.length; i++) {
			mano[i] = new Carta();
		}
	}
	
	public void repartoInicial() {
		boolean sw = false;
		monton.barajarMedioNivel();
		for (int i = 0; i < 40 && sw == false; i++) {
			if(mano[i] != null) {
				if(monton.getBaraja()[i] != null) {
					mano[i] = monton.getBaraja()[i];
					monton.getBaraja()[i] = null;
					sw = true;
					break;
				}else {
				sw = false;
				}
			}
		}
	}
	
	public void robar(int ronda) {
		monton.barajarMedioNivel();
		for (int i = 0, j = ronda; j < 10; i++, j++) {
			if(mano[j] != null) {
				if(monton.getBaraja()[i] != null) {
					mano[j] = monton.getBaraja()[i];
					monton.getBaraja()[i] = null;
					break;
				}
			}
		}
	}
	
	public static Baraja getBaraja() {
		return monton;
	}

	public static void setBaraja(Baraja baraja) {
		Jugador.monton = baraja;
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
	
	@Override
	public String toString() {
		return "Jugador " + nombre + " [mano=" + Arrays.toString(mano) + "]";
	}

}