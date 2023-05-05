import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Grafo {
	private static final int INFINITO = Integer.MAX_VALUE;
	HashSet<Arista> tendido;

	private int[][] matrizAdy;
	private int cantNodos;

	public Grafo(int[][] matrizAdy, int cantNodos) {
		this.matrizAdy = matrizAdy;
		this.cantNodos = cantNodos;
	}

	// Para este ejercicio no le paso un nodoIni, sino la lista de centrales
	// que ya deben estar marcadas.
	public int prim(int nodoIni) {
		int nodoActual = nodoIni - 1;
		int costo = 0;

		boolean[] visitados = new boolean[this.cantNodos];
		visitados[nodoActual] = true;
		int cantVisitados = 1;

		PriorityQueue<Arista> pq = new PriorityQueue<>();

		hallarAristasAdyacentes(pq, nodoActual);

		Arista arista = null;
		while (cantVisitados != this.cantNodos && !pq.isEmpty()) {
			arista = pq.remove();

			if (visitados[arista.getNodoDest()] == false) {
				costo += arista.getCosto();

				visitados[arista.getNodoDest()] = true;

				cantVisitados++;
			}
		}

		if (cantVisitados < this.cantNodos)
			return -1;

		return costo;
	}

	private void hallarAristasAdyacentes(PriorityQueue<Arista> pq, int nodoActual) {
		for (int i = 0; i < this.cantNodos; i++) {
			if (this.matrizAdy[nodoActual][i] > 0 && this.matrizAdy[nodoActual][i] != INFINITO)
				pq.add(new Arista(this.matrizAdy[nodoActual][i], nodoActual, i));
		}
	}

	public int prim(List<Integer> centrales) {
		int costo = 0;

		this.tendido = new HashSet<>();
		PriorityQueue<Arista> pq = new PriorityQueue<>();

		boolean[] visitados = new boolean[this.cantNodos];
		int cantVisitados = centrales.size();

		// Coloco las centrales ya unidas en el conj de Visitados.
		// Y agrego las aristas a la "pq"
		for (int i = 0; i < centrales.size(); i++) {
			visitados[centrales.get(i) - 1] = true;
			hallarAristasAdyacentes(pq, centrales.get(i) - 1);

		}

		Arista arista = null;
		while (cantVisitados != this.cantNodos && !pq.isEmpty()) {
			arista = pq.remove();

			if (visitados[arista.getNodoDest()] == false) {
				costo += arista.getCosto();

//				tendido.add(arista); // Se deberia setear las pos + 1 despues de setear visitados[] a true
				// para usar al misma var
				tendido.add(new Arista(0, arista.getNodoOrigen() + 1, arista.getNodoDest() + 1));

				hallarAristasAdyacentes(pq, arista.getNodoDest());
				visitados[arista.getNodoDest()] = true;

				cantVisitados++;
			}
		}

		if (cantVisitados < this.cantNodos)
			return -1;

		return costo;
	}

	public HashSet<Arista> getTendido() {
		return tendido;
	}

	/*
	 * KRUSKAL
	 */

	public int kruskal() {
		int visitados = 0;
		int costo = 0;
		Arista arista = null;

		PriorityQueue<Arista> pq = new PriorityQueue<>();
		UnionFind uf = new UnionFind(this.cantNodos);

		hallarAristasAdyacentes(pq);

		while (visitados != this.cantNodos && !pq.isEmpty()) {
			arista = pq.remove();

			if (!uf.isConectado(arista.getNodoOrigen(), arista.getNodoDest())) {

				costo += arista.getCosto();

				uf.union(arista.getNodoOrigen(), arista.getNodoDest());
				visitados++;
			}
		}

		if (!pq.isEmpty())
			return -1;

		return costo;
	}

	private void hallarAristasAdyacentes(PriorityQueue<Arista> pq) {
		for (int i = 0; i < this.cantNodos; i++) {
			for (int j = i + 1; j < this.cantNodos; j++) {
				if (this.matrizAdy[i][j] > 0 && this.matrizAdy[i][j] != INFINITO)
					pq.add(new Arista(this.matrizAdy[i][j], i, j));
			}
		}
	}
	
	public int kruskal(List<Integer> centrales) {
		int visitados = centrales.size();
		int costo = 0;
		Arista arista = null;

		PriorityQueue<Arista> pq = new PriorityQueue<>();
		UnionFind uf = new UnionFind(this.cantNodos);
		this.tendido = new HashSet<>();
		
		// Sacar las aristas entre las centrales
		hallarAristasAdyacentes(pq);
		
		/// Conecto los nodos con centrales para que no los tome devuelta
		for (int i = 0; i < centrales.size(); i++) {
			uf.union(centrales.get(0) - 1, centrales.get(i) - 1);
		}

		while (visitados != this.cantNodos && !pq.isEmpty()) {
			arista = pq.remove();

			if (!uf.isConectado(arista.getNodoOrigen(), arista.getNodoDest())) {

				costo += arista.getCosto();
				tendido.add(new Arista(0, arista.getNodoOrigen() + 1, arista.getNodoDest() + 1));
				uf.union(arista.getNodoOrigen(), arista.getNodoDest());
				visitados++;
			}
		}

		return costo;
	}

}
