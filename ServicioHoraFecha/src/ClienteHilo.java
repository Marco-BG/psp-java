import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ClienteHilo extends Thread{
	
	private Date fecha;
	public ClienteHilo(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date dameFecha() {
		return fecha;
		
	}
	@Override
	public void run() {
		/*
		//Scanner leer = new Scanner(System.in);
		//Socket socket;
		try {
			
			socket = new Socket("127.0.0.1", 5000);
			
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			
			String mensaje = in.readUTF();
			System.out.println(mensaje);
			
			String nombre = leer.next();
			out.writeUTF(nombre+" fecha => "+this.dameFecha());
			
		
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}
