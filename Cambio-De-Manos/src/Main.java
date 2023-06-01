public class Main {
	public static void main(String[] args) {
		String nomArchEnt = "caso07– 8milx25milCalles";
		
		Archivo file = new Archivo(nomArchEnt, nomArchEnt);
		Resolucion res = file.leerReg();
		file.guardarArch(res.resolver());
	}
}
