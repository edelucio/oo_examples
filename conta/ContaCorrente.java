package conta;

public class ContaCorrente extends Conta {
	double limite;
	public ContaCorrente(
			String numero, 
			String titular, 
			double saldo,
			double limite){
		
		super(numero, titular, saldo);
		this.limite = limite;
		
		
	}
}
