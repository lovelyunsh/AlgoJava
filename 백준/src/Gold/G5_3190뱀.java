package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_3190뱀 {
	
	static int map[][],N;
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for(int i = 0 ; i < K ; i ++) {
			st= new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[x][y] = 2;
		}
		int L = Integer.parseInt(br.readLine());
		int move[] = new int[L];
		char dir[] = new char[L];
		for(int i = 0 ; i < L ; i++) {
			st = new StringTokenizer(br.readLine());
			move[i] = Integer.parseInt(st.nextToken());
			dir[i] = st.nextToken().charAt(0);
		}
		int d = 0;
		int time = 0;
		int dirnum = 0;
		int row = 0;
		int col = 0;
		Queue<Point> snake = new LinkedList<Point>();
		snake.add(new Point(0,0));
		while(true) {
			time++;
			row = row+dr[d];
			col = col+dc[d];
			if(row<0 || col < 0 || row>=N || col>=N || map[row][col] == 1)
				break;
			if(map[row][col] == 2) {
				snake.offer(new Point(row,col));
				map[row][col] = 1;
			}else {
				snake.offer(new Point(row,col));
				map[row][col] = 1;
				Point tail = snake.poll();
				map[tail.x][tail.y] = 0;
			}
			if(dirnum < L && move[dirnum] == time) {
				if(dir[dirnum] == 'D') {
					d = (d+1)%4;
				}else {
					d = d == 0 ? 3: d-1;
				}
				dirnum++;
			}
		}
		System.out.println(time);
		
	}

}
