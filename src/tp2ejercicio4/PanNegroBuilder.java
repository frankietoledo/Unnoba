package tp2ejercicio4;

public class PanNegroBuilder extends PanBuilder  {

	private PanNegro panNegro = new PanNegro();
	
	@Override
	public void aadirHarinaYRemover() {
		panNegro.setComposicionDeHarina("Harina de la que se ha " +
				"quitado salvado y germen de trigo");
	}
	
	@Override
	public Pan getPan() {
		return panNegro;
	}
	
}
