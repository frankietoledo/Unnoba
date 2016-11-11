package tp2ejercicio5;

public class Pieza extends Articulo {
	private float precio;
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float unPrecio){
		this.precio=unPrecio;
	}
	
	public Pieza(float precio, String nombre) {
		this.precio = precio;
		super.setNombre(nombre);
	}

}
