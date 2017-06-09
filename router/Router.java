package router;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Router {

    public static void main(String[] args) throws IOException {
       
        ArrayList<String> ip_list = new ArrayList<>();

        try ( BufferedReader inputFile = new BufferedReader(new FileReader("IPVizinhos.txt"))) {
            String ip;
            
            while( (ip = inputFile.readLine()) != null){
                ip_list.add(ip);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Router.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        RouterTable tabela = new RouterTable();
        Thread sender = new Thread(new MessageReceiver(tabela));
        Thread receiver = new Thread(new MessageSender(tabela, ip_list));
        
        sender.start();
        receiver.start();
        
    }
    
}