package com.abugrov.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Show {
    private int id;
    private String name;
    private String type;
    private String place;
    private String description;
    private Date date;
    
    public Show() {
    }
    
    public Show(final int id, final String name, final String date, final String type, final String place, final String description) {	
	    this.id = id;
	    this.name = name;
	    this.type = type;
	    this.place = place;

	    
	    if(date != null) {
		Date newdate;
		try {
		    newdate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date);
		} catch (ParseException ex) {
		    newdate = new Date();
		}
		this.date = newdate;
	    } else {
		this.date = new Date();
	    }

	    this.description = description==null?"":description;
    }
    
    public int getId() { 
	return this.id; 
    }
    public String getName() {
	return this.name;
    }

    /**
     * If b is true then returns (yyyy-MM-dd'T'HH:mm) format, else returns (dd-MM-yyyy HH:mm) format
     * @param b
     * @return date as String
     */
    public String getDate(boolean b) {
	return b?new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(this.date)
		:new SimpleDateFormat("dd-MM-yyyy HH:mm").format(this.date);
    }
    public Date getDate() {
	return this.date;
    }
    public String getType() {
	return this.type;
    }
    public String getPlace() {
	return this.place;
    }
    public String getDescription() {
	return this.description;
    }
    
    public void setId(int id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setType(String type) {
	this.type = type;
    }

    public void setPlace(String place) {
	this.place = place;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setDate(Date date) {
	this.date = date;
    }
}
