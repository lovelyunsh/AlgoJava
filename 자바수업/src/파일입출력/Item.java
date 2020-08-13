package 파일입출력;

import java.sql.Time;

public class Item{
	private String title;
	private String link;
	private String description;
	private String author;
	private String comment;
	private String pubDate;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Item [title=" + title + ", link=" + link + ", description=" + description + ", author=" + author
				+ ", pubDate=" + pubDate + "]";
	}
	
	
	
}