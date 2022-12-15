package sk.itlearning.java3.java3a.h.threads;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import sk.itlearning.java3.java3a.i.time.DateUtil;

public class FlowNotBlocked {

	public static void main(String[] args) throws IOException {

		LocalDateTime start = LocalDateTime.now();		
		
		for (int i = 0; i < 1000; i++) {
			new Thread(new SpocitajRunnable(start)).start();
		}
	}

	private static class SpocitajRunnable implements Runnable {
		private LocalDateTime start;
		
		public SpocitajRunnable(LocalDateTime start) {
			super();
			this.start = start;
		}
		
		@Override
		public void run() {
			AtomicLong p1 = new AtomicLong();
			new SpocitajSubory().spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p1);
			LocalDateTime stop = LocalDateTime.now();
			stop = LocalDateTime.now();
			System.out.println(DateUtil.getDurationFormatted(start, stop));
		}
	}

}
