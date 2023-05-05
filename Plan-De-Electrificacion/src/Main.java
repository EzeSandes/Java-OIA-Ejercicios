public class Main {
	public static void main(String[] args) {
		String nroCaso = "caso06";
		
		Archivo file = new Archivo(nroCaso, nroCaso);
		Resolucion resolucion = file.leerArchivo();
		file.guardarRes(resolucion.resolver());
	}
}
