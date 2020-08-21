package SDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import SMO.Seat;

public class SDAO {
	private SDAO() {
	};

	static SDAO dao;

	static public SDAO getinstance() {
		if (dao == null)
			dao = new SDAO();
		return dao;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ssafyseat?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
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

	public void add(Seat s) {
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into ssafyseat(name1,age1,gender1,row1,col1) values(?,?,?,?,?)");
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setString(3, s.getGender());
			ps.setInt(4, s.getRow());
			ps.setInt(5, s.getCol());
			ps.executeUpdate();
			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Seat> searchAll() {
		Connection conn = getConnection();
		List<Seat> seat = new ArrayList<Seat>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from ssafyseat");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				seat.add(new Seat(rs.getString("name1"), rs.getString("gender1"), rs.getInt("age1"), rs.getInt("row1"),
						rs.getInt("col1")));
			}
			close(rs);
			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seat;
	}

	public Seat searchByrowcol(int row, int col) {
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from ssafyseat where row1 = ? and col1 = ?");
			ps.setInt(1, row);
			ps.setInt(2, col);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Seat(rs.getString("name1"), rs.getString("gender1"), rs.getInt("age1"), rs.getInt("row1"),
						rs.getInt("col1"));
			}
			close(rs);
			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public void update(int row, int col, int c_row , int c_col) {
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("update ssafyseat set row1 = ?, col1 = ? where row1 = ? and col1 = ?");
			ps.setInt(1, c_row);
			ps.setInt(2, c_col);
			ps.setInt(3, row);
			ps.setInt(4, col);
			ps.executeUpdate();
			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Seat searchByName(String name) {
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from ssafyseat where name1 = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Seat(rs.getString("name1"), rs.getString("gender1"), rs.getInt("age1"), rs.getInt("row1"),
						rs.getInt("col1"));
			}
			close(rs);
			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
		
	}
	public void delete(int row , int col) {
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from ssafyseat where row1 = ? and col1 = ?");
			ps.setInt(1, row);
			ps.setInt(2, col);
			
			ps.executeUpdate();
			close(ps);
			close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	  public int[] shuffle(){
		    int arr[] = new int[28];
		    //배열 초기화
		    for (int i=0; i<arr.length; i++){
		      arr[i] = i;
		    }
		    int w=0;
		    int r;
		    int temp;
		    while(w < arr.length){
		      r = (int)(Math.random()*arr.length);
		      if(w!=r){
		        temp = arr[w];
		        arr[w] = arr[r];
		        arr[r] = temp;
		        w++;
		      }
		    }
			return arr;
		  }

}
