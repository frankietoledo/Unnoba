package tp2ejercicio2;
import java.util.Vector;
public class Comedor {
	//Attributes
	private Vector<Reserva> reservas=new Vector <Reserva> ();
	private String direccion;
	private int telefono;
	
	//method
	public void agregarReserva (Cliente cliente, Plato plato){
		reservas.add(new Reserva(cliente,plato));
	}
	public void agregarReserva (Cliente cliente, Vector <Plato> platos){
		reservas.add(new Reserva(cliente,platos));
	}
	public float valorReserva(Reserva reserva){
		return reserva.getValor();
	}
	public int totalPlatosReservados(){
		int acumulador=0;
		for (Reserva R:reservas){
			acumulador+=R.cantidadDePlatosReservados();
		}
		return acumulador;
	}
	public float totalValorReservas(){
		float acumulador=0f;
		for (Reserva R:reservas){
			acumulador+=R.getValor();
		}
		return acumulador;
	}
	public Reserva reservaMasPlatos(){
		int mayorCantidad=0;
		Reserva mayorCantidadR = null;//Probar para ver si da problemas el tener esta variable inicializada con Null..
		for (Reserva R:reservas){
			if (mayorCantidad<R.cantidadDePlatosReservados()){
				mayorCantidad=R.cantidadDePlatosReservados();
				mayorCantidadR=R;
			}
		}
		return mayorCantidadR;
	}
	
	
	//Generados Automaticamente
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}