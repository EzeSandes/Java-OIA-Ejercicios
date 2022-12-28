import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Archivo {
	private String pathArchEnt;
	private String pathArchSal;

	public Archivo(String pathEnt, String pathSal) {
		this.pathArchEnt = pathEnt;
		this.pathArchSal = pathSal;
	}

	public List<String> cargarArchivo() {
		Scanner scan = null;
		File file = null;
		List<String> palabras = new LinkedList<>();

		try {
			file = new File(this.pathArchEnt);
			scan = new Scanner(file);
			int cantPalabras = scan.nextInt();

			for (int i = 0; i < cantPalabras; i++) {
				palabras.add(scan.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}

		return palabras;
	}

	public void guardarArchivo(String respuesta) {
		PrintWriter printWriter = null;
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(this.pathArchSal);
			printWriter = new PrintWriter(fileWriter);

			printWriter.print(respuesta);

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
}
