package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class opensourceDividing {
//
	public static void main(String[] args) {
		StringBuilder maven = new StringBuilder();
		StringBuilder npm = new StringBuilder();
		
		String [] a = {"Apache-2.0","BSD-3-Clause","BSD-2-Clause","EPL-1.0","MIT","ISC","MPL-2.0","Zlib","GPL-2.0-or-later","LGPL-2.1-or-later"};
		List<String> licenselist = new ArrayList<String>();
		for(String b : a)
			licenselist.add(b);
		String path1 = "C:\\Users\\multicampus\\Desktop\\오픈소스final.csv";
		List<List<String>> list = CsvUtils.readToList(path1);
		int targetnum = 1;
		for(int i = 1 ; i < list.size() ; i++) {
			try {
				if(Integer.parseInt(list.get(i).get(7)) >targetnum || list.size()-1 == i) {
					if(targetnum == 1) {
						System.out.println(npm);
						return;
					}
					targetnum = Integer.parseInt(list.get(i).get(7));
					BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\multicampus\\Desktop\\오픈소스 정리\\"+licenselist.get(targetnum-1)+"_maven.csv"));
					writer.write(maven.toString());
					writer.close();
					maven = new StringBuilder();
					BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\Users\\multicampus\\Desktop\\오픈소스 정리\\"+licenselist.get(targetnum-1)+"_npm.csv"));
					writer2.write(npm.toString());
					writer2.close();
					npm = new StringBuilder();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			String data = "";
			if(list.get(i).get(6).equals("MAVEN")) {
				data += list.get(i).get(3)+",";
				data += list.get(i).get(4)+"\n";
				maven.append(data);
				
			}else if(list.get(i).get(6).equals("NPM")) {
				data += list.get(i).get(3)+",";
				data += list.get(i).get(4)+"\n";
				npm.append(data);
			}
		}
	}
}