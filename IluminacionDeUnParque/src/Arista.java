
public class Arista implements Comparable<Arista> {
	private int nodoDesde;
	private int nodoHasta;
	private double costo;

	public Arista(int nodoDesde, int nodoHasta, double costo) {
		this.nodoDesde = nodoDesde;
		this.nodoHasta = nodoHasta;
		this.costo = costo;
	}

	@Override
	public int compareTo(Arista o) {
		double dif = Double.doubleToLongBits(this.costo) - Double.doubleToLongBits(o.costo);
		
		if(dif < 0)
			return -1;
		else if(dif > 0)
			return 1;
		else
			return 0;		
	}

	public int getNodoDesde() {
		return nodoDesde;
	}

	public int getNodoHasta() {
		return nodoHasta;
	}

	public double getCosto() {
		return costo;
	}
}
