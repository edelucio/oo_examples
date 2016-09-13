package email;

public class TesteEmail {

	public static void main(String[] args) {
	
Email[] entrada = new Email[3];
		
		entrada[0] = new Email("edumendes@gmail.com", 
								"marum@gmail.com", 
								"Semana de SI", 
								"Estamos atrasados");
		
		Email novo = new Email("edumendes@gmail.com", 
								"jesusmendes@gmail.com", 
								"Almoço", 
								"Não poderei ir");
		
		entrada[1] = novo;
		
		entrada[2] = new Email();
		entrada[2].de = "edumendes@gmail.com";
		entrada[2].para = "capelo@gmail.com";
		entrada[2].assunto = "Lab POO";
		entrada[2].texto = "Precisamos de outros";
		
		for (int i=0; i<entrada.length; i++){
			entrada[i] = null;
			
			
		}
		
	}

}
