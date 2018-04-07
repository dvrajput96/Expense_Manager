package com.example.expense_manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database_Handler extends SQLiteOpenHelper {

	String email, expensecat;
	String pass, incomecat;

	public static final int database_version = 1;
	public String CREATE_QUERY = "create table registration(First_Name text,Last_Name text,Contact_No int,Email_Id text,Pass text,Gender text);";
	public String CREATE_QUERY1 = "create table addincome(Income int,Category text,Description text);";
	public String CREATE_QUERY2 = "create table addexpense(Expense int,Categoryy text,Descriptionn text);";
	public String CREATE_QUERY3 = "create table addincomecat(Id int,Addcategory text);";
	public String CREATE_QUERY4 = "create table addexpensecat(Id int,Addcategory text);";

	public Database_Handler(Context context) {

		super(context, "ExpenseManager", null, 1);
		Log.d("Database Operation", "Database Created .....");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_QUERY);
		db.execSQL(CREATE_QUERY1);
		db.execSQL(CREATE_QUERY2);
		db.execSQL(CREATE_QUERY3);
		db.execSQL(CREATE_QUERY4);
		Log.d("Database Operation", "Table Created .....");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

	public void putInfromation(Database_Handler db, String fname, 
			String lname, String contactno, String eid, String pass,String gender) {
		// TODO Auto-generated method stub
		SQLiteDatabase SQ = db.getWritableDatabase();
		ContentValues CV = new ContentValues();

		CV.put("First_Name", fname);
		
		CV.put("Last_Name", lname);
		CV.put("Contact_No", contactno);
		CV.put("Email_Id", eid);
		CV.put("Pass", pass);
		
		CV.put("Gender", gender);
		
		long k = SQ.insert("registration", null, CV);
		db.close();
		Log.d("Database Operation", "One Row Inserted .....");

	}

	public void putInfromationAddIncome(Database_Handler db, String addincome,
			String addcategory, String adddescription) {
		// TODO Auto-generated method stub

		SQLiteDatabase SQ = db.getWritableDatabase();
		ContentValues CV = new ContentValues();

		CV.put("Income", addincome);
		CV.put("Category", addcategory);
		CV.put("Description", adddescription);

		long k = SQ.insert("addincome", null, CV);
		db.close();
		Log.d("Database Operation", "One Row Inserted .....");

	}

	public void putInfromationAddIncomeCategory(Database_Handler db, int id,
			String addCategory11) {
		// TODO Auto-generated method stub

		SQLiteDatabase SQ = db.getWritableDatabase();
		ContentValues CV = new ContentValues();

		CV.put("Id", id);
		CV.put("AddCategory", addCategory11);

		long k = SQ.insert("addincomecat", null, CV);
		db.close();
		Log.d("Database Operation", "One Row Inserted .....");

	}

	public void putInfromationAddExpenseCategory(Database_Handler db, int id,
			String addCategory) {
		// TODO Auto-generated method stub

		SQLiteDatabase SQ = db.getWritableDatabase();
		ContentValues CV = new ContentValues();

		CV.put("Id", id);
		CV.put("AddCategory", addCategory);

		long k = SQ.insert("addexpensecat", null, CV);
		db.close();
		Log.d("Database Operation", "One Row Inserted .....");

	}

	public void putInfromationAddExpense(Database_Handler db,
			String addexpense, String addcategory1, String adddescription1) {
		// TODO Auto-generated method stub
		SQLiteDatabase SQ = db.getWritableDatabase();
		ContentValues CV = new ContentValues();

		CV.put("Expense", addexpense);
		CV.put("Categoryy", addcategory1);
		CV.put("Descriptionn", adddescription1);

		long k = SQ.insert("addexpense", null, CV);
		db.close();
		Log.d("Database Operation", "One Row Inserted .....");

	}

	public void fetch() {
		SQLiteDatabase db = getReadableDatabase();
		String query = "select Email_Id, Pass from registration";
		Cursor c = db.rawQuery(query, null);
		while (c.moveToNext()) {
			email = c.getString(0);
			pass = c.getString(1);

		}

	}

	public ArrayList<String> fetchincome() {
		int i = 0;
		ArrayList<String> arrayList = new ArrayList<String>();
		SQLiteDatabase db = getReadableDatabase();
		String query = "select Addcategory from addincomecat";
		Cursor c = db.rawQuery(query, null);

		while (c.moveToNext()) {

			arrayList.add(c.getString(0));
			System.out.println(">>>>>>>>>>>>>>>" + c.getString(0));

		}
		System.out.println(">>>>>>>>>>>>>>>>" + arrayList);
		return arrayList;
	}

	public ArrayList<String> fetchexpense() {
		int i = 0;
		ArrayList<String> arrayList = new ArrayList<String>();
		SQLiteDatabase db = getReadableDatabase();
		String query = "select Addcategory from addexpensecat";
		Cursor c = db.rawQuery(query, null);
		while (c.moveToNext()) {

			arrayList.add(c.getString(0));
			System.out.println(">>>>>>>>>>>>>>>" + c.getString(0));

		}
		System.out.println(">>>>>>>>>>>>>>>>" + arrayList);
		return arrayList;
	}
	
	public List<HashMap<String, String>> fetchexpenses() {
		List<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
		SQLiteDatabase db = getReadableDatabase();
		String query = "select Expense, Categoryy, Descriptionn  from addexpense";
		Cursor c = db.rawQuery(query, null);
		while (c.moveToNext()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("Expense", c.getInt(0)+"");
			map.put("Categoryy", c.getString(1));
			map.put("Descriptionn", c.getString(2));
			arrayList.add(map);
		}
		return arrayList;
	}
	

	public List<HashMap<String, String>> fetchincomes() {
		List<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
		SQLiteDatabase db = getReadableDatabase();
		String query = "select Income, Category, Description  from addincome";
		Cursor c = db.rawQuery(query, null);
		while (c.moveToNext()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("Expense", c.getInt(0)+"");
			map.put("Category", c.getString(1));
			map.put("Description", c.getString(2));
			arrayList.add(map);
		}
		return arrayList;
	}
	
	public int getTotalExpence() {
		SQLiteDatabase db = getReadableDatabase();
		String query = "select SUM(Expense) from addexpense";
		Cursor c = db.rawQuery(query, null);
		while (c.moveToFirst()) {
			return c.getInt(0);
		}
		return 0;
	}
	
	public int getTotalIncome() {
		SQLiteDatabase db = getReadableDatabase();
		String query = "select SUM(Income) from addincome";
		Cursor c = db.rawQuery(query, null);
		while (c.moveToFirst()) {
			return c.getInt(0);
		}
		return 0;
	}
	
	public int getBalance(){
		return getTotalIncome() - getTotalExpence();
	}

}
