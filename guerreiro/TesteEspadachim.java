package guerreiro;

public class TesteEspadachim {

	public static void main(String[] args) {
		
		Espadachim e = new Espadachim(new ArmaDeFogo());
		Guerreiro g = new Espadachim(new ArmaDeMetal());
		
		g.sobreviver();
		g.lutar();
		g.usarArma();
		
		e.sobreviver();
		e.lutar();
		e.usarArma();
		e.usarArma(new ArmaDeFogo());
		
	}

}
