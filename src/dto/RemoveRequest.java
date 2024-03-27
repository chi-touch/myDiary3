package dto;

public class RemoveRequest {
    private String userName;

    public RemoveRequest(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public RemoveRequest(){}
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    private String passWord;
}
