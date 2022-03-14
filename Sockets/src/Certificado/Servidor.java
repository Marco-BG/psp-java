package Certificado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class Servidor {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException, KeyStoreException, CertificateException, UnrecoverableKeyException {
		//almacen del certificado de servidor
		System.setProperty("javax.net.ssl.keyStore",
				"C:\\Program Files\\Java\\jre1.8.0_321\\bin\\almacenServidor.p12");
		//contraseña del almacen del certificado del servidor
		System.setProperty("javax.net.ssl.keyStorePassword", "test123");
		//almacen de certificados en que confío (en este caso tengo el mismo almacen para
		//el certificado propio y el certificado de los sitios en que confio)
		System.setProperty("javax.net.ssl.trustStore", 
				"C:\\Program Files\\Java\\jre1.8.0_321\\bin\\almacenServidor.p12");
		//contraseña del almacen de los certificados en que confío
		System.setProperty("javax.net.ssl.trustStorePassword", "test123");
		//creamos el socket seguro
		
		SSLServerSocketFactory sslFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		ServerSocket servSock = sslFactory.createServerSocket(5566);
		
		/*
		Socket socket = servSock.accept();
		
		
		DataInputStream entrada = 
				new DataInputStream(socket.getInputStream());
		
		DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
		salida.writeUTF("hola soy el server");
	
		while(true) {
			try {
				System.out.println(entrada.readUTF());
			}catch(Exception e) {
				
			}
		}
		*/
		
		while(true) {
			Socket socket = servSock.accept();
			
			System.out.println("Se ha conectado un cliente");
			HiloConexion hilo = new HiloConexion(socket);
			
			
			
			hilo.start();
		}
			
	}
}
