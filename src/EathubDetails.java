import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import oracle.jdbc.driver.DBConversion;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EathubDetails extends JFrame {

	private JPanel contentPane;
	 Connection connectionobject = null;
	    Statement statementobject = null;
	    ResultSet resultsetobject = null;
	    private JTable table_1;

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
					EathubDetails frame = new EathubDetails();
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
	public EathubDetails() {
		dbconnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1416, 741);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLICK TO VIEW THE TABLES DETAILS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(560, 233, 365, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CUSTOMER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String sqlquery = "SELECT * FROM F17_19_CUSTOMER";
					  PreparedStatement details = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = details.executeQuery();
					  table_1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(109, 297, 171, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESTAURANT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String sqlquery = "SELECT * FROM F17_19_RESTAURANT";
					  PreparedStatement details = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = details.executeQuery();
					  table_1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(109, 349, 171, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MENU");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String sqlquery = "SELECT * FROM F17_19_MENU";
					  PreparedStatement details = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = details.executeQuery();
					  table_1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(109, 402, 171, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VEHICLE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String sqlquery = "SELECT * FROM F17_19_VEHICLE";
					  PreparedStatement details = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = details.executeQuery();
					  table_1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(109, 455, 171, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("EMPLOYEE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String sqlquery = "SELECT * FROM F17_19_EMPLOYEE";
					  PreparedStatement details = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = details.executeQuery();
					  table_1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(109, 512, 171, 25);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("ORDER DETAILS");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String sqlquery = "SELECT * FROM F17_19_ORDER_DETAILS";
					  PreparedStatement details = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = details.executeQuery();
					  table_1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}
				
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_5.setBounds(109, 567, 171, 25);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("DELIVER DETAILS");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String sqlquery = "SELECT * FROM F17_19_DELIVER_DETAILS";
					  PreparedStatement details = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = details.executeQuery();
					  table_1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_6.setBounds(109, 618, 171, 25);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("MAIN PAGE");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EathubMainPage mp = new EathubMainPage();
				mp.setVisible(true);
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_7.setBounds(1224, 656, 135, 25);
		contentPane.add(btnNewButton_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(364, 293, 807, 350);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JLabel l1 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/cover.png")).getImage();
		l1.setIcon(new ImageIcon(img)); 
		
		l1.setBounds(0, 14, 1386, 206);
		contentPane.add(l1);
	}
}
