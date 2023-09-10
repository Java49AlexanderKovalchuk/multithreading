package telran.multithreading;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class PrinterControllerAppl {

	public static void main(String[] args) {
//		Printer printer1 = new Printer('#', 100);
//		Printer printer2 = new Printer('*', 100);
//		Instant start = Instant.now();
//		printer1.start();
//		printer2.start();
//		printer1.join(); //main thread moves to waiting for finishing printer1
//		printer2.join(); //main thread moves to waiting for finishing printer2
//						 //in the case printer2 has already finished the main thread doesn't wait 
//		System.out.printf("running time is %dms \n", 
//				 ChronoUnit.MILLIS.between(start, Instant.now()));
//	}
		Printer printer = new Printer(".*#$%&");
		Scanner scanner = new Scanner(System.in);
		printer.start();
		while(true) {
			String line = scanner.nextLine();
			if(line.equals("q")) {
				break;
			}
			printer.interrupt();
		}
		printer.stopPrinter();
		
	}
}
