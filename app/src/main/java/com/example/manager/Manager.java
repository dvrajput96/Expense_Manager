package com.example.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Manager {
	
	Context context;
	SharedPreferences sp;
	Editor et;
	private static final String NAME = "expence";
	private static final String EMAIL = "email";
	private static final String PASS = "pass";
	private static final String LOGIN = "login";
	
	public Manager(Context context) {
		this.context = context;
		sp = context.getSharedPreferences(NAME , Context.MODE_PRIVATE);
		et = sp.edit();
	}
	
	public void createSession(String email, String pass){
		et.putString(EMAIL, email);
		et.putString(PASS, pass);
		et.putBoolean(LOGIN, true);
		et.commit();
	}
	
	public void clear(){
		et.clear();
		et.commit();
	}
	
	public String getEmail(){
		return sp.getString(EMAIL, "");
	}
	
	public boolean isLogin(){
		return sp.getBoolean(LOGIN, false);
	}
	
}
