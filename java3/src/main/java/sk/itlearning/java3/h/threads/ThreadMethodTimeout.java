package sk.itlearning.java3.h.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThreadMethodTimeout {

	public static void main(String[] args) {

		Timeoutable t = new Timeoutable();
		t.casovoObmedzenaMetoda();
		System.out.println(t.vysledok);

	}

	private static class Timeoutable {
		boolean timeout = false;
		FileReader vysledok;

		public void casovoObmedzenaMetoda() {

			Runnable casovoNarocnyBlok = new Runnable() {
				@Override
				public void run() {
				    String fileName = "C:\\test\\a.txt";
				    File file = new File(fileName);
				    FileReader fr = null;
				    while (fr == null && !timeout) {
					    try {
							fr = new FileReader(file);
						} catch (FileNotFoundException e) {
							fr = null;
						}
				    }
				    vysledok = fr;
				    synchronized (Timeoutable.this) {
					    timeout = true;
					    Timeoutable.this.notify();
					}
				}
			};

			Thread timer = new Thread(new MethodTimer(this), "timer");
			timer.start();


			Thread metoda = new Thread(casovoNarocnyBlok, "metoda");
			metoda.start();
			while (timeout == false) {
				try {
					synchronized (this) {
						wait();
					}
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			metoda.interrupt();
			timer.interrupt();
		}
	}

	private static class MethodTimer implements Runnable {
		private Timeoutable timeoutable;

		public MethodTimer(Timeoutable timeoutable) {
			this.timeoutable = timeoutable;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
			timeoutable.timeout = true;
			synchronized (timeoutable) {
				timeoutable.notifyAll();
			}
		}
	}

}
