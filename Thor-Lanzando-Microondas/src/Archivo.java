import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {
	private String pathArchEnt;
	private String pathArchSal;

	public Archivo(String nomArchEnt, String nomArchSal) {
		this.pathArchEnt = "casosDePruebas/input/" + nomArchEnt + ".in";
		this.pathArchSal = "casosDePruebas/output/" + nomArchEnt + ".out";
	}

	public Resolucion cargarRegistros() {
		File file = null;
		Scanner scan = null;
		Personaje[] personajes = null;
		Objeto[] objetos = null;
		int distancia = 0;

		try {
			file = new File(this.pathArchEnt);
			scan = new Scanner(file);

			int cantPersonajes = scan.nextInt();
			int cantObjetos = scan.nextInt();
			distancia = scan.nextInt();
			personajes = new Personaje[cantPersonajes];
			objetos = new Objeto[cantObjetos];
			
			for (int i = 0; i < cantPersonajes; i++) {
				personajes[i] = new Personaje(scan.nextInt(), scan.nextInt());
			}
			
			for (int i = 0; i < cantObjetos; i++) {
				objetos[i] = new Objeto(scan.nextInt());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Resolucion(personajes, objetos, distancia);
	}

	public void guardarArchivo(int result) {
		FileWriter fileWriter = null;
		PrintWriter print = null;
		
		try {
			fileWriter = new FileWriter(this.pathArchSal);
			print = new PrintWriter(fileWriter);
			
			print.print(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fileWriter != null)
				try {
					fileWriter.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	}
}
