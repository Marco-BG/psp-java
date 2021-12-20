
public class Carpintero extends Thread {
	Aserradero aserradero;
	Object finalCarpintero;
	int mueblesEncargados;

	public Carpintero(Aserradero aserradero, Object finalCarpintero, int numeroMuebles) {
		super();
		this.aserradero = aserradero;
		this.finalCarpintero = finalCarpintero;
		this.mueblesEncargados = numeroMuebles;
	}

	@Override
	public void run() {
		// El carpintero debe crear muebles hasta que los muebles creados sean los
		// muebles encargados.
		int cCreados = 0;
		while(this.mueblesEncargados > cCreados) {
			if(aserradero.hayMadera(5)) {
				aserradero.utilizarMadera(5);
				cCreados++;
							System.out.println("[Carpintero]:He hecho un mueble, llevo "+cCreados+" de "+mueblesEncargados);
			}else {
				synchronized (aserradero) {
					try {
						aserradero.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		synchronized (finalCarpintero) {
			finalCarpintero.notify();
		}
		// Comprobará la disponibilidad de madera antes de lanzarse a crear un mueble
		// (los muebles cuestan 5 unidades)
		// uso 5 de madera del aserradero
		// Si no hay madera, se quedará esperando una notificación sobre el propio
		// aserradero
		// Cuando haya finalizado notificará sobre el objeto finalCarpintero

	}
}
