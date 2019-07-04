package Model;


//	import java.sql.Connection;
//	import java.sql.DriverManager;
////	import java.sql.ResultSet;
////	import java.sql.SQLException;
//	import java.sql.Statement;
	import java.sql.*;

	public class Mysql {

		public static final String url = "jdbc:mysql://localhost:3306/property?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false&serverTimezone=UTC&autoReconnect=true";
		public static final String user = "root";
		public static final String password = "470820";
//
//		public  static Connection getConn() {
//	
//				return conn;
//			
//		}
//
//		public static void setConn(Connection conn) {
//			Mysql.conn = conn;
//		}
//
//		public static Statement getSmt() {
//			return smt;
//		}
//
//		public static void setSmt(Statement smt) {
//			Mysql.smt = smt;
	//	}

		static{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
//				conn = DriverManager.getConnection(url, user, password);
//				System.out.println("succsessful");
//				smt = conn.createStatement();
			} catch (ClassNotFoundException  e) {
				System.err.println("Jdbc Driver not found");
			}
		}
		public static java.sql.Connection getCon() throws SQLException{
			
				//Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url, user, password);
				//System.out.println("succsessful");
				return conn;
			} 
		}


