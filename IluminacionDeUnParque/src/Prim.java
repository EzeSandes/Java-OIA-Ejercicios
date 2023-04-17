import java.util.PriorityQueue;

public class Prim {

	private static final int INFINITO = Integer.MAX_VALUE;
	private double costo;
	private int nodoOri;
	private boolean[] visitados;
	private Grafo g;
	private Grafo mst;

	public Prim(Grafo g, int nodoOrig) {
		this.costo = 0;
		this.nodoOri = nodoOrig;
		this.g = g;
	}

	public void ejecutar() {
		mst = new Grafo(g.getCantNodos());

		visitados = new boolean[g.getCantNodos()];
		PriorityQueue<Arista> pq = new PriorityQueue<>();
		int cantVisitados = 1;
		visitados[this.nodoOri] = true;

		agregarAristasAdy(pq, this.nodoOri);

		Arista arista = null;
		while (cantVisitados != g.getCantNodos()) {
			arista = pq.remove();

			if (visitados[arista.getNodoHasta()] == false) {
				costo += Math.ceil(arista.getCosto());
				visitados[arista.getNodoHasta()] = true;
				agregarAristasAdy(pq, arista.getNodoHasta());

				mst.addArista(arista);
				cantVisitados++;
			}
		}
	}

	private void agregarAristasAdy(PriorityQueue<Arista> pq, int nodo) {
		double[] ady = g.getAdy(nodo);

		for (int i = 0; i < g.getCantNodos(); i++) {
			if (ady[i] > 0 && ady[i] != INFINITO) {
				pq.add(new Arista(nodo, i, ady[i]));
			}
		}
	}

	public double getCosto() {
		return costo;
	}

	public Grafo getMst() {
		return mst;
	}
}
