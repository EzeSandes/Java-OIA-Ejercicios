import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Archivo {
	private String pathEnt;
	private String pathSal;

	public Archivo(String nomArchEnt, String nomArchSal) {
		this.pathEnt = "casosDePruebas/input/" + nomArchEnt + ".in";
		this.pathSal = "casosDePruebas/output/" + nomArchSal + ".out";
	}

	public Resolucion leerArchivo() {
		Scanner scanner = null;
		File file = null;
		int[][] matrizAdy = null;
		List<Integer> ciudadesConCentrales = new LinkedList<>();

		try {
			file = new File(this.pathEnt);
			scanner = new Scanner(file);

			int cantCiudades = scanner.nextInt();
			int cantCentrales = scanner.nextInt();

			for (int i = 0; i < cantCentrales; i++) {
				ciudadesConCentrales.add(scanner.nextInt()); // O(1)
			}

			matrizAdy = new int[cantCiudades][cantCiudades];

			for (int i = 0; i < cantCiudades; i++) {
				for (int j = 0; j < cantCiudades; j++) {
					matrizAdy[i][j] = scanner.nextInt();
				}
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new Resolucion(matrizAdy, ciudadesConCentrales);
	}

	public void guardarRes(String res) {
		FileWriter fw = null;
		PrintWriter print = null;

		try {
			fw = new FileWriter(this.pathSal);
			print = new PrintWriter(fw);

			print.print(res);

		} catch (IOException e) {
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
