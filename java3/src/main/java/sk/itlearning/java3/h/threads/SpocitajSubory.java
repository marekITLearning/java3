package sk.itlearning.java3.h.threads;

import java.io.File;

public class SpocitajSubory {

	void spocitajSubory(File vAdresari, MutableLong p) {
		if (!vAdresari.isDirectory()) {
			p.value++;
			return; // subory mozu byt vyhladavane len v adresari
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
			return; // subory mozu byt vyhladavane len v adresari
		}
		if (vAdresari.listFiles() != null && vAdresari.listFiles().length > 0) {
			for (File x : vAdresari.listFiles()) {
				spocitajSuboryNotify(x, p);
			}
		}
	}
}
