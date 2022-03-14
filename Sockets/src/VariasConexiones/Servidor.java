package VariasConexiones;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {

		ServerSocket socketServidor = new ServerSocket(5252);
		
			while(true) {
				Socket socket = socketServidor.accept();
				HiloConexion hilo = new HiloConexion(socket);
				
					System.out.println("cliente conectado "+socket.getInetAddress());
				hilo.start();
			}
		}

}
