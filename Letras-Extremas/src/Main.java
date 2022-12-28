import java.util.List;

public class Main {
	public static void main(String[] args) {
		String numCasoPrueba = "caso02";
		Archivo file = new Archivo("casosDePruebas/input/" + numCasoPrueba + ".in",
				"casosDePruebas/output/" + numCasoPrueba + ".out");

		String respuesta;
		List<String> palabras = file.cargarArchivo();
		Resolucion res = new Resolucion(palabras);

		respuesta = res.resolver();
		file.guardarArchivo(respuesta);
	}
}
