package bo.edu.ucb.sis213.manfred.entity;

public class ManfredRole {
    private Integer roleId;
    private String name;
    private String description;
    private Integer status;
    private String txUser;
    private String txDate;
    private String txHost;

    public ManfredRole() {
    }

    public ManfredRole(Integer roleId, String name, String description, Integer status, String txUser, String txDate, String txHost) {
        this.roleId = roleId;
        this.name = name;
        this.description = description;
        this.status = status;
        this.txUser = txUser;
        this.txDate = txDate;
        this.txHost = txHost;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxDate() {
        return txDate;
    }

    public void setTxDate(String txDate) {
        this.txDate = txDate;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    @Override
    public String toString() {
        return "ManfredRole{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", txUser='" + txUser + '\'' +
                ", txDate='" + txDate + '\'' +
                ", txHost='" + txHost + '\'' +
                '}';
    }
}
