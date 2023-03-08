
public class Resolucion {
	
	private Personaje[] personajes;
	private Objeto[] objetos;
	private int distancia;

	public Resolucion() {
		
	}
	
	public Resolucion(Personaje[] personajes, Objeto[] objetos, int distancia) {
		this.personajes = personajes;
		this.objetos = objetos;
		this.distancia = distancia;
	}
	
	public int thor(int []alt, int []fuerza, int []peso, 
			int distancia){
		int cont = 0;
		
		for (int i = 0; i < alt.length; i++) {
			for (int j = 0; j < peso.length; j++) {
				int distCalc = (alt[i] * fuerza[i]) / peso[j];
				
				if(distCalc >= distancia){
					cont++;
				}
			}
		}
		
		return cont;
	}
	
	public int thor(int []alt, int []fuerza, Objeto []pesos, 
			int distancia){
		int cont = 0;
		
		for (int i = 0; i < alt.length; i++) {
			for (int j = 0; j < pesos.length; j++) {
				int distCalc = (alt[i] * fuerza[i]) / 
						pesos[j].getPeso();
				
				if(distCalc >= distancia){
					cont++;
				}
			}
		}
		
		return cont;
	}
	
	public int thor(Personaje[] personajes, Objeto []pesos){
		int cont = 0;
		
		for (int i = 0; i < personajes.length; i++) {
			for (int j = 0; j < pesos.length; j++) {
				int distCalc = personajes[i].calcDistanciaDeTiro(pesos[j]);
				
				if(distCalc >= Personaje.DISTANCIA){
					cont++;
				}
			}
		}
		
		return cont;
	}
	
	public int resolver(){
		int cont = 0;
		
		for (int i = 0; i < this.personajes.length; i++) {
			for (int j = 0; j < this.objetos.length; j++) {
				int distCalc = personajes[i].calcDistanciaDeTiro(this.objetos[j]);
				
				if(distCalc >= this.distancia){
					cont++;
				}
			}
		}
		
		return cont;
	}
}
