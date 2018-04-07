package com.example.expense_manager;

import com.example.manager.Manager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

	private Button login1;
	private TextView signup;
	private TextView signup1;
	private EditText showpass;
	private CheckBox checkit;
	
	private EditText userid;
	private Object password2;
	private Object uid;
	private Manager manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		login1=(Button)findViewById(R.id.button1);
		signup=(TextView)findViewById(R.id.textView5);
		signup1=(TextView)findViewById(R.id.textView7);
		checkit=(CheckBox)findViewById(R.id.checkBox1);
		userid=(EditText)findViewById(R.id.editText1);
		showpass=(EditText)findViewById(R.id.editText2);
		
		manager = new Manager(this);
		
		login1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				uid=userid.getText().toString();
				password2=showpass.getText().toString();
			
				Database_Handler dh = new Database_Handler(Login.this);
				dh.fetch();
				String c_no = dh.email;
				String password = dh.pass;
				
				if(c_no.equals(uid) && password.equals(password2)){
					manager.createSession(c_no, password);
					Intent intent=new Intent(Login.this,Home_page.class);
					startActivity(intent);
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Invalid User_id or password", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
		
		
		
		
		checkit.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    showpass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                   showpass.setInputType(129);
                }
            }
        });
		
		signup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Login.this,Registration.class);
				startActivity(intent);
			}
		});
		signup1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Login.this,Registration.class);
				startActivity(intent);
			}
		});

	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
