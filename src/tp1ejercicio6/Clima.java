package tp1ejercicio6;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Clima {
	private String ciudad,pais,provincia;
	private String condicion;
	private float temperaturaActual,temperaturaMinima,temperaturaMaxima;
	private Escala escala;	
	private float presion,viento;
	private Direccion direccionDelViento;
	private float humedad,visibilidad;
	private Date ultimaActualizacion;
	
	//METODOS 
	
	public Date formatearUnStringToDate (String strFecha) throws ParseException{
		SimpleDateFormat formateador = new SimpleDateFormat ("HH:mm");
		String strFecha1=strFecha;
		Date fecha=null;
		fecha=formateador.parse(strFecha1);
		System.out.println(formateador.format(fecha));
		return fecha;
	}	
	
	//Generadores 
	public Clima() {
		super();
	}
	//Este lo uso para pruebas rapidas y no tener que declarar todos los atributos a la hora de instanciarlos
	public Clima(float temperaturaActual, Date ultimaActualizacion) {
		super();
		this.temperaturaActual = temperaturaActual;
		this.ultimaActualizacion = ultimaActualizacion;
	}
	
	public Clima(String ciudad, String pais, String provincia, float temperaturaActual, float temperaturaMinima,
			float temperaturaMaxima, Escala escala, float presion, float viento, Direccion direccionDelViento,
			float humedad, float visibilidad, Date ultimaActualizacion) {
		super();
		this.ciudad = ciudad;
		this.pais = pais;
		this.provincia = provincia;
		this.temperaturaActual = temperaturaActual;
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
		this.escala = escala;
		this.presion = presion;
		this.viento = viento;
		this.direccionDelViento = direccionDelViento;
		this.humedad = humedad;
		this.visibilidad = visibilidad;
		this.ultimaActualizacion = ultimaActualizacion;
	}

	//Getters and setters

	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public float getTemperaturaActual() {
		return temperaturaActual;
	}

	public void setTemperaturaActual(float temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
	}

	public float getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(float temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public float getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(float temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public Escala getEscala() {
		return escala;
	}

	public void setEscala(Escala escala) {
		this.escala = escala;
	}

	public float getPresion() {
		return presion;
	}

	public void setPresion(float presion) {
		this.presion = presion;
	}

	public float getViento() {
		return viento;
	}

	public void setViento(float viento) {
		this.viento = viento;
	}

	public Direccion getDireccionDelViento() {
		return direccionDelViento;
	}

	public void setDireccionDelViento(Direccion direccionDelViento) {
		this.direccionDelViento = direccionDelViento;
	}

	public float getHumedad() {
		return humedad;
	}

	public void setHumedad(float humedad) {
		this.humedad = humedad;
	}

	public float getVisibilidad() {
		return visibilidad;
	}

	public void setVisibilidad(float visibilidad) {
		this.visibilidad = visibilidad;
	}

	public Date getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}
	public void setCondicion(String cond){
		this.condicion=cond;
	}
	public String getCondicion(){
		return this.condicion;
	}
	@Override
	public String toString() {
		return "Clima [ciudad=" + ciudad + ", temperaturaActual=" + temperaturaActual + ", ultimaActualizacion="
				+ ultimaActualizacion + "]";
	}
}
