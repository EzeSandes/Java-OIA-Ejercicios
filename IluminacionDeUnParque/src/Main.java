public class Main {
	public static void main(String[] args) {
		String nroCP = "caso00";
		
		Archivo file = new Archivo(nroCP, nroCP);
		Resolucion res = file.leerArchivo();
		file.grabarArchivo(res.resolver());
	}
}
