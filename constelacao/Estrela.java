package constelacao;

public class Estrela {
	private String nome;
	private int grandeza;
	
	public Estrela(){}
	
	public Estrela(String nome, int grandeza){
		this.nome = nome;
		this.grandeza = grandeza;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getGrandeza(){
		return grandeza;
	}
	
	public void setNome(String nome){
		if(nome !=null && !nome.equals("")){
			this.nome = nome;
		}
	}
	
	public void setGrandeza(int grandeza){
		if(grandeza >=0 && grandeza <=8){
			this.grandeza = grandeza;
		}
	}
}
