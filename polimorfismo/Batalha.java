package polimorfismo;

public class Batalha {

	public static void main(String[] args) {
		Heroi h1 = new Heroi();
		Heroi h2 = new Heroi("Arqueiro", new Poder());
		Heroi h3 = new Heroi("Ryu", new Hadouken());
		Heroi h4 = new Heroi("Superman", new RaioX());
		
		h1.usarPoder();
		h2.usarPoder();
		h3.usarPoder();
		h4.usarPoder();
		
		h1.setPoder(new Hadouken());
		
		h1.usarPoder();
		
	}
}
