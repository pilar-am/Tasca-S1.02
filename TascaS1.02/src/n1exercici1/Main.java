package n1exercici1;

public class Main {

	public static void main(String[] args) {
		
		/*- Exercici 1
		 * Crea una classe anomenada "Producte" amb els atributs nom i preu, i una altra classe anomenada "Venda". 
		 * Aquesta classe té com a atributs una col·lecció de productes i el preu total de la venda.

		La classe "Venda", té un mètode anomenat calcularTotal() que llança l’excepció personalitzada 
		VendaBuidaException i mostra per pantalla “Per fer una venda primer has d’afegir productes” si la col·lecció 
		de productes està buida. Si la col·lecció té productes, llavors ha de recórrer la col·lecció i guardar la suma 
		de tots els preus dels productes a l’atribut preu total de la venda.

		L’excepció personalitzada VendaBuidaException ha de ser filla de la classe Exception. Al seu constructor li 
		hem de passar el missatge  “Per fer una venda primer has d’afegir productes” i quan capturem l’excepció, 
		l’hem de mostrar per pantalla amb el mètode getMessage() de l’excepció.

		Escriu el codi necessari per a generar i capturar una excepció de tipus ArrayIndexOutOfBoundsException.
		 */
		
		//Es creen dos vendes
		Venda venda1 = new Venda();
		Venda venda2 = new Venda();
		
		//A la venda1 li afegim 2 productes i calculem el preu total
		venda1.afegirProducte(new Producte("Laptop", 200));
		venda1.afegirProducte(new Producte("Ratolí", 35));
		
		try {
			venda1.calcularTotal();
		}catch(VendaBuidaException e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("El preu total de la venda 1 és: " + venda1.getPreuTotal() + " €\n");
		
		//Calculem el preu total de la venda2 i com no hi
		//han productes llença l'excepció
		try {
			venda2.calcularTotal();
		}catch(VendaBuidaException e){
			System.out.println(e.getMessage());
		}
		
		
		//Capturar excepció ArrayIndexOutOfBoundsException
		int[] numeros = new int[5];
		
		try {
			for(int i=0; i<=numeros.length;i++) {
				numeros[i]=i;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
