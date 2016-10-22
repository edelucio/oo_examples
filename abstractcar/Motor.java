package abstractcar;

public abstract class Motor extends Carro{
	
	public Motor(String marca, String modelo, String cor, String potencia) {
		super(marca, modelo, cor, potencia);
	}

	public static String setPotencia(String potencia) {
		return Motor.potencia = potencia;
	}
}
