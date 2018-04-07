package com.example.expense_manager;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_income_category extends Activity {

	private EditText addincomecategory;
	public String addCategory11;
	public int id;
	public String catt;
	final Context context=this;
	Context ctx = this;
	private Button save;
	ArrayList<String> arrayList=new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_income_category);
		
		addincomecategory=(EditText)findViewById(R.id.editText1);
		save=(Button)findViewById(R.id.button2);
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				addCategory11=addincomecategory.getText().toString();
				
				Database_Handler db = new Database_Handler(Add_income_category.this);
				db.putInfromationAddIncomeCategory(db, id, addCategory11);	
				arrayList= db.fetchincome();	
				Toast.makeText(getApplicationContext(), "Income Category Added.....", Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(Add_income_category.this,Add_Income.class);
				startActivity(intent);
				
				Add_income_category.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_income_category, menu);
		return true;
	}

}
