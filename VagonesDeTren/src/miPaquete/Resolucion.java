package miPaquete;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Resolucion {
	private List<Especie> especies;
	private int agresividadMaximaTot;
	private int cantEspecies;
	private List<Vagon> vagones;

	public Resolucion(List<Especie> especies, int agresividadMaximaTot, int cantEspecies) {
		this.especies = especies;
		this.agresividadMaximaTot = agresividadMaximaTot;
		this.cantEspecies = cantEspecies;
	}

	public String resolver() {

		this.vagones = new LinkedList<Vagon>();

		// Descendente: O(n Log(n))
		Collections.sort(this.especies, new Comparator<Especie>() {
			public int compare(Especie e1, Especie e2) {
				return e2.getAgresividad() - e1.getAgresividad();
			}
		});

		int agresivTotal = this.agresividadMaximaTot;
		int i = 0, j = 0;
		int idVagon = 0;

		// O(n)
		while (i < this.especies.size()) {
			j = i + 1;
			int auxDifAgresividadMayorMenor = 0;

			// O(n): Peor caso
			while (j < this.especies.size()
					&& this.especies.get(i).diferenciaAgresividad(this.especies.get(j)) < agresivTotal) {
				auxDifAgresividadMayorMenor = this.especies.get(i).diferenciaAgresividad(this.especies.get(j));
				j++;
			}

			agresivTotal -= auxDifAgresividadMayorMenor;

			//O(1): Las listas en JAVA internamente tienen un puntero al ultimo elemento de la lista
			// 		segun la documentacion en Oracle para poder facilmente agregar elementos al final
			// 		y principio de la lista.
			//		Ver documentacion oficial para mas informacion.
			this.vagones.add(new Vagon(idVagon, auxDifAgresividadMayorMenor)); 
			idVagon++;
			i = j;
		}
		
		// forEach: M. Por cada vagon recorro
		agresivTotal = 0;
		for (Vagon vagon : this.vagones) {
			agresivTotal += vagon.getAgresividadTotal();
		}

		String result = idVagon + " " + agresivTotal;
		return result;
	}

	private String armarRes(int cantVagones, int agresivTotal) {
		return cantVagones + " " + agresivTotal;
	}

}
