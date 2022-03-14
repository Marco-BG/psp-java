import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Scanner;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, NoSuchAlgorithmException, KeyStoreException, CertificateException, UnrecoverableKeyException, KeyManagementException {

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
			Scanner teclado = new Scanner(System.in);
			String mensaje = "";
			while (!mensaje.equals("quit")) {
				System.out.println("Introduce cosas por el teclado:");
				mensaje = teclado.nextLine();
				salida.writeUTF(mensaje);
			}
	}

}
