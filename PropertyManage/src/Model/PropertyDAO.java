/**
 * 
 */
package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Name.PropertyNameTable;
import Name.PropertyTable;


public class PropertyDAO {

	
/*
 * @author gzc
 * @param pid 产品的pid
 * @return 	PropertyTable 该pid产品的信息。
 */
	public PropertyTable searchByPid(int pid) {
		Connection conn = null;
		PropertyTable property = new PropertyTable();
		property.setPid(pid);
		try {
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
//			int id;
//			String sql="select id,status,date from propertyitem where pid="+pid+"and itemcol = 1"; 
//			ResultSet rs=stmt.executeQuery(sql);
//			if (rs.next()) {
//				property.setDate(rs.getDate("date"));
//				property.setStatus(rs.getString("status"));
//				property.setId(rs.getInt("id"));
//				id = rs.getInt("id");
//				String selectname="select propertyname,brand,modelnumber,specification from propertyname where id="+id+"and namecol = 1";
//				ResultSet rs1=stmt.executeQuery(selectname);
//				property.setPropertyname(rs1.getString("propertyname"));
//				property.setBrand(rs1.getString("brand"));
//				property.setModelnumber(rs1.getString("modelnumber"));
//				property.setSpecification(rs1.getString("specification"));
//			}
			String sql = "select propertyitem.id, propertyitem.status, propertyitem.date,propertyname.propertyname,propertyname.brand,propertyname.modelnumber,propertyname.specification from propertyname join propertyitem on propertyname.id=propertyitem.id where propertyitem.pid = "+pid;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
			property.setDate(rs.getDate("propertyitem.date"));
			property.setStatus(rs.getString("propertyitem.status"));
			property.setId(rs.getInt("propertyitem.id"));
			property.setPropertyname(rs.getString("propertyname.propertyname"));
			property.setBrand(rs.getString("propertyname.brand"));
			property.setModelnumber(rs.getString("propertyname.modelnumber"));
			property.setSpecification(rs.getString("propertyname.specification"));
			}
			return property;
			
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
	 * @author zzwj
	 * 通过资产类别id查询具体资产
	 * @param propertyname.id
	 * @return List<PropertyTable>
	 */
	public List<PropertyTable> searchById(int id) {
		Connection conn = null;
		List<PropertyTable> list = new ArrayList<PropertyTable>();
		try {
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			//String sql="select propertyname,brand,modelnumber,specification from propertyname where id="+id+" and namecol = 1"; 
			String sql = "select propertyitem.id, propertyitem.status, propertyitem.date,propertyitem.pid,propertyname.propertyname,propertyname.brand,propertyname.modelnumber,propertyname.specification from propertyname join propertyitem on propertyname.id=propertyitem.id where propertyitem.id = "+id;
			ResultSet rs=stmt.executeQuery(sql);
//			if (rs.next()) {
//				String selectitem="select pid,status,date from propertyitem where id="+id+" and itemcol = 1";
//				ResultSet rs1=stmt.executeQuery(selectitem);
				while (rs.next()){
					PropertyTable property = new PropertyTable();
					property.setDate(rs.getDate("propertyitem.date"));
					property.setStatus(rs.getString("propertyitem.status"));
					property.setPid(rs.getInt("propertyitem.pid"));
					property.setPropertyname(rs.getString("propertyname.propertyname"));
					property.setBrand(rs.getString("propertyname.brand"));
					property.setModelnumber(rs.getString("propertyname.modelnumber"));
					property.setSpecification(rs.getString("propertyname.specification"));
					list.add(property);
				}
		//	}
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
	
	/*
	 * @author zzwj
	 * 通过资产状态查询资产
	 * @param propertyitem.status
	 * @return List<PropertyTable>
	 */
	public List<PropertyTable> searchByStatus(String status){
		Connection conn = null;
		List<PropertyTable> list = new ArrayList<PropertyTable>();
		try {
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql="select propertyitem.pid,propertyname.propertyname,propertyname.brand,propertyname.modelnumber,propertyname.specification,propertyitem.date"
					+ " from propertyname,propertyitem where propertyname.id=propertyitem.id and propertyitem.status='"+status+"' and propertyitem.itemcol = 1"; 
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				PropertyTable property = new PropertyTable();
				property.setDate(rs.getDate("propertyitem.date"));
				property.setStatus(status);
				property.setPid(rs.getInt("propertyitem.pid"));
				property.setPropertyname(rs.getString("propertyname.propertyname"));
				property.setBrand(rs.getString("propertyname.brand"));
				property.setModelnumber(rs.getString("propertyname.modelnumber"));
				property.setSpecification(rs.getString("propertyname.specification"));
				list.add(property);
			}
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
	
	/*
	 * 返回所有资产类别的具体信息	 * 
	 * @return List<PusTable>
	 */
	public List<PropertyNameTable> allInfo(){
		Connection conn = null;
		List<PropertyNameTable> list = new ArrayList<PropertyNameTable>();
		try {
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql="select propertyname.id,propertyname.propertyname,propertyname.brand,propertyname.modelnumber,propertyname.specification,count(*) as counts"
					+ " from propertyname,propertyitem where propertyname.id=propertyitem.id and propertyitem.itemcol = 1 group by propertyname.id"; 
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				PropertyNameTable property = new PropertyNameTable();
				int id = rs.getInt("propertyname.id");
				property.setId(id);
				property.setPropertyname(rs.getString("propertyname.propertyname"));
				property.setBrand(rs.getString("propertyname.brand"));
				property.setModelnumber(rs.getString("propertyname.modelnumber"));
				property.setSpecification(rs.getString("propertyname.specification"));
				property.setCount(rs.getInt("counts"));
				list.add(property);
			}
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
	
	public boolean addProperty(String propertyname,String brand,String modelnumber,String specification,Date date) throws SQLException {
		boolean flag = false ;
		String status = "可用";
		int id = -1; 
		Connection conn = null;
			
		try {
		conn = Mysql.getCon();
		Statement stmt = conn.createStatement();
		
		
		String selectsql = "SELECT * FROM property.propertyname where propertyname = '"+propertyname + "'";
		
		ResultSet rs = stmt.executeQuery(selectsql);
	
		while (rs.next()) {
			String br = rs.getString("brand");
			String mo = rs.getString("modelnumber");
			String sp = rs.getString("specification");
			if(br.equals(brand) && mo.equals(modelnumber) && sp.equals(specification)  ) {
				flag = true;
				id = rs.getInt("id");
				break;
			}
		}
		
		if(flag == false) {
			
			String addname = "INSERT INTO `property`.`propertyname`(`PropertyName`,`Brand`,`ModelNumber`,`Specification`)VALUES(?,?,?,?)" ; 
			PreparedStatement pstmt=conn.prepareStatement(addname);
			pstmt.setString(1,propertyname);
			pstmt.setString(2,brand);
			pstmt.setString(3,modelnumber);
			pstmt.setString(4,specification);
			int result=pstmt.executeUpdate();
			
			if(result!=1){
				System.out.println("插入propertyname失败");
				return false;
			}else {
				
				String selectidsql = "select * from property.propertyname where propertyname = '"+propertyname+"'";
				ResultSet rsid = stmt.executeQuery(selectidsql);
				
				while(rsid.next()) {
					id = rsid.getInt("id");
				}
				
				
			}
		}
		
		String additem = "INSERT INTO `property`.`propertyitem`(`id`,`Status`,`Date`)VALUES(?,?,?)";
		PreparedStatement prestmt=conn.prepareStatement(additem);
		prestmt.setInt(1,id);
		prestmt.setString(2,status);
		prestmt.setDate(3, date);
		int resultitem=prestmt.executeUpdate();
		if(resultitem!=1){
			System.out.println("插入propertyitem失败");
			
			return false;
		}else {
		
		return true;
		}
		} catch (SQLException s) {
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
	
	
	public boolean updateStatus(int pid, String status) throws SQLException {
		
		Connection	conn = null;
		try {
			conn = Mysql.getCon();
			Statement stmt = conn.createStatement();
			String sql = "Update property.propertyitem set Status = '"+status+"' where pid ="+ pid;
			System.out.println(sql);
			int result=stmt.executeUpdate(sql);
			if(result == 1) {
				return true;
			}else {
				return false;
			}
		
		} catch (SQLException s) {
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
	 * @author gzc
	 * @param String类型搜索内容
	 * @return ArrayList<PropertyTable> Propertyname表中的propertyname，brand，modelnumber，specification属性与搜索内容类似的表集合。
	 */
	public ArrayList<PropertyTable> searchProperty(String search) {
		Connection conn = null;
		ArrayList<PropertyTable> propertylist = new ArrayList<PropertyTable>();
		try {
			conn = Mysql.getCon();
			//从propertyname中查询与搜索内容相似的结果
			//PreparedStatement psm = null;
			ResultSet rs = null;
//			String sql="select id,propertyname,brand,modelnumber,specification from propertyname where namecol = 1 and (propertyname like '%?%' or brand like '%?%' or modelnumber like '%?%' or specification like '%?%' )"; 
//			psm = conn.prepareStatement(sql);
//			psm.setString(1, search);
//			psm.setString(2, search);
//			psm.setString(3, search);
//			psm.setString(4, search);
			Statement stmt1 =conn.createStatement();
			String sql="select id,propertyname,brand,modelnumber,specification from propertyname where namecol = 1 and (propertyname like '%"+search+"%' or brand like '%"+search+"%' or modelnumber like '%"+search+"%' or specification like '%"+search+"%')"; 
			rs = stmt1.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String brand=rs.getString(3);
				String modelnumber=rs.getString(4);
				String specification=rs.getString(5);
				//由先前查询到的property的id从propertyitem表中查询相关数据。
				ResultSet rs1 = null;
				Statement stmt = conn.createStatement();
				String sql1 = "select pid,status,date from propertyitem where itemcol = 1 and id ="+id;
				rs1 = stmt.executeQuery(sql1);
				while(rs1.next()) {
					PropertyTable property = new PropertyTable();
					property.setId(id);
					property.setPropertyname(name);
					property.setBrand(brand);
					property.setModelnumber(modelnumber);
					property.setSpecification(specification);
					property.setPid(rs1.getInt("pid"));
					property.setStatus(rs1.getString("status"));
					property.setDate(rs1.getDate("date"));
					propertylist.add(property);
				}
			}
			return propertylist;
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
