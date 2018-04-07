package com.example.expense_manager;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

import android.animation.TimeAnimator;
import android.animation.TimeAnimator.TimeListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

@SuppressLint("NewApi")
public class Edit_reminder_update extends Activity implements
		DatePickerDialog.OnDateSetListener, TimeListener {
	ImageButton bt1, bt2, bt3;
	Button b1, b2;
	byte[] img;
	int index;
	static EditText date1, time1;
	RadioGroup rg;
	RadioButton rb;
  int radio;
	static ImageView v;

	Database_Helper1 db;

	// define spinner

	Spinner sp1, sp2, sp3, sp4, sp5, sp6;
	String item[] = { "Expense", "Income", "None" };
	String item1[] = { "Entertainment", "Food", "Shopping", "Clothing",
			"Travel", "Medical", "Electronics", "Gift", "Auto", "Groceries",
			"Bill payment", "Miscellaneous" };
	String item2[] = { "Cash", "Check", "Debit Card", "Credit Card" };
	String item3[] = { "Weekly", "Monthly", "None" };
	String item4[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
			"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
			"23", "24", "25", "26", "27", "28", "29", "30", "31" };
	String item5[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
			"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
			"23" };
	ArrayAdapter<String> aa1;
	ArrayAdapter<String> aa2;
	ArrayAdapter<String> aa3;
	ArrayAdapter<String> aa4;
	ArrayAdapter<String> aa5;
	ArrayAdapter<String> aa6;

	String spinner1_value, spinner2_value, spinner3_value, spinner4_value,
			spinner5_value, spinner6_value;

	// define edittext

	EditText datevalue, timereturn, headingvalue, pricevalue, discriptionvalue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_reminder_update);
		// define layout id
		datevalue = (EditText) findViewById(R.id.date1);
		timereturn = (EditText) findViewById(R.id.time);
		headingvalue = (EditText) findViewById(R.id.heading);
		pricevalue = (EditText) findViewById(R.id.Price1);
		discriptionvalue = (EditText) findViewById(R.id.description1);
		// typecasting radiogroup into java
		rg = (RadioGroup) findViewById(R.id.radioGroup1);
		

		// imagebutton id
		bt1 = (ImageButton) findViewById(R.id.imageButton1);
		bt2 = (ImageButton) findViewById(R.id.imageButton2);

		bt3 = (ImageButton) findViewById(R.id.imageButton3);

		date1 = (EditText) findViewById(R.id.date1);
		time1 = (EditText) findViewById(R.id.time);
		v = (ImageView) findViewById(R.id.Camera1);

		b2 = (Button) findViewById(R.id.Update);

		String items[] = new String[50];

		bt3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(
						android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

				startActivityForResult(intent, 0);
			}
		});

		// reset BUTTON
		Button b1 = (Button) findViewById(R.id.Reset);

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) { // TODO Auto-generated method stub
				resetEditFieldValues();
			}
		});

		// spinner
		sp1 = (Spinner) findViewById(R.id.sp1);
		sp2 = (Spinner) findViewById(R.id.sp2);
		sp3 = (Spinner) findViewById(R.id.sp3);
		sp4 = (Spinner) findViewById(R.id.sp4);
		sp5 = (Spinner) findViewById(R.id.sp5);
		sp6 = (Spinner) findViewById(R.id.sp6);

		aa1 = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.textcolorforspinner, item);
		aa2 = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.textcolorforspinner, item1);
		aa3 = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.textcolorforspinner, item2);
		aa4 = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.textcolorforspinner, item3);
		aa5 = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.textcolorforspinner, item4);
		aa6 = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.textcolorforspinner, item5);

		sp1.setAdapter(aa1);
		sp2.setAdapter(aa2);
		sp3.setAdapter(aa3);
		sp4.setAdapter(aa4);
		sp5.setAdapter(aa5);
		sp6.setAdapter(aa6);

		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

				spinner1_value = (String) arg0.getItemAtPosition(arg2);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

				spinner2_value = (String) arg0.getItemAtPosition(arg2);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		sp3.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

				spinner3_value = (String) arg0.getItemAtPosition(arg2);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		sp4.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

				spinner4_value = (String) arg0.getItemAtPosition(arg2);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		sp5.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

				spinner5_value = (String) arg0.getItemAtPosition(arg2);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		sp6.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

				spinner6_value = (String) arg0.getItemAtPosition(arg2);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		bt2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Calendar mcurrentTime = Calendar.getInstance();
				int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
				int minute = mcurrentTime.get(Calendar.MINUTE);
				TimePickerDialog mTimePicker;
				mTimePicker = new TimePickerDialog(Edit_reminder_update.this,
						new TimePickerDialog.OnTimeSetListener() {
							@Override
							public void onTimeSet(TimePicker timePicker,
									int selectedHour, int selectedMinute) {
								time1.setText(selectedHour + " : "
										+ selectedMinute);
							}
						}, hour, minute, true);// Yes 24 hour time
				mTimePicker.setTitle("Select Time");
				mTimePicker.show();
			}
		});

		bt1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar c = Calendar.getInstance();
				int mYear = c.get(Calendar.YEAR);
				int mMonth = c.get(Calendar.MONTH);
				int mDay = c.get(Calendar.DAY_OF_MONTH);
				System.out.println("the selected " + mDay);
				DatePickerDialog dialog = new DatePickerDialog(
						Edit_reminder_update.this, new Edit_reminder_update(),
						mYear, mMonth, mDay);
				dialog.show();
			}

		});

		// update database

		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				index = Edit_reminder.a;
           //radio id
				radio=rg.getCheckedRadioButtonId();
				
				rb=(RadioButton) findViewById(radio);

				String datevalue1 = datevalue.getText().toString();
				String timereturn1 = timereturn.getText().toString();
				String headingvalue1 = headingvalue.getText().toString();
				String pricevalue1 = pricevalue.getText().toString();
				String discriptionvalue1 = discriptionvalue.getText()
						.toString();
				String spinner1_value1 = spinner1_value.toString();
				String spinner2_value1 = spinner2_value.toString();
				String spinner3_value1 = spinner3_value.toString();
				String spinner4_value1 = spinner4_value.toString();
				String spinner5_value1 = spinner5_value.toString();
				String spinner6_value1 = spinner6_value.toString();
				
				
				String radiocheck=rb.getText().toString();
               
				Log.d("a", "is" + index);
				Log.d("a",rb.getText().toString());
				
				Toast.makeText(getApplicationContext(), rb.getText().toString(),Toast.LENGTH_LONG).show();
				db = new Database_Helper1(Edit_reminder_update.this);
				db.open();
				db.Update(index, datevalue1, timereturn1, headingvalue1,
						pricevalue1, discriptionvalue1, spinner1_value1,
						spinner2_value1, spinner3_value1, spinner4_value1,
						spinner5_value1, spinner6_value1,radiocheck,img);
				db.close();

			}
		});

	}

	void resetEditFieldValues() {
		datevalue.setText("");
		timereturn.setText("");
		discriptionvalue.setText("");
		headingvalue.setText("");
		pricevalue.setText("");
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		// TODO Auto-generated method stub
		int mYear = year;
		int mMonth = monthOfYear;
		int mDay = dayOfMonth;
		date1.setText(new StringBuilder()
				// Month is 0 based so add 1
				.append(mMonth + 1).append("/").append(mDay).append("/")
				.append(mYear).append(" "));

	}

	@Override
	public void onTimeUpdate(TimeAnimator animation, long totalTime,
			long deltaTime) {
		// TODO Auto-generated method stub

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.i("check point ", "9");

		super.onActivityResult(requestCode, resultCode, data);
		Bitmap bp = (Bitmap) data.getExtras().get("data");
		v.setImageBitmap(bp);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bp.compress(Bitmap.CompressFormat.PNG, 100, bos);
		img = bos.toByteArray();

	}

}
