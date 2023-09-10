package telran.multithreading;

public class Printer extends Thread {
	
//	private char symbol;
//	private int nSymbols;
//	
//	public Printer(char symbol, int nSymbols) {
//		this.symbol = symbol;
//		this.nSymbols = nSymbols;
//	}
//	@Override
//	public void run() {
//		for(int i = 0; i < nSymbols; i++) {
//			System.out.println(symbol);
//			try {
//				sleep(1);
//			} catch (InterruptedException e) {
//				
//			}
//		}
//	}
	private char[] symbols;
	private boolean running = true;
	
	public Printer(String symbols) {
	this.symbols = symbols.toCharArray();
	}

	public void stopPrinter() {
		this.running = false;
	}
	@Override
	public void run() {
		
		int index = 0;
		while(running) {
			System.out.print(symbols[index]);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				
				index++;
				if(index == symbols.length) {
					index = 0;
				}
			}
		}
	}
	
} 