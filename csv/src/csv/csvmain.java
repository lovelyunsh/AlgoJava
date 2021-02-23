package csv;

import java.util.List;

public class csvmain {
//insert into bigdata(text,content) values("Bigdata","빅데이터임");
//insert into middledata(bdid,text,content) values(1,"언어","웹언어임");
//insert into smalldata(bdid,mdid,text,content) values(1,1,"자바","웹언어자바임");
	
	public static void main(String[] args) {
		int big = 0;
		int middle = 0;
		int small = 0;
		StringBuilder query = new StringBuilder();
		String path = "C:\\Users\\multicampus\\Desktop\\data.csv";
		List<List<String>> list = CsvUtils.readToList(path);
		for(int i=0; i<list.size(); i++) {
			List<String> line = list.get(i);
			line.add("");
			for(int j=0; j<line.size(); j++) {
				if(!line.get(j).equals("")) {
					if(j==0 || j==2 || j==4)
						if(line.get(j).length() >=20)
							System.out.println(line.get(j));
					if(j == 0) {
						query.append("insert into bigdata(text,content) values(\""+line.get(j)+"\",\""+line.get(j+1)+"\");\n");
						big++;
					}
					if(j == 2) {
						query.append("insert into middledata(bdid,text,content) values("+big+",\""+line.get(j)+"\",\""+line.get(j+1)+"\");\n");
						middle++;
					}
					if(j == 4) {
						query.append("insert into smalldata(bdid,mdid,text,content) values("+big+","+middle+",\""+line.get(j)+"\",\""+line.get(j+1)+"\");\n");
						small++;
					}
				}
			}
		}
		System.out.println(query);
	}
}