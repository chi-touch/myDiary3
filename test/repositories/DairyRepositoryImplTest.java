package repositories;

import exceptions.InvalidPassWordException;
import model.Diary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DairyRepositoryImplTest {
    private DiaryRepository myDiaryRepo;
    private Diary myDiary;

    @BeforeEach
    public void initializeDiaryRepository(){
        myDiaryRepo = new DiaryRepositoryImpl();
        myDiary =new Diary();




    }
    @Test
    public void testToSaveDiary(){
        Diary myDiary = new Diary();
        myDiaryRepo.save(myDiary);
        assertEquals(1,myDiaryRepo.getNumberOfDiaries());
    }

    @Test
    public void testToAddDiary(){
        Diary myDiary = new Diary("chichi","1234");
        Diary myDiary2 = new Diary("them","3333");
        myDiaryRepo.save(myDiary);
        myDiaryRepo.save(myDiary2);
        assertEquals(2,myDiaryRepo.getNumberOfDiaries());
    }

    @Test
    public void testToRemoveDiaryWithUserName(){
        Diary myDiary = new Diary("chichi","2222");
        myDiaryRepo.save(myDiary);
        assertEquals(1,myDiaryRepo.getNumberOfDiaries());
        myDiaryRepo.delete("chichi");
        assertEquals(0,myDiaryRepo.count());
    }

    @Test
    public void testToRemoveTwoDiariesWithUserName(){
        Diary myDiary = new Diary("them","2222");
        Diary myDiary1 = new Diary("test","1111");
        Diary myDiary2 = new Diary("we","4444");
        myDiaryRepo.save(myDiary);
        myDiaryRepo.save(myDiary1);
        myDiaryRepo.save(myDiary2);
        assertEquals(3,myDiaryRepo.getNumberOfDiaries());
        myDiaryRepo.delete("test");
        myDiaryRepo.delete("them");
        assertEquals(1,myDiaryRepo.getNumberOfDiaries());
    }

    @Test
    public void testTestToDeleteDiary(){
        Diary myDiary = new Diary();
        myDiaryRepo.save(myDiary);
        assertEquals(1,myDiaryRepo.getNumberOfDiaries());
        myDiaryRepo.delete(myDiary);
        assertEquals(0,myDiaryRepo.count());
    }

    @Test
    public void testToFindByUserName(){
        Diary myDiary = new Diary("Chichi","1234");
        myDiaryRepo.save(myDiary);
        myDiaryRepo.findByUsername("chichi");
        assertEquals(1,myDiaryRepo.getNumberOfDiaries());
    }

    @Test
    public void testToFindTwoUsers(){
        Diary myDiary = new Diary("people","3333");
        Diary myDiary2 = new Diary("mesh","7777");
        myDiaryRepo.save(myDiary);
        myDiaryRepo.save(myDiary2);
        myDiaryRepo.findByUsername("people");
        myDiaryRepo.findByUsername("mesh");
        assertEquals(2,myDiaryRepo.getNumberOfDiaries());

    }

    @Test
    public void testToFindAllEnteries(){
        Diary myDiary = new Diary("dayo","2345");
        Diary myDiary2 = new Diary();
        myDiaryRepo.save(myDiary);
        myDiaryRepo.save(myDiary2);
        myDiaryRepo.findAll();
        assertEquals(2,myDiaryRepo.getNumberOfDiaries());

    }




}
