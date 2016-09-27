package polipato;

public class Pato {
	private Voo voo;
	
	public Pato(Voo voo) {
		this.voo = voo;
	}
	public void voar() {
		voo.executar();
	}
}
