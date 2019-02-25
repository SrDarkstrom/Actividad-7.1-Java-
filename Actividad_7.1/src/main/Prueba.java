package main;

import java.util.Scanner;
import clases.Jugador;

public class Prueba {

	public static void main(String[] args) {
		//Clases
		  Jugador jugadores[];
		//String
		  String nombre;
		  char menus = 'a';
		//Enteros
		  int cont;
		  int tam; 
		  int i; 
		  int ganador;
		//Booleanos 
		  boolean banca = false;
		//Scanner 
		  Scanner sc = new Scanner(System.in);
		  
		//Métodos
		  System.out.println("¿Cuántos jugadores van a ser? [1-5]");
		  cont = sc.nextInt();
		  jugadores = new Jugador[cont + 1];
		  for (i = 0; i < jugadores.length; i++) {
			if(i !=0) {
				System.out.println("Indique el nombre del jugador " + (i+1));
				nombre = sc.nextLine();
			}else {
				banca = true;
				nombre = "Banca";
			}
			jugadores[i] = new Jugador(nombre, banca);
		  }
		  
		  do {
			
		} while (!jugadores[i].isJuega() && jugadores[0].probabilidad(jugadores, (cont +1)) < 50);
			
		  sc.close();

	}

}
