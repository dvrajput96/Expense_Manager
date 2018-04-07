package com.example.expense_manager;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class View_reminder extends Activity{
ListView ls;

static ImageView v;

Database_Helper1 dbh;
ArrayAdapter<String> aa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_reminder);
		v = (ImageView) findViewById(R.id.Camera1);
		final ArrayList<String> list1 = new ArrayList<String>();
byte[] img;
		int i = 0;
		ls = (ListView) findViewById(R.id.listView1);
		String date, time,heading,price,discription,add_to,category,payment_mode,recurring,alert_at,alert_via,picture,valueofradiobutton;
		dbh = new Database_Helper1(this);
		dbh.open();
		Cursor c = dbh.getAdd_reminder();
		 Log.w("cp","1");
        
		if (c.moveToFirst()) {
			Log.d("cp", "2");
			do {
				date=c.getString(0);
				time=c.getString(1);
				heading=c.getString(2);
				price=c.getString(3);
				discription=c.getString(4);
				add_to=c.getString(5);
				category=c.getString(6);
				payment_mode=c.getString(7);
				recurring=c.getString(8);
				alert_at=c.getString(9);
				alert_via=c.getString(10);
				//img=c.getString(11);
			img=c.getBlob(c.getColumnIndex("picture"));
				valueofradiobutton=c.getString(12);
				
				Log.d("llevent", "6");
				list1.add(date+"\n "+time+"\n "+heading+"  \n "+price+" \n  "+discription+" \n  "+add_to+" \n  "+category+" \n  "+payment_mode+"  \n "+recurring+"\n  "+alert_at+"\n  "+alert_via+"\n  "+valueofradiobutton);
				
				//DisplayAll_transection(c);
				
			} while (c.moveToNext());
		}
		Log.w("cp","3");
		dbh.close();
		Log.w("cp","4");
		aa= new ArrayAdapter<String>(getApplicationContext(),R.layout.layout_listview_1_selfmade,list1);
		Log.w("cp","5");
		ls.setAdapter(aa);

	}
	private void DisplayAdd_reminder(Cursor c) {
		// TODO Auto-generated method stub
		String date, time,heading,price,discription,add_to,category,payment_mode,recurring,alert_at,alert_via,img,valueofradiobutton;
		date=c.getString(0);
		time=c.getString(1);
		heading=c.getString(2);
		price=c.getString(3);
		discription=c.getString(4);
		add_to=c.getString(5);
		category=c.getString(6);
		payment_mode=c.getString(7);
		recurring=c.getString(8);
		alert_at=c.getString(9);
		alert_via=c.getString(10);
		img=c.getString(11);
		valueofradiobutton=c.getString(12);
		
		/*Toast.makeText(getApplicationContext(),
				"date" + date + "time"
						+ time + "heading" + heading,
				Toast.LENGTH_LONG).show();*/
		
		
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.i("check point ", "9");

		super.onActivityResult(requestCode, resultCode, data);
		Bitmap bp = (Bitmap) data.getExtras().get("data");
		v.setImageBitmap(bp);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bp.compress(Bitmap.CompressFormat.PNG, 100, bos);
		byte[] img = bos.toByteArray();

	}


}
