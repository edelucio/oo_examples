package polimorfismoPato;

public class Pato {

		private String nome;
		private Voo voo;
		private Grasnar grasnar;

		public void setVoo(Voo voo){
			this.voo = voo;
		}
		
		public void setGrasnar(Grasnar grasnar){
			this.grasnar = grasnar;
		}

		public Pato(){
			this.nome = "Marreco";
			this.voo = new Voo();
			this.grasnar = new Grasnar();
		}

		public Pato(String nome, Voo voo, Grasnar grasnar){
			this.nome = nome;
			this.voo = voo;
			this.grasnar = grasnar;
		}

		public void usarVoo(){
			System.out.println(nome + " voo: " + voo.executar());
		}
		
		public void usarGrasnar(){
			System.out.println(nome + " grasnar: " + grasnar.executar()+ "\n");
		}
}