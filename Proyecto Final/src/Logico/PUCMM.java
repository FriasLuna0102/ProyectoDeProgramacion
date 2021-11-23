package Logico;

import java.util.ArrayList;



public class PUCMM {
	private ArrayList<Personas> misPersonas;
	private ArrayList<Trabajos> misTrabajos;
	private ArrayList<Recursos> misRecursos;
	private ArrayList<Eventos> misEventos;
	private ArrayList<Comisiones> misComisiones;
	public static PUCMM alma = null;
	private int generadorDeCodigo;
	public static int cant = 0;


	private PUCMM() {
		super();
		misPersonas = new ArrayList<>();
		misTrabajos = new ArrayList<>();
		misRecursos = new ArrayList<>();
		misEventos = new ArrayList<>();
		misComisiones = new ArrayList<>();
		generadorDeCodigo = 1;

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


	//Funcion para agregar participante al evento correspondiente.
	public void addParticipante(String codigoDeEvento, Participantes participantes) {
		Eventos event = buscarEvento(codigoDeEvento);

		if(event != null) {
			event.getMisParticipantes().add(participantes);
			generadorDeCodigo++;
		}

	}

	public int getGeneradorCodigoVino() {
		return generadorDeCodigo;
	}

	//Funcion para buscar las personas del evento mediante la cedula.
	public Personas buscarPersonas(String cedula) {
		Personas persona = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<misPersonas.size()) {
			if(misPersonas.get(i).getCedula().equalsIgnoreCase(cedula)) {
				encontrado = false;
				persona = misPersonas.get(i);
			}
		}
		return persona;
	}

	public boolean disponibilidadRecursos(String recurse) {
		boolean dispon = false;
		Recursos recursos = buscarRecursos(recurse);
		if (recursos != null) {
			dispon = true;

		}	
		return dispon;

	}
	//Metodo para buscar tipos de recursos.
	public Recursos buscarRecursos(String tipoDeRecursos) {
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

	//Metodo para buscar los tipos de personas, participantes y jurados maximo  3.
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
	//Metodo para buscar personas mediante la cedula.
	public Personas getPersonasCodigo(String cedula) {
		Personas personas = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < misPersonas.size()) {
			if(misPersonas.get(i).getCedula().equalsIgnoreCase(cedula)) {
				personas = misPersonas.get(i);
				encontrado = true;
			}
		}
		return personas;
	}
	//Metodo para saber la cantidad de trabajos registrado por los participantes.
	public int cantDeTrabajosActivos(String codigoDeTrabajo) {
		int cant = 0;
		Trabajos trabajo = buscarTrabajosPresentados(codigoDeTrabajo);
		if(trabajo != null) {
			cant++;		
		}	
		return cant;	
	}
	//Metodo para buscar los trabajos de los participantes.
	public Trabajos buscarTrabajosPresentados(String codigoDeTrabajo) {
		boolean encontrado = false;
		int i = 0;
		Trabajos trabajo = null;
		while(!encontrado && i < misTrabajos.size()) {
			if(misTrabajos.get(i).getCodigo().equalsIgnoreCase(codigoDeTrabajo)) {
				encontrado = true;
				trabajo = misTrabajos.get(i);			}
		}		
		return trabajo;
	}
	//Metodo para ver si se cumplen los requisitos del evento en cuanto a participantes, ver si cumplen el limite y el maximo.
	public boolean verificarSiEventoSePuedeIniciarPorParticipantes(int maxDeParticipantes,int minParticipantes) {
		boolean iniciar = false;
		int [] cantParticipantes = new int [2];
		for (Personas aux : misPersonas) {
			if(aux instanceof Participantes) {
				cantParticipantes[0]+=1;
				if(cantParticipantes[0] > maxDeParticipantes ) {
					System.out.println("Maximo de participantes superados.");
				}else if(cantParticipantes[0]<=maxDeParticipantes && cantParticipantes[0] >= minParticipantes) {
					System.out.println("Participantes registrados:"+cantParticipantes+".\n"+"Evento se puede iniciar.");
				}else if(cantParticipantes[0] < minParticipantes) {
					System.out.println("Evento aun no se puede iniciar, participantes insuficientes.");
				}
			}

		}
		return iniciar;		
	}

	//Metodo para regular el limite de trabajos permitidos en el evento.
	public String limiteDeTrabajosAceptados(int lim,String codigoDeTrabajo) {
		String Aceptado = "";
		int cantDeTrabajos = cantDeTrabajosActivos(codigoDeTrabajo);
		if(cantDeTrabajos > lim) {
			Aceptado = "Se ha sobrepasado el limite de trabajos permitidos en el evento.";
		}
		return Aceptado;
	}

	//Metodo para comprobar si a la comision se le han atribuido los jurados.
	public boolean VerSiLosjuradosEstanAsignados(String nombreDeComision) {
		boolean juradoAsignados = false;
		Comisiones comision = null;
		comision = buscarComisiones(nombreDeComision);
		if(comision != null) {
			int [] cantJurados = new int [2];
			for (Personas aux : misPersonas) {
				if(aux instanceof Jurado) {
					cantJurados[0] += 1;
					if(cantJurados[0] == 3) {
						juradoAsignados = true;

					}else {
						juradoAsignados = false;
					}
				}
			}
		}
		return juradoAsignados;

	}

	//Metodo para asignar un Jurado a presidente.
	public String asignarPresidenteAEvento(String nombreDeComision, String Jurado) {
		Comisiones comision = buscarComisiones(nombreDeComision);
		String presi = "";
		if(comision != null) {
			for (Personas aux : misPersonas) {
				int [] presidente = new int [2];
				if(aux instanceof Jurado) {
					presidente [0] = 1;
					presi = "Se ha asignado un presidente a la comision con nombre:"+nombreDeComision;		
				}
			}
		}
		return presi;
	}

	//Metodo para buscar evento creados.
	public Eventos buscarEvento(String codigoDelEvento) {
		Eventos evento = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < misEventos.size()) {
			if(misEventos.get(i).getCodigoDeEvento().equalsIgnoreCase(codigoDelEvento)) {
				encontrado = true;
				evento = misEventos.get(i);
			}
		}	
		return evento;
	}
	//Metodo para buscar comisiones.
	public Comisiones buscarComisiones (String nombreDeComision) {
		boolean encontrado = false;
		int i = 0;
		Comisiones comision = null;
		while(!encontrado & i<misComisiones.size()) {
			if(misComisiones.get(i).getNombre().equalsIgnoreCase(nombreDeComision)) {
				encontrado = true;
				comision = misComisiones.get(i);
			}
		}
		return comision;
	}

	//Metodo para buscar Jurado.
	public Jurado buscarJurado(	String cedula) {
		Jurado jurado = null;
		for (Personas aux : misPersonas) {
			if(aux instanceof Jurado) {
				if(aux.getCedula().equalsIgnoreCase(cedula)) {
					jurado = (Jurado) aux;		
				}
			}		
		}
		return jurado;
	}

	//Funcion #1 para buscar Participantes.
	public Participantes buscarParticipantes(String eventoCodigo, String cedula) {
		Eventos evento = buscarEvento(eventoCodigo);
		Participantes participante = null;
		int i = 0;
		boolean encontrado = false;
		if(evento != null) {
			while(!encontrado && i<evento.getMisParticipantes().size()) {
				if(evento.getMisParticipantes().get(i).getCedula().equalsIgnoreCase(cedula)) {
					encontrado = true;
					participante = evento.getMisParticipantes().get(i);
				}
			}
		}
		return participante;
	}
	/*
	//Funcion #2 para buscar Participantes.
	public Participantes bucarParticipantes(String cedula) {
		Participantes participantee = null;
		int [] i = new int [2];
		for (Personas aux : misPersonas) {
			if(aux instanceof Participantes) {
				if(aux.getCedula().equalsIgnoreCase(cedula)) {
					i[0] += 1;
					participantee = (Participantes) aux; 
				}			
			}
		}
		return participantee;
	}*/

	//Metodo para buscar los jurados mediante el area de conocimiento que estos tienen.
	public Jurado buscarJuradoPorAreaDeConocimiento(String areaDeConocimiento) {
		Jurado jurado = null;
		for (Personas aux : misPersonas) {
			if(aux instanceof Jurado) {
				if(((Jurado) aux).getAreaDeConocimiento().equalsIgnoreCase(areaDeConocimiento)) {
					jurado = (Jurado) aux;
				}else {
					System.out.println("No se encontro ningun Jurado de esta area.");

				}
			}
		}
		return jurado;		
	}

	//Metodo para buscar al participante con mejor trabajo presentado en el Evento que se deese saber.
	public Participantes premioAlMejorParticipante(String codigoDeTrabajos,String codigoDeEvento) {
		Participantes participante = null;
		Eventos evento = buscarEvento(codigoDeEvento);
		Trabajos trabajo = buscarTrabajosPresentados(codigoDeTrabajos);
		int i = 0;
		if(evento != null && trabajo != null) {
			for (Personas personas : misPersonas) {
				if(personas instanceof Participantes) {
					if(((Participantes) personas).getMisTrabajos().equals(codigoDeTrabajos)) {
						participante = (Participantes) personas;

					}
				}
			}
		}
		return participante;
	}

	//Metodo para calificar los trabajos de los participantes
	public String calificarTrabajos(String codigoDeTrabajo, String codigoDeEvento,int calificacionDeJurados) {
		Trabajos trabajo = buscarTrabajosPresentados(codigoDeTrabajo);
		Eventos event = buscarEvento(codigoDeEvento);
		String calificacion = "";
		if(trabajo != null && event != null) {
			if(calificacionDeJurados >= 90 && calificacionDeJurados <= 100) {
				calificacion = "A";
			}else if (calificacionDeJurados < 90 && calificacionDeJurados >= 80) {
				calificacion = "B";
			}else if (calificacionDeJurados < 80 && calificacionDeJurados >= 70) {
				calificacion = "C";
			}else if (calificacionDeJurados < 70 && calificacionDeJurados >= 60) {
				calificacion = "D";
			}else {
				calificacion = "F";
			}
		}
		return calificacion;		
	}

	//Funcion para determinar si el participante cumple con la edad requerida del evento.
	private boolean edadDeParticipantePermitida(Participantes p1, int edadMinima, int edadMaxima) {
		boolean permitido = false;
		Participantes participante = null;
		for (Personas aux : misPersonas) {
			if(aux instanceof Participantes) {
				participante = (Participantes) aux;
				if(participante.getEdadParticipante() <= edadMaxima && participante.getEdadParticipante() >= edadMinima ) {
					permitido = true;
				}else {
					permitido = false;
				}
			}
		}
		return permitido;

	}

}


