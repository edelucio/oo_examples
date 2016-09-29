package constelacao;

import java.util.ArrayList;

public class Constelacao {
	public String nome;
	public ArrayList<Estrela> estrelas;
	private Estrela maiorEstrela;
	
	public void adicionarEstrela(Estrela e){
		if(e.getGrandeza() > maiorEstrela.getGrandeza()){
			maiorEstrela = e;
			estrelas.add(e);
		}
	}

	public Estrela recuperarMaiorEstrela(){
		return maiorEstrela;
	}
}
