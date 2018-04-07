package com.example.expense_manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database_Helper1 {

	static final String KEY_ID = "_id";
	static final String KEY_PRICE = "price";
	static final String KEY_REMINDER_TIMING = "reminder_timing";
	static final String KEY_CATEGORY = "category";
	static final String KEY_DATE = "date";
	static final String KEY_DESCRIPTION = "description";
	
	static final String KEY_PAYMENT_MODE = "payment_mode";
	static final String KEY_PICTURE = "picture";
	static final int DATABASE_VERSION = 1;
	static final String DATABASE_NAME = "Expense_manager_new";
	static final String DATABASE_Table_ADD_TRANSACTION = "Add_transaction";
	static final String DATABASE_Table_Add_reminder = "Add_reminder";
	static final String TAG = "DBAdapter";

	static final String DATABASE_CREATE = "create table Add_transaction(_id INTEGER PRIMARY KEY AUTOINCREMENT, price text not null, category text not null, date text not null ,description text not null, payment_mode text not null,picture BLOB );";

	// create table Add_reminder

	static final String DATABASE_CREATE_Add_reminder = "create table Add_reminder(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ " date text not null, time text not null, heading text not null ,"
			+ "price text not null, description text not null, Add_to text not null, "
			+ "category text not null, payment_mode text not null, "
			+ "recurring text not null, alert_at text not null,"
			+ "reminder_timing text not null, alert_via text not null, picture BLOB );";

	private static final String KEY_TIME = "time";
	private static final String KEY_HEADING = "heading";
	private static final String KEY_ADD_TO = "add_to";
	private static final String KEY_RECURRING = "recurring";
	private static final String KEY_ALERT_AT = "alert_at";
	private static final String KEY_ALERT_VIA = "alert_via";
	private static final String Add_reminder = "add_reminder";

	static Context context;
	DatabaseHelper DBHelper;
	SQLiteDatabase db;

	public Database_Helper1(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(ctx);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		public DatabaseHelper(Context context) {
			// TODO Auto-generated constructor stub
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			try {
				db.execSQL(DATABASE_CREATE);
				db.execSQL(DATABASE_CREATE_Add_reminder);
				
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("drop table if exists login");
			onCreate(db);
		}
	}

	public Database_Helper1 open() {
		db = DBHelper.getReadableDatabase();
		return this;
	}

	public void close() {
		DBHelper.close();
	}

	public long insertAdd_transaction(String price, String category,
			String date, String description, String payment_mode, byte[] picture) {
		ContentValues values = new ContentValues();
		values.put(KEY_PRICE, price);
		values.put(KEY_CATEGORY, category);
		values.put(KEY_DATE, date);
		values.put(KEY_DESCRIPTION, description);
		values.put(KEY_PAYMENT_MODE, payment_mode);
		values.put(KEY_PICTURE, picture);

		return db.insert(DATABASE_Table_ADD_TRANSACTION, null, values);
	}

	public Cursor getAll_transaction() throws SQLException {
		Log.w("My error", "indide getTerhdgiu");
		return db.query(DATABASE_Table_ADD_TRANSACTION, new String[] {
				KEY_CATEGORY, KEY_DATE, KEY_PRICE, KEY_DESCRIPTION,
				KEY_PAYMENT_MODE }, null, null, null, null, null);

	}

	// Create Add_reminder table

	public long insertAdd_reminder(String date, String time, String heading,
			String price, String discription, String add_to, String category,
			String payment_mode, String recurring, String alert_at,
			String alert_via, String valueofradiobutton, byte[] picture){
		ContentValues values = new ContentValues();
		values.put(KEY_DATE, date);
		values.put(KEY_TIME, time);
		values.put(KEY_HEADING, heading);
		values.put(KEY_PRICE, price);
		values.put(KEY_DESCRIPTION, discription);
		values.put(KEY_ADD_TO, add_to);
		values.put(KEY_CATEGORY, category);
		values.put(KEY_PAYMENT_MODE, payment_mode);
		values.put(KEY_RECURRING, recurring);
		values.put(KEY_ALERT_AT, alert_at);
		values.put(KEY_ALERT_VIA, alert_via);
		values.put(KEY_PICTURE, picture);
		values.put(KEY_REMINDER_TIMING, valueofradiobutton);
		return db.insert(DATABASE_Table_Add_reminder, null, values);

	}
	
	public int getReminderId(){
		Cursor c = db.rawQuery("select * from "+DATABASE_Table_Add_reminder+" order by _id desc limit 1", null);
		if(c.moveToFirst())
		{
			return c.getInt(1);
		}else{
			return 0;
		}
	}

	public Cursor getAdd_reminder() throws SQLException {
		return db.query(Add_reminder, new String[] { KEY_ID, KEY_DATE,
				KEY_TIME, KEY_HEADING, KEY_PRICE, KEY_DESCRIPTION, KEY_ADD_TO,
				KEY_CATEGORY, KEY_PAYMENT_MODE, KEY_RECURRING, KEY_ALERT_AT,
				KEY_ALERT_VIA, KEY_PICTURE, KEY_REMINDER_TIMING }, null, null,
				null, null, null);
	}

	public void Update(long rowid, String date, String time, String heading,
			String price, String discription, String add_to, String category,
			String payment_mode, String recurring, String alert_at,
			String alert_via, String valueofradiobutton, byte[] picture)

	{
		ContentValues cv = new ContentValues();
		cv.put(KEY_DATE, date);
		cv.put(KEY_TIME, time);
		cv.put(KEY_HEADING, heading);
		cv.put(KEY_PRICE, price);
		cv.put(KEY_DESCRIPTION, discription);
		cv.put(KEY_ADD_TO, add_to);
		cv.put(KEY_CATEGORY, category);
		cv.put(KEY_PAYMENT_MODE, payment_mode);
		cv.put(KEY_RECURRING, recurring);
		cv.put(KEY_ALERT_AT, alert_at);
		cv.put(KEY_ALERT_VIA, alert_via);

		cv.put(KEY_PICTURE, picture);
		cv.put(KEY_REMINDER_TIMING, valueofradiobutton);

		db.update(Add_reminder, cv, KEY_ID + "=" + rowid, null);

	}

	public boolean deleteQuestion(long rowid) {
		return db.delete(Add_reminder, KEY_ID + "=" + rowid, null) > 0;
	}

	public Cursor getDateInformation(String date) {
		Log.i("inside datbase", "1");
/*
		String sql = "select category, date, price from "
				+ DATABASE_Table_ADD_TRANSACTION + " where " + KEY_DATE
				+ " like '%" + date + "%'";*/
	//	Log.i("inside datbase", sql);
		return db.rawQuery("SELECT * FROM Add_transaction WHERE date LIKE '%"+date+"%'",null);

	}

	public Cursor getCategoryInformation(String category) {
		Log.i("inside datbase", "1");

		/*String sql = "select category, date, price from "
				+ DATABASE_Table_ADD_TRANSACTION + " where " + KEY_CATEGORY
				+ " like '%" + category + "%'";*/
		//Log.i("inside datbase", sql);
		return db.rawQuery("SELECT * FROM Add_transaction WHERE category LIKE '%"+category+"%'",null);

	}
	
	public Cursor getPaymentInformation(String payment_mode) {
		Log.i("inside datbase", "1");

		/*String sql = "select category, date, price from "
				+ DATABASE_Table_ADD_TRANSACTION + " where " + KEY_CATEGORY
				+ " like '%" + category + "%'";*/
		//Log.i("inside datbase", sql);
		return db.rawQuery("SELECT * FROM Add_transaction WHERE payment_mode LIKE '%"+payment_mode+"%'",null);

	}
	public Cursor getPriceInfo()
	{
		return db.rawQuery("SELECT price FROM Add_transaction", null);

		
	}
	
	
	
	public SQLiteDatabase getWritableDatabase() {
		// TODO Auto-generated method stub
		return null;
	}
}