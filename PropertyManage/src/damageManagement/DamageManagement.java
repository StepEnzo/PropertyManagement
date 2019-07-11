package damageManagement;

import Model.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DamageManagement {
    public List<DamageBean> getDamageInfo(){
        List<DamageBean> damageBeans=new ArrayList<DamageBean>();
        try{
            Statement s=Mysql.getCon().createStatement();
            String sql="select * from damage";
            ResultSet resultSet=s.executeQuery(sql);
            while(resultSet.next()){
                DamageBean damageBean=new DamageBean();
                int id=resultSet.getInt("id");
                int pid=resultSet.getInt("pid");
                String level=resultSet.getString("level");
                String solution=resultSet.getString("solution");
                damageBean.setId(id);
                damageBean.setPid(pid);
                damageBean.setLevel(level);
                damageBean.setSolution(solution);
                damageBeans.add(damageBean);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return damageBeans;
    }
    public boolean addDamageInfo(int pid, String level, String solution) {
        try {
            Statement stmt = Mysql.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("select * from propertyitem where pid = " + pid );
            if (rs.next()) {
                stmt.executeUpdate("insert into damage(pid,level,solution) values (" + pid + ",'" + level + "','" + solution + "')");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//  public boolean addDamageInfo(int pid, String level, String solution) {
//	  Connection a = null;
//  try {
//	  a = Mysql.getCon();
//	  Statement s = a.createStatement();
//	  String sql="select * from propertyitem where pid ='" + pid+"'";
//	  ResultSet rs = s.executeQuery(sql);
//	  if(!rs.next())
//		{
//			String sql1 = "insert into damage(pid,level,solution) values (?,?,?)";
//			PreparedStatement ps1 = a.prepareStatement(sql1);
//			ps1.setInt(1,pid);
//			ps1.setString(2,level);
//			ps1.setString(3,solution);
//
//			int flag = ps1.executeUpdate();
//			if (flag > 0) {
//				System.out.print("1");
//				return true; //成功
//			}
//			else
//			{
//				System.out.print("-2");
//				return false;//插入失败
//			}
//		}
//		else return false;//用户名重复
//	}
//	catch(SQLException e) {
//		System.out.println(e);
//		return false;
//	}finally {
//		if (a != null) {
//			try {
//				a.close();
//			} catch (SQLException ignore) {
//			}
//		}
//	}
//}

    public boolean editDamageInfo(int id,int pid, String level, String solution) {
        try {
            Statement stmt = Mysql.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("select * from damage where id = " + id);
            if (rs.next()) {
                stmt.executeUpdate("update damage set pid= "+pid+",level='"+level+"',solution='"+solution+"'where id = " + id );
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDamageItem(int id) {
        try{
            Statement stmt = Mysql.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("select * from damage where id = " + id);
            if (rs.next()) {
                stmt.executeUpdate("delete from damage where damage.id = " + id);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param offset 开始的下标
     * @param limit 查询的长度
     * @return
     */
//    public List<DamageBean> getDamageInfoList(int offset, int limit) {
//        List<DamageBean> dbs = new ArrayList<>();
//        try {
//            Statement stmt = Mysql.getCon().createStatement();
//            ResultSet rs = stmt.executeQuery("select count(id) from damage");
//            if (rs.next()) {
//                int size = rs.getInt(0);
//                if (offset < size) {
//                    ResultSet res = stmt.executeQuery("select * from damage limit " + offset + "," + (offset + limit));
//                    while (res.next()) {
//                        dbs.add(new DamageBean(res.getString("id"), res.getString("pid"), res.getString("level"), res.getString("solution")));
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return dbs;
//    }

}
