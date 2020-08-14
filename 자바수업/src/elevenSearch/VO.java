package elevenSearch;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import java.awt.Panel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Button;

public class VO {
	JFrame f;
	JList li;
	DAO dao;
	Button button;
	static Panel panel_1;
	static Panel panel_2;
	static JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblNewLabel_1;
	private JLabel label_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_4;
	private JTextField textField;
	
	public VO() {
		dao = new DAO();
		createGUI();
		addEvent();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void createGUI() {
		f = new JFrame("Search");
		JPanel p = new JPanel();
		p.setBounds(0, 0, 589, 264);
		li = new JList();
		f.getContentPane().setLayout(null);
		p.setLayout(new BorderLayout());
		p.add(li);
		f.getContentPane().add(p);

		JPanel panel = new JPanel();
		panel.setBounds(0, 262, 589, 271);
		f.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		panel_1 = new Panel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 261, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 296, SpringLayout.WEST, panel);
		panel.add(panel_1);

		panel_2 = new Panel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 6, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 261, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 283, SpringLayout.EAST, panel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("http://i.011st.com/t/300/pd/20/9/1/2/3/0/8/gOiQn/2660912308_L300.jpg"));
		panel_1.add(lblNewLabel);
		panel.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		label = new JLabel("\uC0C1\uD488\uBA85 :");
		sl_panel_2.putConstraint(SpringLayout.NORTH, label, 38, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, panel_2);
		panel_2.add(label);
		
		lblNewLabel_1 = new JLabel("\uAC00\uACA9 :");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 26, SpringLayout.SOUTH, label);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, label);
		panel_2.add(lblNewLabel_1);
		
		label_1 = new JLabel("");
		sl_panel_2.putConstraint(SpringLayout.NORTH, label_1, 46, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, label_1, 30, SpringLayout.WEST, panel_2);
		panel_2.add(label_1);
		
		lblNewLabel_2 = new JLabel("\uBC30\uB2EC\uB8CC : ");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 4, SpringLayout.SOUTH, label_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, label);
		panel_2.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel(" ");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, label);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_3, 6, SpringLayout.EAST, label);
		panel_2.add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel(" ");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel_3);
		panel_2.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel(" ");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_4, 16, SpringLayout.EAST, lblNewLabel_1);
		panel_2.add(lblNewLabel_4);
		
		textField = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, label_1);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, textField, -30, SpringLayout.SOUTH, panel_2);
		panel_2.add(textField);
		textField.setColumns(10);
		
		button = new Button("Search");
		sl_panel_2.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, textField);
		sl_panel_2.putConstraint(SpringLayout.WEST, button, 14, SpringLayout.EAST, textField);
		panel_2.add(button);
		f.setSize(605, 572);
		f.setVisible(true);
	}

	public void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);}		
		});
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showList(textField.getText());
				
			}
			
			
		});
		
		li.addListSelectionListener(new ListSelectionListener() {
			
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				ProductMO mo = (ProductMO)li.getSelectedValue();
				Image image = null;
				try {
					image = ImageIO.read(new URL(mo.getProductImage()));
					image = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ImageIcon image1 = new ImageIcon(image);
				
				lblNewLabel.setIcon(image1);
				lblNewLabel_3.setText(mo.getProductName());
				lblNewLabel_4.setText(mo.getProductPrice());
				lblNewLabel_5.setText(mo.getDelivery());
				
				
			}
		});
		
	}

	public void showList(String target) {
		java.util.List<ProductMO> datas = dao.Search(target);
		li.removeAll();
		li.setListData(datas.toArray());

	}

	public static void main(String[] args) {
		new VO();
	}
}
