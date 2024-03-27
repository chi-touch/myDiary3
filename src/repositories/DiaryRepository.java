package repositories;

import model.Diary;

import java.util.List;

public interface DiaryRepository {

    Diary save(Diary diary);
    Diary findByUsername(String userName);
    long count();
    List<Diary>findAll();
    void delete(Diary diary);
    void delete (String userName);

    int getNumberOfDiaries();
}
