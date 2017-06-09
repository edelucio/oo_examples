package roteador;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Roteador {

	public static HashMap<String, Integer> tabela;

	static String[] localIP;

	static ArrayList<String> vizinhos;
	
	public static HashMap<String, String> pulo;
	
	public static String mascaraSubRede = "255.255.255.0";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		tabela = new HashMap<String, Integer>();
		pulo = new HashMap<String, String>();
		vizinhos = new ArrayList<String>();
		System.out.println(InetAddress.getLocalHost() + " Conexão Iniciada");
		localIP = InetAddress.getLocalHost().toString().split("/");
		System.out.println("Posição Atualizada 1");
		tabela.put(localIP[1], 0);
		pulo.put(localIP[1], localIP[1]);
		
		Servidor servidor = new Servidor();
		servidor.start();

		int tamanho = args.length;
		
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < tamanho; i++) {
			System.out.println("Digite o custo " + args[i].toString());
			int custo = scan.nextInt();
			new Cliente(args[i], custo).start();
		}
		scan.close();
	}
	
	public static void atualizaTabela(Map<String, Integer> tempo, String enviandoIp, Map<String, String> tempoPulo) {
					
		if (tabela.containsKey(enviandoIp) && tempo.containsKey(localIP[1])) {
			if (tabela.get(enviandoIp) > tempo.get(localIP[1])) {
				tabela.put(enviandoIp, tempo.get(localIP[1]));
				if(tempoPulo.get(localIP[1]).equals(localIP[1])) {
					pulo.put(enviandoIp, enviandoIp);
				}
				else {
					for(int i = 0; i < vizinhos.size(); i++) {
						if(!vizinhos.get(i).equals(enviandoIp)) {
							pulo.put(enviandoIp, vizinhos.get(i));
						}
					}
				}
				
			}
		}
		
		if (!tabela.containsKey(enviandoIp)) {
			tabela.put(enviandoIp, tempo.get(localIP[1]));
			pulo.put(enviandoIp, enviandoIp);
		}

		@SuppressWarnings("rawtypes")
		Iterator it = tempo.entrySet().iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry) it.next();
			String ip = pair.getKey().toString();
			if (!tabela.containsKey(ip)) {
				tabela.put(ip, Integer.parseInt(pair.getValue().toString())
						+ tabela.get(enviandoIp));
				pulo.put(ip, enviandoIp);
			}

			else {
				if (tabela.get(ip) > (Integer.parseInt(pair.getValue()
						.toString()) + tabela.get(enviandoIp))) {
					tabela.put(
							ip,
							(Integer.parseInt(pair.getValue().toString()) + tabela
									.get(enviandoIp)));
					pulo.put(ip, enviandoIp);
				}
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void display() {
				
		Iterator it = tabela.entrySet().iterator();
		System.out.println("------ TABELA ATUALIZADA -----");
		System.out.println("Destino" + '\t' + "Máscara Subrede" + '\t' + "Custo" + '\t' + "Próximo Pulo");
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			String[] ipSubParts = pair.getKey().toString().split("\\.");
			String[] subnetSubParts = mascaraSubRede.split("\\.");
			String[] netID = new String[4];
			for(int i = 0; i < ipSubParts.length; i++) {
				netID[i] = Integer.toString((Integer.parseInt(ipSubParts[i]) & Integer.parseInt(subnetSubParts[i])));
			}
			String networkID = netID[0] + "." + netID[1] + "." + netID[2] + "." + netID[3];
			System.out.println(networkID + '\t' + mascaraSubRede + '\t' + pair.getValue() + '\t' + pulo.get(pair.getKey().toString()));
		}
		System.out.println();
		System.out.println("----------------------------------------------");
	}

}