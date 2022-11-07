package n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * - Exercici 1
		Crea una classe anomenada "Entrada". Aquesta classe ha de servir per controlar les diferents excepcions 
		que poden aparèixer en Java a l’hora d’introduir dades per teclat utilitzant la classe Scanner.

		El primer que s’ha de fer és instanciar un objecte de la classe Scanner i a partir d’aquí, crear mètodes 
		estàtics per llegir els diferents tipus de dades des del teclat. 
		 */

		Scanner entrada = new Scanner(System.in);
		
		int puntuacio;
		byte edat;
		float preu;
		double distancia;
		char classe = 0;
		String comentari ="";
		boolean seguir = false, sino = false;
		
		//Métode per llegir enters
		puntuacio = Entrada.llegirInt("Introdueix la teva puntuació");
		System.out.println("\nLa puntuació de l'usuari és " + puntuacio + "\n");
		
		//Métode per llegir bytes
		edat = Entrada.llegirByte("Introdueix la teva edat");
		System.out.println("\nLa edat de l'usuari és " + edat+ "\n");
		
		//Métode per llegir float
		preu = Entrada.llegirFloat("Introdueix el preu");
		System.out.println("\nEl preu del producte és " + preu+ "\n");
		
		//Llegir double
		distancia = Entrada.llegirDouble("Introdueix la distáncia entre la Terra i la Lluna");
		System.out.println("\nLa distáncia és " + distancia+ "\n");
		
		//Llegir String
		do {
			try {
				seguir = false;
				comentari = Entrada.llegirString("Publica un comentari");
			} catch (Exception e) {
				seguir = true;
				System.out.println(e.getMessage());
			}
		}while(seguir);
		System.out.println("\nEl comentari és " + comentari+ "\n");
				
		//LLegir char
		do {
			try {
				seguir = false;
				classe = Entrada.llegirChar("Introdueix la classe a on t'has inscrit");
			} catch (Exception e) {
				seguir = true;
				System.out.println(e.getMessage());
			}
		}while(seguir);
		System.out.println("\nLa classe és " + classe+ "\n");
		
		//Llegir boolean
		do {
			try {
				seguir = false;
				sino = Entrada.llegirSiNo("Introdueix una 'n' o una 's'");
			} catch (Exception e) {
				seguir = true;
				System.out.println(e.getMessage());
			}
		}while(seguir);
		
		System.out.println("\nHas sel.leccionat " + sino+ "\n");
		
	}

}
