package roteador;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

class Cliente extends Thread {

	Socket conexao;
	String ip = "";
	int custo;
	ObjectInputStream entrada;
	ObjectOutputStream saida;

	public Cliente(String ip, int custo) throws IOException {
		this.ip = ip;
		this.custo = custo;
	}


	@SuppressWarnings({ "unchecked", "unused" })
	public void run() {
		try {
			
			conexao = new Socket(ip, 80);
			Roteador.vizinhos.add(ip);
			saida = new ObjectOutputStream(conexao.getOutputStream());
			entrada = new ObjectInputStream(conexao.getInputStream());
			System.out.println(InetAddress.getLocalHost().toString() + " Conectado ao vizinho: " + ip + " com custo: " + custo);
			if(Roteador.tabela.containsKey(ip)) {
				if(Roteador.tabela.get(ip) > custo) {
					Roteador.tabela.put(ip, custo);
					Roteador.pulo.put(ip, ip);
				}
			}
			else {
				Roteador.tabela.put(ip, custo);
				Roteador.pulo.put(ip, ip);
			}

			while (true) {
				Roteador.display();
				HashMap<HashMap<String, Integer>, HashMap<String, String>> enviar;
				enviar = new HashMap<HashMap<String,Integer>, HashMap<String,String>>();
				enviar.put(Roteador.tabela, Roteador.pulo);
				
				saida.writeObject(enviar);
				saida.reset();

				HashMap<HashMap<String, Integer>, HashMap<String, String>> receber;
				
				receber = (HashMap<HashMap<String,Integer>, HashMap<String,String>>) entrada.readObject();
				HashMap<String, Integer>tempo = (HashMap<String, Integer>) receber.keySet().toArray()[0];
				HashMap<String, String> tempoPulo = receber.get(tempo);				
				Iterator it = (Iterator) tempo.entrySet().iterator();
				Roteador.atualizaTabela(tempo, ip, tempoPulo);
				Thread.sleep(1000);
			}

		} catch (UnknownHostException e) {
			System.out.println("Sem conexão com a rede: "
					+ e.getMessage());
		} catch (IOException e) {
			System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}