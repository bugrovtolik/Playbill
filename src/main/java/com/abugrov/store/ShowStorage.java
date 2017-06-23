package com.abugrov.store;

import com.abugrov.models.Show;
import java.util.Collection;

public class ShowStorage implements Storage {
    private static final ShowStorage INSTANCE = new ShowStorage();

    private final Storage storage = new MemoryStorage();

    public static ShowStorage getInstance() { return INSTANCE; }

    @Override
    public Collection<Show> values() { return storage.values(); }

    @Override
    public int add(final Show show) { return this.storage.add(show); }
    
    @Override
    public void edit(final Show show) { this.storage.edit(show); }

    @Override
    public void delete(final int id) { this.storage.delete(id); }

    @Override
    public Show get(final int id) { return this.storage.get(id); }

    @Override
    public Collection<Show> find(String by, String value) { return this.storage.find(by, value); }

    @Override
    public int generateId() { return this.storage.generateId(); }

    @Override
    public void close() { this.storage.close(); }
}