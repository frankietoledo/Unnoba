package tp2ejercicio5;
import java.util.List;
import java.util.ArrayList;

public class Orden {
	private List<Articulo> articulos = new ArrayList <Articulo>();
	
	public void addArticulo(Articulo unArticulo){
		articulos.add(unArticulo);
	}
	
	public float getPrecio() {
		float montoTotal = 0.0f;
		for(Articulo art : articulos) {
			montoTotal += art.getPrecio();
		}
		return montoTotal;
	}
}
