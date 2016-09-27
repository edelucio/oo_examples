package polimorfismoPato;

public class TestePato {

	public static void main(String[] args) {
		Pato p1 = new Pato();
		Pato p2 = new Pato("Pato Comum", new Voo(), new Grasnar());
		Pato p3 = new Pato("Pato Rei", new Planar(), new Quack());
		Pato p4 = new Pato("Pato Selvagem", new Rasante(), new QuacQuac());

		p1.usarVoo();
		p1.usarGrasnar();
		
		p2.usarVoo();
		p2.usarGrasnar();
		
		p3.usarVoo();
		p3.usarGrasnar();
		
		p4.usarVoo();
		p4.usarGrasnar();

		p1.setVoo(new Rasante());
		p1.setGrasnar(new QuacQuac());

		p1.usarVoo();
		p1.usarGrasnar();

	}

}
