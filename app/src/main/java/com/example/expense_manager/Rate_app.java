package com.example.expense_manager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

public class Rate_app extends Activity {

	
	private TextView txt;
	private RatingBar ratingBar1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rate_app);
		ratingBar1=(RatingBar)findViewById(R.id.ratingBar1);
        txt=(TextView)findViewById(R.id.textView5);
        
        
        ratingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			
			//private Object txt;

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				// TODO Auto-generated method stub
				
				txt.setText("Reting:"+rating+"/"+ratingBar1.getNumStars());
			}
		});
        
    }


	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rate_app, menu);
		return true;
	}

}
