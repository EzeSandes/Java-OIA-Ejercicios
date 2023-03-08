
public class Main {
	public static void main(String[] args) {
		Archivo file = new Archivo("caso00", "caso00");
		Resolucion res = file.cargarRegistros();
		
		int result = res.resolver();
		System.out.println(result);
		file.guardarArchivo(result);
	}
}
