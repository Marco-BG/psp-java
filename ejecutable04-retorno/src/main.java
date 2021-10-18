import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ProcessBuilder constructor = new ProcessBuilder("bash","/home/alumno/Escritorio/psp/repos/psp-test/retorno.sh","3");
		
		Process proceso = constructor.start();
		
		System.out.println(proceso.pid());
		
		int retorno = proceso.waitFor();
		//System.out.println(proceso.exitValue());
		System.out.println(retorno);
		
		String parametro = String.valueOf(retorno);
		
		ProcessBuilder builder = new ProcessBuilder("bash","/home/alumno/Escritorio/psp/repos/psp-test/retorno.sh",parametro);
		
		Process procesoRetorno = builder.start();
		int retornoDos = procesoRetorno.waitFor();
		
		System.out.println(retornoDos);
		
	}
}
