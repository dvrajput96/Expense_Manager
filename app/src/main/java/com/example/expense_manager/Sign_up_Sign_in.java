package com.example.expense_manager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Sign_up_Sign_in extends Activity {
	private Button bt1;
	private Button bt2;
	private Button bt3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE); getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 0);
		
		setContentView(R.layout.activity_sign_up_sign_in);
		bt1=(Button) findViewById(R.id.btnSingIn);
		bt2=(Button) findViewById(R.id.btnSignUp);
		bt3=(Button) findViewById(R.id.btnSkip);
		
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(i);			
			}
		});
		
bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Login.class);
				startActivity(i);
			}
		});
bt2.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(getApplicationContext(),Registration.class);
		startActivity(i);
	}
});

	}
}