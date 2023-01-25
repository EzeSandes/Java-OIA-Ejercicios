package miPaquete;

public class Main {
	public static void main(String[] args) {
		String nomArch = "caso09";
		
		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();
		
		System.out.println(res);
		file.guardarRegistros(res);
	}
}
