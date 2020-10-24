package nhn;

import java.util.Scanner;
import java.util.Stack;

class P3 {
	private static void solution(int numOfOrder, String[] orderArr) {
		for (int order = 0; order < numOfOrder; order++) {
			Stack<Integer> left = new Stack<Integer>();
			StringBuilder nowOrder = new StringBuilder(orderArr[order]);
			for (int i = 0; i < nowOrder.length(); i++) { // 괄호 없애기
				if (nowOrder.charAt(i) == '(') {
					left.push(i);
					continue;
				}
				if (nowOrder.charAt(i) == ')') {
					int start = left.pop();
					String right = nowOrder.substring(start + 1, i);
					StringBuilder sb = new StringBuilder();
					char gop = nowOrder.charAt(start - 1);
					if ('1' <= gop && gop <= '9') {
						int num = Integer.parseInt(gop + "");
						for (int j = 0; j < num; j++) {
							sb.append(right);
						}
					} else {
						for (char a : right.toCharArray()) {
							sb.append(gop);
							sb.append(a);
						}
					}
					nowOrder.delete(start-1, i + 1);
					nowOrder.insert(start-1, sb);
					i = start + sb.length() - 2;
				}
			}
			for (int i = 0; i < nowOrder.length(); i++) {
				if ('1' <= nowOrder.charAt(i) && nowOrder.charAt(i) <= '9') {
					int num = Integer.parseInt(nowOrder.charAt(i) + "");
					char a = nowOrder.charAt(i + 1);
					nowOrder.delete(i, i + 2);
					for (int j = 0; j < num; j++) {
						nowOrder.insert(i, a);
					}
				}
			}
			System.out.println(nowOrder);

		}
	}

	private static class InputData {
		int numOfOrder;
		String[] orderArr;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.orderArr = new String[inputData.numOfOrder];
			for (int i = 0; i < inputData.numOfOrder; i++) {
				inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfOrder, inputData.orderArr);
	}
}