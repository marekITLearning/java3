package sk.itlearning.java3.h.threads;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ThreadCom {

	public static void main(String[] args) throws IOException {

		final Date start = new Date();

		final Pocty p1 = new Pocty();
		
		final ThreadCom i1 = new ThreadCom();
		
		Thread t1 = new Thread() {
			public void run() {
				i1.spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p1);
				Date stop1 = new Date();
				long seconds = (stop1.getTime() - start.getTime()) / 1000;
				System.out.println("Pocet suborov: " + p1.nrFiles + " vyhladane za (sekund): " + seconds);
			}
		};
		t1.start();

		try {
			synchronized (i1) {
				i1.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

		ThreadCom i2 = new ThreadCom();
		Pocty p2 = new Pocty();
		i2.spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p2);
		Date stop2 = new Date();
		long seconds = (stop2.getTime() - start.getTime()) / 1000;
		System.out.println("Pocet suborov: " + p2.nrFiles + " vyhladane za (sekund): " + seconds);

	}

	private static class Pocty {
		long nrFiles;
	}

	private void spocitajSubory(File vAdresari, Pocty p) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!vAdresari.isDirectory()) {
			p.nrFiles++;
			if (p.nrFiles == 200) {
				synchronized (this) {
					this.notifyAll();						
				}
			}
			return; // subory mozu byt vyhladavane len v adresari
		}
		if (vAdresari.listFiles() != null && vAdresari.listFiles().length > 0) {
			for (File x : vAdresari.listFiles()) {
				spocitajSubory(x, p);
			}
		}
	}

}
