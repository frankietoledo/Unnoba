package tp2ejercicio5;
import java.util.List;
import java.util.ArrayList;

public class Taller {

	private List <Orden> ordenes = new ArrayList<Orden>();
	public float getPrecio(){
		float total= 0.0f;
		for (Orden orden1: ordenes){
			total+=orden1.getPrecio();
		}
		return total;
	}
	public void addOrden(Orden unaOrden){
		ordenes.add(unaOrden);
	}
}
