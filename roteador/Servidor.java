package roteador;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

class Servidor extends Thread {

	private static ServerSocket servidor;
	private Socket conexao;
	ObjectInputStream entrada;
	ObjectOutputStream saida;

	public Servidor() throws IOException {
		servidor = new ServerSocket();
	}

	public void run() {
		try {
			accept();
		} catch (UnknownHostException | ClassNotFoundException e) {
			((Throwable) e).printStackTrace();
		}
	}

	public void accept() throws UnknownHostException, ClassNotFoundException {
		try {
			int count = 0;
			while (count < 2) {
				count++;
				System.out.println(InetAddress.getLocalHost() + " esperando conexão " + count);
				
				conexao = servidor.accept();
				System.out.println(InetAddress.getLocalHost() + " conectado com " + conexao.getInetAddress());
				String[] connectionIP = conexao.getInetAddress().toString().split("/");
				Roteador.vizinhos.add(connectionIP[1]);
				saida = new ObjectOutputStream(conexao.getOutputStream());
				entrada = new ObjectInputStream(conexao.getInputStream());
			
				new Thread(new Runnable() {
				
					@SuppressWarnings("unchecked")
					@Override
					public void run() {
						while (true) {
							try {
								HashMap<HashMap<String, Integer>, HashMap<String, String>> receber;
								
								receber = (HashMap<HashMap<String,Integer>, HashMap<String,String>>) entrada.readObject();
								HashMap<String, Integer>temp = (HashMap<String, Integer>) receber.keySet().toArray()[0];
								HashMap<String, String> tempHop = receber.get(temp);
								@SuppressWarnings("unused")
								Iterator it = (Iterator) temp.entrySet().iterator();
								Roteador.atualizaTabela(temp, connectionIP[1], tempHop);
								HashMap<HashMap<String, Integer>, HashMap<String, String>> enviar;
								enviar = new HashMap<HashMap<String,Integer>, HashMap<String,String>>();
								enviar.put(Roteador.tabela, Roteador.pulo);
								
								saida.writeObject(enviar);
								saida.reset();
								Roteador.display();
								Thread.sleep(1000);
							} catch (Exception e) {
								System.exit(0);
							}
						}
					}
				}).start();

			}
		} catch (IOException e) {
			System.exit(0);
		}
	}
}