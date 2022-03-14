package Normales;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socketCliente = new Socket("localhost",5252);
		
			DataInputStream recibir = new DataInputStream(socketCliente.getInputStream());
			
			System.out.println(recibir.readUTF());
	}

}
