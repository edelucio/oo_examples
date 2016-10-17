package grafos;

public class Execute {
	
	public static void main(String[] Args){
		Grafo grafo = new Grafo();
		
		grafo.txtGrafo();
		
		grafo.imprimiMatriz();
		
		if(grafo.VerificaAresta("b")){
			System.out.println("Aresta b OK");
		}
		
		System.out.println("Qnt de Arestas = "+grafo.arrayAresta.size());
		
		grafo.BellmanFord("v8","v17");
		
		grafo.Floyd("v8","v17");
		
		grafo.dijkstra("v8", "v17");
		
		System.out.println();
		
		if(temCaminhoEuler(grafo)){
			System.out.println("Existe Caminho de Euler");
		} else {
			System.out.println("Nao existe caminho de Euler");
		}
		
		System.out.println();
		
		if(buscaEmProfundidade(grafo,grafo.arrayVertice.get("v1"))){
			System.out.println("Grafo Conexo");
		} else {
			System.out.println("Grafo nao Conexo");
		}
		
		grafo.findGrupos();
				
		System.out.println("Grau de v1 = "+grafo.verificaGrauVertice("v1"));
		System.out.println("Grau de v2 = "+grafo.verificaGrauVertice("v2"));
		System.out.println("Grau de v3 = "+grafo.verificaGrauVertice("v3"));
		System.out.println("Grau de v4 = "+grafo.verificaGrauVertice("v4"));
		System.out.println("Grau de v5 = "+grafo.verificaGrauVertice("v5"));
		System.out.println("Grau de v6 = "+grafo.verificaGrauVertice("v6"));
		
		
		System.out.println("Adjacentes de v2 = "+grafo.obterAdjacentes("v2"));
		
		System.out.println("Grau Minimo = "+grafo.grauMinimo);
		System.out.println("Grau Maximo = "+grafo.grauMaximo);
		System.out.println("Grau Medio = "+grafo.grauMedio);
		
	}
		
	public static boolean buscaEmProfundidade(Grafo graf,Vertice vert){
			
		boolean isConexo = true;
		
		vert.setVisitado(true);
		String[] adjacentes = (graf.obterAdjacentes(vert.getID()).split(" "));
		for(String verticeID:adjacentes){
			if (!graf.arrayVertice.get(verticeID).isVisitado()){
				buscaEmProfundidade(graf,graf.arrayVertice.get(verticeID));
			}
		}
		
		for(String vertKey:graf.arrayVertice.keySet()){
			if(!graf.arrayVertice.get(vertKey).isVisitado()){
				isConexo = false;
			}
		}
		
		return isConexo;
	}
	
	public static boolean temCaminhoEuler(Grafo graf){
		boolean euler = false;
		
		if(buscaEmProfundidade(graf,graf.arrayVertice.get("v1"))){
			int total = 0;
			int i = 1;
			while(total <=2 && i<=graf.arrayVertice.size()){
				for(String key:graf.arrayVertice.keySet()){
					int grau = graf.verificaGrauVertice(graf.arrayVertice.get(key).getID());
					if(grau%2 != 0){
						total = total + 1;	
					}
					i++;
				}
				
			}
			if(total>2){
				euler = false;
			} else {
				euler = true;
			}
		} else {
			euler = false;
		}
		return euler;
	}
		
}
