package sk.itlearning.java3.h.threads;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class SpocitajCezSiet {

	private static int nrFiles;

	public static void main(String[] args) throws IOException {

		LocalDateTime start = LocalDateTime.now();

		spocitajSubory(new File("L:"));
		
		while(Thread.activeCount() > 1);

		System.out.println(nrFiles);

		System.out.println(Duration.between(start, LocalDateTime.now()).getSeconds());

	}

	private static void spocitajSubory(File vAdresari) {
		if (!vAdresari.isDirectory()) {
			nrFiles++;
			return;
		}
		if (vAdresari.listFiles() != null) {
			for (File x : vAdresari.listFiles()) {
				Thread t = new Thread() {
					public void run() {
						spocitajSubory(x);
					}
				};
				t.start();
			}
		}
	}


}
