package Logico;

import java.util.ArrayList;
import java.util.Date;

public class Eventos {
	
	private String tituloDeEvento;
	private ArrayList<Participantes> misParticipantes;
	private ArrayList<Trabajos> misTrabajos;
	private Comisiones comision;
	private Recursos recursoUtilizados;
	private String codigoDeEvento;
	private Date fechaDeInicio;
	private Date fechaDeCierre;
	private String lugarDeEvento;
	private Date fechaLimiteDeEntregaDeTrabajos;
	private int horaDeEvento;
	private String correoDeEvento;
	public Eventos(String tituloDeEvento, Comisiones comision, Recursos recursoUtilizados, String codigoDeEvento,
			String lugarDeEvento, int horaDeEvento, String correoDeEvento) {
		super();
		this.tituloDeEvento = tituloDeEvento;
		this.comision = comision;
		this.recursoUtilizados = recursoUtilizados;
		this.codigoDeEvento = codigoDeEvento;
		this.lugarDeEvento = lugarDeEvento;
		this.horaDeEvento = horaDeEvento;
		this.correoDeEvento = correoDeEvento;
		misParticipantes = new ArrayList<>();
		misTrabajos = new ArrayList<>();
		this.fechaDeCierre = new Date();
		this.fechaDeInicio = new Date();
		this.fechaLimiteDeEntregaDeTrabajos = new Date();
		
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
	public Date getFechaDeInicio() {
		return fechaDeInicio;
	}
	public void setFechaDeInicio(Date fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}
	public Date getFechaDeCierre() {
		return fechaDeCierre;
	}
	public void setFechaDeCierre(Date fechaDeCierre) {
		this.fechaDeCierre = fechaDeCierre;
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
}
