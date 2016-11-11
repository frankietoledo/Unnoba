package tp3ejercicio6;

import java.util.Comparator;
import tp1ejercicio6.*;
public class CompararPorTemperatura implements Comparator<Clima>{

	@Override
	public int compare(Clima o1, Clima o2) {
		return (int)o1.getTemperaturaActual()-(int)o2.getTemperaturaActual();
	}

}
