package 파일입출력;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class 싹스handler extends DefaultHandler {

	private StringBuilder data = null;
	private Item item;
	private ArrayList<Item> Itemlist = new ArrayList<Item>(); 
	boolean btitle = false;
	boolean blink = false;
	boolean bdescription = false;
	boolean bauthor = false;
	boolean bpubDate = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException {

		if (qName.equals("title")) {
			item = new Item();
			btitle = true;
		} else if (qName.equals("link")) {
			blink = true;
		} else if (qName.equals("description")) {
			bdescription = true;
		} else if (qName.equals("author")) {
			bauthor = true;
		} else if (qName.equals("pubDate")) {
			bpubDate = true;
		}
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (btitle) {
			item.setTitle(data.toString());
			btitle = false;
		} else if (blink) {
			item.setLink(data.toString());
			blink = false;
		} else if (bauthor) {
			item.setAuthor(data.toString());
			bauthor = false;
		}  else if (bdescription) {
			item.setDescription(data.toString());
			bdescription = false;
		}else if (bpubDate) {
			item.setPubDate(data.toString());
			bpubDate = false;
			Itemlist.add(item);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}

	public ArrayList<Item> getItem() {
		return Itemlist;
	}

}
