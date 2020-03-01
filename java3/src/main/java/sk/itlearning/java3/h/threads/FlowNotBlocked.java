package sk.itlearning.java3.h.threads;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class FlowNotBlocked {

	public static void main(String[] args) throws IOException {
		
		final LocalDateTime start = LocalDateTime.now();
		
//		new Thread(new SpocitajRunnable(start)).start();
//		new Thread(new SpocitajRunnable(start)).start();
//		new Thread(new SpocitajRunnable(start)).start();
//		new Thread(new SpocitajRunnable(start)).start();
//		new Thread(new SpocitajRunnable(start)).start();
		
		
		for (int i = 0; i < 10000; i++) {
			new Thread(new SpocitajRunnable(start)).start();
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
			Duration dr = Duration.between(start, LocalDateTime.now());
			System.out.println(dr.getSeconds() + dr.getNano() / 1_000_000_000.0);
		}
		
	}

}
