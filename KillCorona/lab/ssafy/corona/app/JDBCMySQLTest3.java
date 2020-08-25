package lab.ssafy.corona.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMySQLTest3 {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/corona_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
					"ssafy", "zcx13213");
			ps = con.prepareStatement(" update patient set age = 30 where name = ? ");
			ps.setString(1, "유환자");
			ps.executeUpdate();

			ps.close();

			ps = con.prepareStatement(" select name, age, gender, phone from patient where name = ? ");
			ps.setString(1, "유환자");

			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("name") + " : " + rs.getInt("age") + " : " + rs.getString("gender")
						+ " : " + rs.getString("phone"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
