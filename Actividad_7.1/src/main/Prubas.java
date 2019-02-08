package main;

import clases.Jugador;

public class Prubas {
	public static void main(String[] args) {
		int num = 1, num2 = 2;
		Jugador jugador = new Jugador();
		
		jugador.repartoInicial();
		
		System.out.println(jugador);
		
		jugador.robar(num);
		
		System.out.println(jugador);
		
		jugador.robar(num2);
		
		System.out.println(jugador);
	}
}
