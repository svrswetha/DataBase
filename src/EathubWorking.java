import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EathubWorking extends JFrame {

	private JPanel contentPane;
	private final JLabel label = new JLabel("EATHUB");
	private JTextField textField;

    Connection connectionobject = null;
    Statement statementobject = null;
    ResultSet resultsetobject = null;
    private JTable table;

	/**
	 * Launch the application.
	 */
    public void dbconnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 connectionobject = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hms","hms");
		
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EathubWorking frame = new EathubWorking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EathubWorking() {
		dbconnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1395, 746);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		label.setBounds(535, 286, 238, 55);
		contentPane.add(label);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		
		JLabel lblEnterTheZipcode = new JLabel("ENTER THE ZIPCODE");
		lblEnterTheZipcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterTheZipcode.setForeground(Color.WHITE);
		lblEnterTheZipcode.setBounds(574, 375, 322, 16);
		contentPane.add(lblEnterTheZipcode);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(585, 427, 116, 22);
		contentPane.add(textField);
		Image img=new ImageIcon(this.getClass().getResource("/cover.png")).getImage();
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					  String sqlquery = "SELECT RESTAURANT_NAME FROM F17_19_RESTAURANT WHERE ZIPCODE = '" +textField.getText()+"' ";
					  PreparedStatement zipcodefecthing = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = zipcodefecthing.executeQuery();
					  table.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e) {
						System.out.println(e);
					}
			}
			
		});
		btnNewButton.setBounds(760, 426, 97, 25);
		contentPane.add(btnNewButton);
		
		JScrollPane table_1_1 = new JScrollPane();
		table_1_1.setBounds(303, 480, 752, 206);
		contentPane.add(table_1_1);
		
		table = new JTable();
		table_1_1.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("CONTINUE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WORKING_1 w1 = new WORKING_1();
				w1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(884, 426, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel working = new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/ch.jpg")).getImage();
		working.setIcon(new ImageIcon(img1)); 
		working.setBounds(361, 13, 1214, 337);
		contentPane.add(working);
	}
}
