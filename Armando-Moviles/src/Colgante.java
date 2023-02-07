import java.util.Objects;

public class Colgante {
	private int peso;
	
	public Colgante(int peso) {
		this.peso = peso;
	}
	
	public int getPeso() {
		return this.peso;
	}

	/////////// Debo tener el equals para poder comparar en el Map entre colgantes.
	@Override
	public int hashCode() {
		return Objects.hash(peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colgante other = (Colgante) obj;
		return peso == other.peso;
	}
	
	
}
