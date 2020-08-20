package lab.ssafy.corona.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class CoronaPatientSwing extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField tfPatientId, tfName, tfAge, tfPhone;
	private JLabel lblPatientId, lblName, lblAge, lblPhone, lblGender, lblIsCorona, lblSpaces;
	private JComboBox<String> cbGender, cbIsCorona;
	private JButton btnNew, btnSave, btnRemove, btnList;
	private JTable tblPatientList;
	private DefaultTableModel model;

	private String[] columnNames = { "환자 ID", "이름", "나이", "성별", "전화번호", "코로나 여부" };

	private int selectedPatientId;
	private char modeJob;

	public CoronaPatientSwing() {
		createUI();
		listPatient();

		selectedPatientId = -1;
		modeJob = 'N';
	}

	private void createUI() {

		setUIFont(new javax.swing.plaf.FontUIResource("Sans", Font.PLAIN, 14));

		tblPatientList = new JTable();
		model = new DefaultTableModel();
		tblPatientList.setRowHeight(25);

		model.setColumnIdentifiers(columnNames);
		tblPatientList.setModel(model);
		// tblPatientList.setColumnSelectionAllowed(true);

		add(new JScrollPane(tblPatientList), BorderLayout.CENTER);

		Box patientInfo = Box.createHorizontalBox();
		add(patientInfo, BorderLayout.SOUTH);

		tfPatientId = new JTextField();
		tfPatientId.setEditable(false);
		tfName = new JTextField();
		tfAge = new JTextField();
		tfPhone = new JTextField();

		lblPatientId = new JLabel(" 환자 ID ");
		lblName = new JLabel(" 이름 ");
		lblAge = new JLabel(" 나이 ");
		lblPhone = new JLabel(" 휴대폰 ");
		lblGender = new JLabel(" 성별 ");
		lblIsCorona = new JLabel(" 코로나 ");
		lblSpaces = new JLabel("  ");

		String[] strGender = { "M", "F" };
		cbGender = new JComboBox<String>(strGender);
		String[] strIsCorona = { "Y", "N" };
		cbIsCorona = new JComboBox<String>(strIsCorona);

		btnNew = new JButton("New");
		btnSave = new JButton("Save");
		btnRemove = new JButton("Remove");
		btnRemove.setForeground(Color.RED);
		btnList = new JButton("List");
		btnList.setForeground(Color.BLUE);

		patientInfo.add(lblSpaces);

		patientInfo.add(lblPatientId);
		patientInfo.add(tfPatientId);

		patientInfo.add(lblName);
		patientInfo.add(tfName);

		patientInfo.add(lblSpaces);

		patientInfo.add(lblAge);
		patientInfo.add(tfAge);

		patientInfo.add(lblSpaces);

		patientInfo.add(lblGender);
		patientInfo.add(cbGender);

		patientInfo.add(lblSpaces);

		patientInfo.add(lblPhone);
		patientInfo.add(tfPhone);

		patientInfo.add(lblSpaces);

		patientInfo.add(lblIsCorona);
		patientInfo.add(cbIsCorona);

		patientInfo.add(lblSpaces);

		patientInfo.add(btnNew);
		patientInfo.add(btnSave);
		patientInfo.add(btnRemove);
		patientInfo.add(btnList);

		tblPatientList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = tblPatientList.getSelectedRow();
				tfPatientId.setText((String) tblPatientList.getValueAt(row, 0));
				tfName.setText((String) tblPatientList.getValueAt(row, 1));
				tfAge.setText((String) tblPatientList.getValueAt(row, 2));
				cbGender.setSelectedItem((String) tblPatientList.getValueAt(row, 3));
				tfPhone.setText((String) tblPatientList.getValueAt(row, 4));
				cbIsCorona.setSelectedItem((String) tblPatientList.getValueAt(row, 5));

				selectedPatientId = Integer.parseInt(tfPatientId.getText());
				modeJob = 'D';
			}
		});

		btnNew.addActionListener((e) -> {
			tfPatientId.setText("");
			tfName.setText("");
			tfAge.setText("");
			cbGender.setSelectedItem("M");
			tfPhone.setText("");
			cbIsCorona.setSelectedItem("N");

			modeJob = 'N';
		});

		btnSave.addActionListener((e) -> {
			switch (modeJob) {
			case 'N':
				addPatient();
				listPatient();
				break;
			case 'D':
				modifyPatient();
				listPatient();
				break;
			}
		});

		btnRemove.addActionListener((e) -> {
			removePatient();
			listPatient();
		});
		btnList.addActionListener((e) -> listPatient());
	}

	public void setUIFont(javax.swing.plaf.FontUIResource f) {
		java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}

	private void listPatient() {

		model.setRowCount(0);

		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/corona_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				"ssafy", "zcx13213");) {

			try (PreparedStatement ps = con
					.prepareStatement("select patient_id, name, age, gender, phone, is_corona from patient");
					ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					model.addRow(new Object[] { String.valueOf(rs.getInt(1)), String.valueOf(rs.getString(2)),
							String.valueOf(rs.getInt(3)), String.valueOf(rs.getString(4)),
							String.valueOf(rs.getString(5)), String.valueOf(rs.getString(6)) });
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addPatient() {
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/corona_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				"ssafy", "zcx13213");) {

			try (PreparedStatement ps = con.prepareStatement(
					" insert into patient(name, age, gender, phone, is_corona) values (?, ?, ?, ?, ?)");) {
				ps.setString(1, tfName.getText());
				ps.setInt(2, Integer.parseInt(tfAge.getText()));
				ps.setString(3, (String) cbGender.getSelectedItem());
				ps.setString(4, tfPhone.getText());
				ps.setString(5, (String) cbIsCorona.getSelectedItem());
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void modifyPatient() {
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/corona_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				"ssafy", "zcx13213");) {

			try (PreparedStatement ps = con.prepareStatement(
					" update patient set name = ?, age = ?, gender = ?, phone = ?, is_corona = ? where patient_id = ?");) {
				ps.setString(1, tfName.getText());
				ps.setInt(2, Integer.parseInt(tfAge.getText()));
				ps.setString(3, (String) cbGender.getSelectedItem());
				ps.setString(4, tfPhone.getText());
				ps.setString(5, (String) cbIsCorona.getSelectedItem());
				ps.setInt(6, selectedPatientId);
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void removePatient() {
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/corona_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				"ssafy", "zcx13213");) {

			try (PreparedStatement ps = con.prepareStatement(" delete from patient where patient_id = ?");) {
				ps.setInt(1, selectedPatientId);
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		CoronaPatientSwing ui = new CoronaPatientSwing();
		ui.setTitle("SSAFY V1 - 환자관리시스템 ");
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.setSize(1000, 600);
		ui.setLocationRelativeTo(null);
		ui.setResizable(true);
		ui.setVisible(true);
	}
}

class Patient {
	private int patientId;
	private String name;
	private int age;
	private String phone;
	private boolean isCorona;

	public Patient() {
	}

	public Patient(int patientId, String name, int age, String phone, boolean isCorona) {
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.isCorona = isCorona;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isCorona() {
		return isCorona;
	}

	public void setCorona(boolean isCorona) {
		this.isCorona = isCorona;
	}
}
