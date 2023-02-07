import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resolucion {

	private static final int CANT_COLGANTES_X_MOBIL = 2;
	private List<Colgante> colgantes;

	public Resolucion(List<Colgante> colgantes) {
		this.colgantes = colgantes;
	}

	public String cantMoviles() {
		Map<Colgante, Integer> frecuencias = new HashMap<>();
		int cantVarillas = 0;
		int pesoTotal = 0;

		// Tengo el Map con las claves asociadas a cada uno
		for (Colgante colgante : this.colgantes) {
			// Si el colgante no esta => return 0 + 1.
			// Si el colgante(key) esta => devuelve su valor y sumo 1
			frecuencias.put(colgante, frecuencias.getOrDefault(colgante, 0) + 1);
		}

		// 2 - Itero por cada colgante si es >= 2
		for (Colgante colgante : frecuencias.keySet()) {

			// Aca utilizo el "Equals()" de Colgante
			int cantApariciones = frecuencias.get(colgante);

			if (cantApariciones >= Resolucion.CANT_COLGANTES_X_MOBIL) {
				cantVarillas += cantApariciones / Resolucion.CANT_COLGANTES_X_MOBIL;

//				pesoTotal += (cantApariciones / Resolucion.CANT_COLGANTES_X_MOBIL) * colgante.getPeso()
//						* Resolucion.CANT_COLGANTES_X_MOBIL;
				
				pesoTotal += cantApariciones * colgante.getPeso();
			}

		}

		return cantVarillas == 0 ? "no se puede" : pesoTotal + " " + cantVarillas;
	}
}
