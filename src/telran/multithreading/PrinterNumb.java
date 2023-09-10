package telran.multithreading;

public class PrinterNumb extends Thread {
	private static final long SLEEPING_TIME = 100;
	int printerNumber;
	PrinterNumb next;
	private int inLine;
	static int overAll;
	static int nPartitions;
	
	public PrinterNumb(int printerNumber) {
		this.printerNumber = printerNumber;
		inLine = overAll / nPartitions;
	}
	
	public void setNext(PrinterNumb next) {
		this.next = next;
	}
	
	public static void setOverAll(int overAll) {
		PrinterNumb.overAll = overAll;
	}
	
	public static void setPartitions(int nPartitions) {
		PrinterNumb.nPartitions = nPartitions;
	}
	
	
	@Override
	public void run() {
		int count = 0;
		String line = (" " + printerNumber).repeat(inLine);
		while(count < nPartitions) {
			try {
				join();
			
			} catch (InterruptedException e) {
				System.out.println(line);
				next.interrupt();
				count++;
			}
		}
	}
	
}
