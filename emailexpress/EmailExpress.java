package emailexpress;

import java.util.ArrayList;

public class EmailExpress {
	
		public String meuEmail;
		public MensagemDeEmail[] emailsNovos;
		public ArrayList<String> emailsAmigos;
		public ArrayList<MensagemDeEmail> caixaDeSaida;
		
		public void listarEmailsRecentes(){
			System.out.println("Apresentando as mensagens:" + meuEmail);
			
			int total = 0;
			
			for (int i=0; i < emailsNovos.length; i++){
				if (emailsNovos[i] != null){
					total++;
				}
			}
		
			System.out.println("A quantidade de emails novos eh: " + total);
			
			for (int i=0; i < emailsNovos.length; i++){
				if (emailsNovos[i] != null) {
					System.out.println((i + 1) + " - " + emailsNovos[i].assunto + 
												 " - " + emailsNovos[i].getEmailDoRemetente());
				}
			}
		}
		
		public boolean escreverEmail(){
			
			String enderecoDeEmail = null;
			String assuntoDeEmail;
			String mensagemDeEmail;
			
			if (enderecoDeEmail == null || !enderecoDeEmail.equals("")){
				System.out.println("O email de destino deve ser preenchido corretamante.");
				return false;
				
				}
			return false;
		}
}


