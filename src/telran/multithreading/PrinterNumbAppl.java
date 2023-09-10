package telran.multithreading;

import java.util.stream.IntStream;

public class PrinterNumbAppl {
	private static final int N_THREADS = 50;
	private static final int N_NUMBERS = 100;
	private static final int N_PARTITIONS = 10;
	
	
	
	public static void main(String[] args) {
		PrinterNumb.setPartitions(N_PARTITIONS);
		PrinterNumb.setOverAll(N_NUMBERS);
		PrinterNumb[] printers = new PrinterNumb[N_THREADS];
		creatingPrinters(printers);
		
		printers[0].interrupt();
		
	}

	private static void creatingPrinters(PrinterNumb[] printers) {
		printers[0] = new PrinterNumb(1);
		for(int i = 1; i < printers.length; i++) {
			printers[i] = new PrinterNumb(i + 1);
			printers[i - 1].setNext(printers[i]);
			printers[i - 1].start();
					
		}
		printers[printers.length - 1].setNext(printers[0]);
		printers[printers.length - 1].start();
		
		
	}

}
