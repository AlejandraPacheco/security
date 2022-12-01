package bo.edu.ucb.sis213.manfred.entity;

public class CompanyPerson {
    String companyName;
    private String email;

    public CompanyPerson() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CompanyPerson{" +
                "companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
