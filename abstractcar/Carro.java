package abstractcar;

public abstract class Carro {
	
	private String marca;
	private String modelo;
	private String cor;
	private String motor;
	
	public abstract void ligar();

	public abstract void acelerar();
	
	public Carro(String marca, String modelo, String cor, String motor){
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.motor = motor;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}
}
