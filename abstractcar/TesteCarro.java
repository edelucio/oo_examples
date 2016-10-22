package abstractcar;

public class TesteCarro {

	public static void main(String[] args) {
		
		Carro c1 = new Fiat("Fiat", "Mobi", "Branco", Motor.setPotencia("1.0"));
		
		c1.ligar();
		c1.acelerar();
		
						
		System.out.println("Marca: " + c1.getMarca() + "\nModelo: " + c1.getModelo() + "\nCor: " + c1.getCor() + "\nMotor: " + c1.getPotencia() + "\n");
		
		Carro c2 = new Ford("Ford", "Fusion", "Preto", Motor.setPotencia("2.0"));
		
		c2.ligar();
		c2.acelerar();
		
		System.out.println("Marca: " + c2.getMarca() + "\nModelo: " + c2.getModelo() + "\nCor: " + c2.getCor() + "\nMotor: " + c2.getPotencia() + "\n");
		 
		Carro c3 = new Vw("Vw", "Tiguan", "Vermelho", Motor.setPotencia("4.0"));
		
		c3.ligar();
		c3.acelerar();
				
		System.out.println("Marca: " + c3.getMarca() + "\nModelo: " + c3.getModelo() + "\nCor: " + c3.getCor() + "\nMotor: " + c3.getPotencia() + "\n");
		
	}

}
