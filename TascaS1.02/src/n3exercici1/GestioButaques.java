package n3exercici1;

import java.util.ArrayList;
import java.util.Iterator;

public class GestioButaques {

	private ArrayList<Butaca> butaques = new ArrayList<>();

	
	public void afegirButaques(Butaca b) throws ExcepcioButacaOcupada{
		if(butaques.contains(b)) {
			throw new ExcepcioButacaOcupada("El seient ja no està disponible");			
		}
		butaques.add(b);
	}

	public ArrayList<Butaca> getButaques() {
		return butaques;
	}
		
	public int cercarButaca(int fila, int seient) {
		Iterator it = butaques.iterator();
		int posicio = 0;
		int posicioEscollida = 0;
		boolean trobat = false;
		while(it.hasNext()) {
			if(fila == butaques.get(posicio).getFila() && seient == butaques.get(posicio).getSeient()) {
				posicioEscollida = posicio;
				trobat = true;
			}
		  it.next();
		  posicio++;
		} 
		if(trobat) {
			return posicioEscollida;
		}else {
			return -1;
		}
	}

	public void eliminarButaca(int posicio) throws ExcepcioButacaLliure{
		Iterator it = butaques.iterator();
		int posicioEscollida = 0;
		boolean trobat = false;
						
		if (posicio ==-1) {
			throw new ExcepcioButacaLliure("Aquesta butaca no estava reservada");
		}else {
			butaques.remove(posicio);
		}
		
	}
		
	@Override
	public String toString() {
		return "GestioButaques [butaques=" + butaques + "]";
	}
		
}
