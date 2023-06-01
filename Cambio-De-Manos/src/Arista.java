
public class Arista implements Comparable<Arista>{
	private int id;
	private int nodoIni;
	private int nodoFin;
	private int costo;

	public Arista(int id, int nodoIni, int nodoFin, int costo) {
		this.id = id;
		this.nodoIni = nodoIni;
		this.nodoFin = nodoFin;
		this.costo = costo;
	}

	public int getId() {
		return id;
	}

	public int getNodoIni() {
		return nodoIni;
	}

	public int getNodoFin() {
		return nodoFin;
	}

	public int getCosto() {
		return costo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nodoFin;
		result = prime * result + nodoIni;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		if (nodoFin != other.nodoFin)
			return false;
		if (nodoIni != other.nodoIni)
			return false;
		return true;
	}

	@Override
	public int compareTo(Arista o) {
		int res = 0;
		
		if((res = this.nodoIni - o.nodoIni) == 0){
			return this.nodoFin - o.nodoFin;
		}
		
		return res;
	}

	@Override
	public String toString() {
		return "Arista [id=" + id + ", nodoIni=" + nodoIni + ", nodoFin=" + nodoFin + ", costo=" + costo + "]";
	}
	
	

}
