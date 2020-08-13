package 파일입출력;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파일입출력 {
	public static void main(String[] args) {
		
		try {
			FileOutputStream fo = new FileOutputStream("file.dat");
			// 모든 OutputStream은 write 기능을 정해놓고 있음.
			// write는 세가지.
			// write(int): 해당 정수자료형에서 8비트를 파일에 씁니다.
			// write(byte[]): 바이트 배열만큼 파일에 기록
			// write(byte[], int off, int len): 해당 바이트배열에서 off만큼 건너띄고 len만큼 기록 쓸 때 이걸 많이 써요

			FileInputStream fi = new FileInputStream("file.dat");
			// 모든 InputStream은 read기능을 정해놓고 있음.
			// read도 세가지.
			// int read() : 1바이트를 읽어서 반환하고, 읽을 데이터가 없으면 -1을 반환 읽을 때 이걸 많이 써요
			// int read(byte[]) : byte배열 길이만큼 읽고.

			// 파일 복사해보자!
			byte[] buf = new byte[1024]; // 1키로 바이트
			int len = -1;
			while ((len = fi.read(buf)) != -1) { //버프 크기 만큼 계속 읽어다 쓰기
				fo.write(buf,0,len);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
