package tp2ejercicio4;

public class Horno {

	private PanBuilder builder;

	public PanBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(PanBuilder builder) {
		this.builder = builder;
	} 
	
	public Pan getPan() {
		return getBuilder().getPan();
	}
	
	public void construirPan() {
		builder.comprovarTemperatura();
		builder.prepararAguaConSal();
		builder.prepararLevadura();
		builder.aadirAguaYMezclar();
		builder.aadirHarinaYRemover();
		builder.amasar();
		builder.reposar();
		builder.cortarMasa();
		builder.ponerEnHorno();
	}
	
	public static void main(String[] args) {
		Horno h = new Horno();
		
		h.setBuilder(new PanNegroBuilder());
		h.construirPan();
		
		System.out.println(h.getPan());
	}
	
}
