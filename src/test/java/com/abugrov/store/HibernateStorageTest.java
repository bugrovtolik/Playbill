package com.abugrov.store;

import com.abugrov.models.Show;
import org.junit.Assert;
import org.junit.Test;

public class HibernateStorageTest {
    
    @Test
    public void testCreate() throws Exception {
	final HibernateStorage storage = new HibernateStorage();
	final int id = storage.add(new Show(5, "testname", "1997-11-01'T'21:20", "Concert", "Freedom", "test description"));
	final Show show = storage.get(id);
	Assert.assertEquals(id, show.getId());
	storage.delete(id);
	Assert.assertNull(storage.get(id));
	storage.close();
    }
    
}
