package emailexpress;

public class MensagemDeEmail {
	
	private String emailDoRemetente;
	private String emailDoDestinatario;
	
	public String mensagem;
	public String assunto;
	
	public String getEmailDoRemetente() {
		return emailDoRemetente;
	}
	public void setEmailDoRemetente(String emailDoRemetente) {
		if (emailDoRemetente != null && !emailDoRemetente.equals("")){
		this.emailDoRemetente = emailDoRemetente;
		}
	}
	public String getEmailDoDestinatario() {
		return emailDoDestinatario;
	}
	public void setEmailDoDestinatario(String emailDoDestinatario) {
		if (emailDoDestinatario != null && !emailDoDestinatario.equals("")){
		this.emailDoDestinatario = emailDoDestinatario;
		}
	}
	
}

