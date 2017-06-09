package router;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageSender implements Runnable{
    RouterTable tabela;
    ArrayList<String> vizinhos;
    
    public MessageSender(RouterTable t, ArrayList<String> v){
        tabela = t;
        vizinhos = v;
    }
    
    @Override
    public void run() {
        DatagramSocket clientSocket = null;
        byte[] sendData;
        InetAddress IPAddress = null;
        
        try {
            clientSocket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        while(true){
            
            String tabela_string = tabela.get_tabela_string();
               
            sendData = tabela_string.getBytes();
            
            for (String ip : vizinhos){
               
                try {
                    IPAddress = InetAddress.getByName(ip);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
                    continue;
                }
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 80);         
                
                try {
                    clientSocket.send(sendPacket);
                } catch (IOException ex) {
                    Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }
    
}