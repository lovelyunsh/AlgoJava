package lab.ssafy.corona.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCMySQLTest5 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/corona_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				"ssafy", "zcx13213");) {
			con.setAutoCommit(false);
			boolean isCommit = true;
			try (PreparedStatement ps = con.prepareStatement("delete from patient where name = ? ");) {

				ps.setString(1, "유환자");
				ps.executeUpdate();

			} catch (SQLException e) {
				isCommit = false;
				e.printStackTrace();
			}

			try (PreparedStatement ps = con
					.prepareStatement("insert2 into patient(name, age, gender, phone) values (?, ?, ?, ?)");) {

				ps.setString(1, "유환자");
				ps.setInt(2, 40);
				ps.setString(3, "F");
				ps.setString(4, "01099999999");
				ps.executeUpdate();

			} catch (SQLException e) {
				isCommit = false;
				e.printStackTrace();
			}
			if (isCommit)
				con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}