package corrida;

public class Corrida {
	
	String tipo;
	String autodromo;
	int voltas;
	String vencedor;
	
	public String listarDados(){
		
		return (tipo + " de " + autodromo + ":" + voltas + " volta(s)");
					
	}
	
	public void iniciarCorrida(){
		
		for (int x = 1; x <= 2; x++){
			if (voltas > 0)
				
					System.out.println("Volta número "+ x);
					voltas +=1;
			
		}
	}
			
}