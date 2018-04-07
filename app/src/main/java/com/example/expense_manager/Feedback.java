package com.example.expense_manager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);

		Button submit=(Button)findViewById(R.id.submit);
		Button cancel=(Button)findViewById(R.id.cancle);
		
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Feedback.this,Setting.class);
				startActivity(intent);
			}
		});
				
		submit.setOnClickListener(new OnClickListener() {
			
					
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText name1=(EditText)findViewById(R.id.name1);
				EditText emailid1=(EditText)findViewById(R.id.emailid1);
				EditText suggestion1=(EditText)findViewById(R.id.feedback1);
				
				String name = name1.getText().toString();
	            String emailid = emailid1.getText().toString();
	            String feedback = suggestion1.getText().toString();
	            
	            Intent email = new Intent(Intent.ACTION_SEND);
		           
	            String feedbackdata=name+emailid+feedback;
	                 
	            email.putExtra(Intent.EXTRA_EMAIL,new String[] {"deepakrajput179@gmail.com"});
	            email.putExtra(Intent.EXTRA_SUBJECT, "Feedback For Expense Manager!");
	            email.putExtra(Intent.EXTRA_TEXT,""+feedbackdata);
	            
	            //   need this to prompts email client only
	            email.setType("message/rfc822");
	            
	            try {
	            	
		            // the user can choose the email client
		            startActivity(Intent.createChooser(email, "Choose an Email client :"));

		            } 
		            catch (android.content.ActivityNotFoundException ex) 
		            {
		            Toast.makeText(getApplicationContext(), "No Email Clients Are Installer In Device",Toast.LENGTH_LONG ).show();
		            
		            }
				
		            
				}
			
		});	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feedback, menu);
		return true;
	}

}
