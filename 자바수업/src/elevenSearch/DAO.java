package elevenSearch;

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

public class DAO {
	ArrayList<ProductMO> productMOlist = new ArrayList<>();

	public ArrayList<ProductMO> Search(String target) {
		productMOlist = new ArrayList<>();
		DocumentBuilderFactory fa = DocumentBuilderFactory.newInstance();
		String text = target;
		String url = "http://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=4b2283eca6b900237d0c686f2b579694&apiCode=ProductSearch&keyword="
				+ text;

		try {
			DocumentBuilder db = fa.newDocumentBuilder();
			Document document = db.parse(url);
			Element root = document.getDocumentElement();

			NodeList productlist = root.getElementsByTagName("Product");
			for(int i = 0 ; i < productlist.getLength() ; i++) {
				Node product = productlist.item(i);
				
				if(product.getNodeType() != Node.ELEMENT_NODE)
					continue;
				
				NodeList Productchild = product.getChildNodes();
				ProductMO mo = new ProductMO();
				for(int j = 0 ; j < Productchild.getLength() ; j++) {
					Node child = Productchild.item(j);
					if(child.getNodeType() != Node.ELEMENT_NODE)
						continue;
					
					Element el = (Element)child;
					String name = el.getNodeName();
					String text1 = el.getTextContent();
					switch (name) {
					case "ProductName":
						mo.setProductName(text1);
						break;
					case "ProductPrice":
						mo.setProductPrice(text1);
						break;
					case "ProductImage":
						mo.setProductImage(text1);
						break;
					case "SellerNickDelivery":
						mo.setSellerNickDelivery(text1);
						break;
					case "Delivery":
						mo.setDelivery(text1);
						break;

					}
					
				}
				productMOlist.add(mo);
				
				
				
				
				
				
			}
			

		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productMOlist;

	}

}
