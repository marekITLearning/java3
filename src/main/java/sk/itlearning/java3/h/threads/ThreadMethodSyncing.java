package sk.itlearning.java3.h.threads;

import java.math.BigDecimal;

public class ThreadMethodSyncing {

	static class Counter {
	    private BigDecimal value = new BigDecimal(0);

	    public synchronized void increment() {
	    	value = value.add(new BigDecimal(1));
	    }

	    public synchronized void decrement() {
	    	value = value.add(new BigDecimal(-1));
	    }

	}

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			
		final BigDecimal c = new BigDecimal(0);
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100_000; i++) {
					c.add(new BigDecimal(1));
				}
			}
		};

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100_001; i++) {
					c.add(new BigDecimal(-1));
				}
			}
		};

		new Thread(r1).start();
		new Thread(r2).start();

		while(Thread.activeCount() > 1){};		
		
		if (c.intValue() != 0) {
			System.out.println(c.intValue());
		}
		
		}
	}

}
