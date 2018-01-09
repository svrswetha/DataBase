import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JCheckBox;
import java.awt.Color;

public class StarIndia extends JFrame {

	private JPanel lb3;
	Connection connectionobject = null;
    Statement statementobject = null;
    ResultSet resultsetobject = null;
    
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
					StarIndia frame = new StarIndia();
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
	public StarIndia() {
		dbconnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1076, 485);
		lb3 = new JPanel();
		lb3.setBackground(new Color(0, 0, 0));
		lb3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(lb3);
		lb3.setLayout(null);
		
		JButton btnMainPage = new JButton("MAIN PAGE");
		btnMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EathubMainPage mp = new EathubMainPage();
				mp.setVisible(true);
			}
		});
		btnMainPage.setBounds(576, 400, 97, 25);
		lb3.add(btnMainPage);
		
		JCheckBox CG1 = new JCheckBox("GOBI 65\r\n PRICE: 9.99\r\n SIZE: LARGE");
		CG1.setBackground(new Color(0, 0, 0));
		CG1.setForeground(new Color(255, 255, 255));
		CG1.setBounds(170, 246, 315, 25);
		lb3.add(CG1);
		
		JCheckBox CB1 = new JCheckBox("CHEFS BIRYANI SPECIAL\r\n PRICE: 13.01\r\n SIZE: MEDIUM");
		CB1.setBackground(new Color(0, 0, 0));
		CB1.setForeground(new Color(255, 255, 255));
		CB1.setBounds(170, 284, 346, 25);
		lb3.add(CB1);
		
		JCheckBox R1 = new JCheckBox("RASMALAI\r\n PRICE: 6.99\r\n SIZE: SMALL\r\n");
		R1.setBackground(new Color(0, 0, 0));
		R1.setForeground(new Color(255, 255, 255));
		R1.setBounds(170, 322, 315, 25);
		lb3.add(R1);
		
		JCheckBox CB2 = new JCheckBox("CHEFS BIRYANI SPECIAL\r\n PRICE: 11.01\r\n SIZE: SMALL");
		CB2.setBackground(new Color(0, 0, 0));
		CB2.setForeground(new Color(255, 255, 255));
		CB2.setBounds(562, 246, 369, 25);
		lb3.add(CB2);
		
		JCheckBox M2 = new JCheckBox("MALAI KOFTA\r\n PRICE: 7.99\r\n SIZE: SMALL");
		M2.setBackground(new Color(0, 0, 0));
		M2.setForeground(new Color(255, 255, 255));
		M2.setBounds(562, 284, 328, 25);
		lb3.add(M2);
		
		JCheckBox G2 = new JCheckBox("GOBI 65\r\n PRICE: 6.99\r\n SIZE: SMALL");
		G2.setBackground(new Color(0, 0, 0));
		G2.setForeground(new Color(255, 255, 255));
		G2.setBounds(562, 322, 328, 25);
		lb3.add(G2);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = null;
				double price1=0.00,price2=0.00,price3=0.00,price4=0.00,price5=0.00,price6=0.00;
				if(CG1.isSelected()) {
				price1=9.99;
				}
				 if(CB1.isSelected()) {
					price2=13.01;
				}
				 if(R1.isSelected()) {
						price3=6.99;
				}
			    if(CB2.isSelected()) {
							price4=11.01;
					}
				if(M2.isSelected()) {
								price5=7.99;
						}
				if(G2.isSelected())
									price6=6.99;
				double total=price1+price2+price3+price4+price5+price6+10;
				int dialogResult =	JOptionPane.showConfirmDialog(null, "Please confirm your order");
				if(dialogResult == JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Your Order is confirmed\n Your Order Price:"+total);
				}
				else if(dialogResult == JOptionPane.NO_OPTION){
					JOptionPane.showMessageDialog(null, "Please order again");
				}
			   else if(dialogResult== JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, EXIT_ON_CLOSE);
				   
	
				}
				
				}
			
		});
		btnConfirm.setBounds(394, 400, 97, 25);
		lb3.add(btnConfirm);
		Image img=new ImageIcon(this.getClass().getResource("/cover.png")).getImage();
		
		JLabel lb2 = new JLabel("New label");
		Image img1=new ImageIcon(this.getClass().getResource("/o1.png")).getImage();
		lb2.setIcon(new ImageIcon(img1)); 
		lb2.setBounds(4, 13, 572, 216);
		lb3.add(lb2);
	}
}
