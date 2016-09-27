package polimorfismo2;

public class Voar {

	public static void main(String[] args) {
		
		Pato p1 = new Pato("Pato-comum", new Voar());
		Pato p2 = new Pato("Pato-real", new Voar());
		Pato p3 = new Pato("Pato-selvagem", new Voar());
				
		p1.tipoVoo();
		p2.tipoVoo();
		p3.tipoVoo();
			
	}
}