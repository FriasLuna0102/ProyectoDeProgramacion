package Logico;

public class Recursos {
	private int cantDeRecursos;
	private boolean disponibilidad;
	private String tipoDeRecurso;
	private  Recursos[] salones;
	public Recursos(int cantDeRecursos, boolean disponibilidad, String tipoDeRecurso, int numSalonesDisponibles) {
		super();
		this.cantDeRecursos = cantDeRecursos;
		this.disponibilidad = disponibilidad;
		this.tipoDeRecurso = tipoDeRecurso;
		salones = new Recursos[numSalonesDisponibles]; 
	}
	
	public int getCantDeRecursos() {
		return cantDeRecursos;
	}
	public void setCantDeRecursos(int cantDeRecursos) {
		this.cantDeRecursos = cantDeRecursos;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String getTipoDeRecurso() {
		return tipoDeRecurso;
	}
	public void setTipoDeRecurso(String tipoDeRecurso) {
		this.tipoDeRecurso = tipoDeRecurso;
	}
	
}
 