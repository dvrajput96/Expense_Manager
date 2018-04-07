package com.example.expense_manager;

import com.example.manager.Manager;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.sax.EndElementListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Home_page extends Activity {

	final Context context=this;
	private ImageView expence1;
	private ImageView recent1;
	private ImageView income1;
	private ImageView reminder1;
	private ImageView setting1;
	
	private TextView expence2;
	private TextView income2;
	private TextView recent2;
	private TextView reminder2;
	private TextView setting2;
	private ImageButton recent11;
	private TextView recent22;
	private TextView totalincome;
	private TextView totalexpense;
	private TextView totalbalance;
	private Database_Handler handler;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);
		
		income1=(ImageButton)findViewById(R.id.imageButton1);
		expence1=(ImageButton)findViewById(R.id.imageButton2);
		
		recent1=(ImageButton)findViewById(R.id.imageButton4);
		reminder1=(ImageButton)findViewById(R.id.imageButton5);
		setting1=(ImageButton)findViewById(R.id.imageButton6);
		recent11=(ImageButton)findViewById(R.id.imageButton7);
		
		income2=(TextView)findViewById(R.id.textView1);
		expence2=(TextView)findViewById(R.id.textView2);
		recent2=(TextView)findViewById(R.id.textView4);
		reminder2=(TextView)findViewById(R.id.textView3);
		setting2=(TextView)findViewById(R.id.textView5);
		recent22=(TextView)findViewById(R.id.textView7);
		totalincome=(TextView)findViewById(R.id.textView6);
		totalexpense=(TextView)findViewById(R.id.textView11);
		totalbalance=(TextView)findViewById(R.id.textView12);
		handler = new Database_Handler(this);
		
		totalincome.setText(handler.getTotalIncome() + "");
		totalexpense.setText(handler.getTotalExpence() + "");
		totalbalance.setText(handler.getBalance() + "");
		
		recent11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_page.this,Recent_Record1.class);
				startActivity(intent);
			}
		});
		
		recent22.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_page.this,Recent_Record1.class);
				startActivity(intent);
			}
		});
		
		
		expence1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_page.this,Add_Expense.class);
				startActivity(intent);
			}
		});
		expence2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_page.this,Add_Expense.class);
				startActivity(intent);
			}
		});
		
		income1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_page.this,Add_Income.class);
				startActivity(intent);
			}
		});
		income2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_page.this,Add_Income.class);
				startActivity(intent);
			}
		});


		recent1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(Home_page.this,Recent_Records.class);
				startActivity(intent);
				
			}
		});
		recent2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_page.this,Recent_Records.class);
				startActivity(intent);
			}
		});
		
		reminder1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_page.this,Reminder.class);
				startActivity(intent);
			}
		});
		reminder2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_page.this,Reminder.class);
				startActivity(intent);
			}
		});
		
		
		
		setting1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_page.this,Setting.class);
				startActivity(intent);
			}
		});
		setting2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Home_page.this,Setting.class);
				startActivity(intent);
			}
		});

		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
			case R.id.action_feedback:
				
				Intent intent5 = new Intent(this,Feedback.class);
				startActivity(intent5);
				return true;
				
				
				
			case R.id.action_shareapp:
				
				Intent intent6 = new Intent(android.content.Intent.ACTION_SEND);
				intent6.setType("text/plain");
				intent6.putExtra(android.content.Intent.EXTRA_SUBJECT, "Expense Manager!");
				intent6.putExtra(android.content.Intent.EXTRA_TEXT, "Hey!! There is a app called Expense Manager!, It s a best location search application in Google Play, Download app from clicking on following link.. https://www.expensemanager.org");
				startActivity(Intent.createChooser(intent6, "Share Via"));
				
				return true;
				
			case R.id.action_rateapp:
				
			
				final Dialog dialog = new Dialog(context); 
				dialog.setContentView(R.layout.rate_app); 
                dialog.setTitle("Ratting");
                
                Button dialogButton = (Button) dialog.findViewById(R.id.button1);
                Button dialogButton1 = (Button) dialog.findViewById(R.id.button2);
                dialogButton.setOnClickListener(new OnClickListener() 
                { 
                    @Override
                    public void onClick(View v) 
                    {
                        dialog.dismiss(); 
                    }
                });
                dialogButton1.setOnClickListener(new OnClickListener() 
                { 
                    @Override
                    public void onClick(View v) 
                    {
                        dialog.dismiss(); 
                    }
                });
                dialog.show();
				return true;
				
			case R.id.action_aboutapp:
	
				Intent intent8 = new Intent(this,About_app.class);
				startActivity(intent8);
				return true;
				
			case R.id.action_help:
				
				Intent intent9 = new Intent(this,Help.class);
				startActivity(intent9);
				return true;
				
			case R.id.action_logout:
				Manager manger = new Manager(this);
				manger.clear();
				Intent intent10 = new Intent(this,Login.class);
				startActivity(intent10);
				finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
