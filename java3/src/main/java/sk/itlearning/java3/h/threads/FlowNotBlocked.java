package sk.itlearning.java3.h.threads;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FlowNotBlocked {

	public static void main(String[] args) throws IOException {
		
		final Date start = new Date();
		
		new Thread(new SpocitajRunnable(start)).start();
		new Thread(new SpocitajRunnable(start)).start();
		new Thread(new SpocitajRunnable(start)).start();
		new Thread(new SpocitajRunnable(start)).start();
		new Thread(new SpocitajRunnable(start)).start();
		
	}
	
	private static class SpocitajRunnable implements Runnable {
		Date start;
		
		public SpocitajRunnable(Date start) {
			this.start = start;
		}
		
		@Override
		public void run() {
			MutableLong p = new MutableLong();
			new SpocitajSubory().spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p);
			Date stop1 = new Date();
			double seconds = (stop1.getTime() - start.getTime()) / 1000.0;
			System.out.println("Pocet suborov: " + p.value + " vyhladane za (sekund): " + seconds);
		}
		
	}

}
