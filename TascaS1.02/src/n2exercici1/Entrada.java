package n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

import n1exercici1.VendaBuidaException;

public class Entrada {

	static Scanner entrada = new Scanner(System.in);
	
	//Métodes que capturen l'excepció de la classe InputMismatchException
	public static byte llegirByte(String missatge) {
		byte num = 0;
		boolean seguir;
			do {
				try {
					seguir = false;
					System.out.println(missatge);
					num = entrada.nextByte();
				}catch(InputMismatchException e) {
					System.out.println("Has d'ingresar un num enter fins al 127");
					entrada.next();
					seguir = true;
				}
				entrada.nextLine();
			}while(seguir);
		return num;
	}
	
	public static int llegirInt(String missatge) {
		int num=0;
		boolean seguir;
			do {
				try {
					seguir = false;
					System.out.println(missatge);
					num = entrada.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("Has d'ingresar un num enter");
					entrada.next();
					seguir = true;
				}
				entrada.nextLine();
			}while(seguir);
		return num;
	}
	
	public static float llegirFloat(String missatge) {
		float num = 0;
		boolean seguir;
			do {
				try {
					seguir = false;
					System.out.println(missatge);
					num = entrada.nextFloat();
				}catch(InputMismatchException e) {
					System.out.println("Els decimals han d'estar precedits d'una coma");
					entrada.next();
					seguir = true;
				}
				entrada.nextLine();
			}while(seguir);
		return num;
	}
	
	public static double llegirDouble(String missatge) {
		double num = 0;
		boolean seguir;
			do {
				try {
					seguir = false;
					System.out.println(missatge);
					num = entrada.nextDouble();
				}catch(InputMismatchException e) {
					System.out.println("Els decimals han d'estar precedits d'un punt");
					entrada.next();
					seguir = true;
				}
				entrada.nextLine();
			}while(seguir);
		return num;
	}
	
	//Métodes que capturen l'excepció de la classe Exception
	
	public static char llegirChar(String missatge) throws Exception {
		char lletra = 0;
		
		System.out.println(missatge);
		lletra = entrada.next().charAt(0);

		if(!Character.isLetter(lletra)) {
			throw new Exception ("Has d'ingresar una lletra");
		}	
		return lletra;
	}
	
	public static String llegirString(String missatge) throws Exception {
		String comentari ="";
	
		
		System.out.println(missatge);
		comentari = entrada.nextLine();
		
	    if (comentari.isEmpty()) {
	        throw new Exception("Entrada nul.la");
	    }
	    
		return comentari;
	}
	
	//Si l’usuari/ària introdueix “s”, retorna “true”, 
	//si l’usuari introdueix “n”, retorna “false”
	public static boolean llegirSiNo(String missatge) throws Exception {
		boolean sino=false;
		char lletra =0;
		
		System.out.println(missatge);
		lletra = entrada.next().charAt(0);
		
		if(!(lletra =='n' || lletra == 's'))  {
			throw new Exception("Has d'ingressar 'n' o 's'");
		}
		
		if(lletra =='n') {
			sino = false;
		}else {
			sino = true;
		}
		
		return sino;
	}
}
