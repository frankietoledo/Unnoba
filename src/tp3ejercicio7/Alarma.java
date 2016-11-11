package tp3ejercicio7;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;

public class Alarma implements Observer {
	private List<Sensor> sensores = new ArrayList<Sensor>();
	private List<Sensor> historiales = new ArrayList<Sensor>();
	
	public void addSensor(Sensor s){
		sensores.add(s);
	}
	public void desactivar(){
		for(Sensor s:sensores){
		//	s.desactivar();
		}
	}
	/*public void update(Observable o, Observer ob){
		Sensor s=(Sensor);
		historiales.add(new Historial(s.GregorianCalendar.getInstance().getTime()));
		s.activar();
		
	}*/
	
	public void main(String[]args){
		Alarma a=new Alarma();	
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
