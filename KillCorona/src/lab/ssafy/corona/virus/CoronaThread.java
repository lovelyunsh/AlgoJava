package lab.ssafy.corona.virus;

public class CoronaThread extends Thread {
	int num;
	Cell cell;

	public CoronaThread(int num) {
		this.num = num;
	}

	public CoronaThread(Cell cell) {
		this.cell = cell;
	}

	@Override
	public void run() {
		synchronized (cell) {
			if (cell.power < 100) {
				try {
					cell.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			if (cell.power >= 100) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cell.power = cell.power - 100;
				cell.notifyAll();
			}
		}
		System.out.println("CoronaThread : " + cell.power);
	}
}