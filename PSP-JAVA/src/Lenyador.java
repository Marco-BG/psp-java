
import java.util.concurrent.ThreadLocalRandom;

public class Lenyador implements Runnable {

	Aserradero aserradero;

	public Lenyador(Aserradero aserradero) {
		super();
		this.aserradero = aserradero;
	}

	@Override
	public void run() {
		// Mientras el aserradero no esté parado,
		while (!aserradero.aserraderoParado()) {
			int randomNum = ThreadLocalRandom.current().nextInt(1000, 2000 + 1);
			try {
				Thread.sleep(randomNum);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int madera = ThreadLocalRandom.current().nextInt(1, 3 + 1);
			aserradero.agregarMadera(madera);
			System.out.println("[Le�ador]: He a�adido "+madera +" de madera");
			synchronized (aserradero) {
				aserradero.notify();
			}

		}
		// el carpintero dormirá un tiempo aleatorio entre 1 y 2 segundos:
		// y añadirá un número aleatorio entre 1 y 3 unidades de madera al
		// aserradero.
		// después de añadir la madera,
		// notificará sobre el propio objeto aserradero que hay madera disponible.
		// int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
	}

}
