import java.util.Objects;

public class Mesada implements Comparable<Mesada> {
	private int altura;
	private int ancho;
	private boolean apilable;

	public Mesada(int altura, int ancho) {
		this.altura = altura;
		this.ancho = ancho;
		this.apilable = true; // Solo sera apilable si es true
	}

	public boolean isApilable() {
		return this.apilable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, ancho);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesada other = (Mesada) obj;
		return altura == other.altura && ancho == other.ancho;
	}

	@Override
	public int compareTo(Mesada other) {
		int res;

		// Mayor -> Menor
		if ((res = other.altura - this.altura) == 0)
			return other.ancho - this.ancho;

		return res;
	}

	public boolean puedeContener(Mesada mesada) {
	return (this.ancho >= mesada.ancho && this.altura >= mesada.altura)
			|| (this.ancho >= mesada.altura && this.altura >= mesada.ancho);
	}

	public void setNoApilable() {
		this.apilable = false;
	}

}
