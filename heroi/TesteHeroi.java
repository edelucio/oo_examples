package heroi;

import java.util.Scanner;
import java.util.ArrayList;

public class TesteHeroi {

	public static void main(String[] args) {
					
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Digite o nome do heroi:");
			String nome = scan.nextLine();
			
			System.out.println("Digite a identidade secreta do heroi:");
			String identidadeSecreta = scan.nextLine();
			
			Heroi heroi1 = new Heroi(nome, identidadeSecreta);
			System.out.println("Vc criou o heroi " + heroi1);
			

			/* ArrayList */
		
			ArrayList<String> nomes = new ArrayList<String>();
			nomes.add("Eduardo");
			nomes.add("Luciano");
			nomes.add("Iago");
		
			System.out.println(nomes.size());
		
			if (nomes.isEmpty()) {
				System.out.println("A lista esta vazia");
			}
		
			if (nomes.contains("Eduardo")) {
				System.out.println("Eduardo esta na lista");
			}
		
			System.out.println("O Luciano esta na posicao " + nomes.indexOf("Luciano"));
	}

	
}

