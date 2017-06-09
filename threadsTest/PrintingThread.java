package threadsTest;

import java.util.Random;
import java.util.logging.Logger;

public class PrintingThread implements Runnable {

	private static final Random RANDOM = new Random();
	private static final int TEMPO_MAX = 10000;

	private final int id;
	private final int tempoDeEspera;

	private int count = 0;
	private boolean running = true;

	public PrintingThread(int id) {
		this.id = id;
		this.tempoDeEspera = RANDOM.nextInt(TEMPO_MAX) + 1;
	}

	@Override
	public void run() {
		while (running) {
			try {
				count++;
				Thread.sleep(tempoDeEspera);
			} catch (InterruptedException e) {
				Logger.getAnonymousLogger().warning(e.getMessage());
			}
		}
	}

	public int getId() {
		return id;
	}
	
	public int getCount() {
		return count;
	}

	public void start() {
		new Thread(this).start();
	}

	public void stop() {
		running = false;
	}
}