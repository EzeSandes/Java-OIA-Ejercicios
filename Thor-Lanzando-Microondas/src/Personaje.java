
public class Personaje {
	private int altura;
	private int fuerza;
	public static int DISTANCIA;
	// Cargar un array con las alturas y fuerza de los personajes
	
	public Personaje(int altura, int fuerza) {
		this.altura = altura;
		this.fuerza = fuerza;
	}

	public Personaje(int distancia) {
		Personaje.DISTANCIA = distancia;
	}
	
	public int calcDistanciaDeTiro(Objeto obj){
		return (this.altura * this.fuerza) / obj.getPeso();
	}
	
	
	
	public static int getDISTANCIA() {
		return DISTANCIA;
	}

	public static void setDISTANCIA(int distancia) {
		DISTANCIA = distancia;
	}

	public int getAltura() {
		return altura;
	}

	public int getFuerza() {
		return fuerza;
	}
	
	
	
}
