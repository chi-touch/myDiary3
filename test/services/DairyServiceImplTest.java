package services;

import dto.*;
import exceptions.InvalidPassWordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DairyServiceImplTest {

    private DiaryService diaryService;


    private EntryService entryService;

    @BeforeEach
    public void setUp(){
        diaryService = new DiaryServiceImpl();
        entryService = new EntryServiceImpl();
    }


    @Test
    public void testToRegisterOneUer(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");

        diaryService.register(registerRequest);
        assertEquals(1,diaryService.getNumberOfRegisterUser());
    }

    @Test
    public void testToRegisterMoreUsers(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");

        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setUserName("dave");
        registerRequest1.setPassWord("1111");

        diaryService.register(registerRequest);
        diaryService.register(registerRequest1);
        assertEquals(2,diaryService.getNumberOfRegisterUser());
        System.out.println(diaryService.getNumberOfRegisterUser());
    }


    @Test
    public void testToLoginOneUser(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryService.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("chichi");
        loginRequest.setPassWord("1234");
        diaryService.login(loginRequest);

        assertEquals(1,diaryService.getNumberOfRegisterUser());
        System.out.println();
    }

    @Test
    public void testToLoginMoreUsers(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryService.register(registerRequest);

        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setUserName("dave");
        registerRequest1.setPassWord("1111");
        diaryService.register(registerRequest1);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("chichi");
        loginRequest.setPassWord("1234");
        diaryService.login(loginRequest);

        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest1.setUserName("dave");
        loginRequest1.setPassWord("1111");
        diaryService.login(loginRequest1);

        assertEquals(2,diaryService.getNumberOfRegisterUser());

    }

    @Test
    public void testToLogOutUser(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryService.register(registerRequest);

        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setUserName("dave");
        registerRequest1.setPassWord("1111");
        diaryService.register(registerRequest1);

        LogOutRequest logOutRequest = new LogOutRequest();
        logOutRequest.setUserName("dave");
        diaryService.logOut(logOutRequest);

        assertTrue(diaryService.findDiaryByUserName("dave").isLocked());

    }

    @Test
    public void testForWrongPassword(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryService.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("chichi");
        loginRequest.setPassWord("1244");
        assertThrows(InvalidPassWordException.class,()->diaryService.login(loginRequest));
    }

    @Test
    public void testToDeleteOneUser(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryService.register(registerRequest);

        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setUserName("dave");
        registerRequest1.setPassWord("1111");
        diaryService.register(registerRequest1);

        RemoveRequest removeRequest = new RemoveRequest();
        removeRequest.setUserName("chichi");
        diaryService.remove(removeRequest);
        assertEquals(1,diaryService.getNumberOfRegisterUser());
    }

    @Test
    public void testToDeleteMoreUsers(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryService.register(registerRequest);

        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setUserName("dave");
        registerRequest1.setPassWord("1111");
        diaryService.register(registerRequest1);

        RemoveRequest removeRequest = new RemoveRequest();
        removeRequest.setUserName("chichi");
        diaryService.remove(removeRequest);

        RemoveRequest removeRequest1 = new RemoveRequest();
        removeRequest1.setUserName("dave");
        diaryService.remove(removeRequest1);
        assertEquals(0,diaryService.getNumberOfRegisterUser());

    }

    @Test
    public void testToCreateEntry(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryService.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("chichi");
        loginRequest.setPassWord("1234");
        diaryService.login(loginRequest);


        assertFalse(diaryService.findDiaryByUserName("chichi").isLocked());

        CreateRequest createRequest = new CreateRequest();
        createRequest.setBody("my journey so far");
        createRequest.setTitle("my journey");
        createRequest.setAuthor("chichi");
        diaryService.creatEntry(createRequest);

        assertEquals(1,entryService.findEntriesByUserName("chichi").size());
    }

    @Test
    public void testToCreateEntriesForTwoUsers(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryService.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("chichi");
        loginRequest.setPassWord("1234");
        diaryService.login(loginRequest);


        RegisterRequest registerRequest1 = new RegisterRequest();
        registerRequest1.setUserName("dave");
        registerRequest1.setPassWord("1111");
        diaryService.register(registerRequest1);

        LoginRequest loginRequest1 = new LoginRequest();
        loginRequest1.setUserName("dave");
        loginRequest1.setPassWord("1111");
        diaryService.login(loginRequest1);

        assertFalse(diaryService.findDiaryByUserName("chichi").isLocked());
        assertFalse(diaryService.findDiaryByUserName("dave").isLocked());


        CreateRequest createRequest = new CreateRequest();
        createRequest.setBody("my journey so far");
        createRequest.setTitle("my journey");
        createRequest.setAuthor("chichi");
        diaryService.creatEntry(createRequest);

        CreateRequest createRequest1 = new CreateRequest();
        createRequest1.setTitle("this life");
        createRequest1.setBody("inside life");
        createRequest1.setAuthor("dave");
        diaryService.creatEntry(createRequest1);

       // System.out.println(entryService.findEntriesByUserName("dave"));

        assertEquals(1,entryService.findEntriesByUserName("chichi").size());
        assertEquals(1,entryService.findEntriesByUserName("dave").size());

    }
    @Test
    public void testToDeleteEntry(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("chichi");
        registerRequest.setPassWord("1234");
        diaryService.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("chichi");
        loginRequest.setPassWord("1234");
        diaryService.login(loginRequest);

        CreateRequest createRequest = new CreateRequest();
        createRequest.setBody("my journey so far");
        createRequest.setTitle("my journey");
        createRequest.setAuthor("chichi");
        diaryService.creatEntry(createRequest);


        DeleteEntryRequest deleteEntryRequest = new DeleteEntryRequest();
        deleteEntryRequest.setAuthor("chichi");
        deleteEntryRequest.setId("1");
        System.out.println(createRequest.getAuthor());


        diaryService.deleteEntry(deleteEntryRequest);

        assertEquals(0,entryService.findEntriesByUserName("chichi").size());
        System.out.println(createRequest.getAuthor());

    }

}
