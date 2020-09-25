package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2527직사각형 {
	static int x1, y1, x2, y2, nx1, ny1, nx2, ny2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			nx1 = Integer.parseInt(st.nextToken());
			ny1 = Integer.parseInt(st.nextToken());
			nx2 = Integer.parseInt(st.nextToken());
			ny2 = Integer.parseInt(st.nextToken());

			System.out.println((get()));
		}
	}

	static char get() {
		if ((x2 == nx1 && y2 == ny1) || (x1 == nx2 && y2 == ny1) || (x2 == nx1 && y1 == ny2)
				|| (x1 == nx2 && y1 == ny2)) {
			return 'c';
		} else if ((x2 == nx1 && y2 != ny1) || (x1 == nx2 && y2 != ny1) || (x2 != nx1 && y1 == ny2)
				|| (x1 != nx2 && y1 == ny2)) {
			return 'b';
		} else if (x2 < nx1 || nx2 < x1 || y2 < ny1 || ny2 < y1) {
			return 'd';
		} else {
			return 'a';
		}
	}
}