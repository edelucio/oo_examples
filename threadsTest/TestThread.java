package threadsTest;

import java.util.Scanner;

public class TestThread {

	public static void main(String[] args) {
		int numThreads = 10;
		PrintingThread[] threads = new PrintingThread[numThreads];

		for (int i = 0; i < numThreads; i++) {
			threads[i] = new PrintingThread(i);
			threads[i].start();
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Pressione ENTER...");
		while (true) { // Loop do ENTER.. para fazer uma vez, comentar essa linha e descomentar as demais.
		scanner.nextLine(); // Espera ENTER...

//		pararExecucao(threads);
		imprimirResultado(threads);
		}
//		scanner.close();
	}

//	private static void pararExecucao(PrintingThread[] threads) {
//		for (PrintingThread t : threads) {
//			t.stop();
//		}
//	}

	private static void imprimirResultado(PrintingThread[] threads) {
		for (PrintingThread t : threads) {
			System.out.printf("Thread %d -> %d prints\n", t.getId(), t.getCount());
		}
	}
}

