package Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    int in;
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
    		byte [] recibeDato = new byte [1024];
    		BufferedInputStream bis = new BufferedInputStream(nsfd.getInputStream());
    		DataInputStream dis = new DataInputStream(nsfd.getInputStream());
    		String file = dis.readUTF();
    		file = file.substring(file.indexOf("/")+1,file.length());
    		
    		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
    		while(( in = bis.read(recibeDato))!= -1) {
    			bos.write(recibeDato,0,in);
    			
    		}
    		bos.close();
    		dis.close();

    		
   // 		DataInputStream FlujoLectura = new DataInputStream(new BufferedInputStream(nsfd.getInputStream()));
    	//	FileInputStream fichero = new FileInputStream("pucmm.dat");
    		//File myFile = new File("pucmm.dat");
    	//	byte []
    		/*String txt = "";
    		if(!linea.equals ("")) {

    			txt = txt+" "+linea;
    			System.out.println(txt);
    		}*/
      }
      
      
      catch(IOException ioe)
      {
        System.out.println("Error: "+ioe);
      }
    }
  }
}
/*
FileInputStream fichero = new FileInputStream("pucmm.dat");
BufferedInputStream bis = null;
OutputStream os = null;
File myFile = new File("pucmm.dat");
Socket sock = null;
byte [] mybytearray = new byte[(int)myFile.length()];
fichero = new FileInputStream(myFile);
bis = new BufferedInputStream(fichero);
bis.read(mybytearray, 0 , mybytearray.length);
os = sock.getOutputStream();
System.out.println("Enviando...");
os.write(mybytearray, 0 ,mybytearray.length);
os.flush();
System.out.println("Correcto");

*/
