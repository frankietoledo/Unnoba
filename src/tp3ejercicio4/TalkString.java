package tp3ejercicio4;

public class TalkString {

	public static void main(String[] args) {
		Gato g=new Gato();
		hacerHablar(g);
		Perro p=new Perro();
		hacerHablar(p);
		RelojCucu c=new RelojCucu();
		hacerHablar(c);

	}

	public static void hacerHablar(Hablador objeto){
		objeto.hablar();
	}
}
