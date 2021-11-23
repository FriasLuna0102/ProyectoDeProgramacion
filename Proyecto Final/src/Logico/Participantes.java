package Logico;

import java.util.ArrayList;

public class Participantes extends Personas {
	
	private String Matricula;
	private String institucionProveniente;
	private ArrayList<Trabajos> misTrabajos;
	private int edadParticipante;
	private String codigoDeEvento;

	public Participantes(String nombre, String direccion, String cedula, String apellido, String telefono,
			String correo, String matricula,String institucionesProvenientes,
			String codigo, String nombreTrabajo,String tema, int edadParticipante,String codigoDeEvento) {
		super(nombre, direccion, cedula, apellido, telefono, correo);
		this.Matricula = matricula;
		this.edadParticipante = edadParticipante;
		this.institucionProveniente = institucionesProvenientes;
		this.codigoDeEvento = codigoDeEvento;
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

	public int getEdadParticipante() {
		return edadParticipante;
	}

	public void setEdadParticipante(int edadParticipante) {
		this.edadParticipante = edadParticipante;
	}

	public String getCodigoDeEvento() {
		return codigoDeEvento;
	}

	public void setCodigoDeEvento(String codigoDeEvento) {
		this.codigoDeEvento = codigoDeEvento;
	}

	
} 
