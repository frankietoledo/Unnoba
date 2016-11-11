package tp2ejercicio4;

public class PanBlancoBuilder extends PanBuilder  {

	private PanBlanco panBlanco = new PanBlanco();
	
	@Override
	public void aadirHarinaYRemover() {
		panBlanco.setComposicionDeHarina("Harina que contiene solo" +
				" la parte central del grano");
	}

	@Override
	public Pan getPan() {
		return panBlanco;
	}

}
