
public class Aserradero {
	int unidades;
	boolean finalizado;
	public Aserradero() {
		this.unidades = 0;
		this.finalizado = false;
	}
	
	
	public synchronized void agregarMadera(int n) {
		this.unidades+=n;
	}
	
	public synchronized boolean hayMadera(int n) {
		return this.unidades>=n;
	}
	
	public synchronized void utilizarMadera(int n) {
		this.unidades-=n;
	}
	
	public synchronized void parar() {
		this.finalizado = true;
	}
	
	public synchronized boolean aserraderoParado() {
		return this.finalizado;
	}


	@Override
	public synchronized String toString() {
		return "Estado del aserradero: \n"
				+ "\t¿Aserradero parado?"+this.finalizado+"\n"
				+ "\t¿Unidades de madera?"+this.unidades+"\n";
	}
	
	
}
