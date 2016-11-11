package tp3ejercicio6;
import java.util.Comparator;

import tp1ejercicio6.*;
public class CompararPorHora implements Comparator<Clima>{

	@Override
	public int compare(Clima o1, Clima o2) {
		return o1.getUltimaActualizacion().compareTo(o2.getUltimaActualizacion());
	}

}
