package sk.itlearning.java3.h.threads;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FlowNotBlocked {

	private static class SpocitajSubory implements Runnable {
		final Date start = new Date();
		@Override
		public void run() {
			Pocty p1 = new Pocty();
			spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p1);
			Date stop1 = new Date();
			long seconds = (stop1.getTime() - start.getTime()) / 1000;
			System.out.println("Pocet suborov: " + p1.nrFiles + " vyhladane za (sekund): " + seconds);
		}
	}
	
	public static void main(String[] args) throws IOException {

		final Date start = new Date();
		
		new Thread(new SpocitajSubory()).start();
		new Thread(new SpocitajSubory()).start();
		new Thread(new SpocitajSubory()).start();
		new Thread(new SpocitajSubory()).start();
		new Thread(new SpocitajSubory()).start();
		
		
		
	}

	private static class Pocty {
		long nrFiles;
	}

	private static void spocitajSubory(File vAdresari, Pocty p) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!vAdresari.isDirectory()) {
			p.nrFiles++;
			return; // subory mozu byt vyhladavane len v adresari
		}
		if (vAdresari.listFiles() != null && vAdresari.listFiles().length > 0) {
			for (File x : vAdresari.listFiles()) {
				spocitajSubory(x, p);
			}
		}
	}

}
