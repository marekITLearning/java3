package sk.itlearning.java3.java3a.h.threads;

import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

class SpocitajSubory {

	void spocitajSubory(File vAdresari, AtomicLong pocet) {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (vAdresari.isFile()) {
			pocet.incrementAndGet();
		}
		if (vAdresari.listFiles() != null) {
			for (File f : vAdresari.listFiles()) {
				spocitajSubory(f, pocet);
			}
		}
	}

	void spocitajSuboryNotify(File vAdresari, AtomicLong p) {

	}

}
