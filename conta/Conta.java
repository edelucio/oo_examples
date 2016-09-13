package conta;

public class Conta {
	
	String numero;
	String titular;
	double saldo;
	String[] ultimasoperacoes;
	int proximoIndice;
	
	public Conta(
			String numero, 
			String titular, 
			double saldo){
		
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		ultimasoperacoes = new String[10];
				
	}
	
	public Conta(){}
		
	public void depositar(double deposito){
		saldo += deposito;
		if (proximoIndice<10){
			ultimasoperacoes[proximoIndice] = "Depósito R$ " + deposito;
		}	
	}
	
	public void sacar(double saque){
		if (saldo >= saque){
			saldo -= saque;

	}
		
}
	

}
