/**
 * 
 */
package Model;

import java.sql.*;

/**
 * @author ∫Œ¡˙œË
 *
 */
public class SuperAdminDAO {
	
	public boolean login(String account ,String password) {
		Connection c = null;
		try {
			
			String passwd=" ";
			c = Mysql.getCon();

			Statement s = c.createStatement();

			String sql = "select * from superadmin where account = '" + account + "'";

			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				passwd = rs.getString("password");	
 
				if(passwd.equals(password)) {
					return true;
				}else {
					return false;
				}
		
			}else {
				return false;
			}
		}
		catch(SQLException s) {
			System.out.println(s);	
			return false;
		}
		finally {
			if (c != null) {
				try {					
					c.close();					
				} catch (SQLException ignore) {					
				}
			
			}
		
	}
	}
}
