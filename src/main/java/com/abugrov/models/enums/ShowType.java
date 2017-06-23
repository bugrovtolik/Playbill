package com.abugrov.models.enums;

public enum ShowType {
    Concert,
    Opera,
    Exhibition,
    Movie,
    Play;
    
    public static String[] valuesAsStrings() {
	ShowType[] thisValues = ShowType.values();
	String[] stringValues = new String[thisValues.length];
	for (int i = 0, length = thisValues.length; i < length; i++) {
	    stringValues[i] = thisValues[i].toString();
	}
	return stringValues;
    }
}
