package com.abugrov.store;

import com.abugrov.models.Show;
import com.abugrov.service.Settings;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JdbcStorage implements Storage {
    private final Connection connection;
    
    public JdbcStorage() {
	final Settings settings = Settings.getInstance();
	try {
	    this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
	} catch (SQLException e) {
	    throw new IllegalStateException(e);
	}
	
    }

    @Override
    public Collection<Show> values() {
	final List<Show> shows = new ArrayList<>();
	try (final Statement statement = this.connection.createStatement();
	     final ResultSet rs = statement.executeQuery("select * from show")) {
	    while(rs.next()) {
		shows.add(new Show(rs.getInt("id"), rs.getString("name"), rs.getString("showdate"), rs.getString("type"), rs.getString("place"), rs.getString("description")));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return shows;
    }

    @Override
    public int add(Show show) {
	try (final PreparedStatement statement = this.connection.prepareStatement("insert into show(name, showdate, type, place, description) values(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
	    statement.setString(1, show.getName());
	    statement.setTimestamp(2, new java.sql.Timestamp(show.getDate().getTime()));
	    statement.setString(3, show.getType());
	    statement.setString(4, show.getPlace());
	    statement.setString(5, show.getDescription());
	    statement.executeUpdate();
	    try (final ResultSet generatedKeys = statement.getGeneratedKeys()) {
		if(generatedKeys.next()) {
		    return generatedKeys.getInt(1);
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	throw new IllegalStateException("Couldn't create new show");
    }

    @Override
    public void edit(Show show) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public Show get(int id) {
	try (final PreparedStatement statement = this.connection.prepareStatement(
		"select * from show where idid=(?)")) {
	    statement.setInt(1, id);
	    try (final ResultSet rs = statement.executeQuery()) {
		if(rs.next()) {
		    return new Show(rs.getInt("id"), rs.getString("name"), rs.getString("showdate"), rs.getString("type"), rs.getString("place"), rs.getString("description"));
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	throw new IllegalStateException("Show with id = "+id+" doesn't exist");
    }
    
    @Override
    public Collection<Show> find(String by, String value) { return null; }

    @Override
    public int generateId() { return 0; }

    @Override
    public void close() {
	try {
	    connection.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
}
