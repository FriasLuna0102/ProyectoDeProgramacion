package Logico;

public class Trabajos {
	
	private String codigoDeTrabajo;
	private String nombre;
	private String tema;
	
	public Trabajos(String codigo, String nombre, String tema) {
		super();
		this.codigoDeTrabajo = codigo;
		this.nombre = nombre;
		this.tema = tema;
	}
	
	public String getCodigo() {
		return codigoDeTrabajo;
	}
	public void setCodigo(String codigo) {
		this.codigoDeTrabajo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}

} 

 