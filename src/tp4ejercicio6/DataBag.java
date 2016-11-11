package tp4ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class DataBag <T>{
	
	//ATRIBUTOS
	private int maximoElemento;
	private List<T> objetos=new ArrayList<T>();

	DataBag(int maximoElemento, List<T> objetos) {
		super();
		this.maximoElemento = maximoElemento;
		this.objetos = objetos;
	}

	public void add(T unDato) throws FullDataBagException{
		 if(objetos.size()==maximoElemento){
			  throw new FullDataBagException(); //faltaba el throw para que lo arroje a la nueva exception
		 }
		 else {
			 objetos.add(unDato);
		 }
	}
	
	public void remove()throws EmptyDataBagException{
		if(objetos.isEmpty()){
			throw new EmptyDataBagException();
		}
		else{
			objetos.remove(objetos.size());
		}
	}
	public void elementos(){
		for(T t:objetos){
			System.out.println(t);
		}
	}


}
