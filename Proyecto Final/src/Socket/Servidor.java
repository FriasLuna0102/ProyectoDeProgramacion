package Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Servidor extends Thread
{
  public static Vector usuarios = new Vector();
  
  public static void main (String args[])
  {
    ServerSocket sfd = null;
    int in;
    try
    {
      sfd = new ServerSocket(7000);
      System.out.println("Servidor en ejecución correctamente.");
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
    		FileInputStream fr = new FileInputStream("C:\\Users\\natas\\git\\ProyectoDeProgramacion\\Proyecto Final\\pucmm.dat");
    		byte b[]  = new byte [20002];
    		fr.read(b, 0 , b.length);
    		OutputStream os = nsfd.getOutputStream();
    		os.write(b, 0 , b.length);
    		
      }
      	catch(IOException ioe) {
        System.out.println("Error: "+ioe);
      }
    }
  }
}




