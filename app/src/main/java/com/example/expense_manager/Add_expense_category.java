package com.example.expense_manager;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Add_expense_category extends Activity {
	
	final Context context=this;
	Context ctx = this;
	private EditText addexpensecategory;
	private Button save;
	public String addCategory;
	public int id;
	public Object catt;
	ArrayList<String> arrayList=new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_expense_category);
		addexpensecategory=(EditText)findViewById(R.id.editText1);
		save=(Button)findViewById(R.id.button2);
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				addCategory=addexpensecategory.getText().toString();
				
				Database_Handler db = new Database_Handler(ctx);
				db.putInfromationAddExpenseCategory(db, id, addCategory);
				
				arrayList= db.fetchexpense();	
				Toast.makeText(getApplicationContext(), "Income Category Added.....", Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(Add_expense_category.this,Add_Expense.class);
				startActivity(intent);
				Add_expense_category.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_expense_category, menu);
		return true;
	}

}
