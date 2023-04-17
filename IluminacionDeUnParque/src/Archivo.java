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
		Scanner scan = null;
		List<Nodo> faroles = new LinkedList<>();

		try {
			scan = new Scanner(new File(this.pathEnt));

			int cantFaroles = scan.nextInt();

			for (int i = 0; i < cantFaroles; i++) {
				faroles.add(new Nodo(scan.nextInt(), scan.nextInt(), scan.nextInt()));
			}

			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Resolucion(faroles);
	}
	
	public void grabarArchivo(String res) {
		FileWriter file = null;
		PrintWriter print = null;
		
		try {
			file = new FileWriter(this.pathSal);
			print = new PrintWriter(file);
			
			print.print(res);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(print != null)
				try {
					print.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	}
}
