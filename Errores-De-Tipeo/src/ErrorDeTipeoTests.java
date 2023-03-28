import org.junit.Assert;
import org.junit.Test;

public class ErrorDeTipeoTests {
	@Test
	public void pruebaDeFuncionamiento() {
		ErroresDeTipeo errTip = new ErroresDeTipeo();

		Assert.assertEquals(40, errTip.procesador("Estamos pintando!", "ostant!Em inpados"));
	}
}
