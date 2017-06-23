package com.abugrov.store;

import com.abugrov.models.Show;
import java.util.Collection;

public interface Storage {
    
    public Collection<Show> values();
    
    public int add(final Show show);
    
    public void edit(final Show show);
    
    public void delete(final int id);
    
    public Show get(final int id);
    
    public Collection<Show> find(final String by, final String value);
    
    public int generateId();
    
    public void close();
}
