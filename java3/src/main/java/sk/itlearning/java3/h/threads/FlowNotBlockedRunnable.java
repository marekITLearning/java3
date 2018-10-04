package sk.itlearning.java3.h.threads;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class FlowNotBlockedRunnable {
	
	public static void main(String[] args) throws IOException {
		
		LocalDateTime start = LocalDateTime.now();
		
		for (int i = 0; i < 100; i++) {
			SpocitajRunnable r = new SpocitajRunnable(start);
			new Thread(r).start();
		}
		
	}

	private static class SpocitajRunnable implements Runnable {
		LocalDateTime start;
		
		public SpocitajRunnable(LocalDateTime start) {
			this.start = start;
		}
		
		@Override
		public void run() {
			MutableLong p = new MutableLong();
			new SpocitajSubory().spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p);
			System.out.println(Duration.between(start, LocalDateTime.now()).getNano() / 1_000_000_000.0);
		}
		
	}

}
