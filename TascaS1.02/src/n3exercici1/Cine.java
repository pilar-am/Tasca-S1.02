package n3exercici1;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Cine {

	/*
	 * Constructor: no rebr� par�metres. Crear� l�objecte de la classe Gesti�Butaques. 
	 * I cridar� al m�tode demanarDadesInicials que inicialitzar� el nombre de files 
	 * i de seients.
	 * 
	 * menu: mostrar� les opcions del men� principal a l�usuari/�ria, li demanar� el 
	 * n�mero de l�opci� escollida i el retornar�.
	 * 
	 * mostrarButaques: Mostra totes les butaques reservades
	 * */
	
	int files;
	int seients;
	
	GestioButaques gestio;
	
	
	public Cine() {
		gestio = new GestioButaques();
		demanarDadesInicials();
	}
	
	public void iniciar() {
		int opcio;
		
		do {
			opcio = menu();
			switch(opcio) {
			case 1:
				mostrarButaques();
				break;
			case 2:
				try {
					mostrarButaquesPersona(introduirPersona());
				} catch (ExcepcioNomPersonaIncorrecte e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				reservarButaca();
				break;
			case 4:
				anularReserva();
				break;
			case 5:
				try {
					anularReservaPersona(introduirPersona());
				} catch (ExcepcioNomPersonaIncorrecte e) {
					System.out.println(e.getMessage());
				}
				break;
			case 0:
				System.out.println("Fins aviat!!");
				break;
			default:
				System.out.println("El nombre no correspon al men�");
			}
		}while(opcio != 0);
		
	}
	
	public void mostrarButaques() {
		System.out.println(gestio.getButaques());
		
	}
	
	public int menu() {
		String menu = "1.- Mostrar totes les butaques reservades.\n"
		+ "2.- Mostrar les butaques reservades per una persona.\n"
		+ "3.- Reservar una butaca.\n"
		+ "4.- Anul�lar la reserva d�una butaca.\n"
		+ "5.- Anul�lar totes les reserves d�una persona.\n"
		+ "0.- Sortir.";
		System.out.println(menu);
		
		Scanner entrada = new Scanner(System.in);
		int opcio = entrada.nextInt();
		
		return opcio;
	}

	public void demanarDadesInicials() {
		System.out.println("-------RESERVA DE SEIENTS-----");
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Quantes files t� la sala? ");
		this.files = entrada.nextInt();
		
		System.out.println("Quants seients per fila t� la sala? ");
		this.seients = entrada.nextInt();
		
	}
	
	public String introduirPersona() throws ExcepcioNomPersonaIncorrecte{
		Scanner entrada = new Scanner(System.in);
		System.out.println("Com es diu? ");
		
		String persona = entrada.nextLine();
		
		boolean esNumeric = false;
		for (int i = 0; i < persona.length(); i++) {
			if(isNumeric(String.valueOf(persona.charAt(i)))) {
				esNumeric = true;
			}
		}
		
		if(esNumeric) {
			throw new ExcepcioNomPersonaIncorrecte("Nom no v�lid");
		}
		return persona;
		
	}
	
	public static boolean isNumeric(String str) {
	    try {
	        double d = Double.parseDouble(str);
	    } catch (NumberFormatException e) {
	    	//No �s numeric
	        return false;
	    }
	    //�s numeric
	    return true;
	}
	
	public int introduirFila() throws ExcepcioFilaIncorrecta{
		Scanner entrada = new Scanner(System.in);
		boolean correcte = false;
		do {
			System.out.println("Quina fila vol demanar? ");
			int fila = entrada.nextInt();
			if(fila > this.files) {
				throw new ExcepcioFilaIncorrecta("La fila no �s correcta");
			}else {
				correcte = true;
				return fila;
			}
		}while(!correcte);
		
	}
	
	public int introduirSeient() throws ExcepcioSeientIncorrecte{
		Scanner entrada = new Scanner(System.in);
		System.out.println("Quin seient vol demanar? ");
		int seient = entrada.nextInt();
		if(seient > this.seients) {
			throw new ExcepcioSeientIncorrecte("El seient no �s correcte");
		}else {
			return seient;
		}
	}
		
	public void mostrarButaquesPersona(String persona) {
		
		ArrayList<Butaca> butaquesPersona = new ArrayList<>();
				
        for (Butaca b: gestio.getButaques()){
            if((b.getClient()).equals(persona)) {
            	butaquesPersona.add(b);
            }
        }
        
        for (Butaca b: butaquesPersona) {
        	System.out.println(b.toString());
        }
	}
	
	public void reservarButaca() {
		int fila =0, seient = 0;
		String client = "";
		
		try {
			fila = introduirFila();
		} catch (ExcepcioFilaIncorrecta e) {
			System.out.println(e.getMessage());
		}
		
		try {
			seient = introduirSeient();
		} catch (ExcepcioSeientIncorrecte e) {
			System.out.println(e.getMessage());
		}
		
		try {
			client = introduirPersona();
		} catch (ExcepcioNomPersonaIncorrecte e) {
			System.out.println(e.getMessage());
		}
		
		try {
			gestio.afegirButaques(new Butaca(fila, seient, client));
		} catch (ExcepcioButacaOcupada e) {
			System.out.println(e.getMessage());
		}
		
	}
		
	public void anularReserva() {
		int fila = 0, seient = 0;
		try {
			fila = introduirFila();
		} catch (ExcepcioFilaIncorrecta e) {
			System.out.println(e.getMessage());
		}
		
		try {
			seient = introduirSeient();
		} catch (ExcepcioSeientIncorrecte e) {
			System.out.println(e.getMessage());
		}
		
		int posicio = gestio.cercarButaca(fila, seient);
		try {
			gestio.eliminarButaca(posicio);
		} catch (ExcepcioButacaLliure e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void anularReservaPersona(String persona) {
		
		ArrayList<Butaca> butaquesPersona = new ArrayList<>();
		
        for (Butaca b: gestio.getButaques()){
            if((b.getClient()).equals(persona)) {
            	butaquesPersona.add(b);
            }
        }
        
        (gestio.getButaques()).removeAll(butaquesPersona);	
		
	}
}
