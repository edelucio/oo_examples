import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoBanco {

	String host, porta, banco, usuario, senha;
	
	Connection conexao = null;  
    Statement stmt = null;  
    ResultSet rs = null;
	
	public ConexaoBanco(String host, String porta, String banco, String usuario, String senha){
		this.host = host;
		this.porta = porta;
		this.banco = banco;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public String getURLdeConexao(){
		return "jdbc:sqlserver://" + host + ":" + porta + ";" +  
		         "databaseName=" + banco + ";user=" + usuario + ";password=" + senha;
	}
	
	public void estabeleConexao(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	        conexao = DriverManager.getConnection(getURLdeConexao());
		}
		catch (Exception e) {  
	         e.printStackTrace();  
	    }
	}
	
	public void executaConsulta1(){
		try {
			String consulta1 = 
	        		 "SELECT " +
							 "	[CNPJ POSTO] = P.CNPJ, " +
							 "	[RAZÃO SOCIAL POSTO] = P.RAZAO_SOCIAL, " +
							 "	[BANCO POSTO] = B.BANCO, " +
							 "	[AGÊNCIA POSTO] = B.AGENCIA, " +
							 "	[CONTA POSTO] = B.CONTA_CORRENTE, " + 
							 "	[NOME FANTASIA CLIENTE] = C.NOME_FANTASIA, " + 
							 "	[BANCO CLIENTE] = B1.BANCO, " +
							 "	[AGÊNCIA CLIENTE] = B1.AGENCIA, " +
							 "	[CONTA CLIENTE] = B1.CONTA_CORRENTE, " + 
							 "	[DATA ABASTECIMENTO] = A.DATA_ABASTECIMENTO, " +
							 "	[DATA VENCIMENTO] = A.DATA_VENCIMENTO, " +
							 "	[DATA PAGAMENTO] = A.DATA_PAGAMENTO, " +
							 "	[VALOR DO ABASTECIMENTO] = A.VALOR " +
							 "	FROM ABASTECIMENTO A INNER JOIN POSTO P ON A.ID_POSTO = P.ID_POSTO " +
							 "		INNER JOIN CONTA_BANCO B " +
							 "			ON B.ID_POSTO = P.ID_POSTO " +
							 "		INNER JOIN CLIENTE C " +
							 "			ON C.CPF_CNPJ = A.CPF_CNPJ_CLIENTE " +
							 "		INNER JOIN CONTA_BANCO B1 " +
							 "			ON B1.ID_CLIENTE = C.ID_CLIENTE " +
							 "	WHERE A.TIPO_PAGAMENTO LIKE 'CONVENIO' AND C.TIPO = 'J'";  
	                        
	         stmt = conexao.createStatement();  
	         rs = stmt.executeQuery(consulta1);

	         imprimeConsulta1(rs);
		}
		catch (Exception e) {  
	         e.printStackTrace();  
	    }
	}
	
	public void imprimeConsulta1(ResultSet rs){
		try {
			
			System.out.println("\n===============================");
	        System.out.println("\nCONSULTA 1\n\n");
			
			// itera os dados das tuplas resultantes e mostra-os  
	         while (rs.next()) {
	            System.out.println("[CNPJ DO POSTO]: " + rs.getString(1));
	            System.out.println("[RAZÃO SOCIAL DO POSTO]: " + rs.getString(2));
	            System.out.println("[BANCO DO POSTO]: " + rs.getString(3));
	            System.out.println("[AGÊNCIA DO POSTO]: " + rs.getString(4));
	            System.out.println("[CONTA DO POSTO]: " + rs.getString(5));
	            
	            System.out.println("[NOME FANTASIA DO CLIENTE]: " + rs.getString(6));
	            System.out.println("[BANCO DO CLIENTE]: " + rs.getString(7));
	            System.out.println("[AGÊNCIA DO CLIENTE]: " + rs.getString(8));
	            System.out.println("[CONTA DO CLIENTE]: " + rs.getString(9));
	            
	            System.out.println("[DATA DO ABASTECIMENTO]: " + rs.getString(10));
	            System.out.println("[DATA DE VENCIMENTO]: " + rs.getString(11));
	            System.out.println("[DATA DE PAGAMENTO]: " + rs.getString(12));
	            System.out.println("[VALOR DO ABASTECIMENTO]: " + rs.getString(13));
	            System.out.println("\n");
	         }
	         
	         if (rs != null){
	        	 try {
	        		 rs.close();
	        	}
	         	catch(Exception e) {}
	         }
	        	   
	         if (stmt != null){
	        	 try { 
	        		 stmt.close();
	        	} 
	         	catch(Exception e) {}
	         }
		}
		catch (Exception e) {  
	         e.printStackTrace();  
	    }
	}
	
	public void executaConsulta2(){
		try {
			String consulta2 = 
	        		 "SELECT " + 
	        				 "	[MÊS] = MONTH(A.DATA_ABASTECIMENTO), " + 
	        				 "	[CLIENTE] = C.NOME, 	[CPF] = C.CPF_CNPJ, " + 
	        				 "	[QTD ABASTECIMENTO] = COUNT(A.ID_ABASTECIMENTO), " + 
	        				 "	[VALOR ABASTECIMENTO] = SUM(A.VALOR), " + 
	        				 "	[QTD PONTOS] = SUM(F.QTD_PONTOS) " + 
	        				 "	FROM CLIENTE C " + 
	        				 "	INNER JOIN ABASTECIMENTO A " + 
	        				 "	ON A.CPF_CNPJ_CLIENTE = C.CPF_CNPJ " + 
	        				 "	INNER JOIN FIDELIDADE F " + 
	        				 "	ON F.ID_ABASTECIMENTO = A.ID_ABASTECIMENTO " + 
	        				 "	WHERE C.TIPO = 'F' " + 
	        				 "	GROUP BY C.NOME, C.CPF_CNPJ, MONTH(A.DATA_ABASTECIMENTO) " + 
	        				 "	\r\n" + 
	        				 "	UNION\r\n" + 
	        				 "	\r\n" + 
	        				 "	SELECT	[MÊS] = MONTH(A.DATA_ABASTECIMENTO),\r\n" + 
	        				 "	[CLIENTE] = D.NOME, 	\r\n" + 
	        				 "	[CPF] = D.CPF,\r\n" + 
	        				 "	[QTD ABASTECIMENTO] = COUNT(A.ID_ABASTECIMENTO),\r\n" + 
	        				 "	[VALOR ABASTECIMENTO] = SUM(A.VALOR),\r\n" + 
	        				 "	[QTD PONTOS] = SUM(F.QTD_PONTOS)\r\n" + 
	        				 "	FROM DEPENDENTE_PF D\r\n" + 
	        				 "		INNER JOIN ABASTECIMENTO A \r\n" + 
	        				 "			ON A.ID_DEPENDENTE = D.ID_DEP_PF\r\n" + 
	        				 "		INNER JOIN FIDELIDADE F\r\n" + 
	        				 "	    	ON F.ID_ABASTECIMENTO = A.ID_ABASTECIMENTO\r\n" + 
	        				 "	GROUP BY D.NOME, D.CPF, MONTH(A.DATA_ABASTECIMENTO)"; 
	         
	         stmt = conexao.createStatement();  
	         rs = stmt.executeQuery(consulta2);
	         
	         imprimeConsulta2(rs);
		}
		catch (Exception e) {  
	         e.printStackTrace();  
	    }
	}
	
	public void imprimeConsulta2(ResultSet rs){
		try {
			
			System.out.println("\n===============================");
	        System.out.println("\nCONSULTA 2\n\n");
	         
	         while (rs.next()) {
	            System.out.println("[MÊS]: " + rs.getString(1));
	            System.out.println("[CLIENTE]: " + rs.getString(2));
	            System.out.println("[QUANTIDADE DE ABASTECIMENTOS]: " + rs.getString(4));
	            System.out.println("[VALOR DO ABASTECIMENTO]: " + rs.getString(5));
	            System.out.println("[QUANTIDADE DE PONTOS]: " + rs.getString(6));
	            System.out.println("\n");  
	         }
	         
	         if (rs != null){
	        	 try {
	        		 rs.close();
	        	}
	         	catch(Exception e) {}
	         }
	        	   
	         if (stmt != null){
	        	 try { 
	        		 stmt.close();
	        	} 
	         	catch(Exception e) {}
	         }
		}
		catch (Exception e) {  
	         e.printStackTrace();  
	    }
	}
	
	public void fechaConexao(){
		if (conexao != null) {  
       	 	try {
       	 		conexao.close();
       	 	} catch(Exception e) {}
        }
	}
	
}
