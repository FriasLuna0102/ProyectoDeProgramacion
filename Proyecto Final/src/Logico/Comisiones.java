package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Comisiones implements Serializable {
	private String nombreDeComision;
	private String jurado;
	private String presidente;
	public Comisiones(String nombreDeComision, String jurado, String presidente) {
		super();
		this.nombreDeComision = nombreDeComision;
		this.jurado = jurado;
		this.presidente = presidente;
	}
	public String getNombreDeComision() {
		return nombreDeComision;
	}
	public void setNombreDeComision(String nombreDeComision) {
		this.nombreDeComision = nombreDeComision;
	}
	public String getJurado() { 
		return jurado;
	}
	public void setJurado(String jurado) {
		this.jurado = jurado;
	}
	public String getPresidente() {
		return presidente;
	}
	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}
 
}
