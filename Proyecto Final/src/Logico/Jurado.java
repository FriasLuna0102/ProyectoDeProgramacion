package Logico;

public class Jurado extends Personas {
	
	private String areaDeConocimiento;
	private int a�oDeExperiencia;
	private String recomendacion;
	private String lugarDeRecomendacion;

	public Jurado(String nombre, String direccion, String cedula, String apellido, String telefono, String correo) {
		super(nombre, direccion, cedula, apellido, telefono, correo);
		
	
		this.areaDeConocimiento = areaDeConocimiento;
		this.a�oDeExperiencia = a�oDeExperiencia;
		this.recomendacion = recomendacion;
		this.lugarDeRecomendacion = lugarDeRecomendacion;
	}

}
