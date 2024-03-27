package dto;

public class LogOutRequest {
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public LogOutRequest(String userName) {
        this.userName = userName;
    }
    public LogOutRequest(){}

    public String getUserName() {
        return userName;
    }
}
