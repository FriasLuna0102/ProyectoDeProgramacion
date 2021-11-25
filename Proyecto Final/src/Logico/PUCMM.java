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

	//Funcion para agregar Comisiones al arreglo misComisiones. Verificado.
	public void addComisiones (Comisiones comision) {
		misComisiones.add(comision);
	}
	//Funcion para agregar Eventos al arreglo misEventos. Verificado.
	public void addEventos (Eventos event) {
		misEventos.add(event);
	}

	//Funcion para agregar persona al arreglo misPersonas. Verificado.
	public void addPersona(Personas person) {
		misPersonas.add(person);
	}


	//Funcion para agregar participante al evento correspondiente. Verificado
	public void addParticipante(String codigoDeEvento, Participantes participantes) {
		Eventos event = buscarEvento(codigoDeEvento);

		if(event != null) {
			event.getMisParticipantes().add(participantes);
			generadorDeCodigo++;
		}

	}

	public int getGeneradorCodigoVino() {//vino?
		return generadorDeCodigo;
	}

	//Funcion para buscar las personas del evento mediante la cedula. Verificada
	public Personas buscarPersonas(String cedula) {
		Personas persona = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<misPersonas.size()) {
			if(misPersonas.get(i).getCedula().equalsIgnoreCase(cedula)) {
				encontrado = true;
				persona = misPersonas.get(i);
			}
		}
		return persona;
	}
	//Funcion para ver disponibilidad del tipo de recurso. Verificada.
	public boolean disponibilidadRecursos(String tipoDeRecursos, boolean disponibilidad) {
		boolean dispon = false;
		Recursos recursos = buscarRecursos(tipoDeRecursos);
		if (recursos != null && disponibilidad != false) {
			dispon = true;

		}	
		return dispon;

	}
	//Metodo para buscar tipos de recursos. Verificada.
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

	//Metodo para buscar los tipos de personas, participantes y jurados maximo  3. Verificada.
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

	//Metodo para saber la cantidad de trabajos registrado por los participantes. Verificada
	public int cantDeTrabajosActivos() {
		int cant = 0;
		if(misTrabajos.size() != 0) {
			cant = misTrabajos.size();
		}	
		return cant;	
	}
	//Metodo para buscar los trabajos de los participantes. Verificado
	public Trabajos buscarTrabajosRegistrados(String codigoDeTrabajo) {
		boolean encontrado = false;
		int i = 0;
		Trabajos trabajo = null;
		while(!encontrado && i < misTrabajos.size()) {
			if(misTrabajos.get(i).getCodigo().equalsIgnoreCase(codigoDeTrabajo)) {
				encontrado = true;
				trabajo = misTrabajos.get(i);		
			}
			
		}		
		return trabajo;
	}
	
	//Metodo para ver si se cumplen los requisitos del evento en cuanto a participantes, ver si cumplen el limite y el maximo. Verificado
	public void verificarSiEventoSePuedeIniciarPorParticipantess(int maxDeParticipantes,int minParticipantes,String codigoDeEvento) {
		Eventos evento = buscarEvento(codigoDeEvento);
		int cantParticipantes = evento.getMisParticipantes().size();
		if(cantParticipantes > maxDeParticipantes) {
			System.out.println("Maximo de participantes superados. El maximo es:"+maxDeParticipantes+". Cantidad de Participantes registrados es: "+cantParticipantes);
		}else if(cantParticipantes <= maxDeParticipantes && cantParticipantes >= minParticipantes) {
			System.out.println("Participantes registrados:"+cantParticipantes+".\n"+"Evento se puede iniciar.");
		}else {
			System.out.println("Evento aun no se puede iniciar, participantes insuficientes.");
		}
	}


	//Metodo para regular el limite de trabajos permitidos en el evento ya que un participante puede tener varios trabajo. Verificado
	//Ojo se podria hacer una funcion con limite de trabajos por participantes
	public String limiteDeTrabajosAceptados(int lim, int cant) {
		String Aceptado = "";
		int cantDeTrabajos = cantDeTrabajosActivos();
		if(cantDeTrabajos > lim) {
			Aceptado = "Se ha sobrepasado el limite de trabajos permitidos en el evento. El limite es:"+lim+" y la cantidad de trabajo que hay es:"+cant;
		}else {
			Aceptado = "Todo correcto.";
		}
		return Aceptado;
	}
	
	//Metodo para buscar evento creados. Verificada
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
	
	//Metodo para buscar comisiones. Verificada
	public Comisiones buscarComisiones (String nombreDeComision) {
		boolean encontrado = false;
		int i = 0;
		Comisiones comision = null;
		while(!encontrado & i<misComisiones.size()) {
			if(misComisiones.get(i).getNombreDeComision().equalsIgnoreCase(nombreDeComision)) {
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
	
	
	//Funcion #1 para buscar Participantes. Verificada
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
		Trabajos trabajo = buscarTrabajosRegistrados(codigoDeTrabajos);
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

	//Metodo para calificar los trabajos de los participantes. Verificada
	public String calificarTrabajos(String codigoDeTrabajo, String codigoDeEvento,int calificacionDeJurados) {
		Trabajos trabajo = buscarTrabajosRegistrados(codigoDeTrabajo);
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

	//Funcion para determinar si el participante cumple con la edad requerida del evento. Verificada
	public boolean edadDeParticipantePermitida(String codigoEvento, String cedula, int edadMinima, int edadMaxima) {
		boolean permitido = false;
		Eventos evento = buscarEvento(codigoEvento);
		Participantes participante = buscarParticipantes(codigoEvento, cedula);
		if(participante != null && evento != null) {
			if(participante.getEdadParticipante() <= edadMaxima && participante.getEdadParticipante() >= edadMinima) {
				permitido = true;
			}else {
				permitido = false;
			}
		}
		return permitido;
		
	}

}


