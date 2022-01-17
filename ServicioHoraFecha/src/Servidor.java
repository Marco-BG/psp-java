import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class Servidor {

	public static void main(String[] args) throws IOException {

		List<ConexionCliente> conexiones = null;
		FileWriter fw = null;
		try {
			ServerSocket servidor = new ServerSocket(5000);
			Socket socket;
		
			
			System.out.println("Servidor iniciado");
			
			while(true) {
				socket = servidor.accept();
				
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				
				out.writeUTF("Indica tu nombre: ");
				String reciboDatosCliente = in.readUTF();
				
				//ServidorHilo hilo = new ServidorHilo(in, out, nombreCliente);
				//hilo.start();
				
				System.out.println("Creada la conexion con el cliente "+reciboDatosCliente);
				
				conexiones = Arrays.asList(new ConexionCliente(reciboDatosCliente));
				System.out.println("Se ejecuta esto");
				
				fw = new FileWriter("Ficheros\\conexionesSocket.json", true);
				
				new Gson().toJson(conexiones, fw);
				fw.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
