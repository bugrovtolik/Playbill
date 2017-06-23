package com.abugrov.store;

import com.abugrov.models.Show;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryStorage implements Storage {
    
    private final AtomicInteger ids = new AtomicInteger();
    
    private final ConcurrentHashMap<Integer, Show> shows = new ConcurrentHashMap<>();
    
    
    @Override
    public Collection<Show> values() { return this.shows.values(); }

    @Override
    public int add(Show show) {
	this.shows.put(show.getId(), show);
	return show.getId();
    }

    @Override
    public void edit(Show show) { this.shows.replace(show.getId(), show); }

    @Override
    public void delete(int id) { this.shows.remove(id); }

    @Override
    public Show get(int id) {
	return this.shows.get(id);
    }

    @Override
    public Collection<Show> find(String by, String value) {
	Collection<Show> values = new ArrayList<>();
	List<Show> arrshows = new ArrayList<>(this.values());
	if(!shows.isEmpty()) {
	    for(int i = 0, len = this.shows.size(); i < len; i++) {
		switch(by) {
		    case "name":
			if(arrshows.get(i).getName().equalsIgnoreCase(value)) {
			    values.add(arrshows.get(i));
			}
			break;
		    case "date":
			if(arrshows.get(i).getDate(true).regionMatches(0, value, 0, 10)) {
			    values.add(arrshows.get(i));
			}
			break;
		    case "type":
			if(arrshows.get(i).getType().equals(value)) {
			    values.add(arrshows.get(i));
			}
			break;
		    case "place":
			if(arrshows.get(i).getPlace().equals(value)) {
			    values.add(arrshows.get(i));
			}
			break;
		}
	    }
	}
	return values;
    }

    @Override
    public int generateId() { return this.ids.incrementAndGet(); }

    @Override
    public void close() {}
    
}
