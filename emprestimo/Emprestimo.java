package emprestimo;

public class Emprestimo {
	
	private String credor;
	public double valor;
	public int qtdParcelas;
	
	public String getCredor() {
		return credor;
	}
	public void setCredor(String credor) {
		this.credor = credor;
	}
	
	public double calcularValorDaParcela(double valorDaParcela, int qtdParcelas){
		if (qtdParcelas < 5){
			valorDaParcela = (valorDaParcela+(valor*0.045))/qtdParcelas;
			return valorDaParcela;
		}
		else if (qtdParcelas >= 5 && qtdParcelas <= 12){
			valorDaParcela = (valorDaParcela+(valor*0.085))/qtdParcelas;
			return valorDaParcela;
		}
		else if (qtdParcelas >12){
			valorDaParcela = (valorDaParcela+(valor*0.12))/qtdParcelas;
			return valorDaParcela;
		}
		return valorDaParcela;
	}
	
}
