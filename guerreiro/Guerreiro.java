package guerreiro;

public abstract class Guerreiro {
	
	private String nome;
	private String pais;
	private Arma arma;
	
	public Guerreiro(Arma arma) {
		this.arma = arma;
	}
	
	
	public abstract void sobreviver();
	
	public void lutar() {
		
		System.out.println("LUTANDO!");
		
	}
	
	public void usarArma() {
		
		arma.disparar();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
