package forma;

public class TesteForma {

	public static void main(String[] args){

		Amoeba amoeba = new Amoeba();
		Circulo circulo = new Circulo();
		Quadrado quadrado = new Quadrado();
		Triangulo triangulo = new Triangulo(5,50,"Triangulo: Toc-Toc");
		
		amoeba.x = 2;
		amoeba.y = 20;
		amoeba.sampler = "Blim-Blom ";
		amoeba.girar();
		amoeba.tocarSom();
		
		circulo.x = 3;
		circulo.y = 30;
		circulo.sampler = "Trimmmm ";
		circulo.girar();
		circulo.tocarSom();
		
		quadrado.x = 4;
		quadrado.y = 40;
		quadrado.sampler = "Tra-ta-ta-ta ";
		quadrado.girar();
		quadrado.tocarSom();
		
		triangulo.girar();
		triangulo.tocarSom();
			
	}
}
