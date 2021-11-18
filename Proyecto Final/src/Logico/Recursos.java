package Logico;

public class Recursos {
	private int cantDeRecursos;
	private boolean disponibilidad;
	private String tipoDeRecurso;
	public Recursos(int cantDeRecursos, boolean disponibilidad, String tipoDeRecurso) {
		super();
		this.cantDeRecursos = cantDeRecursos;
		this.disponibilidad = disponibilidad;
		this.tipoDeRecurso = tipoDeRecurso;
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
