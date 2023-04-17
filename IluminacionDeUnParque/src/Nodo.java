public class Nodo {
	private int id;
	private int x;
	private int y;

	public Nodo(int id, int x, int y) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getDistancia(Nodo nodoActual) {
		return Math.hypot((this.x - nodoActual.x), (this.y - nodoActual.y));
	}

}
