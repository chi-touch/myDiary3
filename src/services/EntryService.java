package services;

import dto.CreateRequest;
import model.Entry;

import java.util.ArrayList;
import java.util.List;

public interface EntryService {
    void  save(Entry entry);
    void deleteEntryById(String id);
    List<Entry>findEntriesByUserName(String userName);

}
