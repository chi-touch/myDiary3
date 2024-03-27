package repositories;

import model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository{
    private List<Entry> entries = new ArrayList<>();
    private int numberOfEntries = 0;
    private int idNumber = 0;

    @Override
    public Entry save(Entry entry) {
        entries.add(entry);
        System.out.println("I got here");
        return entry;

    }

    @Override
    public void delete(Entry entry) {
        for (Entry entry1 : entries){
            entries.remove(entry1);
            break;
        }



    }

    @Override
    public void deleteById(String id) {
        for (Entry entry :entries){
            if (entry.getId() == id){
                entries.remove(idNumber);
                break;
            }
        }
    }


    @Override
    public List<Entry> findByAuthor(String author) {
        List<Entry> authorEntries = new ArrayList<>();
        for (Entry myEntry1 : entries){
            if (myEntry1.getAuthor().equals(author)){
                System.out.println("i also got here");
                authorEntries.add(myEntry1);
            }
        }
        return authorEntries;
    }

    @Override
    public Entry findById(String id) {
        for (Entry entry :entries){
            if (entry.getId().equals(id)){
                return entry;
            }
        }
        return null;
    }

    @Override
    public int getNumberOfEntries() {
        return entries.size();
    }

    @Override
    public int generateId() {
        return idNumber;
    }


}
