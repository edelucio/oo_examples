public class Principal {  

   public static void main(String[] args) {  
	   
	  ConexaoBanco conexao = new ConexaoBanco("ELUCIANO", "1433", "BD_POSTO", "sa", "123456");
      conexao.estabeleConexao();

      conexao.executaConsulta1();
      conexao.executaConsulta2();
      
      conexao.fechaConexao();
	   
   } //main  
}//class