import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Archivo {
	private String pathArchEnt;
	private String pathArchSal;

	public Archivo(String nomArchEnt, String nomArchSal) {
		this.pathArchEnt = "casosDePruebas/input/" + nomArchEnt + ".in";
		this.pathArchSal = "casosDePruebas/output/" + nomArchSal + ".out";
	}

	public Resolucion leerArchivo() {

		Scanner scan = null;
		File file = null;
		Mesada[] mesadas = null;

		try {
			file = new File(this.pathArchEnt);
			scan = new Scanner(file);
			int cantMesadas = scan.nextInt();
			int ancho, altura;
			mesadas = new Mesada[cantMesadas];

			for (int i = 0; i < cantMesadas; i++) {
				ancho = scan.nextInt();
				altura = scan.nextInt();
				
				if(ancho > altura)
					mesadas[i] = new Mesada(ancho, altura);
				else
					mesadas[i] = new Mesada(altura, ancho);				
			}

			// Ancho, Altura ---> menor
			Arrays.sort(mesadas);

		} catch (Exception e) {
			e.printStackTrace();
		}

		scan.close();

		return new Resolucion(mesadas);
	}

  // Guardar en un archivo la rta
//	public void guardarRes(int rta) {
//		// TODO Auto-generated method stub
//		
//	}
}
