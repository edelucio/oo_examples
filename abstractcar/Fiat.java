package abstractcar;

public class Fiat extends Carro {
	public Fiat(String marca, String modelo, String cor, String potencia) {
		super(marca, modelo, cor, potencia);
	}
	public void ligar() {
		System.out.println("Fiat Ligado");
		}
	
	public void acelerar() {
		System.out.println("Fiat Acelerando");
	}
	
}
