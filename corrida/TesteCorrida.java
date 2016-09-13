package corrida;

public class TesteCorrida {

	public static void main(String[] args) {
		
		Corrida c = new Corrida();
		
		c.tipo = "F1";
		c.autodromo = "Interlagos";
		c.voltas = 2;
		
		String dados = c.listarDados();
		
		if (dados.equals(dados)) {
			
			System. out .println("TESTE: listarDados OK");
			
		}      
		
		c.iniciarCorrida();
		
		
	}

}
