package sk.itlearning.java3.h.threads;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FlowNotBlockedRunnable {

	public static void main(String[] args) throws IOException {
		Date start = new Date();
		for (int i = 0; i < 1000; i++) {
			RunnableSpocitajSubory r = new RunnableSpocitajSubory();
			Pocty p = new Pocty();
			p.start = start;
			r.setP(p);
			new Thread(r).start();
		}
	}

	private static class RunnableSpocitajSubory implements Runnable {
		private Pocty p;
		@Override
		public void run() {
			spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p);
			Date stop = new Date();
			long seconds = (stop.getTime() - p.start.getTime()) / 1000;
			System.out.println("Pocet suborov: " + p.nrFiles + " vyhladane za (sekund): " + seconds);
		}
		public void setP(Pocty p) {
			this.p = p;
		}
	}

	private static class Pocty {
		private long nrFiles;
		private Date start;
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
