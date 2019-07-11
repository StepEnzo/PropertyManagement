package damageManagement;

import Model.Mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DamageManagement {
    public List<DamageBean> getDamageInfo(){
        List<DamageBean> damageBeans=new ArrayList<DamageBean>();
        Connection c=null;
        try{
            Statement s=c.createStatement();
            String sql="select * form damage";
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
            ResultSet rs = stmt.executeQuery("select from damage where id = " + id);
            if (rs.next()) {
                stmt.executeUpdate("delete from damage where id = " + id);
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
