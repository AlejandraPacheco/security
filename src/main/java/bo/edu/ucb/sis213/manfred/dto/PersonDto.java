package bo.edu.ucb.sis213.manfred.dto;

public class PersonDto {
    private Integer personId;
    private String email;

    public PersonDto() {
    }

    public PersonDto(Integer personId, String email) {
        this.personId = personId;
        this.email = email;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "personId=" + personId +
                ", email='" + email + '\'' +
                '}';
    }
}
