package sortingPD;

public class StopWatch {
	private long startTime;
	private long stopTime;
	private long runtime;
	
	public StopWatch() {
		startTime = 0;
		stopTime = 0;
		runtime = 0;
	}
	
	public long start() {
		startTime = System.nanoTime();
		return startTime;
	}
	
	public long stop() {
		stopTime = System.nanoTime();
		return stopTime;
	}
	
	public long runtime() {
		runtime = stopTime - startTime;
		return runtime;
	}

}
