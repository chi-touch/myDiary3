package services;

import dto.*;
import model.Diary;

public interface DiaryService {
    void register(RegisterRequest registerRequest);
    void login(LoginRequest loginRequest);
    void logOut(LogOutRequest logOutRequest);
    void remove(RemoveRequest removeRequest);
    void creatEntry(CreateRequest createRequest);
    Diary findDiaryByUserName(String userName);
    void deleteEntry(DeleteEntryRequest deleteEntryRequest);


    long getNumberOfRegisterUser();

    void deleteByUser(DeleteUserRequest deleteUserRequest);
}
