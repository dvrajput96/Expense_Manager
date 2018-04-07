package com.example.expense_manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import com.example.manager.Manager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mario on 3/11/2015.
 */
public class Swipe_overview extends FragmentActivity {
	private SQLiteDatabase db;
	private String table_name = "mytable";
	public static final String KEY_ROWID = "value";

	public static final String KEY_NAME = "name";

	private String database_name = "Brt.db";
	private TextView tv1;
	ViewPager viewpager;
	private Button _btn1;
	private Button _btn2;
	private Button _btn3;
	private Button _btn4;
	private ViewPager _mViewPager;
	private com.example.expense_manager.PagerAdapter _adapter;
	private Manager manager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe_overview);
		setUpView();
		setTab();

		DataBaseHelper myDbHelper = new DataBaseHelper(null);
		myDbHelper = new DataBaseHelper(this);

		try {

			myDbHelper.createDataBase();

		} catch (IOException ioe) {

			throw new Error("Unable to create database");

		}

		try {

			myDbHelper.openDataBase();

		} catch (SQLException sqle) {

			throw sqle;

		}

		db = openOrCreateDatabase(database_name,
				SQLiteDatabase.CREATE_IF_NECESSARY, null);

		db.setVersion(1);

		db.setLocale(Locale.getDefault());

		db.setLockingEnabled(true);
		Cursor cur = fetchAllTodos();

		startManagingCursor(cur);

		cur.moveToFirst();

		new ArrayList<String>();
		String stname;

		do {

			stname = cur.getString(1);
			// ans.setText(ans.getText()+String.valueOf(mStrings[i])+"-"+String.valueOf(stname[i]));
		} while (cur.moveToNext());

		manager = new Manager(this);
		if ("a".equals(stname)){
			
			if(!manager.isLogin()){
				Intent i = new Intent(getApplicationContext(), Login.class);
				startActivity(i);
			}else{
				Intent i = new Intent(getApplicationContext(), Home_page.class);
				startActivity(i);
			}
			finish();
		}

		ContentValues cv = new ContentValues();
		cv.put("value", "a");

		db.update("mytable", cv, "name " + "= ?", new String[] { "first" });

	}

	private void setTab() {
		// TODO Auto-generated method stub
		_mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrollStateChanged(int position) {
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				btnAction(position);
			}

		});

	}

	private void setUpView() {
		// TODO Auto-generated method stub
		_mViewPager = (ViewPager) findViewById(R.id.pager);
		_adapter = new PagerAdapter(getApplicationContext(),
				getSupportFragmentManager());
		_mViewPager.setAdapter(_adapter);
		_mViewPager.setCurrentItem(0);
		initButton();
	}

	public Cursor fetchAllTodos() {

		return db.query(table_name, new String[] { KEY_NAME, KEY_ROWID }, null,
				null, null, null, null);

	}

	protected void onDestroy() {

		super.onDestroy();

	}

	private void btnAction(int action) {
		switch (action) {
		case 0:

			setButton(_btn1, "1", 40, 40);
			setButton(_btn2, "", 20, 20);
			setButton(_btn3, "", 20, 20);

			break;
		case 1:

			setButton(_btn2, "2", 40, 40);
			setButton(_btn3, "", 20, 20);
			setButton(_btn1, "", 20, 20);

			break;

		case 2:

			setButton(_btn3, "3", 40, 40);
			setButton(_btn2, "", 20, 20);
			setButton(_btn1, "", 20, 20);

			break;

		}
	}

	private void initButton() {
		_btn1 = (Button) findViewById(R.id.btn1);
		_btn2 = (Button) findViewById(R.id.btn2);
		_btn3 = (Button) findViewById(R.id.btn3);
		_btn4 = (Button) findViewById(R.id.btn4);
		setButton(_btn1, "1", 40, 40);
		setButton(_btn2, "", 20, 20);
		setButton(_btn3, "", 20, 20);
		setButton(_btn4, "", 20, 20);
	}

	private void setButton(Button btn, String text, int h, int w) {

		btn.setWidth(w);
		btn.setHeight(h);
		btn.setText(text);
	}
}