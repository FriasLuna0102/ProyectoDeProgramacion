package Logico;

public class Personas {
	
	protected String nombre;
	protected String direccion;
	protected String cedula;
	protected String apellido;
	protected String telefono;
	protected String correo;
	public Personas(String nombre, String direccion, String cedula, String apellido, String telefono, String correo) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.cedula = cedula;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
} 
