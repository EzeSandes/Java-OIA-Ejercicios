
public class Main {
	public static void main(String[] args) {
		String nomArchEnt = "sumo.in";
		String nomArchSal = "sumo.out";

		// 1 - Lectura del arch dentro del constructor
		Resolucion res = new Resolucion(nomArchEnt);
		
		// 2 - Resuelvo el problema.
		res.resolver(nomArchSal);
	}
}
