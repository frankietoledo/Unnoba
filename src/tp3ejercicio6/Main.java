package tp3ejercicio6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import tp1ejercicio6.Clima;

public class Main {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formateador = new SimpleDateFormat ("HH:mm");
		Date h=formateador.parse("12:33"); 
		Date h1=formateador.parse("09:12");
		Date h2=formateador.parse("18:32");
		Date h3=formateador.parse("02:44");
		Date h4=formateador.parse("17:01");
		Date h5=formateador.parse("22:01");
		EstacionMeteorologica estacion=new EstacionMeteorologica("Pergamino",new Clima(99,GregorianCalendar.getInstance().getTime()));
		estacion.agregar(new Clima(99,h));
		estacion.agregar(new Clima (4,h4));
		estacion.agregar(new Clima (35,h3));
		estacion.agregar(new Clima (64,h1));
		estacion.agregar(new Clima (73,h2));
		estacion.agregar(new Clima (38,h5));
		estacion.imprimirArray();
		System.out.println("Entra a ordenar por hora");
		estacion.ordenarPorHora();
		System.out.println("Ahora por temperatura");
		estacion.ordenaPorTemperatura();
	}
}
