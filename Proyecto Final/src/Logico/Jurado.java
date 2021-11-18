package Logico;

public class Jurado extends Personas {
	
	private String areaDeConocimiento;
	private int a�oDeExperiencia;
	private String recomendacion;
	private String lugarDeRecomendacion;

	public Jurado(String nombre, String direccion, String cedula, String apellido, String telefono, String correo, 
			String areaDeConocimiento, int a�oDeExperiencia, String recomendacion, String lugarDeRecomendacion) {
		super(nombre, direccion, cedula, apellido, telefono, correo);
		
	
		this.areaDeConocimiento = areaDeConocimiento;
		this.a�oDeExperiencia = a�oDeExperiencia;
		this.recomendacion = recomendacion;
		this.lugarDeRecomendacion = lugarDeRecomendacion;
	}

	public String getAreaDeConocimiento() {
		return areaDeConocimiento;
	}

	public void setAreaDeConocimiento(String areaDeConocimiento) {
		this.areaDeConocimiento = areaDeConocimiento;
	}

	public int getA�oDeExperiencia() {
		return a�oDeExperiencia;
	}

	public void setA�oDeExperiencia(int a�oDeExperiencia) {
		this.a�oDeExperiencia = a�oDeExperiencia;
	}

	public String getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}

	public String getLugarDeRecomendacion() {
		return lugarDeRecomendacion;
	}

	public void setLugarDeRecomendacion(String lugarDeRecomendacion) {
		this.lugarDeRecomendacion = lugarDeRecomendacion;
	}

}
