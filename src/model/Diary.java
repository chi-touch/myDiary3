package model;

import exceptions.InvalidPassWordException;

public class Diary {
    private String userName;
    private String passWord;
    private boolean isLocked;

    public Diary(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        if(passWord.length()>4){
            throw new InvalidPassWordException("you enter the wrong password");
        }

    }

    public Diary(){}

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

    public boolean isLocked() {return isLocked;
    }
    public void setLocked(boolean locked) {
        isLocked = locked;
    }



}
