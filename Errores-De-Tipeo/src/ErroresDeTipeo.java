public class ErroresDeTipeo {
	
	public static void main(String[] args) {
		ErroresDeTipeo errTip = new ErroresDeTipeo();
		
		errTip.procesador("Estamos pintando!", "ostant!Em inpados");
	}
	
	public int procesador(String texto, String prueba) {
		int cantidadMovimientos = 0;
		
		String s = prueba;
		for (int i = 0; i < texto.length() - 1; i++) {
			String letra = "" + texto.charAt(i); // obtengo la letra
			int posEncontrada = s.indexOf(letra);

			cantidadMovimientos = cantidadMovimientos + posEncontrada; // seteo los movimientos
			s = s.replaceFirst(letra, "");
		}

		System.out.println(cantidadMovimientos);
		
		return cantidadMovimientos;
	}
}
