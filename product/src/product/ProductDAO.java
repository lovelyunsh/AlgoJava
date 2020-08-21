package product;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO implements IProductMgr {
	static ProductDAO Dao;
	ArrayList<Product> products = new ArrayList<Product>();

	private ProductDAO() {
		ObjectInputStream Ois;
		try {
			Ois = new ObjectInputStream(new FileInputStream("product.dat"));
			products = (ArrayList<Product>) Ois.readObject();
		} catch (Exception e) {
			products = new ArrayList<Product>();
		}
	}

	static public ProductDAO makeMgr() {
		if (Dao == null)
			Dao = new ProductDAO();

		return Dao;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/product?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
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

	@Override
	public void add(Product p) {
		System.out.println(p.getInch());
		Connection conn = getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement("insert into product values(?,?,?,?,?,?)");
			ps.setInt(1, p.getNo());
			ps.setInt(2, p.getPrice());
			ps.setString(3, p.getName());
			ps.setInt(4, p.getStock());
			ps.setInt(5, p.getInch());
			ps.setInt(6, p.getVolume());
			ps.executeUpdate();

			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Product> searchAll() {
		Connection conn = getConnection();
		ArrayList<Product> products = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt("Inch") == 0) {
					Refrigerator p = new Refrigerator();
					p.setVolume(rs.getInt("volume"));
					p.setNo(rs.getInt("productNo"));
					p.setName(rs.getString("Name"));
					p.setPrice(rs.getInt("price"));
					p.setStock(rs.getInt("Stock"));
					products.add(p);
				} else {
					TV p = new TV();
					p.setInch(rs.getInt("Inch"));
					p.setNo(rs.getInt("productNo"));
					p.setName(rs.getString("Name"));
					p.setPrice(rs.getInt("price"));
					p.setStock(rs.getInt("Stock"));
					products.add(p);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product searchByNo(int No) {
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from product where productNo = ?");
			ps.setInt(1, No);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if (rs.getInt("Inch") == 0) {
				Refrigerator p = new Refrigerator();
				p.setVolume(rs.getInt("volume"));
				p.setNo(rs.getInt("productNo"));
				p.setName(rs.getString("Name"));
				p.setPrice(rs.getInt("price"));
				p.setStock(rs.getInt("Stock"));
				return p;
			} else {
				TV p = new TV();
				p.setInch(rs.getInt("Inch"));
				p.setNo(rs.getInt("productNo"));
				p.setName(rs.getString("Name"));
				p.setPrice(rs.getInt("price"));
				p.setStock(rs.getInt("Stock"));
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new CodeNotFoundException(No);
	}

	@Override
	public ArrayList<Product> searchByName(String Name) {
		Connection conn = getConnection();
		ArrayList<Product> products = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from product where Name like ?");
			ps.setString(1, "%" +Name+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt("Inch") == 0) {
					Refrigerator p = new Refrigerator();
					p.setVolume(rs.getInt("volume"));
					p.setNo(rs.getInt("productNo"));
					p.setName(rs.getString("Name"));
					p.setPrice(rs.getInt("price"));
					p.setStock(rs.getInt("Stock"));
					products.add(p);
				} else {
					TV p = new TV();
					p.setInch(rs.getInt("Inch"));
					p.setNo(rs.getInt("productNo"));
					p.setName(rs.getString("Name"));
					p.setPrice(rs.getInt("price"));
					p.setStock(rs.getInt("Stock"));
					products.add(p);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public ArrayList<Product> searchTV() {

		Connection conn = getConnection();
		ArrayList<Product> products = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from product where Inch != 0");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TV p = new TV();
				p.setInch(rs.getInt("Inch"));
				p.setNo(rs.getInt("productNo"));
				p.setName(rs.getString("Name"));
				p.setPrice(rs.getInt("price"));
				p.setStock(rs.getInt("Stock"));
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;

	}

	@Override
	public ArrayList<Product> searchRefrigerator() {

		Connection conn = getConnection();
		ArrayList<Product> products = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from product where volume != 0");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Refrigerator p = new Refrigerator();
				p.setVolume(rs.getInt("volume"));
				p.setNo(rs.getInt("productNo"));
				p.setName(rs.getString("Name"));
				p.setPrice(rs.getInt("price"));
				p.setStock(rs.getInt("Stock"));
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;

	}

	@Override
	public boolean delete(int No) {
		Connection conn = getConnection();
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from product where productNo = ?");
			ps.setInt(1, No);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result == 0)
			return false;
		return true; 
		
	}





	@Override
	public boolean changePrice(int No, int changePrice) {
		Connection conn = getConnection();
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("update product set price = ? where productNo = ?");
			ps.setInt(1, changePrice);
			ps.setInt(2, No);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result == 0)
			return false;
		return true; 

	}




}
