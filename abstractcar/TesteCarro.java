package abstractcar;

public class TesteCarro {

	public static void main(String[] args) {
		
		Carro c1 = new Fiat();
		
		c1.setMarca("Fiat");
		c1.setModelo("Toro");
		c1.setCor("Branco");
		c1.Ligar();
		c1.Acelerar();
		
		System.out.println("Carro Marca: " + c1.getMarca() + "\nModelo: " + c1.getModelo() + "\nCor: " + c1.getCor()+ "\n");
		
		Carro c2 = new Ford();
		
		c2.setMarca("Ford");
		c2.setModelo("Fusion");
		c2.setCor("Preto");
		c2.Ligar();
		c2.Acelerar();
		
		System.out.println("Carro Marca: " + c2.getMarca() + "\nModelo: " + c2.getModelo() + "\nCor: " + c2.getCor() + "\n");
		
		Carro c3 = new Vw();
		
		c3.setMarca("Vw");
		c3.setModelo("Tiguan");
		c3.setCor("Vermelho");
		c3.Ligar();
		c3.Acelerar();
		
		System.out.println("Carro Marca: " + c3.getMarca() + "\nModelo: " + c3.getModelo() + "\nCor: " + c3.getCor() + "\n");
		
	}
}
