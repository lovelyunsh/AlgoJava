package Silver;

import java.util.ArrayList;
import java.util.Scanner;

class point {
	int x;
	int y;

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 한빈이형참외 {
	static int X = 0, Y = 0, max = 0, a = 0, area = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int melon = sc.nextInt();
		ArrayList<point> farm = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			int d = sc.nextInt();
			int len = sc.nextInt();
			farm.add(new point(d, len));
		}
		for (int i = 0; i < farm.size(); i++) {
			if (max < farm.get(i).y) {
				max = farm.get(i).y; //
			}
		}
		for (int i = 0; i < farm.size(); i++) {
			if (i == 0) {
				if (farm.get(i).y == max) {
					X = Math.max(farm.get(farm.size() - 1).y, farm.get(1).y); // 50
					Y = Math.min(farm.get(farm.size() - 1).y, farm.get(1).y); // 30
					// 160*50 = 8000
					break;
				} else
					continue;
			}
			if (i == (farm.size() - 1)) {
				if (farm.get(i).y == max) {

					X = Math.max(farm.get(i - 1).y, farm.get(0).y); // 50
					Y = Math.min(farm.get(i - 1).y, farm.get(0).y); // 30
					// 160*50 = 8000
					break;
				} else
					continue;
			}
			if (i > 0) {
				if (farm.get(i).y == max) {
					X = Math.max(farm.get(i - 1).y, farm.get(i + 1).y); // 50
					Y = Math.min(farm.get(i - 1).y, farm.get(i + 1).y); // 30
					// 160*50 = 8000
					break;
				} else
					continue;
			}
		}
		// X-Y = 20 작은 세로길이 구함.
		for (int i = 0; i < farm.size(); i++) {

			if (farm.get(i).y == Y) {
				if (i == (farm.size() - 1)) {
					a = Math.min(farm.get(0).y, farm.get(i-1).y);
					break;
				}
				if(i == 0) {
					a = Math.min(farm.get(1).y, farm.get(farm.size()-1).y);
					break;
				}
				a = Math.min(farm.get(i + 1).y, farm.get(i - 1).y);
				break;
			}
		}
		area = Math.abs((max * X) - ((X - Y) * a));
		System.out.println(area * melon);
		sc.close();
	}
}