import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws InterruptedException {

		Scanner leer = new Scanner(System.in);
		System.out.println("\n");
		Date fecha = new Date();
		
		try {
			Socket socket = new Socket("127.0.0.1",5000);
			
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			
			ClienteHilo	clienteHilo = new ClienteHilo(fecha);
			clienteHilo.start();
			String nombre = leer.next();
			out.writeUTF(nombre+" fecha => "+clienteHilo.dameFecha()+" puerto local "+socket.getLocalPort());
			clienteHilo.join();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
