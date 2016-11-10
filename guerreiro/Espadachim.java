package guerreiro;

public class Espadachim extends Guerreiro {
	
	public Espadachim(Arma arma) {
		super(arma);
	}
	
	public void sobreviver() {
		
		System.out.println("UFA!");
		
	}
	
	public void lutar() {
		
		System.out.println("FIGHT!");
		
	}
	
	public void usarArma(Arma outraArma) {
		
		outraArma.disparar();
		
	}

}
