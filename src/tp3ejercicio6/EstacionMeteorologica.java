package tp3ejercicio6;
import java.util.ArrayList;
import java.util.Collections;
//import java.text.SimpleDateFormat;//BORRAR
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.github.fedy2.weather.data.Channel;

import ar.edu.unnoba.WeatherService;
import ar.edu.unnoba.util.City;
import sun.awt.image.ImageRepresentation;
import sun.util.locale.UnicodeLocaleExtension;
import tp1ejercicio6.Clima;
import tp1ejercicio6.Direccion;
import tp1ejercicio6.Escala;
public class EstacionMeteorologica extends Observable implements Observer {
	// ############ ATRIBUTOS ##################################
	//
	private Clima climaActual;
	private String ciudad;
	private boolean estadoServ=false;
	private List <Clima> historial = new ArrayList <Clima> ();
	private static WeatherService servicio = new WeatherService(City.Pergamino, 1);
		
	//Metodos
	public String getCiudad(){
		return this.ciudad;
	}
	public Clima climaActual(){
		return climaActual;
	}
	public void remover (Clima unClima){
		historial.remove(unClima);
	}
	public void agregar (Clima unClima){
		if (historial.isEmpty()){
			historial.add(unClima);
			climaActual=historial.get(0);
		}else{
			historial.add(climaActual);
			climaActual=unClima;
		}
	}
	public void agregar (Channel channel){
		Clima unClima = new Clima ();
		unClima.setViento(channel.getWind().getSpeed());
		unClima.setCiudad(channel.getLocation().getCity());
		unClima.setPais(channel.getLocation().getCountry());
		unClima.setProvincia(channel.getLocation().getRegion()); //posible error?
		unClima.setTemperaturaActual(channel.getItem().getCondition().getTemp());
		unClima.setEscala(Escala.Centigrados);
		unClima.setPresion(channel.getAtmosphere().getPressure());
		
		//Con lo siguiente se setea la direccion del viento del numero recibido por el servicio
		Integer direccion=channel.getWind().getDirection();
		if (direccion<45){
			unClima.setDireccionDelViento(Direccion.Este);
		}else if (direccion > 45 && direccion < 135){
			unClima.setDireccionDelViento(Direccion.Norte);
		}else if (direccion >135 && direccion < 225){
			unClima.setDireccionDelViento(Direccion.Oeste);
		}else if (direccion >225 && direccion < 315){
			unClima.setDireccionDelViento(Direccion.Sur);
		}else{
			unClima.setDireccionDelViento(Direccion.Este);
		}
		unClima.setHumedad(channel.getAtmosphere().getHumidity());
		unClima.setVisibilidad(channel.getAtmosphere().getVisibility());
		unClima.setUltimaActualizacion(channel.getLastBuildDate());
		unClima.setTemperaturaMaxima(channel.getItem().getForecasts().get(0).getHigh());
		unClima.setTemperaturaMinima(channel.getItem().getForecasts().get(0).getLow());
		unClima.setCondicion(channel.getItem().getCondition().getText());
		agregar(unClima);
	}
	public List<Clima> getClimas(){
		return historial;
	}
	public boolean getEstadoServicio(){
		return estadoServ;
	}
	/////////// INICIAR SERVICIO //////////////////////////////
	public void iniciarServicio(){
		estadoServ=true;
		WeatherService servicio = new WeatherService(City.Pergamino,5);
		servicio.addObserver(this);
		servicio.start();
	}
	public void pararServicio(){
		estadoServ=false;
		servicio.stop();
		servicio.deleteObserver(this);
	}
	///////////////// BLOQUE ///////////////////////////
	//ordenar por fecha y temp
	public void ordenaPorTemperatura(){
		List<Clima> copia=new ArrayList<Clima>(historial);
		Collections.sort(copia,new CompararPorTemperatura());
		historial.clear();
		historial=new ArrayList<Clima>(copia);
	}
	public void ordenarPorHora(){
		ArrayList<Clima> copia=new ArrayList<Clima> (historial);
		Collections.sort(copia,new CompararPorHora());
		historial.clear();
		historial=new ArrayList<Clima>(copia);
	}
	//Constructores
	public EstacionMeteorologica(String ciudad,Clima unClima) {
		super();
		this.ciudad = ciudad;
		this.climaActual=unClima;
	}
	public EstacionMeteorologica() {
		super();
		if (historial.isEmpty()){
		}
	}
	public void imprimirArray(){
		for (Clima c:historial){
			System.out.println(c);
		}
	}
	
	@Override
	public void update(Observable weather, Object param) {
		Channel channel = ((WeatherService)weather).getChannel();
		agregar(channel);
		setChanged();
		notifyObservers(climaActual);
		//System.out.println(channel.getItem().getCondition().getText());
		/*Channel posee toda la informcion necesaria*/		
	}
}