import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Canvas;
import java.io.*;
import javax.imageio.*;
import java.awt.SystemColor;

public class EathubMainPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
					EathubMainPage frame = new EathubMainPage();
					frame.setVisible(true);
				
					//frame.setContentPane(new JLabel(new ImageIcon("apitite.jpg")));
				
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Image Doesn't exist");
				}
			}
			
		});
		
	}

	/**
	 * Create the frame.
	 */
	public EathubMainPage() {
		dbconnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1277, 777);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 153, 255));
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    
		JLabel lblEathubtittle = new JLabel("EATHUB");
		lblEathubtittle.setForeground(new Color(255, 255, 255));
		lblEathubtittle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblEathubtittle.setBounds(510, 303, 256, 96);
		contentPane.add(lblEathubtittle);
		
		JButton btnNewButton = new JButton("FUNCTIONALITIES");
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Functionalities f = new Functionalities();
				f.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(478, 580, 273, 25);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(82, 510, 339, -212);
		contentPane.add(table);
		
		JButton btnEathubDetails = new JButton("EATHUB DETAILS");
		btnEathubDetails.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btnEathubDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EathubDetails ed = new EathubDetails();
				ed.setVisible(true);
				
			}
		});
		btnEathubDetails.setBounds(478, 457, 273, 25);
		contentPane.add(btnEathubDetails);
		
		JButton btnNewButton_1 = new JButton("BUSINESS GOALS");
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BusinessGoals bg = new BusinessGoals();
				bg.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(478, 645, 273, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel l1 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/cover.png")).getImage();
		l1.setIcon(new ImageIcon(img)); 
		l1.setBounds(0, 0, 1259, 206);
		contentPane.add(l1);
		
		JButton btnNewButton_2 = new JButton("EATHUB WORKING");
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EathubWorking EW = new EathubWorking();
				EW.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(478, 520, 273, 25);
		contentPane.add(btnNewButton_2);
	}
}
