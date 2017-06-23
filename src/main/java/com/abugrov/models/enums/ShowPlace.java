package com.abugrov.models.enums;

public enum ShowPlace {
    Freedom,
    BelEtage,
    Sentrum,
    Atlas,
    CaribbeanClub,
    StereoPlaza;
    
    public static String[] valuesAsStrings() {
	ShowPlace[] thisValues = ShowPlace.values();
	String[] stringValues = new String[thisValues.length];
	for (int i = 0, length = thisValues.length; i < length; i++) {
	    stringValues[i] = thisValues[i].toString();
	}
	return stringValues;
    }
}
