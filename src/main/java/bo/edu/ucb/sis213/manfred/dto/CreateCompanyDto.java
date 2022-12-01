package bo.edu.ucb.sis213.manfred.dto;

public class CreateCompanyDto {
    private String companyName;
    private String description;
    private String companyWebsite;
    private String managerName;
    private Integer managerPhoneNumber;

    public CreateCompanyDto() {
    }

    public CreateCompanyDto(String companyName, String description, String companyWebsite, String managerName, Integer managerPhoneNumber) {
        this.companyName = companyName;
        this.description = description;
        this.companyWebsite = companyWebsite;
        this.managerName = managerName;
        this.managerPhoneNumber = managerPhoneNumber;
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

    @Override
    public String toString() {
        return "CreateCompanyDto{" +
                "companyName='" + companyName + '\'' +
                ", description='" + description + '\'' +
                ", companyWebsite='" + companyWebsite + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerPhoneNumber=" + managerPhoneNumber +
                '}';
    }
}
