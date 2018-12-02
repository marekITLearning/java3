package sk.itlearning.java3.h.threads;

public class ThreadMethodSyncing {

	static class Counter {
	    private int value = 0;

	    public synchronized void increment() {
	    	value++;
	    }

	    public synchronized void decrement() {
	    	value--;
	    }
	}

	public static void main(String[] args) {

		Counter c = new Counter();
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000000; i++) {
					c.increment();
				}
			}
		};

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000000; i++) {
					c.decrement();
				}
			}
		};

		new Thread(r1).start();
		new Thread(r2).start();
		
//		while (Thread.activeCount() > 1);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (c.value != 0) {
			System.out.println(c.value);
		}
		
	}

}
