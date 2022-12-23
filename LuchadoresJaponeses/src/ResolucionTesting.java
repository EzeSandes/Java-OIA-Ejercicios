//import org.junit.Before;
import org.junit.Test;

public class ResolucionTesting {

	private Resolucion res;
	
//	@Before
//	public void before() {
//		this.res = new Resolucion();
//	}
//	
	
	@Test
	public void pruebaCaso00() {
		String nomArchEnt = "./casosDePrueba/Entrada/caso00.in";
		String nomArchSal = "./casosDePrueba/SalidasObtenidas/caso00.out";

		Resolucion res = new Resolucion(nomArchEnt);

		res.resolver(nomArchSal);

		res = null;
	}

	@Test
	public void pruebaCaso01() {
		String nomArchEnt = "./casosDePrueba/Entrada/caso01.in";
		String nomArchSal = "./casosDePrueba/SalidasObtenidas/caso01.out";

		Resolucion res = new Resolucion(nomArchEnt);

		res.resolver(nomArchSal);

		res = null;
	}

	
	@Test
	public void pruebaCaso02() {
		String nomArchEnt = "./casosDePrueba/Entrada/caso02.in";
		String nomArchSal = "./casosDePrueba/SalidasObtenidas/caso02.out";

		Resolucion res = new Resolucion(nomArchEnt);

		res.resolver(nomArchSal);

		res = null;
	}

	@Test
	public void pruebaCaso03() {
		String nomArchEnt = "./casosDePrueba/Entrada/caso03.in";
		String nomArchSal = "./casosDePrueba/SalidasObtenidas/caso03.out";
		
		Resolucion res = new Resolucion(nomArchEnt);
		
		res.resolver(nomArchSal);
		
		res = null;
	}

	@Test
	public void pruebaCaso04() {
		String nomArchEnt = "./casosDePrueba/Entrada/caso04.in";
		String nomArchSal = "./casosDePrueba/SalidasObtenidas/caso04.out";
		
		Resolucion res = new Resolucion(nomArchEnt);
		
		res.resolver(nomArchSal);
		
		res = null;
	}

	@Test
	public void pruebaCaso05() {
		String nomArchEnt = "./casosDePrueba/Entrada/caso05.in";
		String nomArchSal = "./casosDePrueba/SalidasObtenidas/caso05.out";
		
		Resolucion res = new Resolucion(nomArchEnt);
		
		res.resolver(nomArchSal);
		
		res = null;
	}

	@Test
	public void pruebaCaso06() {
		String nomArchEnt = "./casosDePrueba/Entrada/caso06.in";
		String nomArchSal = "./casosDePrueba/SalidasObtenidas/caso06.out";
		
		Resolucion res = new Resolucion(nomArchEnt);
		
		res.resolver(nomArchSal);
		
		res = null;
	}
}
