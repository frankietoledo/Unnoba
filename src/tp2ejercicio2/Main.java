package tp2ejercicio2;
import java.util.Vector;
public class Main {

	public static void main(String[] args) {
		System.out.println("Se agregan todos los platos ");
		Plato plato1=new Plato("fideos",25f,"Martes");
		Plato plato2=new Plato("Hambur",55f,"Miercoles");
		Plato plato3=new Plato("TuHermana",1f,"Sabados");
		Plato plato4=new Plato("Tarta",51f,"Lunes");
		Plato plato5=new Plato("Atun",12f,"Jueves");
		Plato plato6=new Plato("Milanga",35f,"Viernes");
		Plato plato7=new Plato("Verduras",43f,"Domingo");
		
		System.out.println("Se agregan todos los Clientes");
		Cliente cliente1=Cliente.ALUMNO;
		Cliente cliente2=Cliente.PARTICULAR;
		Cliente cliente3=Cliente.PROFESOR;
		Comedor comedor1=new Comedor();
		comedor1.setDireccion("San lorenzo 42");
		comedor1.setTelefono(414141);
		
		System.out.println(comedor1.getDireccion()+" "+comedor1.getTelefono());
		comedor1.agregarReserva(cliente1, plato1);
		comedor1.agregarReserva(cliente2, plato3);
		comedor1.agregarReserva(cliente2, plato5);
		comedor1.agregarReserva(cliente1, plato4);
		
		System.out.println("Se agrega un vector");
		
		Vector <Plato> platasos=new Vector<Plato>();
		platasos.add(plato7);platasos.addElement(plato2);platasos.add(plato6);
		
		System.out.println("de tama�o :"+platasos.size());
		
		comedor1.agregarReserva(cliente3,platasos);
		Reserva reserva=new Reserva(cliente3,plato6);
		System.out.println("Valor de la Reserva: "+comedor1.valorReserva(reserva));
		reserva=new Reserva(cliente3,platasos);
		System.out.println("Valor de la Reserva: "+comedor1.valorReserva(reserva));
		System.out.println("Total de platos reservados "+comedor1.totalPlatosReservados());
		System.out.println("Total de $ en platos reservados "+comedor1.totalValorReservas());
		System.out.println(comedor1.reservaMasPlatos());
	}

}
