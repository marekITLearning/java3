package sk.itlearning.java3.h.threads;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConcurrencyTest {

	public static void main(String[] args) {

		ExecutorService es = Executors.newSingleThreadExecutor();

		SpocitajSubory s1 = new SpocitajSubory();
		MutableLong ml = new MutableLong();
		
		Callable<String> callable = () -> {
			s1.spocitajSubory(new File("P:"), ml);
			return String.valueOf(ml.value);
		};
		
		Future<String> future = es.submit(callable);
	
		try {
			if (future.isDone()) {
				System.out.println(future.get());
			} else {
//				future.cancel(true);
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		es.shutdown();
	}

}
