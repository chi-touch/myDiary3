package controllers;

import dto.*;
import exceptions.*;
import model.Entry;
import services.DiaryService;
import services.DiaryServiceImpl;
import services.EntryService;
import services.EntryServiceImpl;

import java.util.List;

public class DiaryController {
    private DiaryService diaryService = new DiaryServiceImpl();
    private EntryService entryService = new EntryServiceImpl();

    public String register(RegisterRequest registerRequest){
        try {
            diaryService.register(registerRequest);
            return "Registration Successful";
        }catch (DiaryNotFoundException e){
            return e.getMessage();
        }
    }

    public String addEntry(CreateRequest createRequest){
        try {
            diaryService.creatEntry(createRequest);
            return "Created successful";
        }catch (UserAlreadyExistException e){
            return e.getMessage();
        }
    }

    public String login(LoginRequest loginRequest){
        try {
            diaryService.login(loginRequest);
            return "Successfully login";
        }catch (InvalidPassWordException e){
            return e.getMessage();

        }
    }

    public String logOut(LogOutRequest logOutRequest){
        System.out.println("how u dey");
        try {
            diaryService.logOut(logOutRequest);
            return "logOut successful";
        }catch (InvalidUserException e){
            return e.getMessage();
        }
    }
    public String deleteEntry(DeleteEntryRequest deleteEntryRequest){
        try {
            entryService.deleteEntryById(deleteEntryRequest.getId());
            return "delete entry was successful";
        }catch (WrongEntryException e){
            return e.getMessage();
        }
    }

    public List<Entry>getAllEntries(String userName){
        try {

            return entryService.findEntriesByUserName(userName);
        }catch(WrongEntryException e){
            return List.of();
        }

    }

}
