package grafos;

public class Aresta {
	
	private String ID;
	private Vertice origem;
	private Vertice destino;
	private int peso;
	
	public Aresta() {
		super();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Vertice getOrigem() {
		return origem;
	}

	public void setOrigem(Vertice origem) {
		this.origem = origem;
	}

	public Vertice getDestino() {
		return destino;
	}

	public void setDestino(Vertice destino) {
		this.destino = destino;
	}
	
	public int getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = Integer.parseInt(peso);
	}

	public String toString(){
	
		return "Aresta = " + ID + " , Origem = " + origem.getID() + " , Destino = " + destino.getID() + " , Peso = " + peso;
	}
	
}
