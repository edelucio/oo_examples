package polimorfismo2;

public class Rasante extends Pato {
	
	public Rasante(String nome, Voar voar) {
		super(nome, voar);
	}
		
	public String voar(){
		return "RASANTE";
	}
}
