package com.ssafy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private BookDAO() {
	};

	static BookDAO dao;

	static public BookDAO getinstance() {
		if (dao == null)
			dao = new BookDAO();
		return dao;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/book?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
					"ssafy", "zcx13213");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertBook(Book book) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement(" insert into book(isbn, title, author, publisher, price, description)"
							+ " values (?, ?, ?, ?, ?, ?)");
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPublisher());
			ps.setInt(5, book.getPrice());
			ps.setString(6, book.getDescription());
			ps.executeUpdate();

			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBook(Book book) {
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update book set title = ?, author = ?, publisher = ? , price = ? , description = ?  where isbn = ? ");
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDescription());
			ps.setString(6, book.getIsbn());

			ps.executeUpdate();

			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteBook(String isbn) {
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(" delete from book where isbn = ? ");
			ps.setString(1, isbn);
			ps.executeUpdate();
			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Book findBook(String isbn) {
		Connection conn = getConnection();
		Book result = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from book where isbn = ?");
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			rs.next();
			result = new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
					rs.getString("publisher"), rs.getInt("price"), rs.getString("description"));
			close(rs);
			close(ps);
			close(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Book> listBook() {
		Connection conn = getConnection();
		List<Book> result = new ArrayList<Book>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from book");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getString("publisher"), rs.getInt("price"), rs.getString("description")));
			}
			close(rs);
			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int count() {
		Connection conn = getConnection();
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) from book");
			ResultSet rs = ps.executeQuery();
			rs.next();
			result = rs.getInt(1);
			close(rs);
			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
