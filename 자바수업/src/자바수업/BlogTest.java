package 자바수업;

import java.io.File;
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

public class BlogTest {
	public static void main(String[] args) {

		File blog = new File("C:\\Users\\YunS\\Desktop\\blog.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		ArrayList<Item> itemList = new ArrayList<>();

		try {

			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(blog);
			doc.getDocumentElement().normalize();

			Element rss = doc.getDocumentElement();
			Node channel = rss.getFirstChild();
			
			
			NodeList childNodes = channel.getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;
					String textContent = element.getTextContent();
					String nodeName = element.getNodeName();
					switch (nodeName) {
					case "item":
						NodeList itemChildNodes = element.getChildNodes();
						Item item = new Item();
						for (int j = 0; j < itemChildNodes.getLength(); j++) {
							Node childNode = itemChildNodes.item(j);
							if (childNode.getNodeType() == Node.ELEMENT_NODE) {
								Element childElement = (Element) childNode;
								String childTextContent = childElement.getTextContent();
								String childNodeName = childElement.getNodeName();
								switch (childNodeName) {
								case "title":
									// System.out.println("title : " + childTextContent);
									item.setTitle(childTextContent);
									break;
								case "link":
									// System.out.println("link : " + childTextContent);
									item.setLink(childTextContent);
									break;
								case "description":
									// System.out.println("description : " + childTextContent);
									item.setDescription(childTextContent);
									break;
								case "bloggername":
									// System.out.println("bloggername : " + childTextContent);
									item.setBloggername(childTextContent);
									break;
								case "bloggerlink":
									// System.out.println("bloggerlink : " + childTextContent);
									item.setBloggerlink(childTextContent);
									break;
								case "postdate":
									// System.out.println("postdate : " + childTextContent);
									item.setPostdate(childTextContent);
									break;
								}
							}
						}
						itemList.add(item);
					}
				}
			}
		} catch (SAXException | ParserConfigurationException | IOException e1) {
			e1.printStackTrace();
		}
		for (Item i : itemList)
			System.out.println(i);
	}

}