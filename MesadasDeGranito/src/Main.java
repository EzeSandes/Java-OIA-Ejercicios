
public class Main {
	public static void main(String[] args) {
		String nomCP = "caso08";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		int rta = res.resolver();
		
		System.out.println(rta);
    file.guardarRes(rta);
	}
}
