package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.CoronaThread;

public class CoronaThreadTest {

	public static void main(String[] args) {

		for (int t = 0; t < 1000; t++) {

			CoronaThread thread = new CoronaThread(t);
			thread.start();

		}
	}
}