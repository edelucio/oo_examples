package conta;

public class TesteConta {
	public static void main(String[] args){
		
		Conta conta1 = new Conta("001", "Eduardo", 1000);
		Conta conta2 = new Conta();
		conta2.numero = "002";
		conta2.titular = "Iago";
		conta2.saldo = 500;
		conta2.ultimasoperacoes = new String[10];
		
		conta1.depositar(600);
		conta2.depositar(200);
		
	}

}
