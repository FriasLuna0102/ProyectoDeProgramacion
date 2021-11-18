package Logico;

public class Jurado extends Personas {
	
	private String areaDeConocimiento;
	private int añoDeExperiencia;
	private String recomendacion;
	private String lugarDeRecomendacion;

	public Jurado(String nombre, String direccion, String cedula, String apellido, String telefono, String correo) {
		super(nombre, direccion, cedula, apellido, telefono, correo);
		
	
		this.areaDeConocimiento = areaDeConocimiento;
		this.añoDeExperiencia = añoDeExperiencia;
		this.recomendacion = recomendacion;
		this.lugarDeRecomendacion = lugarDeRecomendacion;
	}

}
