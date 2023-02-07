import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo {
	private String pathEntrada;
	private String pathSalida;

	public Archivo(String nomArchEnt, String nomArchSal) {
		this.pathEntrada = "casosDePruebas/input/" + nomArchEnt + ".in";
		this.pathSalida = "casosDePruebas/output/" + nomArchSal + ".out";
	}

	public List<Colgante> cargarColgantes() {

		Scanner scan;
		List<Colgante> colgantes = new ArrayList<Colgante>();

		try {
			scan = new Scanner(new File(this.pathEntrada));
			int c = scan.nextInt();

			for (int i = 0; i < c; i++)
				colgantes.add(new Colgante(scan.nextInt()));

			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return colgantes;
	}

	public void guardarArchivo(String cantMoviles) {
		File file = null;
		FileWriter pfTxt = null;
		try {
			file = new File(this.pathSalida);
			pfTxt = new FileWriter(file);
			pfTxt.write(cantMoviles);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pfTxt != null)
				try {
					pfTxt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}

	}
}
