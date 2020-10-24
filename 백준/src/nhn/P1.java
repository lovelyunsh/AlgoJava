package nhn;

import java.util.Scanner;

class P1 {
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) throws Exception {

		boolean SMans[] = new boolean[numOfAllPlayers];
		int taggerNum[] = new int[numOfAllPlayers];
		for (char i : namesOfQuickPlayers )
			SMans[i - 'A'] = true;
		char map[] = new char[numOfAllPlayers - 1];
		for (int i = 0; i < numOfAllPlayers - 1; i++) 
			map[i] = (char) ('A' + i+1);
		char tagger = 'A';
		taggerNum[0]++;
		int nowPos = 0;
		for(int turn = 0 ; turn < numOfGames ; turn ++) {
			int nowmove = numOfMovesPerGame[turn];
			nowPos = nowmove + nowPos;
			nowPos = nowPos % (numOfAllPlayers-1);
			nowPos = nowPos >=0 ? nowPos : (numOfAllPlayers-1)+nowPos;
			if(SMans[map[nowPos] - 'A']) {
				taggerNum[tagger-'A']++;
				continue;
			}
			taggerNum[map[nowPos]-'A']++;
			char temp = map[nowPos];
			map[nowPos] = tagger;
			tagger = temp;
		}
		for(int i = 0 ; i < numOfAllPlayers-1 ; i++) {
			System.out.println(map[i]+" "+taggerNum[map[i]-'A']);
		}
		System.out.println(tagger+" "+taggerNum[tagger-'A']);
	}

	private static class InputData {
		int numOfAllPlayers;
		int numOfQuickPlayers;
		char[] namesOfQuickPlayers;
		int numOfGames;
		int[] numOfMovesPerGame;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
			System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0,
					inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

			inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.numOfMovesPerGame = new int[inputData.numOfGames];
			String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
			for (int i = 0; i < inputData.numOfGames; i++) {
				inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers,
				inputData.numOfGames, inputData.numOfMovesPerGame);
	}
}