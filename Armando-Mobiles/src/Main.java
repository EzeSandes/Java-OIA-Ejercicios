import java.util.List;

public class Main {
	public static void main(String[] args) {

		String nroPruebaTxt = "caso00";

		Archivo file = new Archivo(nroPruebaTxt, nroPruebaTxt);
		List<Colgante> colgantes = file.cargarColgantes();

		Resolucion res = new Resolucion(colgantes);

		file.guardarArchivo(res.cantMoviles());
	}
}
