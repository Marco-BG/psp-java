package ejecutable05;

import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder constructor = new ProcessBuilder("cat","/proc/timer_list");
		
		constructor.inheritIO();
		constructor.redirectError();
		Process proceso = constructor.start();
	}
}
