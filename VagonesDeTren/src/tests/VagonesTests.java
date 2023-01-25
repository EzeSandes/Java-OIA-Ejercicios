package tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import miPaquete.Archivo;
import miPaquete.Resolucion;

public class VagonesTests {

	@Test
	public void pruebaDeFuncionamientoConArchivo() throws IOException {
		String nomArch = "caso00";

		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();
		file.guardarRegistros(res);
		
		byte[] file1Bytes = Files.readAllBytes(Paths.get("casosDePruebas/output/" + nomArch + ".out"));
		byte[] file2Bytes = Files.readAllBytes(Paths.get("casosDePruebas/outputEsperado/" + nomArch + ".out"));
		
		String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
		String file2 = new String(file2Bytes, StandardCharsets.UTF_8);
		
		Assert.assertEquals(file1, file2);
	}

	@Test
	public void pruebaDeFuncionamiento() {
		String nomArch = "caso00";

		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();

		System.out.println(res);

		Assert.assertEquals("4 45", res);
	}

	@Test
	public void todosLosAnimalesEnUnVagon() {
		String nomArch = "caso01";

		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();

		Assert.assertEquals("1 1995", res);
	}

	@Test
	public void todosLosAnimalesEnVagonesDistintos() {
		String nomArch = "caso02";

		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();

		Assert.assertEquals("6 0", res);
	}

	@Test
	public void todosLosAnimalesVanSolos() {
		String nomArch = "caso03";

		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();

		Assert.assertEquals("4 0", res);
	}

	@Test
	public void haySoloUnaEspecie() {
		String nomArch = "caso04";

		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();

		Assert.assertEquals("1 0", res);
	}

	@Test
	public void haySoloUnaEspecieConMuchosAnimales() {
		String nomArch = "caso05";

		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();

		Assert.assertEquals("1 0", res);
	}

	@Test
	public void haySoloUnaEspecieConUnAnimal() {
		String nomArch = "caso06";

		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();

		Assert.assertEquals("1 0", res);
	}

	@Test
	public void especiesDistintasConMismaAgresividad() {
		String nomArch = "caso07";

		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();

		Assert.assertEquals("1 0", res);
	}

	@Test
	public void especiesConAgresividadCero() {
		String nomArch = "caso08";

		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();

		Assert.assertEquals("1 0", res);
	}

	@Test
	public void pruebaDeFuncionamientoDistinta() {
		String nomArch = "caso09";

		Archivo file = new Archivo(nomArch, nomArch);
		Resolucion resolucion = file.cargarRegistros();

		String res = resolucion.resolver();

		Assert.assertEquals("3 50", res);
	}

}
