package calculadora;

public class TesteCalculadora {

	public static void main(String[] args) {
		
		Calculadora c = new Calculadora();      
		
		int resultado = c.somar(3, 4);      
		
		if (resultado == 7) {
			
			System. out .println("TESTE: somar OK");   
			
		} else {
			
			System. out .println("TESTE: somar ERRO");   
		}      
		
		resultado = c.subtrair(10, 7);      
		
		if (resultado == 3) { 
			
			System. out .println("TESTE: subtrair OK");   
			
			} else {
				
			System. out .println("TESTE: subtrair ERRO");
				
			}
		
		double outroResultado = c.multiplicar(3.5, 10.0);      
		
		if (outroResultado == 35.0) {
		
			System. out .println("TESTE: multiplicar OK");   
			
		} else {
		
			System. out .println("TESTE: multiplicar ERRO"); 
		
		}

	}

}
