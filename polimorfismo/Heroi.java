package polimorfismo;

public class Heroi {
	
	private String nome;
	private Poder poder;
	
	public void setPoder(Poder poder){
		this.poder = poder;
	}
	
	public Heroi(){
		this.nome = "Batman";
		this.poder = new Poder();
	}
	
	public Heroi(String nome, Poder poder){
		this.nome = nome;
		this.poder = poder;
	}
	
	public void usarPoder(){
		System.out.println(nome + " usando: " + poder.ativar());
		
		}
	}

