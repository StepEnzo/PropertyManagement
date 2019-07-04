/**
 * 
 */
package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Name.Pus;
//import Name.PusTable;



/**
 * @author gzc
 *
 */
public class PusDAO {
	
	
	public static PusDAO getInstance() {
		return new PusDAO();
	}
	
	/*	向数据库pus表中插入新的一行。
	 *  @param Pus类data
	 *  
	 */
	public boolean insert(Pus data) {
		Connection conn = null;
		boolean f = true;
		try {
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			int propertyid=data.getPropertyid();
			int userid=data.getUserid();
			Date date=data.getDate();
			String status=data.getStatus();
			String sql="INSERT INTO pus(propertyid,userid,date,status)values("+propertyid+ ","+userid+" ,'"+date+"' ,'"+status+"')"; 
			int i=stmt.executeUpdate(sql);
			if(i!=1) {
				f=false;
				System.out.println("插入失败！");
			}
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
	
	/*
	 * 通过输入的用户id从pus表中查询与其相关的数据。
	 * @param 用户id，int
	 * @return Pus类的列表
	 */
	public ArrayList<Pus> selectByUserid(int id) {
		Connection conn = null;
		ArrayList<Pus> puslist = new ArrayList<Pus>();
		try {
			
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql="select propertyid,userid,date,status from pus where userid = "+id; 
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				Pus pus = new Pus();
				pus.setPropertyid(rs.getInt("propertyid"));
				pus.setUserid(id);
				pus.setDate(rs.getDate("date"));
				pus.setStatus(rs.getString("status"));
				puslist.add(pus);
			}
			return puslist;
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
	
	
	/*
	 * 通过输入的资产id从pus表中查询与其相关的数据。
	 * @param 产品id，int
	 * @return Pus类的列表
	 */
	public ArrayList<Pus> selectByPropertyid(int id) {
		Connection conn = null;
		
		ArrayList<Pus> puslist = new ArrayList<Pus>();
		try {
			
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql="select propertyid,userid,date,status from pus where propertyid = "+id; 
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				Pus pus = new Pus();
				pus.setPropertyid(id);
				pus.setUserid(rs.getInt("userid"));
				pus.setDate(rs.getDate("date"));
				pus.setStatus(rs.getString("status"));
				puslist.add(pus);
			}
			return puslist;
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
	
	/*
	 * 通过输入的状态类型从pus表中查询与其相关的数据。
	 * @param 表单状态 status
	 * @return Pus类的列表
	 */
	public ArrayList<Pus> selectByStatus(String status) {
		Connection conn = null;
		ArrayList<Pus> puslist = new ArrayList<Pus>();
		try {
			
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql="select propertyid,userid,date,status from pus where status = '"+status+"'"; 
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				Pus pus = new Pus();
				pus.setPropertyid(rs.getInt("propertyid"));
				pus.setUserid(rs.getInt("userid"));
				pus.setDate(rs.getDate("date"));
				pus.setStatus(status);
				puslist.add(pus);
			}
			return puslist;
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
	
	/*
	 * 通过输入的userid,propertyid，status改变Pus表中对应行的status，date为输入的changedstatus,date
	 * @param userid 用户id
	 * @param propertyid 资产id
	 * @param  status 当前的状态
	 * @param changedstatus 想要改变的状态
	 * @param date 执行该操作的日期
	 * @return Boolean值，是否更新成功。
	 */
	public boolean changeStatus(int userid,int propertyid,String status,String changedstatus,Date date) {
		Connection conn = null;
		boolean f;
		try {
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql="update pus set date='"+date+"',status = '"+ changedstatus+"' where status = '"+status+"' and userid = "+userid+" and propertyid ="+propertyid; 
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
	
	/*
	 * 通过用户id和记录表状态 返回PusTable的列表
	 * @param user.id pus.status
	 * @return List<PusTable>
	 */
	public List<Pus> searchByUser_Status(int id,String status) {
		Connection conn = null;
		List<Pus> list = new ArrayList<Pus>();
		try {
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
//			String sql="select propertyitem.id,propertyitem.date,pus.date"
//					+ "from user,pus,propertyitem where user.id=pus.userid and propertyitem.pid=pus.propertyid and user.id="+id+" and pus.status= '"+status+"'"; 
			String sql = "select propertyid,userid,date,status from pus where userid="+id+" and status= '"+status+"'";;
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				Pus pus = new Pus();
				pus.setPropertyid(rs.getInt("propertyid"));
				pus.setUserid(id);
				pus.setDate(rs.getDate("date"));
				pus.setStatus(rs.getString("status"));
				list.add(pus);
			}
//			while (rs.next()) {
//				int nameid = rs.getInt("propertyitem.id");
//				String select="select propertyname,brand,modelnumber,specification from propertyname where id="+nameid+" and namecol = 1";
//				ResultSet rs1=stmt.executeQuery(select);
//				if (rs1.next()){
//					PusTable property = new PusTable();
//					property.setDate(rs.getDate("pus.date"));
//					property.setBuydate(rs.getDate("propertyitem.date"));
//					property.setStatus(status);
//					property.setPropertyname(rs1.getString("propertyname"));
//					property.setBrand(rs1.getString("brand"));
//					property.setModelnumber(rs1.getString("modelnumber"));
//					property.setSpecification(rs1.getString("specification"));
//					list.add(property);
//				}
//			}
			
			return list;
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
}
