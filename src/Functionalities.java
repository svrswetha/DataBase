import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Functionalities extends JFrame {

	private JPanel contentPane;
	 Connection connectionobject = null;
	    Statement statementobject = null;
	    ResultSet resultsetobject = null;

	private JTable tb1;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf7;

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
					Functionalities frame = new Functionalities();
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
	public Functionalities() {
		dbconnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					  String sqlquery = "INSERT INTO F17_19_CUSTOMER (CUSTOMER_ID,CUSTOMER_NAME,DOB,PHONE#,EMAIL_ID,AREA,ZIPCODE) VALUES (?,?,?,?,?,?,?)";
					  PreparedStatement p = connectionobject.prepareStatement(sqlquery);
					  
			          p.setString(1, tf1.getText());
					  p.setString(2, tf2.getText());
			          p.setString(3, tf3.getText());
			          p.setString(4, tf4.getText());
					  p.setString(5, tf5.getText());
				      p.setString(6, tf6.getText());
			          p.setString(7, tf7.getText());
     				  p.execute();
					  JOptionPane.showMessageDialog(null, "ROW INSERTED");
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}
			}
				
					});
		btnAdd.setBounds(61, 482, 97, 25);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String sqlquery = "DELETE FROM F17_19_CUSTOMER WHERE CUSTOMER_ID = '" +tf1.getText()+"' ";
					  PreparedStatement zipcodefecthing = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = zipcodefecthing.executeQuery();
					  JOptionPane.showMessageDialog(null, "ROW DELETED");
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}
			
				
			}
		});
		btnDelete.setBounds(195, 482, 97, 25);
		contentPane.add(btnDelete);
		
		JButton btnModify = new JButton("MODIFY");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				
				
				
				
				
				try {
					  String sqlquery = "UPDATE F17_19_CUSTOMER SET CUSTOMER_NAME=?,DOB=?,PHONE#=?,EMAIL_ID=?,AREA=?,ZIPCODE=? WHERE CUSTOMER_ID =?";
					  PreparedStatement p = connectionobject.prepareStatement(sqlquery);
					  p.setString(1, tf2.getText());
			          p.setString(2, tf3.getText());
			          p.setString(3, tf4.getText());
					  p.setString(4, tf5.getText());
				      p.setString(5, tf6.getText());
			          p.setString(6, tf7.getText());	
			          p.setString(7, tf1.getText());
			          p.execute();
					  JOptionPane.showMessageDialog(null, "ROW MODIFIED");
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}
			} 
			
			
		});
		btnModify.setBounds(327, 482, 97, 25);
		contentPane.add(btnModify);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(61, 247, 148, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblRestuarantId = new JLabel("NAME");
		lblRestuarantId.setForeground(new Color(255, 255, 255));
		lblRestuarantId.setBounds(61, 276, 148, 16);
		contentPane.add(lblRestuarantId);
		
		JLabel lblPhone = new JLabel("DOB");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setBounds(61, 305, 148, 16);
		contentPane.add(lblPhone);
		
		JLabel lblOpeningTime = new JLabel("PHONE");
		lblOpeningTime.setForeground(new Color(255, 255, 255));
		lblOpeningTime.setBounds(61, 334, 148, 16);
		contentPane.add(lblOpeningTime);
		
		JLabel lblClosingTime = new JLabel("EMAIL");
		lblClosingTime.setForeground(new Color(255, 255, 255));
		lblClosingTime.setBounds(61, 363, 148, 16);
		contentPane.add(lblClosingTime);
		
		JLabel lblArea = new JLabel("AREA");
		lblArea.setForeground(new Color(255, 255, 255));
		lblArea.setBounds(61, 393, 148, 16);
		contentPane.add(lblArea);
		
		JLabel lblZipcode = new JLabel("ZIPCODE");
		lblZipcode.setForeground(new Color(255, 255, 255));
		lblZipcode.setBounds(61, 422, 148, 16);
		contentPane.add(lblZipcode);
		
		tf1 = new JTextField();
		tf1.setBounds(223, 242, 116, 22);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(223, 271, 116, 22);
		contentPane.add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(223, 300, 116, 22);
		contentPane.add(tf3);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(223, 329, 116, 22);
		contentPane.add(tf4);
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		tf5.setBounds(223, 358, 116, 22);
		contentPane.add(tf5);
		
		tf6 = new JTextField();
		tf6.setColumns(10);
		tf6.setBounds(223, 388, 116, 22);
		contentPane.add(tf6);
		
		tf7 = new JTextField();
		tf7.setColumns(10);
		tf7.setBounds(223, 416, 116, 22);
		contentPane.add(tf7);
		
		JButton btnMainPage = new JButton("MAIN PAGE");
		btnMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EathubMainPage mp = new EathubMainPage();
				mp.setVisible(true);
			}
		});
		btnMainPage.setBounds(831, 482, 97, 25);
		contentPane.add(btnMainPage);
		
		JLabel lb1 = new JLabel("");
        Image img=new ImageIcon(this.getClass().getResource("/cover.png")).getImage();
		lb1.setIcon(new ImageIcon(img)); 
		lb1.setBounds(0, 0, 968, 201);
		contentPane.add(lb1);
	}
}
