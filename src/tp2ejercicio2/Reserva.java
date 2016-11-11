package tp2ejercicio2;
import java.util.Vector;
import java.util.Date;
public class Reserva {
	
	//Attributes
	private Cliente cliente;
	private Date fecha;
	//Ver como conviene mas hacer las cosas
	//si con dos variables o un vector de 1 elem
	private Vector <Plato> platos=new Vector <Plato> ();
	
	//Methods
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Vector<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(Vector<Plato> platos) {
		this.platos = platos;
	}
	public Reserva(Cliente cliente, Plato plato) {
		this.cliente = cliente;
		platos.add(plato);
	}
	public Reserva(Cliente cliente, Vector<Plato> platos) {
		this.cliente = cliente;
		for (Plato p:platos){
			this.platos.add(p);
		}
	}
	public float getValor(){
		//Retorna el valor de todos los platos que tenga sumados y aplicado el descuento
		float acumulador=0f;
		for (Plato p:platos){
			acumulador+=p.getPrecio();
		}
		return acumulador-(acumulador*cliente.getDescuento());
	}
	public int cantidadDePlatosReservados(){
		return platos.size();
	}
}