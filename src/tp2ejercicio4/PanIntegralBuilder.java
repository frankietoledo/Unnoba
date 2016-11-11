package tp2ejercicio4;

public class PanIntegralBuilder extends PanBuilder  {

	private PanIntegral panIntegral = new PanIntegral();
	
	@Override
	public void aadirHarinaYRemover() {
		panIntegral.setComposicionDeHarina("Harina que conserva " +
				"todos sus componentes");
	}
	
	@Override
	public Pan getPan() {
		return panIntegral;
	}

}
