package sk.itlearning.java3.java3a.h.threads;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class T3_ThreadCommunication {

	public static void main(String[] args) throws IOException {

		final Date start = new Date();

		final AtomicLong p1 = new AtomicLong();
		
		final SpocitajSubory s1 = new SpocitajSubory();
		Thread t1 = new Thread() {
			public void run() {
				s1.spocitajSuboryNotify(new File("C:\\Windows\\System32\\drivers"), p1);
				Date stop1 = new Date();
				double seconds = (stop1.getTime() - start.getTime()) / 1000.0;
				System.out.println("Pocet suborov: " + p1.get() + " vyhladane za (sekund): " + seconds);
			}
		};
		t1.start();
		
		synchronized (s1) {
			try {
				s1.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		SpocitajSubory s2 = new SpocitajSubory();
		final AtomicLong p2 = new AtomicLong();
		s2.spocitajSuboryNotify(new File("C:\\Windows\\System32\\drivers"), p2);
		Date stop2 = new Date();
		double seconds = (stop2.getTime() - start.getTime()) / 1000.0;
		System.out.println("Pocet suborov: " + p2.get() + " vyhladane za (sekund): " + seconds);

	}

}
