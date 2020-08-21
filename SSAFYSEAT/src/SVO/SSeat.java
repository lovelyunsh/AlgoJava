package SVO;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import SDAO.SDAO;
import SMO.Seat;

public class SSeat {
	private JFrame frame;
	private JTable table;
	SDAO dao;
	List<Seat> allseat;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_11;
	JLabel lblNewLabel_12;
	JLabel lblNewLabel_7;
	JLabel lblNewLabel_8;
	JLabel lblNewLabel_9;
	JLabel lblNewLabel_10;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SSeat window = new SSeat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SSeat() {
		dao = SDAO.getinstance();
		allseat = dao.searchAll();
		initialize();
	}

	public void seatChange() {
		allseat = dao.searchAll();
		Object[][] obj = new Object[][] { { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, };
		if (allseat.size() != 0) {
			for (Seat s : allseat) {
				obj[s.getRow()][s.getCol()] = s.getName();
			}
			table.setModel(new DefaultTableModel(obj,
					new String[] { "New column", "New column", "New column", "New column" }));
		}
	}

	public void rowcolSet(int row, int col) {
		lblNewLabel_11.setText("" + row);
		lblNewLabel_12.setText("" + col);
		Seat s = dao.searchByrowcol(row, col);
		Image image = null;

		if (s != null) {
			lblNewLabel_7.setText("" + s.getName());
			lblNewLabel_8.setText("" + s.getAge());
			lblNewLabel_9.setText("" + s.getGender());
			lblNewLabel_10.setText(row + "," + col);

			try {
				image = ImageIO.read(new File("C:\\SSAFY\\AlgoJava\\SSAFYSEAT\\ssafyface\\" + s.getName() + ".jpg"));
				image = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			lblNewLabel_2.setIcon(new ImageIcon(image));
		} else {
			lblNewLabel_7.setText("");
			lblNewLabel_8.setText("");
			lblNewLabel_9.setText("");
			lblNewLabel_10.setText("");
			lblNewLabel_2.setIcon(null);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.setBounds(100, 100, 860, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowcolSet(table.getSelectedRow(), table.getSelectedColumn());
			}
		});
		table.setBackground(new Color(245, 245, 245));
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, -37, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, -340, SpringLayout.EAST, frame.getContentPane());
		table.setRowHeight(62);

		Object[][] obj = new Object[][] { { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, };

		table.setModel(
				new DefaultTableModel(obj, new String[] { "New column", "New column", "New column", "New column" }));
		frame.getContentPane().add(table);
		seatChange();
		JLabel lblNewLabel = new JLabel("광주2반자리시스템");
		springLayout.putConstraint(SpringLayout.NORTH, table, 11, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -482, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, frame.getContentPane());
		lblNewLabel.setBackground(Color.PINK);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -748, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 6, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, frame.getContentPane());
		lblNewLabel_1.setIcon(new ImageIcon("C:\\SSAFY\\AlgoJava\\SSAFYSEAT\\ssafyface\\header-logo.jpg"));
		frame.getContentPane().add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 11, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, panel, 6, SpringLayout.EAST, table);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 261, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, panel, 330, SpringLayout.EAST, table);
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		lblNewLabel_2 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 23, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 106, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("이   름 :");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 33, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("나   이 :");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 33, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_3, 23, SpringLayout.EAST, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -6, SpringLayout.NORTH, lblNewLabel_4);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("성   별 :");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 33, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -6, SpringLayout.NORTH, lblNewLabel_5);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("자   리 :");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 33, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -41, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -5, SpringLayout.NORTH, lblNewLabel_6);
		panel.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 0, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_7, 6, SpringLayout.EAST, lblNewLabel_3);
		panel.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_8, 0, SpringLayout.WEST, lblNewLabel_7);
		panel.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_9, 0, SpringLayout.WEST, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_9, 0, SpringLayout.SOUTH, lblNewLabel_5);
		panel.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_10, 0, SpringLayout.WEST, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_10, 0, SpringLayout.SOUTH, lblNewLabel_6);
		panel.add(lblNewLabel_10);

		lblNewLabel_11 = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 6, SpringLayout.SOUTH, panel);
		frame.getContentPane().add(lblNewLabel_11);

		lblNewLabel_12 = new JLabel("0");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_12, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_12, 23, SpringLayout.EAST, lblNewLabel_11);
		frame.getContentPane().add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("현재 선택 위치:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_13, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_11, 16, SpringLayout.EAST, lblNewLabel_13);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_13, 10, SpringLayout.WEST, panel);
		frame.getContentPane().add(lblNewLabel_13);

		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 25, SpringLayout.SOUTH, lblNewLabel_11);
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblNewLabel_13);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("추가");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField.getText();
				int age = Integer.parseInt(textField_1.getText());
				String gender = textField_2.getText();
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				dao.add(new Seat(name, gender, age, row, col));
				seatChange();

			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, -1, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 13, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 79, SpringLayout.EAST, textField);
		frame.getContentPane().add(btnNewButton);

		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 477, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, -28, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, lblNewLabel_13);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel label = new JLabel("이름");
		springLayout.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.SOUTH, lblNewLabel_13);
		springLayout.putConstraint(SpringLayout.WEST, label, 61, SpringLayout.EAST, table);
		frame.getContentPane().add(label);

		JLabel lblNewLabel_14 = new JLabel("나이");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_14, 0, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_14, -6, SpringLayout.NORTH, textField_1);
		frame.getContentPane().add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("성별");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_15, 0, SpringLayout.WEST, label);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_15, -6, SpringLayout.NORTH, textField_2);
		frame.getContentPane().add(lblNewLabel_15);

		JButton btnNewButton_1 = new JButton("삭제");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dao.delete(table.getSelectedRow(), table.getSelectedColumn());
				seatChange();

			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 45, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 72, SpringLayout.EAST, btnNewButton);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Shuffle");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int [] ran = dao.shuffle();
				List<Seat> s = dao.searchAll();
				for(int i = 0 ; i < s.size() ; i++) {
					dao.update(s.get(i).getRow(), s.get(i).getCol(), ran[i]/4, ran[i]%4);
				}
				seatChange();
				
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 0, SpringLayout.SOUTH, table);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -30, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_2);
	}
}
