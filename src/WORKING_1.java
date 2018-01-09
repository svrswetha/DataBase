import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
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
import java.awt.Color;
import java.awt.Font;

public class WORKING_1 extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	 Connection connectionobject = null;
	    Statement statementobject = null;
	    ResultSet resultsetobject = null;
	    private JLabel lb1;
	   

		
	    public void dbconnection(){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 connectionobject = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hms","hms");
			
			}
			catch(Exception e) {
				System.out.println(e);
				
			}
		}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WORKING_1 frame = new WORKING_1();
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
	public WORKING_1() {
		dbconnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1305, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER THE RESTAURANT NAME:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(353, 295, 339, 31);
		contentPane.add(lblNewLabel_1);
		
		tf1 = new JTextField();
		tf1.setBounds(671, 301, 116, 22);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JButton btnFetchMenu = new JButton("FETCH MENU");
		btnFetchMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res_name=tf1.getText();
				switch(res_name) {
				case "STAR INDIA":
						StarIndia si = new StarIndia();
						si.setVisible(true);
						break;
				}
					        
				}
			
			
		});
		btnFetchMenu.setBounds(539, 431, 153, 25);
		contentPane.add(btnFetchMenu);
		
		lb1 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/o2.jpg")).getImage();
		lb1.setIcon(new ImageIcon(img)); 
		lb1.setIcon(new ImageIcon(img)); 
		lb1.setBounds(-90, 40, 1377, 206);
		contentPane.add(lb1);
	}

}
