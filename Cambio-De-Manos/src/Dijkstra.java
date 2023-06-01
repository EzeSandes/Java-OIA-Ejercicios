import java.util.Stack;

public class Dijkstra {
	private static final int INFINITO = Integer.MAX_VALUE;
	private int[] distancias;
	private int[] precedencias;
	private boolean[] conjSol;
	private int nodoOri;
	private Grafo g;
	private int[][] ady;

	public Dijkstra(Grafo g, int nodoOri) {
		this.g = g;
		this.nodoOri = nodoOri;
		this.ady = g.getAdy();
	}

	public void ejecutar() {
		conjSol = new boolean[g.getCantNodos()];
		distancias = new int[g.getCantNodos()];
		precedencias = new int[g.getCantNodos()];
		int nodoActual = this.nodoOri;

		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = INFINITO;
			precedencias[i] = nodoActual;
		}

		distancias[nodoActual] = 0;

		for (int i = 0; i < g.getCantNodos(); i++) {
			conjSol[nodoActual] = true;

			for (int j = 0; j < g.getCantNodos(); j++) {
				if (conjSol[j] == false && ady[nodoActual][j] > 0 && ady[nodoActual][j] != INFINITO) {
					double minTemp = (double) distancias[nodoActual] + ady[nodoActual][j];

					if (minTemp < distancias[j]) {
						distancias[j] = (int) minTemp;
						precedencias[j] = nodoActual;
					}
				}
			}
			nodoActual = hallarMinNodo(conjSol, distancias);
		}
	}

	private int hallarMinNodo(boolean[] conjSol2, int[] distancias2) {
		int min = INFINITO;
		int nodo = 0;

		for (int i = 0; i < distancias2.length; i++) {
			if (conjSol2[i] == false && distancias2[i] < min) {
				min = distancias2[i];
				nodo = i;
			}
		}

		return nodo;
	}

	public int getDistancias(int nodo) {
		return distancias[nodo];
	}
	
	public Stack<Integer> getCamino(int nodoHasta){
		int i = nodoHasta;
		Stack<Integer> camino = new Stack<>();
		
		camino.push(i + 1);
		
		while(this.precedencias[i] != this.nodoOri){
			camino.push(precedencias[i] + 1);
			i = precedencias[i];
		}
		
		camino.push(this.nodoOri + 1);
		
		return camino;
	}
}
