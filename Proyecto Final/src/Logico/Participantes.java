package Logico;

import java.util.ArrayList;

public class Participantes extends Personas {
	
	private String matricula;
	private String proyecto;
	private String institucionProveniente;
	private ArrayList<Trabajos> misTrabajos;

	public Participantes(String nombre, String direccion, String cedula, String apellido, String telefono,
			String correo) {
		super(nombre, direccion, cedula, apellido, telefono, correo);
		this.matricula = matricula;
		this.proyecto = proyecto;
		this.institucionProveniente = institucionProveniente;
		misTrabajos = new ArrayList<>();
		
	}

	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getInstitucionProveniente() {
		return institucionProveniente;
	}

	public void setInstitucionProveniente(String institucionProveniente) {
		this.institucionProveniente = institucionProveniente;
	}

	public ArrayList<Trabajos> getMisTrabajos() {
		return misTrabajos;
	}

	public void setMisTrabajos(ArrayList<Trabajos> misTrabajos) {
		this.misTrabajos = misTrabajos;
	}

	

}
