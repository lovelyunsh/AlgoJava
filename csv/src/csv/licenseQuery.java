package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class licenseQuery {
//
//insert into license values(1,"Apache whole dummy data","Apache 2.0",1,1,1,1,1,1,1,1,1,0,0,0,"Apache V2","","http://www.apache.org/licenses/");
	public static void main(String[] args) {
		StringBuilder queryList = new StringBuilder();
		String path1 = "C:\\Users\\multicampus\\Desktop\\license.csv";
		List<List<String>> list = CsvUtils.readToList(path1);
		
		for(int i = 1 ; i < list.size() ; i++) {
			String query = "insert into license (license_id,name,identifier,url,is_osi,is_modify,is_license,is_copyright,sourceopen,is_anotherlicense,is_modify_notice,is_warranty,is_respon,contents,user_id) values(";
			query += i+",";
			query += "\""+list.get(i).get(0)+"\""+",";
			query += "\""+list.get(i).get(1)+"\""+",";
			query += "\""+list.get(i).get(2)+"\""+",";
			query += list.get(i).get(3)+",";
			query += list.get(i).get(4)+",";
			query += list.get(i).get(5)+",";
			query += list.get(i).get(6)+",";
			query += "\""+list.get(i).get(7)+"\""+",";
			query += list.get(i).get(8)+",";
			query += list.get(i).get(9)+",";
			query += list.get(i).get(10)+",";
			query += list.get(i).get(11)+",";
			query += "\""+list.get(i).get(12)+"\"";
			query += ",0);\n";
			queryList.append(query);
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\multicampus\\Desktop\\licenseinsertquery.txt"));
			writer.write(queryList.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}