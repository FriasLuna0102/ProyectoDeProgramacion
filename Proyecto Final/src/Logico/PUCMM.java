package Logico;

import java.util.ArrayList;

public class PUCMM {
	private ArrayList<Personas> misPersonas;
	private ArrayList<Trabajos> misTrabajos;
	private ArrayList<Recursos> misRecursos;
	private ArrayList<Eventos> misEventos;
	private ArrayList<Comisiones> misComisiones;
	public static PUCMM alma = null;

	private PUCMM() {
		super();
		misPersonas = new ArrayList<>();
		misTrabajos = new ArrayList<>();
		misRecursos = new ArrayList<>();
		misEventos = new ArrayList<>();
		misComisiones = new ArrayList<>();

	}
	public static PUCMM getInstance() {
		if(alma == null) {
			alma = new PUCMM();
		}
		return alma;
	}
	public ArrayList<Personas> getMisPersonas() {
		return misPersonas;
	}
	public void setMisPersonas(ArrayList<Personas> misPersonas) {
		this.misPersonas = misPersonas;
	}
	public ArrayList<Trabajos> getMisTrabajos() {
		return misTrabajos;
	}
	public void setMisTrabajos(ArrayList<Trabajos> misTrabajos) {
		this.misTrabajos = misTrabajos;
	}
	public ArrayList<Recursos> getMisRecursos() {
		return misRecursos;
	}
	public void setMisRecursos(ArrayList<Recursos> misRecursos) {
		this.misRecursos = misRecursos;
	}
	public ArrayList<Eventos> getMisEventos() {
		return misEventos;
	}
	public void setMisEventos(ArrayList<Eventos> misEventos) {
		this.misEventos = misEventos;
	}
	public ArrayList<Comisiones> getMisComisiones() {
		return misComisiones;
	}
	public void setMisComisiones(ArrayList<Comisiones> misComisiones) {
		this.misComisiones = misComisiones;
	}

	public void addEventos (Eventos event) {
		misEventos.add(event);
	}

	public void addPersona(Personas person) {
		misPersonas.add(person);
	}
	
	public boolean disponibilidadRecursos(String recurse) {
		boolean dispon = false;
		Recursos recursos = buscarRecursos(recurse);
		if (recursos != null) {
			dispon = true;
			
		}	
		return dispon;
		
	}
	private Recursos buscarRecursos(String tipoDeRecursos) {
		boolean encontrado = false;
		int i = 0;
		Recursos recursos = null;
		while(!encontrado && i < misRecursos.size()) {
			if(misRecursos.get(i).getTipoDeRecurso().equalsIgnoreCase(tipoDeRecursos)) {
				encontrado = true;
				recursos = misRecursos.get(i);			
			}
		}	
		return recursos;
	}
	
	
	public int [] cantTipoDePersonas() {
		int [] cantByTipo = new int [2];
		for (Personas aux : misPersonas) {
			if(aux instanceof Participantes) {
				cantByTipo[0]+=1;
			}	
			if(aux instanceof Jurado) {
				cantByTipo[1]+=1;
				if(cantByTipo[1] > 3) {
					System.out.print("Solo pueden ser 3 Jurados.");
				}
			}
		}
		return cantByTipo;

	}	
	
	

} 
