package miPaquete;

public class Especie {
	private String nombre;
	private int agresividad;
	private int cantAnimales;
	
	public Especie(String nombre, int agresividad, int cantidad) {
		this.nombre = nombre;
		this.agresividad = agresividad;
		this.cantAnimales = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getAgresividad() {
		return agresividad;
	}

	public int getCantAnimales() {
		return cantAnimales;
	}

	public int diferenciaAgresividad(Especie especie) {
		return this.getAgresividad() - especie.getAgresividad();
	}
	
	
}
