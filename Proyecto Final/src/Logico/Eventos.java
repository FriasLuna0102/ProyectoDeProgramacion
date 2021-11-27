package Logico;

import java.util.ArrayList;
import java.util.Date;

public class Eventos {

	private int limiteDeParticipantes;
	private String tituloDeEvento;
	private ArrayList<Participantes> misParticipantes;
	private ArrayList<Trabajos> misTrabajos;
	private ArrayList<Jurado> misJurados;
	private Comisiones comision;
	private Recursos recursoUtilizados;
	private String codigoDeEvento;
	private int fechaDeInicio;
	private int fechaDeCierre;
	private String lugarDeEvento;
	private Date fechaLimiteDeEntregaDeTrabajos;
	private int horaDeEvento;
	private String correoDeEvento;
	private String tipoDeEvento;
	private String nombreDeComision;
	public Eventos(String tituloDeEvento, Comisiones comision, Recursos recursoUtilizados, String codigoDeEvento,
			String lugarDeEvento, int fechaDeInicio, String correoDeEvento, int limiteDeParticipantes,String tipoDeEvento,String nombreDeComision, int fechaDeCierre) {
		super();
		this.tituloDeEvento = tituloDeEvento;
		this.comision = comision;
		this.recursoUtilizados = recursoUtilizados;
		this.codigoDeEvento = codigoDeEvento;
		this.lugarDeEvento = lugarDeEvento;
		this.fechaDeInicio = fechaDeInicio;
		this.correoDeEvento = correoDeEvento;
		this.limiteDeParticipantes = limiteDeParticipantes;
		misParticipantes = new ArrayList<>();
		misTrabajos = new ArrayList<>();
		misJurados = new ArrayList<>();
		this.fechaLimiteDeEntregaDeTrabajos = new Date();
		this.tipoDeEvento = tipoDeEvento;
		this.nombreDeComision = nombreDeComision;
		this.fechaDeCierre = fechaDeCierre;

	}

	public String getTituloDeEvento() {
		return tituloDeEvento;
	}
	public void setTituloDeEvento(String tituloDeEvento) {
		this.tituloDeEvento = tituloDeEvento;
	}
	public ArrayList<Participantes> getMisParticipantes() {
		return misParticipantes;
	}
	public void setMisParticipantes(ArrayList<Participantes> misParticipantes) {
		this.misParticipantes = misParticipantes;
	}
	public ArrayList<Trabajos> getMisTrabajos() {
		return misTrabajos;
	}
	public void setMisTrabajos(ArrayList<Trabajos> misTrabajos) {
		this.misTrabajos = misTrabajos;
	}
	public ArrayList<Jurado> getMisJurados() {
		return misJurados;
	}
	public void setMisJurados(ArrayList<Jurado> misJurados) {
		this.misJurados = misJurados;
	}
	public Comisiones getComision() {
		return comision;
	}
	public void setComision(Comisiones comision) {
		this.comision = comision;
	}
	public Recursos getRecursoUtilizados() {
		return recursoUtilizados;
	}
	public void setRecursoUtilizados(Recursos recursoUtilizados) {
		this.recursoUtilizados = recursoUtilizados;
	}
	public String getCodigoDeEvento() {
		return codigoDeEvento;
	}
	public void setCodigoDeEvento(String codigoDeEvento) {
		this.codigoDeEvento = codigoDeEvento;
	}
	
	public String getLugarDeEvento() {
		return lugarDeEvento;
	}
	public void setLugarDeEvento(String lugarDeEvento) {
		this.lugarDeEvento = lugarDeEvento;
	}
	public Date getFechaLimiteDeEntregaDeTrabajos() {
		return fechaLimiteDeEntregaDeTrabajos;
	}
	public void setFechaLimiteDeEntregaDeTrabajos(Date fechaLimiteDeEntregaDeTrabajos) {
		this.fechaLimiteDeEntregaDeTrabajos = fechaLimiteDeEntregaDeTrabajos;
	}
	public int getHoraDeEvento() {
		return horaDeEvento;
	}
	public void setHoraDeEvento(int horaDeEvento) {
		this.horaDeEvento = horaDeEvento;
	}
	public String getCorreoDeEvento() {
		return correoDeEvento;
	}
	public void setCorreoDeEvento(String correoDeEvento) {
		this.correoDeEvento = correoDeEvento;
	}
	public int getLimiteDeParticipantes() {
		return limiteDeParticipantes;
	}
	public void setLimiteDeParticipantes(int limiteDeParticipantes) {
		this.limiteDeParticipantes = limiteDeParticipantes;
	}

	//Funcion para insertar Eventos.
	public void insertarEvento(Eventos event) {
		PUCMM.getInstance().getMisEventos().add(event);

	}


	public void insertarParticipantes(Participantes participantes) {
		int i = 0;
		misParticipantes.add(participantes);
		i++;
	}

	public String getTipoDeEvento() {
		return tipoDeEvento;
	}

	public void setTipoDeEvento(String tipoDeEvento) {
		this.tipoDeEvento = tipoDeEvento;
	}

	public String getNombreDeComision() {
		return nombreDeComision;
	}

	public void setNombreDeComision(String nombreDeComision) {
		this.nombreDeComision = nombreDeComision;
	}

	public int getFechaDeCierre() {
		return fechaDeCierre;
	}

	public void setFechaDeCierre(int fechaDeCierre) {
		this.fechaDeCierre = fechaDeCierre;
	}

	public int getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(int fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}
	
} 
