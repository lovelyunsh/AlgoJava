package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class opensourceQuery {
//
	public static void main(String[] args) {
		StringBuilder openQueryList = new StringBuilder();
		StringBuilder openlicenseQueryList = new StringBuilder();
		String path1 = "C:\\Users\\multicampus\\Desktop\\오픈소스final.csv";
		List<List<String>> list = CsvUtils.readToList(path1);
		//insert into license_opensource values(10,6);
		for(int i = 1 ; i < list.size() ; i++) {
			String openQuery = "insert into opensource (opensource_id,name,url,copyright,group_id,artifact_id,version,package_type,user_id) values(";
			openQuery += i+",";
			openQuery += "\""+list.get(i).get(0)+"\""+",";
			openQuery += "\""+list.get(i).get(1)+"\""+",";
			openQuery += "\""+list.get(i).get(2)+"\""+",";
			openQuery += "\""+list.get(i).get(3)+"\""+",";
			openQuery += "\""+list.get(i).get(4)+"\""+",";
			openQuery += "\""+list.get(i).get(5)+"\""+",";
			openQuery += "\""+list.get(i).get(6)+"\"";
			openQuery += ",0);\n";
			openQueryList.append(openQuery);
			String opslicQuery = "insert into license_opensource (license_id,opensource_id) values("+list.get(i).get(7)+","+i+");\n";
			openlicenseQueryList.append(opslicQuery);
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\multicampus\\Desktop\\opensourceinsertquery.txt"));
			writer.write(openQueryList.toString());
			writer.close();
			BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\Users\\multicampus\\Desktop\\opslicquery.txt"));
			writer2.write(openlicenseQueryList.toString());
			writer2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}