package bo.edu.ucb.sis213.manfred.dto;

public class AuthResDto{
    private String token;
    private String refresh;

    public AuthResDto() {
    }

    public AuthResDto(String token, String refresh) {
        this.token = token;
        this.refresh = refresh;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    @Override
    public String toString() {
        return "AuthResDto{" +
                "token='" + token + '\'' +
                ", refresh='" + refresh + '\'' +
                '}';
    }
}
