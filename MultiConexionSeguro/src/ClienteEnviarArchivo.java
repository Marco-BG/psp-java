import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.net.ssl.SSLSocketFactory;

public class ClienteEnviarArchivo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//almacen del certificado de cliente
		 System.setProperty("javax.net.ssl.keyStore",
				 "/home/ubuntu/Escritorio/almacenCliente.p12");
		 //contraseña del almacen del certificado del cliente
		 System.setProperty("javax.net.ssl.keyStorePassword", "test321");
		 //almacen de certificados en que confío (en este caso tengo el mismo almacen para
		 //el certificado propio y el certificado de los sitios en que confio)
		 System.setProperty("javax.net.ssl.trustStore", 
				 "/home/ubuntu/Escritorio/almacenCliente.p12");
		 //contraseña del almacen de los certificados en que confío
		 System.setProperty("javax.net.ssl.trustStorePassword", "test321");
		 
		 
		 
		 SSLSocketFactory sslFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		 
		 Socket socket = sslFactory.createSocket("192.168.1.37",5566);
		 
		 DataOutputStream salida = 
					new DataOutputStream(socket.getOutputStream());
		 
		 FileInputStream fileInputStream = null;
		 
		 
			Scanner teclado = new Scanner(System.in);
			
			
			String mensaje = "";
			while (!mensaje.equals("quit")) {
				System.out.println("Introduce la ruta del archivo: ");
				
				mensaje = teclado.nextLine();
				File file = new File(mensaje);
				
				
				fileInputStream = new FileInputStream(file);
				
				salida.write(fileInputStream.readAllBytes());
				salida.writeUTF(mensaje);
			}
	}

}
