package tp4ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class ClassMain {

	public static void main(String[] args)throws FullDataBagException,EmptyDataBagException {
		List<Integer>listaEnteros =new ArrayList<Integer>();
		DataBag<Integer> d= new DataBag<Integer>(2,listaEnteros);
		d.add(1);
		d.add(12);
		d.add(32);
		
	}

}
