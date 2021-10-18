package ejecutable01;

import java.io.IOException;
import java.util.concurrent.Executors;

public class comando {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println(System.getProperty("os.name"));
		
		Process proceso;
		
			proceso = Runtime.getRuntime().exec("ls / -l");
			
			StreamGobbler stream = new StreamGobbler(proceso.getInputStream(), System.out::println);//Expresion lam
			Executors.newSingleThreadExecutor().submit(stream);
			
			int exitCode = proceso.waitFor();
			
			System.out.println("Codigo de finalizacion del proceso "+exitCode);
		
		}
}
