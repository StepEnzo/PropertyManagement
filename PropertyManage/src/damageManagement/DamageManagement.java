package damageManagement;

import Model.Mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DamageManagement {
    public boolean addDamageInfo(String pid, String level, String solution) {
        if (pid == null || level == null || solution == null) {
            return false;
        }
        try {
            Statement stmt = Mysql.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("select * from propertyitem where pid = '" + pid + "'");
            if (rs.next()) {
                stmt.executeUpdate("insert into damage(pid,level,solution) values (" + pid + ",'" + level + "','" + solution + "')");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param pid
     * @param item
     * @param tag 0 ->level | 1 ->solution
     * @return
     */
    public boolean editDamageInfo(String pid, String item, int tag) {
        if (pid == null ||item == null) {
            return false;
        }
        try {
            Statement stmt = Mysql.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("select * from damage where pid = '" + pid + "'");
            if (rs.next()) {
                stmt.executeUpdate("update damage set " + (tag == 0 ? "level" : "solution") + " = '" + item + "' where pid = '" + pid + "' ");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editDamageInfo(String pid, String level, String solution) {

        return (level == null || editDamageInfo(pid, level, 0)) && (solution == null || editDamageInfo(pid, solution, 1));
    }

    public boolean deleteDamageItem(String id) {
        if (id == null) {
            return false;
        }
        try{
            Statement stmt = Mysql.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("select from damage where id = '" + id + "'");
            if (rs.next()) {
                stmt.executeUpdate("delete from damage where id = '" + id + "'");
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
    public List<DamageBean> getDamageInfoList(int offset, int limit) {
        List<DamageBean> dbs = new ArrayList<>();
        try {
            Statement stmt = Mysql.getCon().createStatement();
            ResultSet rs = stmt.executeQuery("select count(id) from damage");
            if (rs.next()) {
                int size = rs.getInt(0);
                if (offset < size) {
                    ResultSet res = stmt.executeQuery("select * from damage limit " + offset + "," + (offset + limit));
                    while (res.next()) {
                        dbs.add(new DamageBean(res.getString("id"), res.getString("pid"), res.getString("level"), res.getString("solution")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbs;
    }

}
