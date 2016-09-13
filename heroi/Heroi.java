package heroi;

public class Heroi {
	private String nome;
	public String identidadeSecreta;
	
	public Heroi(String nome, String identidadeSecreta) {
		this.nome = nome;
		this.identidadeSecreta = identidadeSecreta;
	}
	
	public String toString() {
		return nome + " - " + identidadeSecreta; 
	}

}
