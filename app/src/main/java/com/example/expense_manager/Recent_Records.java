package com.example.expense_manager;

import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Recent_Records extends Activity {

	private ListView listView1;
	SimpleAdapter adapter;
	List<HashMap<String, String>> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recent__records);
		
		listView1 = (ListView) findViewById(R.id.listView1);
		Database_Handler db = new Database_Handler(this);
		data = db.fetchexpenses();
		String[] from = {"Expense", "Categoryy", "Descriptionn"};
		int[] to = {R.id.expense , R.id.category, R.id.desc};
		adapter = new SimpleAdapter(this, data, R.layout.custom_view1 , from, to);
		
		listView1.setAdapter(adapter);
	}

}
