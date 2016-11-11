package tp4ejercicio1;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;


public class RandomSelector<T>{
	private List<T> lista=new ArrayList<T>();
	Random r= new Random();
	
	public void add(T objeto){
		lista.add(objeto);
	}
	public T selectNext(){
		return lista.get(r.nextInt(lista.size()));
	}
	
	
}
