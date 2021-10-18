package ejecutable02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class lanzarPrograma {

	public static void main(String[] args) throws IOException {
		
		Process proceso = Runtime.getRuntime().exec("ls");
		
		//Conectamos un reader (lector) a la salida del proceso
		BufferedReader lector = new BufferedReader(
								new InputStreamReader(proceso.getInputStream()));
		
	//Mientras haya datos a la salida, leelos de linea en linea
		//e imprimimos por la salida estándar.
		while(lector.ready()) {
				System.out.println(lector.readLine());
		}
	}
}
