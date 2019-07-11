package damageManagement;

public class DamageBean {
    private int id;
    private int pid;
    private String level;
    private String solution;

//    public DamageBean(String id,String pid,String level,String solution){
//        this.id=id;
//        this.pid=pid;
//        this.level=level;
//        this.solution=solution;
//    }
    public DamageBean(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
