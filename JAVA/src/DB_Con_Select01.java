import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.ucanaccess.jdbc.JackcessOpenerInterface;

public class DB_Con_Select01 {
	public static void main(String[] args) throws SQLException {
		//1.�X�ʵ{��
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.�s����Ʈw&�ɮ׸��|
		Connection con = DriverManager.getConnection("jdbc:ucanaccess://d:/�a�}.mdb");
		Statement smt = con.createStatement();
		//3.����SQL
		ResultSet rs = smt.executeQuery("SELECT * from �a�}");
		System.out.println("�s��\t�m�W\t��}");
		
		while (rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}
		con.close();
	}
}
