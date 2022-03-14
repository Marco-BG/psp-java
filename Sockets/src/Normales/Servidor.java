package Normales;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {

		ServerSocket servidor = new ServerSocket(5252);
		Socket socket = servidor.accept();
		
		System.out.println("Dirección del cliente "+socket.getInetAddress()+"\n");
		DataOutputStream escribir = new DataOutputStream(socket.getOutputStream());
		
		escribir.writeUTF("Hola soy el servidor y lo esta recibiendo el cliente");
		
		escribir.close();
	}

}
