
public class Resolucion {

	Mesada[] mesadas;

	public Resolucion(Mesada[] mesadas) {
		this.mesadas = mesadas;
	}

	public int resolver() {

		int cantPilas = 0;
		Mesada mesadaInf = null;

		for (int i = 0; i < mesadas.length; i++) {
			if (!mesadas[i].isApilable())
				continue;

			mesadas[i].setNoApilable();
			mesadaInf = mesadas[i];
			cantPilas++;

			for (int j = i + 1; j < mesadas.length; j++) {

				if (mesadas[j].isApilable() && mesadaInf.puedeContener(mesadas[j])) {
					mesadas[j].setNoApilable();
					mesadaInf = mesadas[j];
				}
			}
		}

		return cantPilas;
	}
}
