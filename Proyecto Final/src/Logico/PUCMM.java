package Logico;

import java.util.ArrayList;

public class PUCMM {
	 private ArrayList<Personas> misPersonas;
	 private ArrayList<Trabajos> misTrabajos;
	 private ArrayList<Recursos> misRecursos;
	 private ArrayList<Eventos> misEventos;
	 public static PUCMM alma = null;
	 
	 private PUCMM() {
		 super();
		 misPersonas = new ArrayList<>();
		 misTrabajos = new ArrayList<>();
		 misRecursos = new ArrayList<>();
		 misEventos = new ArrayList<>();
		 
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

}
