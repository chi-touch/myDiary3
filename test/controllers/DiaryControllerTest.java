package controllers;

import dto.LogOutRequest;
import dto.LoginRequest;
import dto.RegisterRequest;
import exceptions.InvalidPassWordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryControllerTest {

    private DiaryController diaryController;

    @BeforeEach
    public void setUp(){
        diaryController = new DiaryController();
    }

    @Test
    public void testToRegister(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryController.register(registerRequest);

        assertEquals("Registration Successful",diaryController.register(registerRequest));
    }

    @Test
    public  void testToRegisterMoreUsers(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryController.register(registerRequest);

        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setUserName("chibuzor");
        registerRequest1.setPassWord("2222");
        diaryController.register(registerRequest1);

        assertEquals("Registration Successful",diaryController.register(registerRequest));
        assertEquals("Registration Successful",diaryController.register(registerRequest1));
    }

    @Test
    public void testToLoginUser(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryController.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("chichi");
        loginRequest.setPassWord("1234");
        diaryController.login(loginRequest);

        assertEquals("Successfully login",diaryController.login(loginRequest));


    }

    @Test
    public void testToLogOutUsers(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryController.register(registerRequest);



        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("chichi");
        loginRequest.setPassWord("1234");
        diaryController.login(loginRequest);

        LogOutRequest logOutRequest = new LogOutRequest();
        logOutRequest.setUserName("chichi");
        diaryController.logOut(logOutRequest);

        assertEquals("logOut successful",diaryController.logOut(logOutRequest));

    }

    @Test
    public void testToLoginWithWrongPassword(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryController.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("chichi");
        loginRequest.setPassWord("1244");
        diaryController.login(loginRequest);

        assertEquals("this password is incorrect",diaryController.login(loginRequest));
    }

    @Test
    public  void testToLogOutUnRegisteredUser(){
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUserName("mesh");
//        loginRequest.setPassWord("2222");
//        diaryController.login(loginRequest);

        LogOutRequest logOutRequest = new LogOutRequest();
        logOutRequest.setUserName("chichi");
       // diaryController.logOut(logOutRequest);
        assertEquals("this user does not exist",diaryController.logOut(logOutRequest));
    }



}