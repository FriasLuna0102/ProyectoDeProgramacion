package Socket;
/*
import java.io.BufferedInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Servidor extends Thread
{
  public static Vector usuarios = new Vector();
  
  public static void main (String args[])
  {
    ServerSocket sfd = null;
    try
    {
      sfd = new ServerSocket(7000);
      System.out.println("Servidor en ejecucion correctamente.");
    }
    catch (IOException ioe)
    {
      System.out.println("Comunicación rechazada."+ioe);
      System.exit(1);
    }

    while (true)
    {
      try
      {
    	  Socket nsfd = sfd.accept();
    		System.out.println("Conexion aceptada de: "+nsfd.getInetAddress());
    		DataInputStream FlujoLectura = new DataInputStream(new BufferedInputStream(nsfd.getInputStream()));
    		FileInputStream fichero = new FileInputStream("pucmm.dat");
    		String txt = "";
    		if(!linea.equals ("")) {

    			txt = txt+" "+linea;
    			System.out.println(txt);
    		}
      }
      catch(IOException ioe)
      {
        System.out.println("Error: "+ioe);
      }
    }
  }
}*/



