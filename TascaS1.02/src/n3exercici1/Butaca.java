package n3exercici1;

import java.util.Objects;

public class Butaca {

	private int fila;
	private int seient;
	private String client;
	
	public Butaca(int fila, int seient, String client) {
		this.fila = fila;
		this.seient = seient;
		this.client = client;
	}

	public int getFila() {
		return fila;
	}

	public int getSeient() {
		return seient;
	}

	public String getClient() {
		return client;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Butaca other = (Butaca) obj;
		return fila == other.fila && seient == other.seient;
	}

	@Override
	public String toString() {
		return "Fila: " + fila + ", Seient: " + seient + ", Persona: " + client;
	}

	

	
	
	
}
