
public class Grafo {
	private int[][] ady;
	private int cantNodos;

	public Grafo(int[][] ady) {
		this.ady = ady;
		this.cantNodos = ady.length;
	}

	public int[][] getAdy() {
		return ady;
	}

	public int getCantNodos() {
		return cantNodos;
	}

}
