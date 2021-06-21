package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class opensourceCollect {
//insert into opensource(artifact_id,copyright,group_id,name,package_type,url,version,user_id) values("spring-boot-starter-web", "Pivotal Software, Inc.","org.springframework.boot","Spring Boot Starter Web","maven","https://spring.io/projects/spring-boot", "2.4.5",0);
	
	public static void main(String[] args) {
		StringBuilder queryList = new StringBuilder();
		String ossinsertcutdata = "C:\\Users\\multicampus\\Desktop\\ossinsertcut.csv";
		String dependata = "C:\\Users\\multicampus\\Desktop\\dependata.csv";
		List<List<String>> ossinsertcut = CsvUtils.readToList(ossinsertcutdata);
		List<List<String>> depen = CsvUtils.readToList(dependata);
		StringBuilder ossdata = new StringBuilder();
		int totalcount = 0;
		int liccount = 1;
		for(int i = 0 ; i < ossinsertcut.size() ; i++) {
			String name = ossinsertcut.get(i).get(0);
			StringBuilder temp = new StringBuilder();
			for(int j = 1 ; j < depen.size() ; j++ ) {
				if(name.equals(depen.get(j).get(0))){
					temp.append(ossinsertcut.get(i).get(0)+","); //name
					temp.append(ossinsertcut.get(i).get(1)+","); //url
					temp.append(ossinsertcut.get(i).get(3)+","); //copyright
					temp.append(depen.get(j).get(1)+","); //groupid
					temp.append(depen.get(j).get(2)+","); //artifactid
					temp.append(depen.get(j).get(3)+","); //version
					temp.append(depen.get(j).get(5)+","); //packagemanager
					temp.append(ossinsertcut.get(i).get(4)+"\n"); //license_num
					
					ossdata.append(temp);
					break;
				}
			}

		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\multicampus\\Desktop\\오픈소스final.csv"));
			writer.write(ossdata.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}