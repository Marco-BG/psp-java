import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class VerDirectoriosRaiz {

	public static void main(String[] args) throws SocketException, IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		
		FTPClient cliente = new FTPClient();
		String direccionRemoto = "192.168.1.36";
		int puertoFTP = 21;
		String user = "ubuntu";
		String password = "ubuntu";
		
		cliente.connect(direccionRemoto, puertoFTP);
		
		boolean conectado = cliente.login("ubuntu", "ubuntu");
		
		// ftp admite datos de texto binarios.
					cliente.setFileType(FTP.BINARY_FILE_TYPE);
		if(conectado) {
			System.out.println("Cliente conectado al servidor ftpServer");
			FTPFile[] carpetas = cliente.listFiles();
			
			for(FTPFile c : carpetas) {
				
				if(!c.isDirectory()) {
				System.out.println(c.getName());
				
				File archivoLocal = new File("descargado_"+c.getName());
				
				String archivoRemoto = c.getName();
				
				OutputStream os = new FileOutputStream(archivoLocal);
				System.out.println("Comenzando la descarga...");
				
				boolean descargado = cliente.retrieveFile(archivoRemoto, os);
				os.close();
				if (descargado) {
					System.out.println("Fichero descargado");
				}else {
					System.out.println("¡El fichero no se descargó!");
				}
			}
			}
			File archivoSubida = new File("log.txt");
			FileWriter archivo = new FileWriter(archivoSubida, true);
			BufferedWriter archivoEscribir = new BufferedWriter(archivo);
			
			archivo.write("Descarga realizada el "+dtf.format(now).substring(0, 10)+" a las horas "+dtf.format(now).substring(10).trim()+" ");			
			archivoEscribir.close();
		}
	}
}
