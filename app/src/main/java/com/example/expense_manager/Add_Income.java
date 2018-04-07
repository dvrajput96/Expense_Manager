package com.example.expense_manager;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_Income extends Activity {
	
	final Context context=this;
	Context ctx = this;
	public String addincome,addcategory,adddescription;
	private EditText income1;
	private Spinner category1;
	private EditText description1;
	private Button save1;
	private Button addincomecategory;
	public Object uid;

	ArrayList<String> arrayList=new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add__income);
		
		income1=(EditText)findViewById(R.id.editText1);
		category1=(Spinner)findViewById(R.id.spinner1);
		description1=(EditText)findViewById(R.id.editText2);
		save1=(Button)findViewById(R.id.button2);
		addincomecategory=(Button)findViewById(R.id.button1);
		
		Database_Handler db = new Database_Handler(Add_Income.this);
		arrayList= db.fetchincome();
		
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(Add_Income.this, android.R.layout.simple_list_item_1, arrayList);
		category1.setAdapter(adapter);
		
		addincomecategory.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Add_Income.this,Add_income_category.class);
				startActivity(intent);
					

				Add_Income.this.finish();
				
			}
		});
		
		save1.setOnClickListener(new OnClickListener() {
			
		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				addincome=income1.getText().toString();
				addcategory=category1.getSelectedItem().toString();
				adddescription=description1.getText().toString();
				
				Database_Handler db = new Database_Handler(ctx);
				db.putInfromationAddIncome(db,addincome,addcategory,adddescription);
				Toast.makeText(getApplicationContext(), "Income Added Successfully.....", Toast.LENGTH_SHORT).show();
				
				income1.setText("");
				
				description1.setText("");
				
			}
		});
		
		
		
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add__income, menu);
		return true;
	}

}
