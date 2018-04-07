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
import android.widget.Toast;

public class Setting extends Activity {

	private ListView lst1;
	final Context context=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		
		lst1=(ListView)findViewById(R.id.listView1);
		lst1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				// TODO Auto-generated method stub
				String name=(String)lst1.getAdapter().getItem(pos);
				
				if(name.equalsIgnoreCase("Rate Application"))
				{
		
					final Dialog dialog = new Dialog(context); 
					dialog.setContentView(R.layout.rate_app); 
	                dialog.setTitle("Ratting");
	                
	                Button dialogButton = (Button) dialog.findViewById(R.id.button1);
	                Button dialogButton2 = (Button) dialog.findViewById(R.id.button2);
	                
	                dialogButton2.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							dialog.dismiss(); 
						}
					});
	                
	                dialogButton.setOnClickListener(new OnClickListener() 
	                { 
	                    @Override
	                    public void onClick(View v) 
	                    {
	                        dialog.dismiss(); 
	                    }
                    });
	                dialog.show();
				}
				
				else if(name.equals("Feedback"))
				{
					Intent intent3 = new Intent(Setting.this,Feedback.class);
					startActivity(intent3);
				}
				else if(name.equals("About App"))
				{
					Intent intent4 = new Intent(Setting.this,About_app.class);
					startActivity(intent4);
				}
				else if(name.equals("Help"))
				{
					Intent intent5 = new Intent(Setting.this,Help.class);
					startActivity(intent5);
				}
			}
	
		});
	}
	public void onClick(View arg0) 
	{
		Intent intent=new Intent(Setting.this,Home_page.class);
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
		return true;
	}

}
