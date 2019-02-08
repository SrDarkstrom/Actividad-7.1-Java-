package main;

import java.util.Arrays;
import java.util.Scanner;

import clases.Jugador;

public class MainApartado_a {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Jugador jugadores[];
		String nombre;
		char menu;
		int cont,tam;
		boolean banca;
		
		do {
			do {
				System.out.println("¿Cuantos jugadores? [1-5]");
				cont = sc.nextInt();
			} while (cont < 1 || cont > 5);
			sc.nextLine();
			tam = cont + 1;
			jugadores = new Jugador[tam];
			
			for (banca = false;!banca;cont--) {
				if (cont == 0) {
					banca = true;
					nombre = "Banca";
				} else {
					System.out.println("Introduce nombre del jugador " + (tam - cont));
					nombre = sc.nextLine();
				}
				jugadores[tam - cont - 1] = new Jugador(nombre,banca);
			}
			
			jugadores[5].repartoInicial();
			
			System.out.println(Jugador.getBaraja());
			
			System.out.println(Arrays.toString(jugadores));
			
			jugadores[1].robar();
			
			do {
				System.out.println("¿Quieres volver a jugar? [s/n]");
				menu = sc.nextLine().charAt(0);
			} while (menu != 's' && menu != 'n');
			if (menu == 'n') {
				System.out.println("Hasta luego");
			}
			
		} while (menu == 's') ;
		
		sc.close();
	}
}