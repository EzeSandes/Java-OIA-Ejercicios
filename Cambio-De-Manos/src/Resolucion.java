import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Resolucion {
	private HashMap<Arista, Integer> aristas;
	private int nodoIni;
	private int nodoFin;
	private Grafo g;

	public Resolucion(HashMap<Arista, Integer> aristas, int nodoIni, int nodoFin, Grafo g) {
		this.aristas = aristas;
		this.g = g;
		this.nodoFin = nodoFin;
		this.nodoIni = nodoIni;
	}

	public String resolver() {
		LinkedList<Integer> respuestas = new LinkedList<>();

		// 1_ Dijkstra sobre el grafo desde el nodoIni
		Dijkstra dj = new Dijkstra(g, this.nodoIni);

		dj.ejecutar();

		// 2_ Conseguir costo
		int costoMin = dj.getDistancias(this.nodoFin);

		// 3_ Conseguir camino a nodoEscuela == nodoFin
		Stack<Integer> camino = dj.getCamino(this.nodoFin);
		int cantCalles = camino.size();
		String respuesta = "";
		boolean caminoVacio = false;

		int esqAnt = camino.pop() - 1;
		for (int i = 0; i < cantCalles - 1; i++) {
			
			if (camino.isEmpty()) {
				caminoVacio = true;
				break;
			}

			int esqSig = camino.pop() - 1;

			Arista calleActual = new Arista(0, esqAnt, esqSig, 0);

			if (aristas.containsKey(calleActual) == false) {
				int calleInvertida = aristas.get(new Arista(0, esqSig, esqAnt, 0));

				respuestas.add(calleInvertida);
			}
			
			esqAnt = esqSig;
		}

		System.out.println("Costo Min: " + costoMin);

		respuesta += costoMin + "\n";
		
		if (caminoVacio == true)
			return respuesta;

		System.out.println("Aristas: ");
		for (Integer id : respuestas) {
			respuesta += id + " ";
		}
		
		System.out.println(respuesta);

		return respuesta;
	}

}
