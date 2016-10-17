package abstractcar;

public class Vw extends Carro{
	public Vw(String marca, String modelo, String cor, String motor) {
		super(marca, modelo, cor, motor);
	}
	public void ligar() {
		System.out.println("Vw Ligado");
		}
	
	public void acelerar() {
		System.out.println("Vw Acelerando");
	}
}
