package polimorfismo2;

public class Pato {
	
	private String nome;
	private Voar voar;
	
	public Voar getVoar(){
		return voar;
	}
	
	public void setVoar(Voar voar){
		this.voar = voar;
	}
		
	public Pato(String nome, Voar voar){
		this.nome = nome;
		new Voar();
	}
	
	public void tipoVoo(){
		System.out.println(nome + " - tipo voo: " + Planar.voar());
		
	}
}