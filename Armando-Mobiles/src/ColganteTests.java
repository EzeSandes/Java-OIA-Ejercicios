import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class ColganteTests {
	
	@Test
	public void casoDeFuncionamiento() {
		String nroPruebaTxt = "caso00";

		Archivo file = new Archivo(nroPruebaTxt, nroPruebaTxt);
		List<Colgante> colgantes = file.cargarColgantes();

		Resolucion res = new Resolucion(colgantes);

		Assert.assertEquals("8 2", res.cantMoviles());
	}

	@Test
	public void todosLosPesosDiferentes() {
		String nroPruebaTxt = "caso01";
		
		Archivo file = new Archivo(nroPruebaTxt, nroPruebaTxt);
		List<Colgante> colgantes = file.cargarColgantes();
		
		Resolucion res = new Resolucion(colgantes);
		
		Assert.assertEquals("no se puede", res.cantMoviles());
	}
	
	@Test
	public void todosLosPesosIgualesSinSobrantes() {
		String nroPruebaTxt = "caso02";
		
		Archivo file = new Archivo(nroPruebaTxt, nroPruebaTxt);
		List<Colgante> colgantes = file.cargarColgantes();
		
		Resolucion res = new Resolucion(colgantes);
		
		Assert.assertEquals("32 2", res.cantMoviles());
	}

	@Test
	public void todosLosPesosIgualesConSobrantes() {
		String nroPruebaTxt = "caso03";
		
		Archivo file = new Archivo(nroPruebaTxt, nroPruebaTxt);
		List<Colgante> colgantes = file.cargarColgantes();
		
		Resolucion res = new Resolucion(colgantes);
		
		Assert.assertEquals("32 2", res.cantMoviles());
	}

	@Test
	public void ceroColgantes() {
		String nroPruebaTxt = "caso04";
		
		Archivo file = new Archivo(nroPruebaTxt, nroPruebaTxt);
		List<Colgante> colgantes = file.cargarColgantes();
		
		Resolucion res = new Resolucion(colgantes);
		
		Assert.assertEquals("no se puede", res.cantMoviles());
	}

	@Test
	public void unSoloColgante() {
		String nroPruebaTxt = "caso05";
		
		Archivo file = new Archivo(nroPruebaTxt, nroPruebaTxt);
		List<Colgante> colgantes = file.cargarColgantes();
		
		Resolucion res = new Resolucion(colgantes);
		
		Assert.assertEquals("no se puede", res.cantMoviles());
	}
	
	
}
