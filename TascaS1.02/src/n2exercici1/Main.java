package n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * - Exercici 1
		Crea una classe anomenada "Entrada". Aquesta classe ha de servir per controlar les diferents excepcions 
		que poden apar�ixer en Java a l�hora d�introduir dades per teclat utilitzant la classe Scanner.

		El primer que s�ha de fer �s instanciar un objecte de la classe Scanner i a partir d�aqu�, crear m�todes 
		est�tics per llegir els diferents tipus de dades des del teclat. 
		 */

		Scanner entrada = new Scanner(System.in);
		
		int puntuacio;
		byte edat;
		float preu;
		double distancia;
		char classe = 0;
		String comentari ="";
		boolean seguir = false, sino = false;
		
		//M�tode per llegir enters
		puntuacio = Entrada.llegirInt("Introdueix la teva puntuaci�");
		System.out.println("\nLa puntuaci� de l'usuari �s " + puntuacio + "\n");
		
		//M�tode per llegir bytes
		edat = Entrada.llegirByte("Introdueix la teva edat");
		System.out.println("\nLa edat de l'usuari �s " + edat+ "\n");
		
		//M�tode per llegir float
		preu = Entrada.llegirFloat("Introdueix el preu");
		System.out.println("\nEl preu del producte �s " + preu+ "\n");
		
		//Llegir double
		distancia = Entrada.llegirDouble("Introdueix la dist�ncia entre la Terra i la Lluna");
		System.out.println("\nLa dist�ncia �s " + distancia+ "\n");
		
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
		System.out.println("\nEl comentari �s " + comentari+ "\n");
				
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
		System.out.println("\nLa classe �s " + classe+ "\n");
		
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
