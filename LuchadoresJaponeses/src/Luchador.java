
public class Luchador {
	
	// Int para simplificar cuentas
	private int altura;
	private int peso;
	
	public Luchador(int peso, int altura) {
		this.altura = altura;
		this.peso = peso;
	}

	public boolean domina(Luchador luchador) {
		
		if(this.peso > luchador.peso && this.altura > luchador.altura)
			return true;
		
		if(this.peso == luchador.peso && this.altura > luchador.altura)
			return true;
		
		if(this.altura == luchador.altura && this.peso > luchador.peso)
			return true;
		
		return false;
	}
	
	
}
