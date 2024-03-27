package repositories;

import model.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryRepositoryImplTest {
    private EntryRepository myEntryRepo;
    private Entry myEntry;

    @BeforeEach
    public void initializeEntryRepository(){
        myEntryRepo = new EntryRepositoryImpl();
        myEntry = new Entry();
    }
    @Test
    public void testToSaveEntries(){
        Entry myEntry = new Entry();
        myEntryRepo.save(myEntry);
        assertEquals(1,myEntryRepo.getNumberOfEntries());

    }

    @Test
    public void testToSaveMoreEntries(){
        Entry myEntry = new Entry("1","chichi","my story","this is my story");
        myEntryRepo.save(myEntry);
        Entry myEntry1 = new Entry("2","dayo","this life","in this life");
        myEntryRepo.save(myEntry1);
        assertEquals(2,myEntryRepo.getNumberOfEntries());
    }

    @Test
    public void testToDeleteById(){
        Entry myEntry = new Entry("1","chichi","my story","this is my story");
        myEntryRepo.save(myEntry);
        Entry myEntry1 = new Entry("2","dayo","this life","in this life");
        myEntryRepo.save(myEntry1);
        assertEquals(2,myEntryRepo.getNumberOfEntries());

        myEntryRepo.deleteById("1");
        assertEquals(1,myEntryRepo.getNumberOfEntries());

    }

    @Test
    public void testToDeleteMoreEntriesById(){
        Entry myEntry = new Entry("1","chichi","my story","this is my story");
        myEntryRepo.save(myEntry);
        Entry myEntry1 = new Entry("2","dayo","this life","in this life");
        myEntryRepo.save(myEntry1);
        Entry myEntry2 = new Entry("3","ebu","the journey","the journey so far");
        myEntryRepo.save(myEntry2);
        assertEquals(3,myEntryRepo.getNumberOfEntries());

        myEntryRepo.deleteById("1");
        myEntryRepo.deleteById("2");
        assertEquals(1,myEntryRepo.getNumberOfEntries());
    }

    @Test
    public void testToDeleteEntryByEntry(){
        Entry myEntry = new Entry();
        myEntryRepo.save(myEntry);
        myEntryRepo.delete(myEntry);
        assertEquals(1,myEntryRepo.getNumberOfEntries());
    }

    @Test
    public void testToDeleteMoreEntry(){
        Entry myEntry = new Entry();
        Entry myEntry1 = new Entry();
        Entry myEntry2 = new Entry();
        myEntryRepo.save(myEntry);
        myEntryRepo.save(myEntry1);
        myEntryRepo.save(myEntry2);
        assertEquals(3,myEntryRepo.getNumberOfEntries());

        myEntryRepo.delete(myEntry);
        myEntryRepo.delete(myEntry1);
        assertEquals(1,myEntryRepo.getNumberOfEntries());

    }

    @Test
    public void testToFindAuthor(){
        Entry myEntry = new Entry("1","chichi","my story","this is my story");
        myEntryRepo.save(myEntry);
        myEntryRepo.findByAuthor("chichi");
        assertEquals(1,myEntryRepo.getNumberOfEntries());
    }

    @Test
    public void testToFindMoreAuthors(){
        Entry myEntry = new Entry("1","chichi","my story","this is my story");
        myEntryRepo.save(myEntry);
        Entry myEntry1 = new Entry("2","dayo","this life","in this life");
        myEntryRepo.save(myEntry1);

        myEntryRepo.findByAuthor("dayo");
        myEntryRepo.findByAuthor("chichi");

        assertEquals(2,myEntryRepo.getNumberOfEntries());

    }

    @Test
    public void testFindById(){
        Entry myEntry = new Entry("1","chichi","my story","this is my story");
        myEntryRepo.save(myEntry);
        myEntryRepo.findById("1");
        assertEquals(1,myEntryRepo.getNumberOfEntries());
    }
    @Test
    public void testToFindMyEntriesById(){
        Entry myEntry = new Entry("1","chichi","my story","this is my story");
        myEntryRepo.save(myEntry);
        Entry myEntry1 = new Entry("2","dayo","this life","in this life");
        myEntryRepo.save(myEntry1);

        myEntryRepo.findById("1");
        myEntryRepo.findById("2");
        assertEquals(2,myEntryRepo.getNumberOfEntries());

    }


}
