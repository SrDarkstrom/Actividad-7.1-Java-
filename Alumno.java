package clases;

import java.util.Arrays;

public class Alumno {
	private int DNI;
	private String nombre;
	private Asignaturas asignaturas[] = new Asignaturas [6];
	
	// Métodos constructores
		// Sin parámetros
		public Alumno() {
			this.DNI = 0;
			this.nombre = "Sin Identificar";
			this.asignaturas = null;
		}
		
		// Con todo como parámetros
		public Alumno(int DNI, String nombre) {
			this.DNI = DNI;
			this.nombre = nombre;
		}
	// FIn métodos contructores
		
		
	// Métodos get
		public String getNombre() {
			return this.nombre;
		}
		
		public int getDNI() {
			return this.DNI;
		}
		
		public Asignaturas[] getAsignaturas() {
			return this.asignaturas;
		}
	// Fin métodos get
	
	// Método Pago
	public int cuantoPaga() {
		int euros = 0;
		int precioTotal = 0;
		int total;
		boolean sw = false;
		for (int i = 0; i < asignaturas.length && sw == false; i++) {
			/* Dentro del for se comprueba se si la asignatura es nula, si lo es se cierra el bucle,
			   si no lo es, comprueba si tiene practicas, a lo cual sumara 50 a los euros, si no tiene
			   no los sumara, despues comprueba los creditos los cuales se multiplican por 50 y por ultimo 
			   se suma todo cuando el bucle se cierra, y este valor es el que se retorna.
			*/
			if(asignaturas[i] == null) {
				sw = true;
				break;
			}else {
				if(asignaturas[i].getPracticas().equals("si")) {
					euros = euros + 50;
				}
				precioTotal = precioTotal + asignaturas[i].getCreditos() * 50;
				sw = false;
			}
		}
		total = euros + precioTotal;
		return total;
	}
	
	// Método para matricular
	public boolean matricular(Asignaturas a) {
		boolean sw = false;
		for (int i = 0; i < asignaturas.length && sw == false; i++) {
			if(asignaturas[i] == a) {
				sw = false;
				break;
			}else {
				if(asignaturas[i] == null) {
					asignaturas[i] = a;
					sw = true;
					break;
				}else {
					sw = false;
				}
			}
		}
		return sw;
	}
	
	// Método desmatricular
	public boolean desmatricular(Asignaturas a) {
		boolean sw = false;
		for (int i = 0; i < asignaturas.length && sw == false; i++) {
			if(asignaturas[i] == null) {
				sw = false;
				break;
			}else {
				if(asignaturas[i] == a) {
					asignaturas[i] = null;
					sw = true;
					break;
				}else {
					sw = false;
				}
			}
		}
		return sw;
	}

	// Método toString
	public String toString() {
		String cadena;
		
		cadena = new String	("El alumno con DNI: " + DNI + ", nombre: " + nombre + ", asignaturas: " + Arrays.toString(asignaturas));
		
		return cadena;
	}
}
