package trabalho;

public class Helper {
	
	static int altura(Elemento e){ 
		
		if (e.dir == null && e.esq == null){ 
			e.altura = 1;
			return 1; 
		}
		else if (e.dir == null){ 
			e.altura = altura(e.esq) + 1;
			return e.altura; 
		}
			else if (e.esq == null){ 
				e.altura = altura(e.dir) + 1;
				return e.altura; 
		}	
		else{
			e.altura = Math.max(altura(e.esq), altura(e.dir)) + 1;
			return e.altura; 
		}
	}
	
	static void preordemFolha(Elemento e){ 
				
		System.out.println("Elemento: "+ e.chave +" Altura: "+ e.altura);
			
		if (e.esq != null) 
			preordemFolha(e.esq); 
		if (e.dir != null) 
			preordemFolha(e.dir); 
		
		}
	
	static Elemento buscaABBnaoRec(Elemento e, int x){   
		Elemento aux = e;
		while(aux !=null && aux.chave!=x){
			if(x > aux.chave){
				if( aux.dir != null)
					aux = aux.dir;
				else
					return aux;
			}
			else {
				if (aux.esq !=null)
					aux = aux.esq;
				else
					return aux;
			}
		}
		return aux;
}

		
	static Elemento buscaPai(Elemento e, int x){
		if ((e.chave == x) || (e.esq != null && e.esq.chave == x) || (e.dir != null && e.dir.chave == x))
			return e;   
		else if (e.esq != null && x < e.chave)     
			return buscaPai(e.esq, x);   
		else if (e.dir != null && x > e.chave)   
			return buscaPai(e.dir, x); 
		else
			return e;
		
	} 
		
	static int soma(Elemento e){
		if (e.altura == 1)
			return e.chave;
		else if (e.esq != null && e.dir != null)
			return soma(e.esq) + soma (e.dir);
		else if (e.esq != null)
			return soma(e.esq);
		else
			return soma(e.dir);
				
	}
	
	static void inserir(Elemento e, int x) {
		buscaPai(e,x);
		if (x < e.chave) {
	           if (e.esq != null) {
	              	inserir(e.esq,x);
	           } else {
	            	System.out.println("Inserindo " + x + " a esquerda de " + e.chave);
	               	e.esq = new Elemento(x);
	           } 
		} else if (x > e.chave) {
	            if (e.dir != null) {
	               	inserir(e.dir,x);
	            } else {
	               	System.out.println("Inserindo " + x + " a direita de " + e.chave);
	            	e.dir = new Elemento(x);
	            }    
	      }
	}
	
	static Elemento removeElemento(Elemento e, int x){
		buscaPai(e,x);
		if (e == null){ 
			return null; 
		} else if (e.chave > x){
			System.out.println("Removendo " + x + " a esquerda de " + e.chave);
			e.esq = removeElemento(e.esq, x);
		} else if (e.chave < x){
			System.out.println("Removendo " + x + " a direita de " + e.chave);
			e.dir = removeElemento(e.dir, x); 
		} else { 									
			/* sem filhos */ 
			if (e.esq == null && e.dir == null) { 
			e = null; 
			} 									
			/* tem filho a direita */ 
			else if (e.esq == null) { 
			e = e.dir; 
			} 									
			/* tem filho a esquerda */ 
			else if (e.dir == null) { 
			e = e.esq; 
			}
			/* tem os dois filhos */ 
			else { 
				Elemento f = e.esq; 
				while (f.dir != null) { 
					f = f.dir; 
				} 
				e.chave = f.chave; 					
				/* substitui as informações */ 
				f.chave = x; 
				System.out.println("Removendo " + x + " a esquerda de " + e.chave);
				e.esq = removeElemento(e.esq,x); 
			}
		} 
		return e;
	}    
}
	


	
