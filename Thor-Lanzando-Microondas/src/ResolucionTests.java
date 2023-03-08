import org.junit.Assert;
import org.junit.Test;

public class ResolucionTests {

	@Test
	public void prueba01() {
		Resolucion res = new Resolucion();
		int[] alt = new int[] { 14, 10, 11, 5 };
		int[] fuerza = new int[] { 4, 3, 5, 29 };
		int[] peso = new int[] { 4, 10, 7 };
		Objeto[] objetos = new Objeto[] { new Objeto(4), new Objeto(10), new Objeto(7) };

		Assert.assertEquals(4, res.thor(alt, fuerza, peso, 14));
	}
	
	
}
