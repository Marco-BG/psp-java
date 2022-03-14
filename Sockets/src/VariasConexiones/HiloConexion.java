package VariasConexiones;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloConexion extends Thread {

	 Socket socket;

	public HiloConexion(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			oos.writeObject(new String("Hola soy un hilo de cliente"));
			oos.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
