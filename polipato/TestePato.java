package polipato;

public class TestePato {
	public static void main(String[] args) {
		Pato p1 = new Pato(new Voo());
		Pato p2 = new Pato(new Planar());
		Pato p3 = new Pato(new Rasante());
		
		p1.voar();
		p2.voar();
		p3.voar();
	}
}
