package grafos;

public class Vertice {
	
	private String ID;
	private int grau;
	private boolean visitado;
		
	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getGrau() {
		return grau;
	}

	public void setGrau(int grau) {
		this.grau = grau;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Vertice() {
		super();
	}
	
	public int qualGrau(){
			
		return 0;
	}
	

}
