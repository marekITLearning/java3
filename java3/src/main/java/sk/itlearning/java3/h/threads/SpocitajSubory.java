package sk.itlearning.java3.h.threads;

import java.io.File;

class SpocitajSubory {

	void spocitajSubory(File vAdresari, MutableLong p) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!vAdresari.isDirectory()) {
			p.value++;
			return;
		}
		if (vAdresari.listFiles() != null && vAdresari.listFiles().length > 0) {
			for (File x : vAdresari.listFiles()) {
				spocitajSubory(x, p);
			}
		}
	}

	void spocitajSuboryNotify(File vAdresari, MutableLong p) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!vAdresari.isDirectory()) {
			p.value++;
			if (p.value == 200) {
				synchronized (this) {
					this.notify();
				}
			}
			return;
		}
		if (vAdresari.listFiles() != null && vAdresari.listFiles().length > 0) {
			for (File x : vAdresari.listFiles()) {
				spocitajSuboryNotify(x, p);
			}
		}
	}
}
