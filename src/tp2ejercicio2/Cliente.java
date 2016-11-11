package tp2ejercicio2;

public enum Cliente {
	ALUMNO(0.20f),
	PROFESOR(0.10f),
	PARTICULAR(0.0f);
	private final float descuento;
	private Cliente (float descuento){
		this.descuento=descuento;
	}
	public float getDescuento(){
		return descuento;
	}
}
