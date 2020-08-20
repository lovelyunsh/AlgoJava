package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Test {
	public static void main(String[] args) throws IOException {
		BookDAO dao = BookDAO.getinstance();
		while (true) {
			System.out.println("---------------------------------------------");
			System.out.println("1.insert 2.update 3.delete 4.find 5.list 6.count 0.end");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int choice = -1;
			try {
				choice = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 쓰세요");
			} catch (IOException e) {
				System.out.println("입력이 안돼요");
			}
			if(choice == 0)
				break;
			else if(choice == 1) {
				System.out.println("isbn :");
				String isbn = br.readLine();
				System.out.println("title :");
				String title = br.readLine();
				System.out.println("author :");
				String author = br.readLine();
				System.out.println("publisher :");
				String publisher = br.readLine();
				System.out.println("price :");
				int price = Integer.parseInt(br.readLine());
				System.out.println("description :");
				String description = br.readLine();
				
				Book book = new Book(isbn, title, author, publisher, price, description);
				dao.insertBook(book);
			}
			else if (choice == 2) {
				System.out.println("isbn :");
				String isbn = br.readLine();
				Book prevBook = dao.findBook(isbn);
				System.out.println("previous title : "+ prevBook.getTitle());
				System.out.println("title :");
				String title = br.readLine();
				System.out.println("previous author : "+ prevBook.getAuthor());
				System.out.println("author :");
				String author = br.readLine();
				System.out.println("previous publisher : "+ prevBook.getPublisher());
				System.out.println("publisher :");
				String publisher = br.readLine();
				System.out.println("previous price : "+ prevBook.getPrice());
				System.out.println("price :");
				int price = Integer.parseInt(br.readLine());
				System.out.println("previous description : "+ prevBook.getDescription());
				System.out.println("description :");
				String description = br.readLine();
				
				dao.updateBook(new Book(isbn, title, author, publisher, price, description));
			}
			else if (choice == 3) {
				System.out.println("isbn :");
				String isbn = br.readLine();
				dao.deleteBook(isbn);
			}
			else if (choice == 4) {
				System.out.println("isbn :");
				String isbn = br.readLine();
				Book book = dao.findBook(isbn);
				System.out.println(book);
			}
			else if(choice == 5) {
				List<Book> blist = dao.listBook();
				if(blist == null) {
					System.out.println("없어여");
					continue;
				}
				for(Book b : blist)
					System.out.println(b);
			}
			else if(choice == 6) {
				System.out.println(dao.count());
			}
		}

	}
}
