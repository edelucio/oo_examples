package conta;

public class Poupanca extends Conta {
	
	public Poupanca(
			String numero,
			String titular,
			double saldo){
		super(numero, titular, saldo);
		
	}

	public void renderJuros(double indice){
		saldo += saldo * (indice/100);
		
	}
	
}
