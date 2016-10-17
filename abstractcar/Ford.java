package abstractcar;

public class Ford extends Carro {
	public Ford(String marca, String modelo, String cor, String motor) {
		super(marca, modelo, cor, motor);
	}
	public void ligar() {
		System.out.println("Ford Ligado");
		}
	
	public void acelerar() {
		System.out.println("Ford Acelerando");
	}
}
