package damageManagement;

public class DamageBean {
    private String id;
    private String pid;
    private String level;
    private String solution;

    public DamageBean(String id, String pid, String level, String solution) {
        this.id = id;
        this.pid = pid;
        this.level = level;
        this.solution = solution;
    }

    public String getId() {
        return id;
    }

    public String getPid() {
        return pid;
    }

    public String getLevel() {
        return level;
    }

    public String getSolution() {
        return solution;
    }
}
