package com.example.expense_manager;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Delete_Reminder extends Activity {

	static int a;
	ListView lv1;
	ArrayList<String> aa1 = new ArrayList<String>();
	ArrayList<Integer> aa2 = new ArrayList<Integer>();
	// AlertDialog.Builder alertDialogBuilder;
	ArrayAdapter<String> adap1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete__reminder);
		lv1 = (ListView) findViewById(R.id.listView1);

		adap1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, aa1);
		final Database_Helper1 db = new Database_Helper1(this);
		db.open();
		try {
			Cursor c = db.getAdd_reminder();
			if (c.moveToFirst())
				;
			{
				do {
					aa2.add(c.getInt(0));
					aa1.add("Reminder " + c.getString(0));
				} while (c.moveToNext());
			}
			lv1.setAdapter(adap1);

			lv1.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						final int arg2, long arg3) {

					a = aa2.get(arg2);

					AlertDialog.Builder builder = new Builder(Delete_Reminder.this);
					builder.setTitle("Delete Reminder");
					builder.setMessage("Are you sure want to delete?");
					builder.setPositiveButton("Yes", new OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							if (aa2.isEmpty()) {
								Toast.makeText(getApplicationContext(),
										"insert new reminder ", Toast.LENGTH_LONG)
										.show();
							} else {
								db.open();
								db.deleteQuestion(aa2.get(arg2));
								db.close();
								aa1.remove(aa1.get(arg2));
								aa2.remove(aa2.get(arg2));

								lv1.setAdapter(adap1);

							}
							
						}
					});
					builder.setNegativeButton("No", new OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getApplicationContext(),
									"None Operation Perform", Toast.LENGTH_LONG)
									.show();
							
						}
					});
					builder.show();
					

				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
