package com.group10.SchooManagementSystem.Data;

public enum SearchTypes {
	userId, name;

	private SearchTypes(){ }
	public String value(){
		return name();
	}
	public static SearchTypes fromValue(String v){
		return valueOf(v);
	}
}
