package Certificado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloConexion extends Thread{

	Socket socket;
	private DataInputStream dis;
	
	
	public HiloConexion(Socket socket) throws IOException {
		this.socket = socket;
		this.dis = new DataInputStream(socket.getInputStream());
		
	}
	@Override
	public void run() {
		super.run();
		
		ObjectOutputStream oos;
		try {
			/*
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(new String("Hola soy un hilo de cliente"));
			oos.close();
			*/
			String mensaje = "";
			File file = new File("cliente.txt");
			PrintWriter escribimeEsta = new PrintWriter(file, "UTF-8");
			
			
		
			while(!mensaje.equals("quit")) {
				System.out.println(mensaje);
				escribimeEsta.println(mensaje);
				mensaje = dis.readUTF();
				
				
				
				
			}
			escribimeEsta.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
