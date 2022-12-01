package bo.edu.ucb.sis213.manfred.entity;

public class Company {
    private Integer personId;
    private String companyName;
    private String description;
    private String companyWebsite;
    private String managerName;
    private Integer managerPhoneNumber;
    private Integer status;
    private String txUser;
    private String txDate;
    private String txHost;

    public Company() {
    }

    public Company(Integer personId, String companyName, String description, String companyWebsite, String managerName, Integer managerPhoneNumber, Integer status, String txUser, String txDate, String txHost) {
        this.personId = personId;
        this.companyName = companyName;
        this.description = description;
        this.companyWebsite = companyWebsite;
        this.managerName = managerName;
        this.managerPhoneNumber = managerPhoneNumber;
        this.status = status;
        this.txUser = txUser;
        this.txDate = txDate;
        this.txHost = txHost;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Integer getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(Integer managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
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
        return "Company{" +
                "personId=" + personId +
                ", companyName='" + companyName + '\'' +
                ", description='" + description + '\'' +
                ", companyWebsite='" + companyWebsite + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerPhoneNumber=" + managerPhoneNumber +
                ", status=" + status +
                ", txUser='" + txUser + '\'' +
                ", txDate='" + txDate + '\'' +
                ", txHost='" + txHost + '\'' +
                '}';
    }
}
