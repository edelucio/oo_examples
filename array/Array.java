package array;

public class Array {
	
	public static void main(String[] args){
		
		
		String[] a = new String[3]; 
		
		a[0] = "Rex";
		a[1] = "Apolo";
		a[2] = "Bidu";
		
		int[] array = new int[3];
		
		for (int x = 0; x < array.length; x++)
			System.out.println("Nome do Cachorro: "+ a[x]);
							
		int numero = 0;
		
		while (numero < 3){
			System.out.println("Array: "+ numero);
			numero ++;
		}
		
	}	
		
}
