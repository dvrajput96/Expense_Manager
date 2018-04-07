package com.example.expense_manager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends Activity {
	
	Context ctx = this;
	public String fname,lname,contactnocode,contactno,eid,pass,gender,contact;
	
	private Button reg;
	
	private TextView login;
	private EditText firstname1;
	private EditText lastname1;
	private EditText emailid1;
	private Spinner gender1;
	private EditText contactno1;
	private Spinner contactnocode1;
	private EditText pass1;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		
		reg=(Button)findViewById(R.id.button2);
		login=(TextView)findViewById(R.id.textView11);
	    firstname1=(EditText)findViewById(R.id.editText1);
        
        lastname1=(EditText)findViewById(R.id.editText3);
        contactnocode1=(Spinner)findViewById(R.id.editText4);
        contactno1=(EditText)findViewById(R.id.editText8);
        emailid1=(EditText)findViewById(R.id.editText5);
        pass1=(EditText)findViewById(R.id.editText6);
       
        gender1=(Spinner)findViewById(R.id.spinner1);
       
        
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				Intent i = new Intent(Registration.this,Login.class);
				startActivity(i);
				
			}
		});
		
		reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
						
				fname=firstname1.getText().toString();
				
				lname=lastname1.getText().toString();
				contactnocode=contactnocode1.getSelectedItem().toString();
				contactno=contactno1.getText().toString();
				eid=emailid1.getText().toString();
				pass=pass1.getText().toString();
				
				gender=gender1.getSelectedItem().toString();
				
				
				
				
				contact=contactnocode+""+contactno;
				
				Database_Handler db = new Database_Handler(ctx);
				db.putInfromation(db,fname,lname,contact,eid,pass,gender);
				
				Toast.makeText(getApplicationContext(), "Registered Successfully...", Toast.LENGTH_SHORT).show();
				
			

				
				Intent intent=new Intent(Registration.this,Login.class);
				startActivity(intent);
				
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}

}
