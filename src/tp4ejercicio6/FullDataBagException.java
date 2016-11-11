package tp4ejercicio6;

public class FullDataBagException extends Exception{
	@Override
	public String getMessage(){
		 return "La bolsa esta llena";
	}
}
