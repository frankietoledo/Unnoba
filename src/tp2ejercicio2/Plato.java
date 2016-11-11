package tp2ejercicio2;

public class Plato {
	//Attributes
	private String nombre;
	private float precio;
	private String diaDisponible;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getDiaDisponible() {
		return diaDisponible;
	}
	public void setDiaDisponible(String diaDisponible) {
		this.diaDisponible = diaDisponible;
	}
	public Plato(String nombre, float precio, String diaDisponible) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.diaDisponible = diaDisponible;
	}
	

}