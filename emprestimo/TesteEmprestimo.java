package emprestimo;

import java.util.Scanner;

public class TesteEmprestimo {

	public static void main(String[] args) {
		
		Emprestimo e1 = new Emprestimo();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite Credor: ");
		e1.setCredor(scan.nextLine());
		
		System.out.println("Digite valor : ");
		e1.valor = scan.nextDouble();
		
		System.out.println("Digite quantidade de parcelas: ");
		e1.qtdParcelas = scan.nextInt();
		
			
		System.out.println("Caro " + e1.getCredor() + ", para o empréstimo no valor de " + e1.valor + 
				            " você pagará " + e1.qtdParcelas + " de " + calcularValorDaParcela(e1.valor, e1.qtdParcelas));

	}
}

