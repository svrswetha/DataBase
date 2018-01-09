import java.sql.*;
import javax.swing.JOptionPane;

public class DatabaseConnection {
	public static void main(String args[]) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hms","hms");
			JOptionPane.showMessageDialog(null, "Established Connection");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
	}

}
