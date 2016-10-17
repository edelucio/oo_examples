package grafos;

import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	public Map<String, Vertice> arrayVertice = new HashMap<String, Vertice>();
	public String[] ordemVertice = new String[100];
	public Map<String, Aresta> arrayAresta = new HashMap<String, Aresta>();
	Map<Integer, String> compGrupos = new HashMap<Integer, String>();
			
	public int[][] matrizAdj;
	public int[][] matrizAdjPon;
	
	public int grauMinimo;
	public float grauMedio;
	public int grauMaximo;
	private int quantGrupos; 
		
	public void Floyd(String vertOrigem,String vertDestino){
		
		preencheMatriz();
		
		long startTime = System.nanoTime();
				
		System.out.println();
		System.out.println("Algoritmo de Floyd:");
		
		int iteracoes = 0;
		int[][] matrizDist = matrizAdjPon;
		
		for (int k = 0; k<arrayVertice.size(); k++){
			for (int i = 0; i<arrayVertice.size(); i++){
				for (int j = 0; j<arrayVertice.size(); j++){
					if(matrizDist[i][k]+matrizDist[k][j]<matrizDist[i][j]){
						matrizDist[i][j] = matrizDist[i][k]+matrizDist[k][j];
						iteracoes++;
					}
				}
			}
		}
		
		long endTime = System.nanoTime() - startTime;
		
		int indOri = Arrays.asList(ordemVertice).indexOf(vertOrigem);
		int indDest = Arrays.asList(ordemVertice).indexOf(vertDestino);
		
		System.out.println("Distancia = "+matrizDist[indOri][indDest]);
		System.out.println("Iteracoes = "+iteracoes);
		System.out.println("Runtime = "+endTime);
		
	}
	
	public void findGrupos(){
		
		Map<String, Integer> grupos = new HashMap<String, Integer>();
		
		Set<String> verticesGrupos = new HashSet<String>(arrayVertice.keySet());
		
		int num = 1;
		
		
		while(!verticesGrupos.isEmpty()){
			String[] primeiro = verticesGrupos.toArray(new String[0]);
			Map<String, Integer> gruposVert = percorre(primeiro[0],num,grupos);
			verticesGrupos.removeAll(gruposVert.keySet());
			compGrupos.put(num, "");
			num++;
		}
		
		quantGrupos = num-1;
		
		
		System.out.println();
		System.out.println("Quantidade de Componentes = "+quantGrupos);
		
		for(String Key:grupos.keySet()){
			compGrupos.put(grupos.get(Key), compGrupos.get(grupos.get(Key)).concat(" "+Key));
		}
		
		for(int i=1; i<=quantGrupos; i++){
			System.out.println("Componente "+i+" = "+compGrupos.get(i));
			System.out.println("Tamanho do Componente "+i+" = "+(compGrupos.get(i).split(" ").length-1));
		}
		
		System.out.println();
	}
	
	public Map<String,Integer> percorre(String vert, int num, Map<String, Integer> grupos){
		
		grupos.put(vert,num);
		String[] adjacentes = (obterAdjacentes(vert).split(" "));
		for(String verticeID:adjacentes){
			if(!grupos.containsKey(verticeID)){
				percorre(verticeID,num, grupos);
			}	
		}
		return grupos;
	}
	
	public void BellmanFord(String vertOrigem,String vertDest){
		
		preencheMatriz();
		
		long startTime = System.nanoTime();
		
		System.out.println();
		System.out.println("Algoritmo de Bellman Ford:");
		
		int indexOrigem = Arrays.asList(ordemVertice).indexOf(vertOrigem);
		int distanciaAnterior = 0;
		int distMin = 0;
		int iteracoes = 0;
		
		Map<String,Integer> d = new LinkedHashMap<String, Integer>();
		Map<String, String> s = new LinkedHashMap<String, String>();
		
		d.put(vertOrigem, 0);
		
		
		
		for (int z=0; z<arrayVertice.size(); z++){
			if (z == indexOrigem){
				d.put(ordemVertice[z], matrizAdjPon[indexOrigem][Integer.valueOf(z)]);
				
			} else {
				d.put(ordemVertice[z], matrizAdjPon[indexOrigem][Integer.valueOf(z)]);
				
			}
			s.put(ordemVertice[z], vertOrigem);
		}
		
		for(int i = 0; i<arrayVertice.size(); i++){
			for(int u = 0; u<arrayVertice.size(); u++){
				for (int v = 0; v<arrayVertice.size(); v++){
					distanciaAnterior = d.get(ordemVertice[v]);
					distMin = Math.min(d.get(ordemVertice[v]), d.get(ordemVertice[u])+matrizAdjPon[u][v]);
					d.put(ordemVertice[v], distMin);
					if(distMin!=distanciaAnterior){
						s.put(ordemVertice[v], ordemVertice[u]);
					}
					iteracoes++;
				}
			}
		}
		
		long endTime = System.nanoTime() - startTime;
		
		String vert = vertDest;
		
		do{
			System.out.print(vert +" ");
			vert = s.get(vert);
		}while(!vert.equals(vertOrigem));
		System.out.println(vertOrigem);
		System.out.println("Distancia ="+d.get(vertDest));
		System.out.println("Iteracoes ="+iteracoes);
		System.out.println("Runtime = "+endTime);
		
	}
		
	public void dijkstra(String vertOrigem, String vertDest){
		
		preencheMatriz();
		
		System.out.println();
		System.out.println("Algoritmo de Dijkstra:");
		
		Map<String,Integer> distMap = new LinkedHashMap<String, Integer>();
		Map<String,Integer> d = new LinkedHashMap<String, Integer>();
		Map<String, String> s = new LinkedHashMap<String, String>();
		ArrayList<String> N = new ArrayList<String>();
		
		int distanciaAnterior = 0;
		int distAnt = 0;
		int distOri = 0;
		int distAdj = 0;
		
		int iteracoes = 0;
		
		N.add(vertOrigem);
		s.put(vertOrigem, vertOrigem);
		
		int indiceOrigem = Integer.valueOf(vertOrigem.substring(1));
		
		//Inicializa d e s
		for(int i = 0; i<arrayVertice.size(); i++){
			String vet = (String)ordemVertice[i];
			Integer ind = Integer.parseInt(vet.substring(1));
			
			d.put((String) ordemVertice[i], matrizAdjPon[indiceOrigem-1][ind-1]);
			distMap.put((String) ordemVertice[i], matrizAdjPon[indiceOrigem-1][ind-1]);
			s.put((String)ordemVertice[i],vertOrigem);	
		}
		
		long startTime = System.nanoTime();
		
		while(!N.contains(vertDest)){
			String p = menorDe(d,N);
			N.add(p);
			
			String[] Nvetor = new String[d.size()];
			Nvetor = N.toArray(Nvetor);
			for(int i = 0;i<N.size();i++){
				d.remove(Nvetor[i]);
			}
			
			String[] vetores = d.keySet().toArray(new String[0]);
		
			for(int i=0; i<d.size();i++){
				distanciaAnterior = distMap.get(vetores[i]);
				distAnt = distMap.get(vetores[i]);
				distOri = distMap.get(p);
				distAdj = this.buscaAresta(p, (String)vetores[i]);
				
				iteracoes++;
				int dist = Math.min(distAnt,distOri+distAdj);
				
				if(dist!=distanciaAnterior){
					s.put((String)vetores[i],p);
					distMap.put(vetores[i], dist);
					d.put(vetores[i], dist);
				} 
			}
		}
		
		long endTime = System.nanoTime() - startTime;
		
		String vert = vertDest;
		do{
			System.out.print(vert +" ");
			vert = s.get(vert);
		}while(!vert.equals(vertOrigem));
		System.out.println(vertOrigem);
		System.out.println("Distancia ="+distMap.get(vertDest));
		System.out.println("Iteracoes = "+iteracoes);
		System.out.println("Runtime = "+endTime);
	}
		
	private int buscaAresta(String ori,String dest){
		int ind1 = Integer.parseInt(ori.substring(1))-1;
		int ind2 = Integer.parseInt(dest.substring(1))-1;
		return matrizAdjPon[ind1][ind2];
		
	}
	
	private String menorDe(Map<String, Integer> distMap,ArrayList<String> N){
		
		int menor = 101;
		String VetorProx = new String();
		
		String[] Nvetor = new String[distMap.size()];
		Nvetor = N.toArray(Nvetor);
		for(int i = 0;i<N.size();i++){
			distMap.remove(Nvetor[i]);
		}
		
		String[] vetores = distMap.keySet().toArray(new String[0]);
		
		for(int i= 0; i<distMap.size(); i++){
			if(distMap.get(vetores[i])<menor){
				menor = distMap.get(vetores[i]);
				VetorProx = vetores[i];
			}
		}
		return VetorProx;
	}
	
	private void grausMatriz(){
		
		grauMinimo = verificaGrauVertice("v1");
		grauMaximo = verificaGrauVertice("v1");
		grauMedio = verificaGrauVertice("v1");
		
		for(String key:arrayVertice.keySet()){
			
			grauMedio = (grauMedio + verificaGrauVertice(arrayVertice.get(key).getID()))/2;
			
			if(verificaGrauVertice(arrayVertice.get(key).getID()) < grauMinimo){
				grauMinimo = verificaGrauVertice(arrayVertice.get(key).getID());
			}
			
			if(verificaGrauVertice(arrayVertice.get(key).getID()) >= grauMaximo){
				grauMaximo = verificaGrauVertice(arrayVertice.get(key).getID());
			}
		}
	}
	
	public String obterAdjacentes(String vertic){
		
		int index = Integer.parseInt(vertic.substring(1));
		
		String adjacentes = "";
		
		if(arrayVertice.containsKey(vertic)){
			for (int j = 0; j<arrayVertice.size(); j++){
				if(matrizAdj[index-1][j] == 1){
					String adj = "v"+(j+1)+" ";
					adjacentes = adjacentes + adj;
				}
			}
		}
		return adjacentes;
	}
	
	public int verificaGrauVertice(String nome){
		int grau = 0;
		int index = Integer.parseInt(nome.substring(1));
	
		
		if(arrayVertice.containsKey(nome)){
			for(int j = 0;j<arrayVertice.size();j++){
				grau = matrizAdj[index-1][j] + grau;
				if ((index-1 == j)&&(matrizAdj[index-1][j] == 1)){
					grau = grau + 1;
				}
			} 
		} else {
			return -1;
		}
		return grau;
	}
	
	private void criaMatriz(){
		matrizAdj = new int [arrayVertice.size()][arrayVertice.size()];
		matrizAdjPon = new int [arrayVertice.size()][arrayVertice.size()];
		
		for (int i = 0; i<arrayVertice.size(); i++){
			for (int j = 0; j<arrayVertice.size(); j++){
				matrizAdj[i][j] = 0;
				matrizAdjPon[i][j] = 100;
				if (i==j){
					matrizAdjPon[i][j]=0;
				}
			}
		}
	}
	
	public void preencheMatriz(){
		
		criaMatriz();
		
		for(String key:arrayAresta.keySet()){
		
			int origem = Integer.parseInt(arrayAresta.get(key).getOrigem().getID().substring(1));
			
			int destino = Integer.parseInt(arrayAresta.get(key).getDestino().getID().substring(1));
			
			
			matrizAdjPon[origem-1][destino-1] = arrayAresta.get(key).getPeso();
			matrizAdjPon[destino-1][origem-1] = arrayAresta.get(key).getPeso();
		}
		
		for(String key:arrayAresta.keySet()){
			
			int origem = Integer.parseInt(arrayAresta.get(key).getOrigem().getID().substring(1));
			int destino = Integer.parseInt(arrayAresta.get(key).getDestino().getID().substring(1));
				
			matrizAdj[origem-1][destino-1] = 1;
			matrizAdj[destino-1][origem-1] = 1;
		}
		
		grausMatriz();
	}
	
	public void imprimiMatriz(){
		preencheMatriz();
		
		for (int i = 0; i<arrayVertice.size(); i++){
			for (int j = 0; j<arrayVertice.size(); j++){
				System.out.print(" "+ matrizAdj[i][j]);
			}
			System.out.println();
		}
		System.out.println("");
		for (int i = 0; i<arrayVertice.size(); i++){
			for (int j = 0; j<arrayVertice.size(); j++){
				System.out.print(" "+ matrizAdjPon[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean VerificaAresta(String nome){
		
		return arrayAresta.containsKey(nome);
	}
	
	public void addAresta(String[] tx){
		if(!arrayAresta.containsKey(tx[0])){
			
			Aresta a = new Aresta();
			a.setID(tx[0]);
			a.setOrigem(arrayVertice.get(tx[1]));
			a.setDestino(arrayVertice.get(tx[2]));
			a.setPeso(tx[3]);
			arrayAresta.put(a.getID(), a);
		} else {
			System.out.println("Aresta "+tx[0]+"j‡ exiti!");
		}
	}
	
	public void removeAresta(String nome){
		if(arrayAresta.containsKey(nome)){
			arrayAresta.remove(nome);
			System.out.println("Aresta removida");
		} else {
			System.out.println("Aresta n‹o existi!");
		}
	}
	
	public void txtGrafo(){
		String texto;
		File file = new File(System.getProperty("user.home"), "grafo.txt");
		int i = 0;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((texto = br.readLine()) != null){
				if(texto.startsWith("v")){
					Vertice v = new Vertice();
					v.setID(texto);
					arrayVertice.put(texto, v);
					ordemVertice[i] = texto;
					i++;
					//System.out.println(arrayVertice.get(texto).getID());
				} else {
					String[] tx = texto.split(" ");
					addAresta(tx);
				}
			}
			br.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}

