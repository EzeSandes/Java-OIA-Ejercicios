public class Grafo {
	private double[][] ady;
	private int cantNodos;

	public Grafo(double[][] mat) {
		this.ady = mat;
		this.cantNodos = mat.length;
	}

	public Grafo(int cantNodos) {
		this.ady = new double[cantNodos][cantNodos];
		this.cantNodos = cantNodos;
	}

	public void addArista(Arista arista) {
		this.ady[arista.getNodoDesde()][arista.getNodoHasta()] = arista.getCosto();
		this.ady[arista.getNodoHasta()][arista.getNodoDesde()] = arista.getCosto();
	}

	public double[][] getAdy() {
		return ady;
	}

	public double[] getAdy(int nodo) {
		return ady[nodo];
	}

	public int getCantNodos() {
		return cantNodos;
	}
}
