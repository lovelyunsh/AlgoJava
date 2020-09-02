package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1051숫자정사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = str.charAt(j);
		}

		for (int size = (N > M) ? M : N; size > 0; size--)
			for (int i = 0; i + size <= N; i++) {
				for (int j = 0; j + size <= M; j++) {
					if(map[i+size-1][j] != map[i][j])
						continue;
					if(map[i][j+size-1] != map[i][j])
						continue;
					if(map[i+size-1][j+size-1] != map[i][j])
						continue;
					System.out.println(size*size);
					System.exit(0);
			}
			}

	}

}
