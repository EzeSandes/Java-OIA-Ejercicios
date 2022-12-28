import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Resolucion {
	private List<String> palabras;

	public Resolucion(List<String> palabras) {
		this.palabras = palabras;
	}

	public String resolver() {

		Map<Character, Integer> mapChars = new HashMap<>();
		Set<String> palabrasLetrasMaximas = new HashSet<>();
		
		int cantMax = 0;

		// 1 - Recorro la lista y cargo la cantidad de ocurrencias de cada letra extrema
		mapChars = this.cargarMapaDeLetras(mapChars, this.palabras);

		// 2 - Busco la concurrencia maxima.
		cantMax = this.buscarMaxCantidad(mapChars);

		// 3 - Busco las letras que tienen concurrencia maxima
		char[] letrasMaximas = this.buscarLetrasMaximas(mapChars, cantMax);
		
		// 4 - Busco las palabras que contienen las letras maximas
		palabrasLetrasMaximas = this.buscarPalabrasLetrasMaximas(palabrasLetrasMaximas ,this.palabras, letrasMaximas);

		// 5 - Crear una String con las letras maximas y el set de palabras a grabar
		return this.crearStringSalida(letrasMaximas, palabrasLetrasMaximas);		
	}

	private String crearStringSalida(char[] letrasMaximas, Set<String> palabrasLetrasMaximas) {
	
		String res = "";
		
		for (char letra : letrasMaximas)
			res += letra + " "; // Si le pongo un CHAR => sumara el ASCI. Cuidado con eso!
		
		res += "\n";
		
		for (String palabra : palabrasLetrasMaximas) {
			res += palabra + "\n";
		}
		
		return res;
	}

	private Set<String> buscarPalabrasLetrasMaximas(Set<String> palabrasLetrasMaximas, List<String> palabras, char[] letrasMaximas) {
		char primeraLetra, ultimaLetra;
		
		for(int i = 0; i < letrasMaximas.length; i++) {
			
			for (String palabra : palabras) {
				primeraLetra = palabra.charAt(0);
				ultimaLetra = palabra.charAt(palabra.length() - 1);
				
				if(primeraLetra == letrasMaximas[i] || ultimaLetra == letrasMaximas[i])
					palabrasLetrasMaximas.add(palabra);
			}
		}
		
		return palabrasLetrasMaximas;
	}

	private char[] buscarLetrasMaximas(Map<Character, Integer> mapChars, int cantMax) {

		String letrasMax = "";

		for (Map.Entry<Character, Integer> par : mapChars.entrySet()) {
			if (par.getValue() == cantMax)
				letrasMax += par.getKey();
		}

		return letrasMax.toCharArray();
	}

	private int buscarMaxCantidad(Map<Character, Integer> mapChars) {

		int cantMax = 0;

		for (Integer cantApariciones : mapChars.values()) {
			if (cantApariciones > cantMax)
				cantMax = cantApariciones;
		}

		return cantMax;
	}

	private Map<Character, Integer> cargarMapaDeLetras(Map<Character, Integer> mapChars, List<String> palabras) {

		for (String palabra : palabras) {
			// 1ra Letra
			mapChars.put(palabra.charAt(0), mapChars.getOrDefault(palabra.charAt(0), 0) + 1);

			// 2da Letra
			mapChars.put(palabra.charAt(palabra.length() - 1),
					mapChars.getOrDefault(palabra.charAt(palabra.length() - 1), 0) + 1);
		}

		return mapChars;
	}
}
