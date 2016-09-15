package trabalho;

public class Programa {

	public static void main(String[] args) {
		
		// Criando Construtor
				
		Elemento raiz = new Elemento(10);
		raiz.esq = new Elemento(8);
		raiz.esq.esq = new Elemento(6);
		raiz.dir = new Elemento(20);
		raiz.dir.esq = new Elemento (15);
		raiz.dir.dir = new Elemento(30);
		
		// Retorna altura da �rvore
		
		Helper.altura(raiz);
		
		// Coloca �rvore em pr�-ordem
		
		Helper.preordemFolha(raiz);
		
		// Busca ABB, n�o recursiva
		
		System.out.println(" ");
		
		Elemento aux = Helper.buscaABBnaoRec(raiz, 16);
		
		System.out.println("Busca N�o Recursiva Elemento: "+ aux.chave);
		
		// Busca ABB, retorna poss�vel pai
		
		System.out.println(" ");
		
		Elemento x = Helper.buscaPai(raiz, 9);
		
		System.out.println("Busca Pai: "+ x.chave);
		
		// Soma as folhas 
		
		System.out.println(" ");
				
		System.out.println("Soma das folhas: " + Helper.soma(raiz));
		
		// Inserir Elemento
		
		System.out.println(" ");
		
		Helper.inserir(raiz, 9);
		
		// Remover Elemento
		
		System.out.println(" ");
		
		Helper.removeElemento(raiz, 15);
		
		}

}
