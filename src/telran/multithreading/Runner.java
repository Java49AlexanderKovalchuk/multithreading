package telran.multithreading;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Runner extends Thread {
	private Race race;
	private int runnerId;
	private static Object mutex = new Object();

	public Runner(Race race, int runnerId) {
		this.race = race;
		this.runnerId = runnerId;
	}
	@Override
	public void run() {
		int sleepRange = race.getMaxSleep() - race.getMinSleep() + 1;
		int minSleep = race.getMinSleep();
		int distance = race.getDistance();
		Instant time = Instant.now();
			for (int i = 0; i < distance; i++) {
				try {
					sleep((long) (minSleep + Math.random() * sleepRange));
						
				} catch (InterruptedException e) {
				throw new IllegalStateException();
				}
				System.out.println(runnerId);
			}
		//race.setWinner(runnerId);
		long timeRace = ChronoUnit.MILLIS.between(time, Instant.now());
		
		synchronized(mutex) {
			Race.tableRunners.put(runnerId, (int) timeRace);
		}
	}
}
