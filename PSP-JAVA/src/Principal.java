
public class Principal {
	public static void main(String[] args) throws InterruptedException {
		//crear un objeto finalCarpintero (clase Object)
		Object finalCarpintero = new Object();
		//Crear el aserradero
		Aserradero aserradero = new Aserradero();
		// Crear 2 lenyadores pasándoles el aserradero y lanzarlos.
		Thread lenyador1 = new Thread(new Lenyador(aserradero));
		Thread lenyador2 = new Thread(new Lenyador(aserradero));
		// Crear un carpintero. Pasándole el aserradero, el Objeto para que notifique que
		Thread carpintero = new Thread(new Carpintero(aserradero, finalCarpintero, 10));
		
		lenyador1.start();
		lenyador2.start();
		carpintero.start();
		//Carpintero c = new Carpintero(aserradero, finalCarpintero, 10);
		// ya ha terminado y el número de muebles que tiene que hacer y lanzarlo.
		
		//Esperar la notificación sobre el objeto finalCarpinteros.
		synchronized (finalCarpintero) {
			finalCarpintero.wait();
		}
		
		//imprimir el estado del aserradero.
		System.out.println(aserradero);
		//Esperar al carpintero con join.
		carpintero.join();
		//Parar el aserradero.
		aserradero.parar();
		//esperar la finalización de los lenyadores con join.
		lenyador1.join();
		lenyador2.join();
		//imprimir el estado final del aserradero.
		System.out.println(aserradero);
	}
}
