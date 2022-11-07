package n1exercici1;

import java.util.ArrayList;
import java.util.Iterator;

public class Venda {

	private ArrayList<Producte> productes = new ArrayList<>();
	private double preuTotal;
	
	public void afegirProducte(Producte producte) {
		productes.add(producte);
	}
	
	public void calcularTotal() throws VendaBuidaException{
		if (productes == null || productes.size() == 0) {
			throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
		}else {
			for (Producte p: productes){
				preuTotal += p.getPreu();
				p.getPreu();
		    }
		}
	}
	
	public double getPreuTotal() {
		return preuTotal;
	}

	public void setPreuTotal(double preuTotal) {
		this.preuTotal = preuTotal;
	}

	public void mostrar(){
		for (Producte p: productes){
			System.out.println(p);
			
	    }
	}
}
