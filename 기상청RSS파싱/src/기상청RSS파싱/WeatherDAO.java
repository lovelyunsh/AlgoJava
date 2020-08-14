package 기상청RSS파싱;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDAO {
	static WeatherDAO dao;
	static WeatherDAO makeDAO(){
		if(dao == null)
			dao = new WeatherDAO();
		return dao;
	}
	private WeatherDAO() {
		
	}

	public ArrayList<Weather> getWeatherList() {
		ArrayList<Weather> weatherList = new ArrayList<>();
		String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2920064000";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(url);
			Element rss = document.getDocumentElement();
			NodeList bodychild = rss.getElementsByTagName("data");

			for (int i = 0; i < bodychild.getLength(); i++) {
				Node data = bodychild.item(i);
				if (data.getNodeType() != Node.ELEMENT_NODE || !data.getNodeName().equals("data"))
					continue;
				Weather wea_temp = new Weather(); 
				NodeList datachild = data.getChildNodes();
				for(int j = 0 ; j < datachild.getLength() ; j++) {
					Node detail = datachild.item(j);
					if(detail.getNodeType() != Node.ELEMENT_NODE)
						continue;
					Element detailE = (Element) detail; 
					String detailname = detailE.getNodeName();
					String value = detailE.getTextContent();
					switch (detailname) {
					case "hour":
						wea_temp.setHour(value);
						break;
					case "temp":
						wea_temp.setTemp(value);
						break;
					case "reh":
						wea_temp.setReh(value);
						break;
					case "wfKor":
						wea_temp.setWfkor(value);
						break;

					}
				}
				weatherList.add(wea_temp);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return weatherList;
	}

}
