package Logico;

public class MainPrueba {

	public static void main(String[] args) {
		Jurado jurado = new Jurado("ds", "ds", "5050", "ds", "ds", "ds", "mma", 56, "ds", "ds");
		

		PUCMM.getInstance().addPersona(jurado);
		
		


		Comisiones comision = new Comisiones("Fisica", "Miguel", "Antonio");
		Trabajos trabajo = new Trabajos("8989", "Quimica", "Los medios");
		Trabajos trabaje = new Trabajos("8989", "Quimica", "Los medios");

		Trabajos trabajso = new Trabajos("25", "Quimica", "Los medios");
 
		Recursos recurso = new Recursos(81, true, "salones",25);
		//Eventos evento = new Eventos("Cientifico", comision, recurso, "9090", "San pedro", 25, ".com", 5, "Cientifico","Fisica",89);
		//Participantes participante = new Participantes("Angel", "6 de junio", "00000011111", "Luna", "8025455", ".cpm", "0001", "Fausto", "0001", "0001", "0001", 25, "9091");
		//Participantes participantee = new Participantes("Angel", "6 de junio", "00000011111", "Luna", "8025455", ".cpm", "0001", "Fausto", "0001", "0001", "0001", 25, "5858");
		//evento.getMisParticipantes().add(participantee);
		//PUCMM.getInstance().addEventos(evento);
	//	PUCMM.getInstance().addParticipante("9090", participantee);
		
		
		

		PUCMM.getInstance().getMisRecursos().add(recurso);
		
	
		PUCMM.getInstance().addComisiones(comision);
		PUCMM.getInstance().addJurado("9090",jurado);
		PUCMM.getInstance().getMisTrabajos().add(trabajo);
		PUCMM.getInstance().calificarTrabajos("8989", "9090", 60);

	}
}


