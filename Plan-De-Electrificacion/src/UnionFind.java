
public class UnionFind {

	private int[] id;

	public UnionFind(int cantNodos) {
		this.id = new int[cantNodos];

		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	public int find(int p) {
		while (p != id[p])
			p = id[p];

		return p;
	}

	public void union(int p, int q) {
		int repreDeP = find(p);
		int repreDeQ = find(q);

		if (repreDeP == repreDeQ)
			return;

		id[repreDeP] = repreDeQ;
	}

	public boolean isConectado(int p, int q) {
		return find(p) == find(q);
	}
}
