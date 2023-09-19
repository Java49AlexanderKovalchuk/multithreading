package telran.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	private int winnerFlag = -1;
	private AtomicInteger winner = new AtomicInteger(winnerFlag);
	public Race(int distance, int minSleep, int maxSleep) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
	}
	public int getWinner() {
		return this.winner.get();
		
		
	}
	public void setWinner1(int winner) {
//		if (this.winner == -1) {
//			this.winner = winner;
//		}
	
		this.winner.compareAndSet(winnerFlag, winner);
	}
	
	public int getDistance() {
		return distance;
	}
	public int getMinSleep() {
		return minSleep;
	}
	public int getMaxSleep() {
		return maxSleep;
	}
	
}