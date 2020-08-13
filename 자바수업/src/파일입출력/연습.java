package 파일입출력;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class 연습 {
	public static void main(String[] args) {
		ArrayList<Item> itemlist = new ArrayList<Item>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			Document document = db.parse("http://rss.etnews.com/Section902.xml");
			document.normalize();

			Element rss = document.getDocumentElement();
			NodeList channel1 = rss.getChildNodes();
			Node channel = channel1.item(1);

			NodeList nodelist = channel.getChildNodes();
			for (int i = 0; i < nodelist.getLength(); i++) {
				Node node = nodelist.item(i);
				if (node.getNodeType() != Node.ELEMENT_NODE 
						|| ((Element) node).getNodeName() != "item")
					continue;
				NodeList itemchild = node.getChildNodes();
				Item item = new Item();

				for (int j = 0; j < itemchild.getLength(); j++) {
					if (itemchild.item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;

					Element child = (Element) itemchild.item(j);
					String childTextContent = child.getTextContent();
					switch (child.getNodeName()) {
					case "title":
						item.setTitle(childTextContent);
						break;
					case "link":
						item.setLink(childTextContent);
						break;
					case "description":
						item.setDescription(childTextContent);
						break;
					case "author":
						item.setAuthor(childTextContent);
						break;
					case "comments":
						item.setComment(childTextContent);
						break;
					case "pubDate":
						item.setPubDate(childTextContent);
						break;
					}
				}
				itemlist.add(item);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		for(Item i : itemlist) 	System.out.println(i);
		
	}
}
