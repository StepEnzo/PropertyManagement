/**
 * 
 */
package Model;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

//import Name.Pus;
//import Name.Pus;
import Name.User;

/**
 * @author gzc
 *
 */
public class UserDAO {
	
	
	
	public static UserDAO getInstance() {
		return new UserDAO();
	}

	
	/*
	 * 通过输入的用户id从user表中查询与其相关的数据。
	 * @param 用户id，int
	 * @return user类的列表
	 */
	public User selectByUserid(int id) {
		Connection conn = null;
		User user = new User();
		try {
			
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql="select account,password,phone,username,usercontrol from user where id = "+id; 
			ResultSet rs=stmt.executeQuery(sql);
			if (rs.next()) {
				user.setId(id);
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setUsercontrol(rs.getInt("usercontrol"));
			}
			return user;
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
	
	public int selectidByAccount(String account) {
		Connection conn = null;
		int id;
		try {
			
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql="select id from user where account = '"+account+"'"; 
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
				id = rs.getInt("id");
			else id=0;
			return id;
	}catch (SQLException s) {
		System.out.println(s);	
		return 0;
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
	public List<User> list(int start, int count) {
		List<User> users = new ArrayList<User>();
		Connection c = null;
		try {
			
			c = Mysql.getCon();
			
			String sql = "select * from user order by question_id desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				int id=rs.getInt("id");
				String account = rs.getString("account");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String username = rs.getString("username");
				int usercontrol = rs.getInt("usercontrol");


				user.setId(id);
				user.setAccount(account);
				user.setPassword(password);
				user.setPhone(phone);
				user.setUsername(username);
				user.setUsercontrol(usercontrol);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			System.out.println(e);	
			return null;
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
	
	public int getTotal() {
		int total = 0;
		Connection c = null;
		try {

			c = Mysql.getCon();
			Statement s = c.createStatement();

			String sql = "select count(*) from user";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}
			System.out.println("total:" + total);
			return total;

		} catch (SQLException e) {
			System.out.println(e);
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
	
	public int add(String account,String password,String phone,String username){
		Connection a = null;
		try{
		a = Mysql.getCon();
		Statement s = a.createStatement();
		String sql = "select * from user where account = '"+account+"'";
		
		ResultSet rs = s.executeQuery(sql);
		if(!rs.next())
		{
			String sql1 = "insert into user(account,password,phone,username) values(?,?,?,?)";
			PreparedStatement ps1 = a.prepareStatement(sql1);
			ps1.setString(1,account);
			ps1.setString(2,password);
			ps1.setString(3,phone);
			ps1.setString(4,username);
			
			
			int flag = ps1.executeUpdate();
			if (flag > 0) {
				System.out.print("1");
				return 1; //成功
			}
			else			
			{
				System.out.print("-2");
				return 0;//插入失败
			}
		}
		else return -2;//用户名重复
		}
		catch(SQLException e) {
			System.out.println(e);
			return 0;
		}finally {
			if (a != null) {
				try {					
					a.close();					
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

		String sql = "select * from user where account = '" + account + "'";

		ResultSet rs = s.executeQuery(sql);
		
		if(rs.next()) {
			passwd = rs.getString("password");	
			type=rs.getInt("usercontrol");
			
		
//		System.out.println(acc);
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
		return -2;
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

public List<User> search(String search){
	List<User> users = new ArrayList<User>();
	Connection a =null;
	try{
		
		a = Mysql.getCon();
		String sql = "select * from user where (usercontrol = 1 or usercontrol = -1) and ( account like '%"+ search + "%' or password like '%"+ search + "%' or phone like '%"+ search + "%' or username like '%"+ search + "%')";
		Statement ad = a.createStatement();
		
		/*ad.setString(1,admin.getName());
		ad.setString(2,admin.getAccount());*/
		

		ResultSet rs = ad.executeQuery(sql);
		while (rs.next()) {
			User user1 = new User();
			int id=rs.getInt("id");
			String account = rs.getString("account");
			String password = rs.getString("password");
			String phone = rs.getString("phone");
			String username = rs.getString("username");
			int usercol =rs.getInt("usercontrol");
			user1.setId(id);
			user1.setAccount(account);
			user1.setPassword(password);
			user1.setPhone(phone);
			user1.setUsername(username);
			user1.setUsercontrol(usercol);
			if(usercol==1) {
				user1.setStatus("正常");
			}
			if(usercol==-1) {
				user1.setStatus("被冻结");
			}
			users.add(user1);
		}
		return users;
		
}
	catch(SQLException s) {
		System.out.println(s);	
		return null;
	}
	finally {
		if (a != null) {
			try {					
				a.close();					
			} catch (SQLException ignore) {					
			}
		
		}
	
}
}

public List<User> searchall(){
	List<User> users = new ArrayList<User>();
	Connection a =null;
	try{
		
		a = Mysql.getCon();
		String sql = "select * from user where usercontrol = 1 or usercontrol = -1";
		Statement ad = a.createStatement();
		
		/*ad.setString(1,admin.getName());
		ad.setString(2,admin.getAccount());*/
		

		ResultSet rs = ad.executeQuery(sql);
		while (rs.next()) {
			User user1 = new User();
			int id=rs.getInt("id");
			String account = rs.getString("account");
			String password = rs.getString("password");
			String phone = rs.getString("phone");
			String username = rs.getString("username");
			int usercol =rs.getInt("usercontrol");
			user1.setId(id);
			user1.setAccount(account);
			user1.setPassword(password);
			user1.setPhone(phone);
			user1.setUsername(username);
			user1.setUsercontrol(usercol);
			if(usercol==1) {
				user1.setStatus("正常");
			}
			if(usercol==-1) {
				user1.setStatus("被冻结");
			}
			users.add(user1);
		}
		return users;
		
}
	catch(SQLException s) {
		System.out.println(s);	
		return null;
	}
	finally {
		if (a != null) {
			try {					
				a.close();					
			} catch (SQLException ignore) {					
			}
		
		}
	
}
}

public int update(int id,String account,String password,String phone,String username,int usercontrol) {
	Connection c=null;
	try {

		 c = Mysql.getCon();

		String sql = "update user set account = ?, password = ?, phone = ?,username = ?, usercontrol = ? where id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		
		
		ps.setString(1, account);

		ps.setString(2, password);
		
		ps.setString(3, phone);
		ps.setString(4, username);
		ps.setInt(5, usercontrol);
		ps.setInt(6, id);

		int flag = ps.executeUpdate();
		
		return flag;

	} catch (SQLException s) {
		System.out.println(s);	
		return 0;
	}finally {
		if (c != null) {
			try {					
				c.close();					
			} catch (SQLException ignore) {					
			}
		
		}
	
}
}

public int update1(int id) {
	Connection c =null;
	try {
		c = Mysql.getCon();

		String sql = "update user set password = ? where id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1,"123456");
		ps.setInt(2, id);
		

		int flag = ps.executeUpdate();
		return flag;

	} catch (SQLException s) {
		System.out.println(s);	
		return 0;
	}finally {
		if (c != null) {
			try {					
				c.close();					
			} catch (SQLException ignore) {					
			}
		
		}
	
}

}

/*
 * @author gzc
 * @param 用户id id
 * @param 需要改变的状态 col（0：删除；-1：锁定）
 * @return boolean值 true表示更新成功，false表示更新失败
 */
public boolean deleteById(int id,int col) {
	Connection conn = null;
	boolean f;
	try {
		conn = Mysql.getCon();
		Statement stmt = conn.createStatement();
		String sql="update user set usercontrol = "+col+" where id="+id; 
		int i=stmt.executeUpdate(sql);
		if(i!=1) f=false;
		else f=true;
		return f;
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



}
