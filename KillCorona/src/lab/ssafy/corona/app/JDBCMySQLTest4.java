package lab.ssafy.corona.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMySQLTest4 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/corona_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				"ssafy", "zcx13213");) {

			try (PreparedStatement ps = con.prepareStatement("delete from patient where name = ? ");) {

				ps.setString(1, "유환자");
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			try (PreparedStatement ps = con.prepareStatement("select name, age, gender, phone from patient");
					ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					System.out.println(rs.getString("name") + " : " + rs.getInt("age") + " : " + rs.getString("gender")
							+ " : " + rs.getString("phone"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}