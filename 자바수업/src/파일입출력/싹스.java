package 파일입출력;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;



public class 싹스 {

	public static void main(String[] args) {

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			싹스handler handler = new 싹스handler();
			saxParser.parse("http://rss.etnews.com/Section902.xml", handler);

			ArrayList<Item> itemlist = handler.getItem();
			for(Item i : itemlist)
				System.out.println(i);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
