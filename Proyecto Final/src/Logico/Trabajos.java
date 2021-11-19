package Logico;

public class Trabajos {
	
	private String codigo;
	private String nombre;
	private String tema;
	
	public Trabajos(String codigo, String nombre, String tema) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tema = tema;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

 