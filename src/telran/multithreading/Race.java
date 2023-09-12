package telran.multithreading;

import java.util.LinkedHashMap;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	//private int winner = -1;
	
	static LinkedHashMap<Integer, Integer> tableRunners = new LinkedHashMap<>();
	
		public Race(int distance, int minSleep, int maxSleep) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
	}
//	public int getWinner() {
//		return winner;
//	}
//	public void setWinner(int winner) {
//		if (this.winner == -1) {
//			this.winner = winner;
//		}
//	}
	public int getDistance() {
		return distance;
	}
	public int getMinSleep() {
		return minSleep;
	}
	public int getMaxSleep() {
		return maxSleep;
	}
	
	public static void setTableRunners(LinkedHashMap<Integer, Integer> tableRunners) {
		Race.tableRunners = tableRunners;
	}
	
}