package sk.itlearning.java3.h.threads;

import java.math.BigDecimal;

public class ThreadMethodSyncing {

	static class Counter {
	    private BigDecimal value;
	    
	    public Counter(BigDecimal value) {
	    	this.value = value;
	    }

	    public Counter increment() {
	        Counter c = new Counter(value);
	        c.value = new BigDecimal(c.value.intValue() + 1);
	        return c;
	    }

	    public Counter decrement() {
	        Counter c = new Counter(value);
	        c.value = new BigDecimal(c.value.intValue() - 1);
	        return c;
	    }
	}

	public static void main(String[] args) {

		final Counter c = new Counter(new BigDecimal(0));
		double[] d = {0};
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					d[0] = c.increment().value.doubleValue();
					System.out.println(c.value);
				}
			}
		};

		System.out.println(d[0]);
		
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					c.decrement();
					System.out.println(c.value);
				}
			}
		};

		new Thread(r1).start();
		new Thread(r2).start();
		System.out.println();

	}

}
