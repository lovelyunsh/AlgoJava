package nhn;

import java.util.Scanner;

class P2 {
	private static void solution(int day, int width, int[][] blocks) {

		int map[] = new int[width];
		int simen = 0;
		for (int d = 0; d < day; d++) {
			int max = -1;
			int maxIdx = 0;
			for (int i = 0; i < width; i++) {
				map[i] += blocks[d][i];
				if (map[i] > max) {
					maxIdx = i;
					max = map[i];
				}
			}
			int now = 0;
			int nowH = map[now];
			for(int i = 1 ; i <= maxIdx ; i++) {
				if(map[i] >nowH) {
					for(int j = now+1 ; j < i ; j++) {
						simen += nowH-map[j];
						map[j] = nowH;
					}
					now = i;
					nowH = map[i];
				}
			}
			now = width-1;
			nowH = map[now];
			for(int i = width-2 ; i>=maxIdx ; i--) {
				if(map[i] >nowH) {
					for(int j = now-1 ; j > i ; j--) {
						simen += nowH-map[j];
						map[j] = nowH;
					}
					now = i;
					nowH = map[i];
				}
			}

		}
		System.out.println(simen);

	}

	private static class InputData {
		int day;
		int width;
		int[][] blocks;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.blocks = new int[inputData.day][inputData.width];
			for (int i = 0; i < inputData.day; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.width; j++) {
					inputData.blocks[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.day, inputData.width, inputData.blocks);
	}
}