package guerreiro;

public abstract class Arma extends Perigoso {
	
	public abstract void disparar();
	
	public void manejarComCuidado() {
		
		System.out.println("CUIDADO!");
		
	}

}
