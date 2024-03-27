package services;

import dto.*;
import exceptions.*;
import model.Diary;
import model.Entry;
import repositories.DiaryRepository;
import repositories.DiaryRepositoryImpl;

import java.util.List;

public class DiaryServiceImpl implements DiaryService{
    private DiaryRepository myRepo = new DiaryRepositoryImpl();
    private static EntryService entryServ = new EntryServiceImpl();


    @Override
    public void register(RegisterRequest registerRequest) {
        if(registerRequest.getUserName().isEmpty() || registerRequest.getPassWord().isEmpty()){
            throw new WrongInputEnteredException("you can not register with an empty space");
        }

//        validateUser(registerRequest.getUserName());
        Diary myDiary = new Diary();


        myDiary.setUserName(registerRequest.getUserName());
        myDiary.setPassWord(registerRequest.getPassWord());

        myRepo.save(myDiary);

    }

//    private void validateUser(String userName){
//        var diary = myRepo.findByUsername(userName);
//        if (diary != null){
//            throw new UserAlreadyExistException("this username already exist");
//        }
//    }

    @Override
    public void login(LoginRequest loginRequest) {

//        String user = loginRequest.getUserName();
//        String password = loginRequest.getPassWord();
//        Diary foundUser1 = myRepo.findByUsername(loginRequest.getUserName());
//
//        if (foundUser1 ==null)throw new DiaryNotFoundException("Diary not found");
//        validatePassWord(foundUser1,password);
//        foundUser1.setLocked(false);
//        myRepo.save(foundUser1);


        Diary foundUser = myRepo.findByUsername(loginRequest.getUserName());
        if (foundUser.getPassWord().equals(loginRequest.getPassWord())){
            foundUser.setLocked(false);
        }else{
            throw new InvalidPassWordException("this password is incorrect");
        }
     //   myRepo.save(foundUser);







    }

//    private static void validatePassWord(Diary diary,String password){
//        if (diary.getPassWord().equals(password)){
//            diary.setLocked(false);
//        }
//        throw new InvalidPassWordException("this password is incorrect");
//    }

    @Override
    public void logOut(LogOutRequest logOutRequest) {
        Diary foundUser = myRepo.findByUsername(logOutRequest.getUserName());
        if (foundUser == null){
            throw new InvalidUserException("This user does not exit");
        }

        foundUser.setLocked(true);
        myRepo.save(foundUser);

    }


    @Override
    public void remove(RemoveRequest removeRequest) {
        Diary foundDiary = myRepo.findByUsername(removeRequest.getUserName());
        if (foundDiary.getUserName() == removeRequest.getUserName()){
            myRepo.delete(foundDiary);
        }


    }

    @Override
    public void creatEntry(CreateRequest createRequest) {
        String foundAuthor = createRequest.getAuthor();
        Diary diary = findDiaryByUserName(foundAuthor);
        isLocked(diary);

        validateEntry(createRequest);

        Entry entry = new Entry();
        entry.setTitle(createRequest.getTitle());
        entry.setBody(createRequest.getBody());
        entry.setAuthor(createRequest.getAuthor());
        entryServ.save(entry);

    }
    private void validateEntry(CreateRequest createRequest){
        List<Entry> myEntries = entryServ.findEntriesByUserName(createRequest.getAuthor());
        for (Entry entry : myEntries){
            if (entry.getTitle().equals(createRequest.getTitle())){
                throw new TitleAlreadyCreated("Entry title already exit");
            }

        }
    }

    private void isLocked(Diary diary){
        if (diary.isLocked()) throw new TitleAlreadyCreated("this title already exist");
    }

    @Override
    public Diary findDiaryByUserName(String userName) {
        Diary foundDiary = myRepo.findByUsername(userName);
        if (foundDiary == null) {
            throw new DiaryNotFoundException("this diary is not registered");
        }
        return foundDiary;
    }

    @Override
    public void deleteEntry(DeleteEntryRequest deleteEntryRequest) {
        Diary foundDiary = myRepo.findByUsername(deleteEntryRequest.getAuthor());
        isLocked(foundDiary);
        entryServ.deleteEntryById(deleteEntryRequest.getId());

    }

    @Override
    public long getNumberOfRegisterUser() {
        return myRepo.count();
    }

    public void deleteByUser(DeleteUserRequest deleteUserRequest){
        String username = deleteUserRequest.getUserName();
        String password = deleteUserRequest.getPassWord();
        Diary diary = myRepo.findByUsername(username);

        validatePassword(diary, password);
        myRepo.delete(diary);
    }

    private static void validatePassword(Diary diary, String password){
        if (diary.getPassWord().equals(password)) diary.setLocked(false);
        throw new InvalidPassWordException("password is incorrect");


    }

}
