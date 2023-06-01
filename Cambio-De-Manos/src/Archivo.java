import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Archivo {
	private String pathSal;
	private String pathEnt;

	public Archivo(String nomArchEnt, String nomArchSal) {
		super();
		this.pathEnt = "casosDePruebas/input/" + nomArchEnt + ".in";
		this.pathSal = "casosDePruebas/output/" + nomArchSal + ".out";
	}

	public Resolucion leerReg() {

		File file = null;
		Scanner scan = null;
		HashMap<Arista, Integer> aristas = new HashMap<>();
		int[][] ady = null;
		int nodoIni = 0;
		int nodoFin = 0;
		Grafo g = null;

		try {
			file = new File(this.pathEnt);
			scan = new Scanner(file);

			int cantNodos = scan.nextInt();
			nodoIni = scan.nextInt() - 1;
			nodoFin = scan.nextInt() - 1;
			int cantAristas = scan.nextInt();

			ady = new int[cantNodos][cantNodos];

			for (int i = 0; i < cantAristas; i++) {
				int ini = scan.nextInt() - 1;
				int fin = scan.nextInt() - 1;
				int costo = scan.nextInt();

				ady[ini][fin] = costo;
				ady[fin][ini] = costo;

				// aristas.add(new Arista(i + 1, ini, fin, costo));
				aristas.put(new Arista(i + 1, ini, fin, costo), i + 1);

			}

			/// Agregar infinitos y ceros
			for (int i = 0; i < ady.length; i++) {
				for (int j = i + 1; j < ady.length; j++) {
					if (ady[i][j] == 0) {
						ady[i][j] = Integer.MAX_VALUE;
					}
					ady[i][i] = 0;
				}
			}

			g = new Grafo(ady);

			scan.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Resolucion(aristas, nodoIni, nodoFin, g);
	}

	public void guardarArch(String res) {
		FileWriter fw = null;
		PrintWriter print = null;

		try {
			fw = new FileWriter(this.pathSal);
			print = new PrintWriter(fw);

			print.print(res);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (print != null)
				try {
					print.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	}

}
