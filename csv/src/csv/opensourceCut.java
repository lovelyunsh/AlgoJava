package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class opensourceCut {
//insert into opensource(artifact_id,copyright,group_id,name,package_type,url,version,user_id) values("spring-boot-starter-web", "Pivotal Software, Inc.","org.springframework.boot","Spring Boot Starter Web","maven","https://spring.io/projects/spring-boot", "2.4.5",0);
	
	public static void main(String[] args) {
		StringBuilder queryList = new StringBuilder();
		String nameIdenti = "C:\\Users\\multicampus\\Desktop\\이름식별자.csv";
		String ossinsert = "C:\\Users\\multicampus\\Desktop\\ossinsert.csv";
		List<List<String>> nameiden = CsvUtils.readToList(nameIdenti);
		List<List<String>> ossi = CsvUtils.readToList(ossinsert);
		StringBuilder ossdata = new StringBuilder();
		StringBuilder licensedata = new StringBuilder();
		int totalcount = 0;
		int liccount = 1;
		for(int i = 1 ; i < nameiden.size() ; i++) {
			String iden = nameiden.get(i).get(0);
			StringBuilder temp = new StringBuilder();
			int count = 0;
			for(int j = ossi.size()-1 ; j >= 1; j-- ) {
				if(iden.equals(ossi.get(j).get(2))){
					count++;
					temp.append(ossi.get(j).get(0)+",");
					temp.append(ossi.get(j).get(1)+",");
					temp.append(ossi.get(j).get(2)+",");
					temp.append(ossi.get(j).get(3)+",");
					temp.append(liccount +"\n");
					ossi.remove(j);
				}
			}
			if(count > 20) {
				liccount++;
				totalcount+= count;
				licensedata.append(nameiden.get(i).get(0)+",");
				licensedata.append(nameiden.get(i).get(1)+"\n");
				ossdata.append(temp);
			}
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\multicampus\\Desktop\\이름식별자cut.csv"));
			writer.write(licensedata.toString());
			writer.close();
			BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\Users\\multicampus\\Desktop\\ossinsertcut.csv"));
			writer2.write(ossdata.toString());
			writer2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}