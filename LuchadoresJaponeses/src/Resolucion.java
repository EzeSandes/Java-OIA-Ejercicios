import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Resolucion {

	private int cantLuchadores;
	private Luchador[] luchadores;
	private static int[] dominados;
//	private int[] dominados;

	public Resolucion(String nomArchEnt) {
		// Inicializo las variables a usar.
		this.cargarLuchadores(nomArchEnt);
	}

	private void cargarLuchadores(String nomArchEnt) {
		Scanner scan = null;
		File file = null;

		try {
			file = new File(nomArchEnt);
			scan = new Scanner(file);

			this.cantLuchadores = scan.nextInt();
			if (this.cantLuchadores < 1 || this.cantLuchadores > 100000)
				throw new Exception("Cant de luchadores por debajo o encima de los limites");

			this.luchadores = new Luchador[this.cantLuchadores];
			int peso, altura;

			for (int i = 0; i < this.cantLuchadores; i++) {
				peso = scan.nextInt();
				altura = scan.nextInt();

				this.luchadores[i] = new Luchador(peso, altura);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

	public void resolver(String nomArchSal) {
//		this.contarDominados();
		this.contarDominados2();
		this.crearArchivoSalida(nomArchSal);
	}

	private void crearArchivoSalida(String nomArchSal) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;

		try {
			fileWriter = new FileWriter(nomArchSal);
			printWriter = new PrintWriter(fileWriter);

//			for (int i = 0; i < Resolucion.dominados.length; i++) {
//				printWriter.print(Resolucion.dominados[i]);
//			}

			for (int dominado : Resolucion.dominados) {
				printWriter.println(dominado);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	private void contarDominados() {

		Resolucion.dominados = new int[this.cantLuchadores];

		for (int i = 0; i < this.luchadores.length; i++) {

			for (int j = 0; j < this.luchadores.length; j++) {
				if (this.luchadores[i].domina(this.luchadores[j]))
					Resolucion.dominados[i]++;
			}
		}
	}

	private void contarDominados2() {
		Resolucion.dominados = new int[this.cantLuchadores];

		for (int i = 0; i < this.luchadores.length; i++) {
			for (int j = i + 1; j < this.luchadores.length; j++) {
				if (this.luchadores[i].domina(this.luchadores[j])) {
					Resolucion.dominados[i]++;
				} else if (this.luchadores[j].domina(this.luchadores[i])) {
					Resolucion.dominados[j]++;
				}
			}
		}
	}

}
