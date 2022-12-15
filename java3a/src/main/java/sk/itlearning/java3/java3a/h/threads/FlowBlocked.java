package sk.itlearning.java3.java3a.h.threads;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import sk.itlearning.java3.java3a.i.time.DateUtil;

public class FlowBlocked {

	public static void main(String[] args) throws IOException {

		LocalDateTime start = LocalDateTime.now();

		AtomicLong p1 = new AtomicLong();
		new SpocitajSubory().spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p1);
		LocalDateTime stop = LocalDateTime.now();

		System.out.println(p1.get());
		System.out.println(DateUtil.getDurationFormatted(start, stop));

		for (int i = 0; i < 10; i++) {
			AtomicLong p2 = new AtomicLong();
			new SpocitajSubory().spocitajSubory(new File("C:\\Windows\\System32\\drivers"), p2);
			System.out.println(p2.get());
		}

		stop = LocalDateTime.now();
		System.out.println(DateUtil.getDurationFormatted(start, stop));

	}

}
