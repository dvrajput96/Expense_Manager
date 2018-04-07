package com.example.expense_manager;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.example.expense_manager.R.string;

import android.animation.TimeAnimator;
import android.animation.TimeAnimator.TimeListener;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;
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
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Add_Reminder extends Activity implements
		DatePickerDialog.OnDateSetListener, TimeListener {
	ImageButton bt1, bt2, bt3;
	Button b1, b2;
	byte[] img;
	static EditText date1, time1;
	RadioGroup rg;

	static ImageView v;

	Database_Helper1 db;

	int hour, minute, mYear, mMonth, mDay;
	int hh, mm;

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
		setContentView(R.layout.activity_add__reminder);
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

		b2 = (Button) findViewById(R.id.Save);

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

			public void onNothingSeleVibratorcted(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

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
				hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);

				minute = mcurrentTime.get(Calendar.MINUTE);

				TimePickerDialog mTimePicker;
				mTimePicker = new TimePickerDialog(Add_Reminder.this,
						new TimePickerDialog.OnTimeSetListener() {
							@Override
							public void onTimeSet(TimePicker timePicker,
									int selectedHour, int selectedMinute) {
								hh = selectedHour;
								mm = selectedMinute;

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
				mYear = c.get(Calendar.YEAR);
				Log.w("Year", String.valueOf(mYear));
				mMonth = c.get(Calendar.MONTH);
				mDay = c.get(Calendar.DAY_OF_MONTH);
				System.out.println("the selected " + mDay);
				DatePickerDialog dialog = new DatePickerDialog(
						Add_Reminder.this, new Add_Reminder(), mYear, mMonth,
						mDay);
				dialog.show();
			}

		});

		// save button
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Log.d("query is", Database_Helper1.DATABASE_CREATE_Add_reminder);
				int i = rg.getCheckedRadioButtonId();
				RadioButton rb = (RadioButton) findViewById(i);
				String valueofradiobutton = rb.getText().toString();
				String pricevalue1 = pricevalue.getText().toString();
				String datevalue1 = datevalue.getText().toString();
				Log.d("value of datevalue", datevalue1);
				Log.d("Checkpoint", "1");
				String timevalue1 = timereturn.getText().toString();
				Log.d("Checkpoint", "2");
				String headingvalue1 = headingvalue.getText().toString();
				Log.d("Checkpoint", "3");

				Log.d("Checkpoint", "4");
				String descriptionvalue1 = discriptionvalue.getText()
						.toString();
				Log.d("Checkpoint", "5");

				Database_Helper1 dc = new Database_Helper1(Add_Reminder.this);
				Log.d("Checkpoint", "6");
				dc.open();
				Log.d("Checkpoint", "7");
				String recurring;
				Log.d("Checkpoint", "8");
				dc.insertAdd_reminder(datevalue1, timevalue1, headingvalue1,
						pricevalue1, descriptionvalue1, spinner1_value,
						spinner2_value, spinner3_value, spinner4_value,
						spinner5_value, spinner5_value, valueofradiobutton, img); //
				Log.d("Checkpoint", "9");
				int id = dc.getReminderId();
				dc.close();

				Toast.makeText(getApplicationContext(),
						"successfully add reminder", Toast.LENGTH_SHORT).show();

				Intent in = new Intent("com.vishal.expence");
				PendingIntent operation = PendingIntent.getBroadcast(
						getBaseContext(), id, in, 1);
				AlarmManager alarmManager = (AlarmManager) getBaseContext()
						.getSystemService(ALARM_SERVICE);
				// Log.w("Timeeeeee",String.valueOf(mYear)+String.valueOf(mMonth));
				GregorianCalendar calendar = new GregorianCalendar(mYear,
						mMonth, mDay, hh, mm);

				long alarm_time = calendar.getTimeInMillis();
				/** Setting an alarm, which invokes the operation at alart_time */
				alarmManager
						.set(AlarmManager.RTC_WAKEUP, alarm_time, operation);

				/** Alert is set successfully */
				Toast.makeText(getBaseContext(), "Alarm is set successfully " + calendar.getTime().toString(),
						Toast.LENGTH_SHORT).show();
				resetEditFieldValues();
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
