package telran.multithreading;

import java.awt.color.ColorSpace;
import java.util.stream.IntStream;

import telran.view.*;

public class RaceAppl {
	
	private static final int MIN_THREADS = 3;
	private static final int MAX_THREADS = 10;
	private static final int MIN_DISTANCE = 100;
	private static final int MAX_DISTANCE = 3500;
	private static final int MIN_SLEEP = 2;
	private static final int MAX_SLEEP = 5;
	private static final String HEADER1 = "place";
	private static final String HEADER2 = "racer number";
	private static final String HEADER3 = "time";
	private static final String SPACE = " ";
	
	public static void main(String[] args) throws InterruptedException {
		InputOutput io = new ConsoleInputOutput();
		Item[] items = getItems();
		Menu menu = new Menu("Race Game", items);
		menu.perform(io);
		
	}

	private static Item[] getItems() {
		Item[] res = {
				Item.of("Start new game", RaceAppl::startGame),
				Item.ofExit()
		};
		return res;
	}
	static void startGame(InputOutput io) {
		int nTrhreads = io.readInt("Enter number of runners", "Wrong number of the runners", 
				MIN_THREADS, MAX_THREADS);
		int distance = io.readInt("Enter distance", "Wrong distance", 
				MIN_DISTANCE, MAX_DISTANCE);
		Race race = new Race(distance, MIN_SLEEP, MAX_SLEEP);
		Runner[] runners = new Runner[nTrhreads];
		startRunners(runners, race);
		joinRunners(runners);
		//displayWinner(race);
		displayTable(race);
	}

	private static void displayTable(Race race) {
		
		System.out.printf("%s%s%s%s%s\n", HEADER1, SPACE.repeat(5), 
				HEADER2, SPACE.repeat(5), HEADER3);
		int sizeMap = race.tableRunners.size();
		Integer [] racers = (Integer[]) race.tableRunners.keySet().toArray(Integer[]::new);
		Integer [] times = (Integer[]) race.tableRunners.values().toArray(Integer[]::new);
		for(int i = 0; i < sizeMap; i++) {
			System.out.printf("%d%s%d%s%d\n", 
					i+1, SPACE.repeat(15), racers[i], SPACE.repeat(11), times[i]);
		}
		
	}

//	private static void displayWinner(Race race) {
//		System.out.println("Congratulations to runner " + race.getWinner());
//		
//	}

	private static void joinRunners(Runner[] runners) {
		IntStream.range(0, runners.length).forEach(i -> {
			try {
				runners[i].join();
			} catch (InterruptedException e) {
				throw new IllegalStateException();
			}
		});
		
	}

	private static void startRunners(Runner[] runners, Race race) {
		IntStream.range(0, runners.length).forEach(i -> {
			runners[i] = new Runner(race, i + 1);
			runners[i].start();
		});
		
	}
	
}
