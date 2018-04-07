package com.example.expense_manager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		Thread timer = new Thread() {
			public void run() {

				try {
					sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();

				} finally {
					
					Intent openMainActivity = new Intent(
							getApplicationContext(), Swipe_overview.class);
					startActivity(openMainActivity);
					finish();
				}
			}
		};
		timer.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}
}
