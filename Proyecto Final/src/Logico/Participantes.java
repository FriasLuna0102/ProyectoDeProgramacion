package Logico;

import java.util.ArrayList;

public class Participantes extends Personas {
	
	private String Matricula;
	private String institucionProveniente;
	private ArrayList<Trabajos> misTrabajos;

	public Participantes(String nombre, String direccion, String cedula, String apellido, String telefono,
			String correo, String matricula,String institucionesProvenientes,
			String codigo, String nombreTrabajo,String tema) {
		super(nombre, direccion, cedula, apellido, telefono, correo);
		this.Matricula = matricula;
		this.institucionProveniente = institucionesProvenientes;
		misTrabajos = new ArrayList<>();
		Trabajos trabajo = new Trabajos(codigo, nombreTrabajo, tema);
		misTrabajos.add(trabajo);
		
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
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
