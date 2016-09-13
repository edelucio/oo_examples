package emprestimo;

import java.util.Scanner;

public class TesteEmprestimo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Emprestimo emprestimo = new Emprestimo();
				
		System.out.println("Digite Credor: ");
		String resposta = scan.nextLine();
		emprestimo.setCredor(resposta);
		
		System.out.println("Digite valor do emprestimo : ");
		Double valor = scan.nextDouble();
		emprestimo.valor = valor;
		
		System.out.println("Digite quantidade de parcelas: ");
		emprestimo.qtdParcelas = scan.nextInt();
		
			
		System.out.println("Caro " + emprestimo.getCredor() + ", para o empréstimo no valor de " + emprestimo.valor + 
				            " você pagará " + emprestimo.qtdParcelas + " de " + emprestimo.calcularValorDaParcela(emprestimo.valor, emprestimo.qtdParcelas));

	}
}

