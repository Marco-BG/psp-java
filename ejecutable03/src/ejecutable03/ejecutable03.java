package ejecutable03;

import java.io.IOException;

public class ejecutable03 {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Preparo el comando
		ProcessBuilder constructor = new ProcessBuilder("firefox");
		//Ejecuto el comando
		Process proceso = constructor.start();	
		long pid = proceso.pid();
		System.out.println(pid);
		
		
		Thread.sleep(3000);
		//Destruir el proceso
		
		if(proceso.isAlive()) {
			System.out.println("Esta vivo "+pid);
		}else {
			System.out.println("Ha muerto");
		}
		proceso.destroy();
		
		Thread.sleep(1000);
		if(proceso.isAlive()) {
			System.out.println("Esta vivo "+pid);
		}else {
			System.out.println("Ha muerto");
		}
	}
}
