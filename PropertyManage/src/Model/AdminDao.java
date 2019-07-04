/**
 * 
 */
package Model;

import java.sql.*;
import java.util.ArrayList;

import Name.AdminTable;

/**
 * @author lenovo
 *
 */
public class AdminDao {
	
	
	public boolean AddAdmin(String account,String password,String phone,String name) throws SQLException{
		Connection conn =null;
		try {
			conn= Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sqlj ="select * from admin where account= '"+account+"'";
			ResultSet rs=stmt.executeQuery(sqlj);
			if(rs.next()) return false;
			String sql="insert into admin(`account`,`password`,`phone`,`name`)values('"+account+"','"+password+"','"+phone+"','"+name+"')"; 
			int judge =stmt.executeUpdate(sql);
			if(judge==1) return true;
			else return false;
	}catch (SQLException s) {
		System.out.println(s);	
		return false;
	}
		finally {
		if (conn != null) {
			try {					
				conn.close();					
			} catch (SQLException ignore) {					
			}
		}
		}
	}
	
	public boolean DeleteAdmin(int id) throws SQLException{
		Connection conn = null;
		try {
			conn=Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql="update admin set admincol = 0 where id="+id;
			int judge = stmt.executeUpdate(sql);
			if ( judge == 1) return true;
			else return false;
	}catch (SQLException s) {
		System.out.println(s);	
		return false;
	}
		finally {
		if (conn != null) {
			try {					
				conn.close();					
			} catch (SQLException ignore) {					
			}
		}
		}
	}
	
	public boolean UpdateAdmin(AdminTable admin) throws SQLException{
		Connection conn = null;
		try {
			conn=Mysql.getCon();
			Statement stmt = conn.createStatement();
			int id = admin.getId();
			String account = admin.getAccount();
			String password = admin.getPassword();
			String name = admin.getName();
			String phone =admin.getPhone();
			String sql="update admin set account ='"+account+"', password='"+password+"', name='"+name+"', phone='"+phone+"' where id= "+id;
			int judge=stmt.executeUpdate(sql);
			if(judge==1) return true;
			else  return false;
	}catch (SQLException s) {
		System.out.println(s);	
		return false;
	}
		finally {
		if (conn != null) {
			try {					
				conn.close();					
			} catch (SQLException ignore) {					
			}
		}
		}
	}
	
	public ArrayList<AdminTable> SearchAdmin(String search) throws SQLException{
		Connection conn = null;
		ArrayList<AdminTable> AdminList =new ArrayList<AdminTable>();
		try {
			conn=Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql="select * from admin where"
				+ "(account like '%"+search+"%' or password like '%"+search+"%' or phone like '%"+search+"%'"
						+ "or name like '%"+search+"%') and admincol=1";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				AdminTable admin =new AdminTable();
				admin.setId(rs.getInt("id"));
				admin.setAccount(rs.getString("account"));
				admin.setPassword(rs.getString("password"));
				admin.setPhone(rs.getString("phone"));
				admin.setName(rs.getString("name"));
				AdminList.add(admin);
			}
			return AdminList;
	}catch (SQLException s) {
		System.out.println(s);	
		return null;
	}
		finally {
		if (conn != null) {
			try {					
				conn.close();					
			} catch (SQLException ignore) {					
			}
		}
		}
	}
	
	public AdminTable SearchAdminbyID(int id) throws SQLException{
		Connection conn =null;
//		ArrayList<AdminTable> AdminList =new ArrayList<AdminTable>();
		try {
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql="select * from admin where id ="+id+" and admincol=1";
			ResultSet rs=stmt.executeQuery(sql);
			AdminTable admin =new AdminTable();
			while(rs.next()){
				admin.setId(id);
				admin.setAccount(rs.getString("account"));
				admin.setPassword(rs.getString("password"));
				admin.setPhone(rs.getString("phone"));
				admin.setName(rs.getString("name"));
//				AdminList.add(admin);
			}
			return admin;
	}catch (SQLException s) {
		System.out.println(s);	
		return null;
	}
		finally {
		if (conn != null) {
			try {					
				conn.close();					
			} catch (SQLException ignore) {					
			}
		}
		}
	}
	
	public int logIn(String account,String password) {
		int type;
		Connection c = null;
		try {
			
			String passwd=" ";
			c = Mysql.getCon();

			Statement s = c.createStatement();

			String sql = "select * from admin where account = '" + account + "'";

			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				passwd = rs.getString("password");	
				type=rs.getInt("admincol");
				
			
//			System.out.println(acc);
		if(type == 0) 
					return 0;
		else { 
			if(passwd.equals(password)) 
				return type;
			else return -2;
		}
			}
			else return 0;
		}
		catch(SQLException s) {
			System.out.println(s);	
			return 0;
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
