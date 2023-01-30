package sven.workshop.concurrency;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadLooping {

	private List<String> threadReady = new CopyOnWriteArrayList<>();

	Runnable worker = () -> {
		Logger.getGlobal().log(Level.INFO, Thread.currentThread().getName() + " started");
		makeFakeWork();
	};

	private synchronized void makeFakeWork() {

		while (!Thread.interrupted()) {
			// Do some Fakey McFake Work
		}
		threadReady.add(Thread.currentThread().getName());
	}

	public List<String> runMe() {

		var t3 = new Thread(worker, "Thread-3");
		var t4 = new Thread(worker, "Thread-4");
		var t5 = new Thread(worker, "Thread-5");

		t3.start();
		t4.start();
		t5.start();
		Sleeper.sleep(5);
		t3.interrupt();
		t4.interrupt();
		t5.interrupt();
		Sleeper.sleep(50);
		return threadReady;
	}

}
