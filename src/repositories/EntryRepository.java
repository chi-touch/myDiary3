package repositories;

import model.Entry;

import java.util.List;

public interface EntryRepository {
    Entry save(Entry entry);
    void delete(Entry entry);
    void deleteById(String id);
    List<Entry> findByAuthor(String userName);
    Entry findById(String id);

    int getNumberOfEntries();

    int generateId();
}
