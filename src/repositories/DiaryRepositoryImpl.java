package repositories;

import model.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository{
    private List <Diary> myDiary = new ArrayList<>();
    private int numberOfDiaries = 0;

    @Override
    public Diary save(Diary diary) {
        myDiary.add(diary);
        numberOfDiaries++;
            return diary;
    }

    @Override
    public Diary findByUsername(String username) {
        for (Diary dairy : myDiary){
            if (dairy.getUserName().equalsIgnoreCase(username)) {
                return dairy;
            }
        }
        return null;
    }

    @Override
    public long count() {
        return numberOfDiaries;
    }

    @Override
    public List<Diary> findAll() {
        return myDiary;
    }

    @Override
    public void delete(Diary diary) {
        myDiary.remove(diary);
        numberOfDiaries --;

    }

    @Override
    public void delete(String userName) {
        Diary deleteDiary = null;
        for (Diary diaryRemove : myDiary){
            if (diaryRemove.getUserName().equals(deleteDiary)) {
                deleteDiary = diaryRemove;
            }

        }
        if (deleteDiary != null)myDiary.remove(deleteDiary);
        numberOfDiaries--;


    }

    @Override
    public int getNumberOfDiaries() {
        return numberOfDiaries;
    }
}
