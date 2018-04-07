package com.example.expense_manager;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Edit_reminder extends Activity {
	Database_Helper1 dbh;

	ListView ls;
	ArrayAdapter<String> adap1;
	ArrayList<String> aa1 = new ArrayList<String>();

	ArrayList<Integer> aa2 = new ArrayList<Integer>();
	// static String a;
	static int a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_reminder);

		ls = (ListView) findViewById(R.id.listView1);
		adap1 = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.layout_listview_1_selfmade, aa1);

		// String heading;
		dbh = new Database_Helper1(this);
		dbh.open();
		Cursor c = dbh.getAdd_reminder();
		Log.w("cp", "1");

		if (c.moveToFirst()) {
			Log.d("cp", "2");
			do {
				// heading=c.getString(3);
				aa2.add(c.getInt(0));
				aa1.add("Reminder " + c.getString(0));
				// DisplayAll_transection(c);

			} while (c.moveToNext());

		}
		Log.w("cp", "3");
		dbh.close();
		Log.w("cp", "4");

		Log.w("cp", "5");
		ls.setAdapter(adap1);
		ls.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				a = aa2.get(arg2);
				Toast.makeText(Edit_reminder.this, "Want to updated",
						Toast.LENGTH_SHORT).show();
				Intent i = new Intent(Edit_reminder.this,
						Edit_reminder_update.class);
				startActivity(i);

			}
		});
	}

	private void DisplayAdd_reminder(Cursor c) {
		// TODO Auto-generated method stub
		String heading;
		heading = c.getString(3);

		Toast.makeText(getApplicationContext(), "heading", Toast.LENGTH_LONG)
				.show();

	}
}