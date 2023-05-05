
public class Arista implements Comparable<Arista> {
	private int costo;
	private int nodoOrigen;
	private int nodoDest;

	public Arista(int costo, int nodoOrigen, int nodoDest) {
		this.costo = costo;
		this.nodoOrigen = nodoOrigen;
		this.nodoDest = nodoDest;
	}

	public int getCosto() {
		return costo;
	}

	public int getNodoOrigen() {
		return nodoOrigen;
	}

	public int getNodoDest() {
		return nodoDest;
	}

	@Override
	public int compareTo(Arista o) {
		return this.costo - o.costo;
	}

	@Override
	public String toString() {
		return "" + nodoOrigen + " " + nodoDest;
	}

}
