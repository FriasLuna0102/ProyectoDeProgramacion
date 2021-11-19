package Logico;

public class Comisiones {
	private String nombre;
	private String jurado;
	private String presidente;
	public Comisiones(String nombre, String jurado, String presidente) {
		super();
		this.nombre = nombre;
		this.jurado = jurado;
		this.presidente = presidente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getJurado() {
		return jurado;
	}
	public void setJurado(String jurado) {
		this.jurado = jurado;
	}
	public String getPresidente() {
		return presidente;
	}
	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}
	
}
