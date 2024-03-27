package services;

import model.Entry;
import repositories.EntryRepository;
import repositories.EntryRepositoryImpl;

import java.util.List;

public class EntryServiceImpl implements EntryService{
    private static EntryRepository myEntryRepo = new EntryRepositoryImpl();
    @Override
    public void save(Entry entry) {
        myEntryRepo.save(entry);

    }

    @Override
    public void deleteEntryById(String id) {
        myEntryRepo.deleteById(id);

    }

    @Override
    public List<Entry> findEntriesByUserName(String userName) {
        return myEntryRepo.findByAuthor(userName);
    }
}
