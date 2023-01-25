package miPaquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {
	private String pathArchEnt;
	private String pathArchSal;

	public Archivo(String nomArchEnt, String nomArchSal) {
		this.pathArchEnt = "casosDePruebas/input/" + nomArchEnt + ".in";
		this.pathArchSal = "casosDePruebas/output/" + nomArchSal + ".out";
	}

	public Resolucion cargarRegistros() {
		int agresividadMaximaTot = 0;
		List<Especie> especies = null;
		int cantEspecies = 0;

		try {
			File file = new File(this.pathArchEnt);
			Scanner scan = new Scanner(file);
			scan.useLocale(Locale.ENGLISH);

			especies = new LinkedList<Especie>();

			cantEspecies = scan.nextInt();
			agresividadMaximaTot = scan.nextInt();

			for (int i = 0; i < cantEspecies; i++) {
				String nomEspecie = scan.next();
				int agresiv = scan.nextInt();
				especies.add(new Especie(nomEspecie, agresiv, scan.nextInt()));
			}

			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return new Resolucion(especies, agresividadMaximaTot, cantEspecies);
	}

	public void guardarRegistros(String res) {
		FileWriter file = null;
		PrintWriter print = null;

		try {
			file = new FileWriter(this.pathArchSal);
			print = new PrintWriter(file);

			print.print(res);

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (print != null)
				try {
					print.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	}

	public String getPathArchEnt() {
		return pathArchEnt;
	}

	public String getPathArchSal() {
		return pathArchSal;
	}

}
