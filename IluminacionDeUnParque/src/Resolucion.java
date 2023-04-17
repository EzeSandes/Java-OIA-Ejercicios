import java.util.List;

public class Resolucion {

	private static final int NRO_GENERADOR = 0;
	private static final int INFINITO = Integer.MAX_VALUE;
	private List<Nodo> faroles;
	private int cantFaroles;

	public Resolucion(List<Nodo> faroles) {
		this.faroles = faroles;
		this.faroles.add(new Nodo(0, 0, 0));
		this.cantFaroles = this.faroles.size();
	}

	public String resolver() {
		double[][] mat = new double[this.cantFaroles][this.cantFaroles];

		// Calculo las distancias entre nodos
		// O(N^2)
		// Esto me coloca distancia 0 en la DP
		for (Nodo nodoOrig : faroles) {
			for (Nodo nodoActual : faroles) {
				mat[nodoOrig.getId()][nodoActual.getId()] = nodoOrig.getDistancia(nodoActual);
			}
		}

		Grafo g = new Grafo(mat);
		Prim prim = new Prim(g, NRO_GENERADOR);

		prim.ejecutar();
		Grafo mst = prim.getMst();

		String res = "";

		res += prim.getCosto() + "\n";
		double[] ady;
		// Empiezo del farol 1
		for (int i = 1; i < g.getCantNodos(); i++) {
			ady = mst.getAdy(i);

			res += "" + i;
			for (int j = 0; j < ady.length; j++) {
				if (ady[j] > 0 && ady[j] != INFINITO)
					res += " " + j;
			}

			res += "\n";
		}
		
		return res;
	}
}
