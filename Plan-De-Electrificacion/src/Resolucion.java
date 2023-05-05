import java.util.HashSet;
import java.util.List;

public class Resolucion {
	private int[][] matrizAdy;
	private List<Integer> centrales;
	private int cantCiudades;
	
	public Resolucion(int[][] matrizAdy, List<Integer> ciudadesConCentrales) {
		this.matrizAdy = matrizAdy;
		this.centrales = ciudadesConCentrales;
		this.cantCiudades = matrizAdy.length;
	}

	/////////////////////
	
	
	public String resolver() {
		
		Grafo grafo = new Grafo(this.matrizAdy, this.cantCiudades);
		
		// Colocar en el prim, los nodos ya marcados en visitados.
		int costoTotalMin = grafo.kruskal(centrales);
		HashSet<Arista> tendido = grafo.getTendido();

		String res = "" + costoTotalMin + "\n";
		
		for (Arista arista : tendido) {
			res += arista + "\n";
		}
		
		return res;
	}
}
