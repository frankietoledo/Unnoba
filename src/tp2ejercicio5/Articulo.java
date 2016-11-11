package tp2ejercicio5;

public abstract class Articulo {
	private float precio;
	private String nombre;
	
	public abstract float getPrecio();
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre(){
		return this.nombre;
	}
}
