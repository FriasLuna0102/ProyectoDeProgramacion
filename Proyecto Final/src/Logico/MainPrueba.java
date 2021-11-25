package Logico;

public class MainPrueba {

	public static void main(String[] args) {
		Jurado jurado = new Jurado("ds", "ds", "ds", "ds", "ds", "ds", "ds", 56, "ds", "ds");
		Jurado jurado2 = new Jurado("ds", "ds", "ds", "ds", "ds", "ds", "ds", 56, "ds", "ds");
		Jurado jurado3 = new Jurado("ds", "ds", "ds", "ds", "ds", "ds", "ds", 56, "ds", "ds");
		Jurado jurado4 = new Jurado("ds", "ds", "ds", "ds", "ds", "ds", "ds", 56, "ds", "ds");

		PUCMM.getInstance().addPersona(jurado);
		PUCMM.getInstance().addPersona(jurado2);
		PUCMM.getInstance().addPersona(jurado3);

		


		Comisiones comision = new Comisiones("Fisica", "Miguel", "Antonio");
		Trabajos trabajo = new Trabajos("8080", "Quimica", "Los medios");
		Recursos recurso = new Recursos(81, true, "salones",25);
		Eventos evento = new Eventos("Cientifico", comision, recurso, "9090", "San pedro", 25, ".com", 5, "Cientifico");
		Participantes participante = new Participantes("Angel", "6 de junio", "00000011111", "Luna", "8025455", ".cpm", "0001", "Fausto", "0001", "0001", "0001", 25, "9090");
		PUCMM.getInstance().addParticipante("9090", participante);
		PUCMM.getInstance().getMisTrabajos().add(trabajo);
		PUCMM.getInstance().getMisRecursos().add(recurso);
		PUCMM.getInstance().addEventos(evento);
		evento.getMisParticipantes().add(participante);
		PUCMM.getInstance().addComisiones(comision);
		
		System.out.print(PUCMM.getInstance().edadDeParticipantePermitida( "9090", "00000011111", 18, 25));
		
	}
}


