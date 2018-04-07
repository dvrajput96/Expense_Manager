package com.example.expense_manager;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class Reminder extends Activity {

	
	private ListView lst1;
	final Context context=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reminder);
		lst1=(ListView)findViewById(R.id.listView1);
		lst1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				// TODO Auto-generated method stub
				String name=(String)lst1.getAdapter().getItem(pos);
				if(name.equals("Add Reminder"))
				{
					Intent intent = new Intent(Reminder.this,Add_Reminder.class);
					startActivity(intent);
				}
				else if(name.equalsIgnoreCase("Edit Reminder"))
				{
		
					Intent intent = new Intent(Reminder.this,Edit_reminder.class);
					startActivity(intent);
				}
				else if(name.equals("View Reminder"))
				{
					Intent intent = new Intent(Reminder.this,View_reminder.class);
					startActivity(intent);
				}
				else if(name.equals("Delete Reminder"))
				{
					Intent intent3 = new Intent(Reminder.this,Delete_Reminder.class);
					startActivity(intent3);
				}
				
			}
	
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reminder, menu);
		return true;
	}

}
