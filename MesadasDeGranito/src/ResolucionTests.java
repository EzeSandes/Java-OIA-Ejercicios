import org.junit.Assert;
import org.junit.Test;

public class ResolucionTests {
	
	
	@Test
	public void pruebaDeFuncionamiento() {
		String nomCP = "caso00";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		Assert.assertEquals(3, res.resolver());
	}
	
	@Test
	public void dosPilasMinimas() {
		String nomCP = "caso01";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		Assert.assertEquals(2, res.resolver());
	}
	
	@Test
	public void ningunaMesadaPuedeApilarAOtra() {
		String nomCP = "caso02";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		Assert.assertEquals(2, res.resolver());
	}

	@Test
	public void unaMesadaApilaATodos() {
		String nomCP = "caso03";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		Assert.assertEquals(1, res.resolver());
	}
	
	@Test
	public void todasLasMesadasIguales() {
		String nomCP = "caso04";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		Assert.assertEquals(1, res.resolver());
	}
	
	@Test
	public void rotarMesadaParaApilar() {
		String nomCP = "caso05";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		Assert.assertEquals(1, res.resolver());
	}
	
	/////////////// PRUEBAS SUGERIDAS DE PROFES
	@Test
	public void cantidadesMinimas() {
		String nomCP = "caso06";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		Assert.assertEquals(1, res.resolver());
	}

	@Test
	public void rotaciones() {
		String nomCP = "caso07";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		Assert.assertEquals(2, res.resolver());
	}
	
	@Test
	public void pilasOrdenadas() {
		String nomCP = "caso08";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		Assert.assertEquals(2, res.resolver());
	}
	
	
	@Test
	public void analizandoPilas() {
		String nomCP = "caso09";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		Assert.assertEquals(3, res.resolver());
	}

	@Test
	public void escalera() {
		String nomCP = "caso10";
		
		Archivo file = new Archivo(nomCP, nomCP);
		
		Resolucion res = file.leerArchivo();
		
		Assert.assertEquals(1, res.resolver());
	}
	
	
}
