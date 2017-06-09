package router;

import java.net.InetAddress;

public class RouterTable {
        
    public RouterTable(){
    
    }
        
    public void update_tabela(String tabela_s,  InetAddress IPAddress){
               
        System.out.println( IPAddress.getHostAddress() + ": " + tabela_s);
    
    }
    
    public String get_tabela_string(){
        String tabela_string = "Enviado!"; 
        	
        return tabela_string;
    }
   
}