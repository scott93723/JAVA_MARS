import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.ucanaccess.jdbc.JackcessOpenerInterface;

public class DB_Con_Select01 {
	public static void main(String[] args) throws SQLException {
		//1.驅動程式
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.連結資料庫&檔案路徑
		Connection con = DriverManager.getConnection("jdbc:ucanaccess://d:/地址.mdb");
		Statement smt = con.createStatement();
		//3.執行SQL
		ResultSet rs = smt.executeQuery("SELECT * from 地址");
		System.out.println("編號\t姓名\t住址");
		
		while (rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}
		con.close();
	}
}
