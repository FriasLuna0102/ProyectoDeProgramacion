package Logico;

import com.sun.javafx.geom.transform.CanTransformVec3d;

public class Main {

	public static void main(String[] args) {
		Jurado jurado = new Jurado("ds", "ds", "ds", "ds", "ds", "ds", "ds", 56, "ds", "ds");
		Jurado jurado2 = new Jurado("ds", "ds", "ds", "ds", "ds", "ds", "ds", 56, "ds", "ds");
		Jurado jurado3 = new Jurado("ds", "ds", "ds", "ds", "ds", "ds", "ds", 56, "ds", "ds");
		Jurado jurado4 = new Jurado("ds", "ds", "ds", "ds", "ds", "ds", "ds", 56, "ds", "ds");
		
		PUCMM.getInstance().addPersona(jurado);
		PUCMM.getInstance().addPersona(jurado2);
		PUCMM.getInstance().addPersona(jurado3);
		PUCMM.getInstance().addPersona(jurado4);

		PUCMM.getInstance().cantTipoDePersonas();
	}

}
