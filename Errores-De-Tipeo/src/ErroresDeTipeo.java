
public class ErroresDeTipeo {
	
	public static void main(String[] args) {
		ErroresDeTipeo errTip = new ErroresDeTipeo();
		
		errTip.procesador("Estamos pintando!", "ostant!Em inpados");
	}
	
	public int procesador(String texto, String prueba) {
//		int tamText = texto.length();
		int cantidadMovimientos = 0;
		
		String s = prueba;
		for (int i = 0; i < texto.length() - 1; i++) {
			String letra = "" + texto.charAt(i); // obtengo la letra
			int posEncontrada = s.indexOf(letra);
			// int postEncontrada=s.indexOf(letra);

			// int posEncontrada=s.indexOf(this.texto.substring(i,i+1)); //busco la posicion
			// en el string desordenado
			cantidadMovimientos = cantidadMovimientos + posEncontrada; // seteo los movimientos
			// s.deleteCharAt(posEncontrada); //elimino el char encontrado
			s = s.replaceFirst(letra, "");
			
			// En la proxima vuelta, al haber eliminado un char, el index sera distinto.
//			System.out.println(s.length());

		}

		System.out.println(cantidadMovimientos);
		
		return cantidadMovimientos;
	}
}
