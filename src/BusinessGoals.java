import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class BusinessGoals extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	  Connection connectionobject = null;
	    Statement statementobject = null;
	    ResultSet resultsetobject = null;
	    private JTable tb1;
	    private JTextField tf2;
		

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
					BusinessGoals frame = new BusinessGoals();
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
	public BusinessGoals() {
		dbconnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1208, 529);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("QUERY-1");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					  String sqlquery ="SELECT CUSTOMER_NAME\r\n" + 
					  		"FROM F17_19_CUSTOMER\r\n" +
					  		"WHERE CUSTOMER_ID IN\r\n" +
					  		"(SELECT F17_19_ORDER_DETAILS.CUSTOMER_ID\r\n" + 
					  		"FROM F17_19_CUSTOMER, F17_19_ORDER_DETAILS\r\n" + 
					  		"WHERE ((ORDER_PRICE>'"+tf1.getText()+"') AND (F17_19_CUSTOMER.CUSTOMER_ID = F17_19_ORDER_DETAILS.CUSTOMER_ID))\r\n" + 
					  		"GROUP BY (F17_19_ORDER_DETAILS.CUSTOMER_ID) HAVING COUNT(*)>1 )";
					  	 
					  PreparedStatement zipcodefecthing = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = zipcodefecthing.executeQuery();
					  tf1.setText("");
					  tb1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e) {
						System.out.println(e);
					}

				
			}
		});
		btnNewButton.setBounds(39, 13, 116, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("QUERY-2");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sqlquery ="SELECT CUISINE_NAME,COUNT(CUISINE_NAME)\r\n" + 
					  		"FROM F17_19_CUISINE,F17_19_ORDER_DETAILS\r\n" +
					  		"WHERE F17_19_CUISINE.ITEM_ID = F17_19_ORDER_DETAILS.ITEM_ID\r\n" +
					  		"GROUP BY CUISINE_NAME\r\n" + 
					  		"HAVING COUNT(*)= (SELECT MAX(ABC)\r\n" + 
					  		"FROM (SELECT CUISINE_NAME,COUNT(CUISINE_NAME)AS ABC\r\n" +
					  		"FROM F17_19_ORDER_DETAILS,F17_19_CUISINE WHERE F17_19_CUISINE.ITEM_ID=F17_19_ORDER_DETAILS.ITEM_ID\r\n" +
					  		"GROUP BY CUISINE_NAME))";
					  		  PreparedStatement zipcodefecthing = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = zipcodefecthing.executeQuery();
					  tb1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}	 	
			}
		});
		btnNewButton_1.setBounds(39, 51, 116, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("QUERY-7");
		btnNewButton_2.setForeground(Color.GRAY);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         		String sqlquery ="SELECT DISTINCT EMP_NAME\r\n" + 
					  		"FROM F17_19_EMPLOYEE\r\n" +
					  		"WHERE EMP_ID IN\r\n" +
					  		"(SELECT DISTINCT F17_19_EMPLOYEE.EMP_ID\r\n" + 
					  		"FROM F17_19_EMPLOYEE, F17_19_DELIVER_DETAILS, F17_19_ORDER_DETAILS\r\n" + 
					  		"WHERE DEL_DATE = ORDER_DATE AND F17_19_DELIVER_DETAILS.VEHICLE_ID = F17_19_EMPLOYEE.VEHICLE_ID AND DEL_TIME - ORDER_TIME > INTERVAL '30' MINUTE\r\n" +
					  		"GROUP BY (F17_19_EMPLOYEE.EMP_ID) HAVING COUNT(*)>'"+tf2.getText()+"')ORDER BY EMP_NAME ASC";
					  PreparedStatement zipcodefecthing = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = zipcodefecthing.executeQuery();
					  tf2.setText("");
					  tb1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}	

				
			}
		});
		btnNewButton_2.setBounds(39, 240, 116, 25);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("IDENTIFY A CUSTOMER WHO HAVE USED EATHUB MORE THAN ONCE AND MADE A BILL MORE THAN $");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(168, 17, 587, 16);
		contentPane.add(lblNewLabel);
		
		tf1 = new JTextField();
		tf1.setBounds(743, 15, 26, 22);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 308, 644, 161);
		contentPane.add(scrollPane);
		
		tb1 = new JTable();
		scrollPane.setViewportView(tb1);
		
		JLabel query2 = new JLabel("IDENTIFY THE EMPLOYEES WHO HAVE MISSED TO DELIVER THE FOOD ON TIME FOR MORE THAN");
		query2.setForeground(new Color(255, 255, 255));
		query2.setBounds(167, 245, 562, 16);
		contentPane.add(query2);
		
		JLabel lblNewLabel_1 = new JLabel("IDENTIFY THE MOST POPULAR CUISINE BASED ON THE MAXIMUM ORDERS PLACED.");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(167, 55, 624, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("QUERY-4");
		btnNewButton_3.setForeground(Color.ORANGE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					  String sqlquery ="SELECT  ORDER_TIME\r\n" + 
					  		"FROM F17_19_ORDER_DETAILS\r\n" +
					  		"GROUP BY  ORDER_TIME\r\n" + 
					  		"HAVING COUNT(*)=(SELECT MAX(CAL)\r\n" + 
					  		"FROM (SELECT ORDER_TIME,COUNT(*) AS CAL\r\n" + 
					  		"FROM F17_19_ORDER_DETAILS\r\n" +
					  		"GROUP BY ORDER_TIME HAVING COUNT(*)>2))";
					  	 
					  PreparedStatement zipcodefecthing = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = zipcodefecthing.executeQuery();
					  tb1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}	
	
			}
		});
		btnNewButton_3.setBounds(39, 127, 116, 25);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("FIND OUT THE PEAK HOURS OF BUSINESS IN WHICH PEOPLE ORDER MORE THAN 2 TIMES.");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(168, 131, 579, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnQuery = new JButton("QUERY-5");
		btnQuery.setForeground(Color.CYAN);
		btnQuery.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
							String sqlquery ="SELECT F17_19_ORDER_DETAILS.ORDER_NUMBER, SUM(F17_19_ORDER_DETAILS.ORDER_PRICE)\r\n" + 
					  		"FROM F17_19_ORDER_DETAILS\r\n" + 
					  		"GROUP BY ROLLUP(F17_19_ORDER_DETAILS.ORDER_NUMBER)";
					  	 
					  PreparedStatement zipcodefecthing = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = zipcodefecthing.executeQuery();
					  tb1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}	

			}
		});
		btnQuery.setBounds(39, 165, 116, 25);
		contentPane.add(btnQuery);
		
		JLabel lblNewLabel_3 = new JLabel("FIND OUT THE  TOTAL PRICE SUMMARY OF EACH ORDER.");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(168, 169, 584, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_4 = new JButton("QUERY-6");
		btnNewButton_4.setForeground(Color.GREEN);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					  String sqlquery ="SELECT DISTINCT EMP_NAME\r\n" + 
					  		"FROM F17_19_EMPLOYEE\r\n" +
					  		"WHERE EMP_ID IN (SELECT EMP_ID\r\n" +
					  		"FROM  F17_19_DELIVER_DETAILS\r\n" + 
					  		"GROUP BY  EMP_ID\r\n" + 
					  		"HAVING  COUNT(*)= (SELECT MIN(CAL) \r\n" +
					  		"FROM (SELECT F17_19_DELIVER_DETAILS.EMP_ID,COUNT(*) AS CAL\r\n" +
					  		"FROM F17_19_ORDER_DETAILS,F17_19_DELIVER_DETAILS\r\n" +
					  		"WHERE DEL_DATE = ORDER_DATE AND DEL_TIME - ORDER_TIME > INTERVAL '30' MINUTE AND DEL_DATE BETWEEN '11-OCT-2017' AND '11-NOV-2017'\r\n" +
					  		"GROUP BY F17_19_DELIVER_DETAILS.EMP_ID)))";
					  	 
					  PreparedStatement zipcodefecthing = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = zipcodefecthing.executeQuery();
					  tb1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}	
	
			}
		});
		btnNewButton_4.setBounds(39, 203, 116, 25);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("IDENTIFY THE EMPLOYEE WHO HAS DELIVERED THE LEAST NUMBER OF ORDERS OVER A MONTH(11TH OCT - 11TTH NOV).");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(168, 207, 715, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton btnQuery_1 = new JButton("QUERY-3");
		btnQuery_1.setForeground(Color.MAGENTA);
		btnQuery_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuery_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
							String sqlquery ="SELECT DISTINCT CUSTOMER_NAME\r\n" + 
					  		"FROM F17_19_CUSTOMER WHERE CUSTOMER_ID IN (SELECT DISTINCT CUSTOMER_ID\r\n" +
					  		"FROM F17_19_ORDER_DETAILS\r\n" +
					  		"WHERE ORDER_DATE BETWEEN '11-NOV-2017' AND '12-DEC-2017' AND CUSTOMER_ID IN(SELECT DISTINCT CUSTOMER_ID\r\n" +  
					  		"FROM F17_19_ORDER_DETAILS\r\n" + 
					  		"GROUP BY CUSTOMER_ID HAVING COUNT(*)>=2))";
					  	 
					  PreparedStatement zipcodefecthing = connectionobject.prepareStatement(sqlquery);
					  resultsetobject = zipcodefecthing.executeQuery();
					  tb1.setModel(DbUtils.resultSetToTableModel(resultsetobject));
					}
					catch(SQLException e1) {
						System.out.println(e1);
					}	
			}
		});
		btnQuery_1.setBounds(39, 89, 116, 25);
		contentPane.add(btnQuery_1);
		
		JLabel lblNewLabel_5 = new JLabel("IDENTIFY THE CUSTOMERS WHO HAS ORDERED FOR ATLEAST 2 TIMES OR MORE OVER A MONTH (11TH NOV - 11TH DEC).");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(168, 93, 805, 16);
		contentPane.add(lblNewLabel_5);
		
		tf2 = new JTextField();
		tf2.setBounds(743, 242, 26, 22);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JLabel lblTimes = new JLabel("TIMES.");
		lblTimes.setForeground(new Color(255, 255, 255));
		lblTimes.setBounds(781, 243, 56, 20);
		contentPane.add(lblTimes);
		
		JButton btnMainPage = new JButton("MAIN PAGE");
		btnMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EathubMainPage mp = new EathubMainPage();
				mp.setVisible(true);
			}
		});
		btnMainPage.setBounds(969, 424, 97, 25);
		contentPane.add(btnMainPage);
		
		JLabel lb1 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/o2.jpg")).getImage();
		lb1.setIcon(new ImageIcon(img)); 
		lb1.setBounds(743, 126, 499, 300);
		contentPane.add(lb1);

	}
}