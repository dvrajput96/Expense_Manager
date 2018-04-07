package com.example.expense_manager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;


public class Add_Expense extends Activity {
	
	Context ctx = this;
	public String addexpense,addcategory,adddescription;
	private Button button1;
	private ImageButton camera;
	private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;
	private static final String IMAGE_DIRECTORY_NAME = "Hello Camera";
	private Uri fileUri;
	private ImageView imgPreview;
	private EditText expense1;
	private Spinner category1;
	private EditText description1;
	private Button save1;
	ArrayList<String> arrayList=new ArrayList<String>();
	
@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add__expense);
		button1=(Button)findViewById(R.id.button1);
		camera=(ImageButton)findViewById(R.id.imageButton1);
		imgPreview=(ImageView)findViewById(R.id.imageView1);
		expense1=(EditText)findViewById(R.id.editText1);
		category1=(Spinner)findViewById(R.id.spinner1);
		description1=(EditText)findViewById(R.id.editText2);
		save1=(Button)findViewById(R.id.button2);
		
		Database_Handler db = new Database_Handler(Add_Expense.this);
		arrayList= db.fetchexpense();
		
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(Add_Expense.this, android.R.layout.simple_list_item_1, arrayList);
		category1.setAdapter(adapter);
		
		camera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				captureImage();
			}
		});
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Add_Expense.this,Add_expense_category.class);
				startActivity(intent);
				
				Add_Expense.this.finish();
			}
		});
		save1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				addexpense=expense1.getText().toString();
				addcategory=category1.getSelectedItem().toString();
				adddescription=description1.getText().toString();
				
				Database_Handler db = new Database_Handler(ctx);
				db.putInfromationAddExpense(db,addexpense,addcategory,adddescription);
				Toast.makeText(getApplicationContext(), "Expense Added Successfully.....", Toast.LENGTH_SHORT).show();
				
				expense1.setText("");
				
				description1.setText("");

			}
		});
	}

protected void onSaveInstanceState(Bundle outState) {
	super.onSaveInstanceState(outState);

	// save file url in bundle as it will be null on scren orientation
	// changes
	outState.putParcelable("file_uri", fileUri);
}

@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
	super.onRestoreInstanceState(savedInstanceState);

	// get the file url
	fileUri = savedInstanceState.getParcelable("file_uri");
}

/**
 * Receiving activity result method will be called after closing the camera
 * */
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// if the result is capturing Image
	if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
		if (resultCode == RESULT_OK) {
			// successfully captured the image
			// display it in image view
			previewCapturedImage();
		} else if (resultCode == RESULT_CANCELED) {
			// user cancelled Image capture
			Toast.makeText(getApplicationContext(),"User cancelled image capture", Toast.LENGTH_SHORT).show();
		} else {
			// failed to capture image
			Toast.makeText(getApplicationContext(),"Sorry! Failed to capture image", Toast.LENGTH_SHORT).show();
		}
	} 
}

/*
 * Display image from a path to ImageView
 */
private void previewCapturedImage() {
	try {
		imgPreview.setVisibility(View.VISIBLE);

		// bimatp factory
		BitmapFactory.Options options = new BitmapFactory.Options();

		// downsizing image as it throws OutOfMemory Exception for larger
		// images
		options.inSampleSize = 8;

		final Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(),
				options);

		imgPreview.setImageBitmap(bitmap);
	} catch (NullPointerException e) {
		e.printStackTrace();
	}
}


/**
 * ------------ Helper Methods ---------------------- 
 * */

/*
 * Creating file uri to store image/video
 */
public Uri getOutputMediaFileUri(int type) {
	return Uri.fromFile(getOutputMediaFile(type));
}

/*
 * returning image / video
 */
private static File getOutputMediaFile(int type) {

	// External sdcard location
	File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),	IMAGE_DIRECTORY_NAME);

	// Create the storage directory if it does not exist
	if (!mediaStorageDir.exists()) {
		if (!mediaStorageDir.mkdirs()) {
			Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create " + IMAGE_DIRECTORY_NAME + " directory");
			return null;
		}
	}

	// Create a media file name
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
			Locale.getDefault()).format(new Date());
	File mediaFile;
	if (type == MEDIA_TYPE_IMAGE) {
		mediaFile = new File(mediaStorageDir.getPath() + File.separator	+ "IMG_" + timeStamp + ".jpg");
	} else if (type == MEDIA_TYPE_VIDEO) {
		mediaFile = new File(mediaStorageDir.getPath() + File.separator	+ "VID_" + timeStamp + ".mp4");
	} else {
		return null;
	}

	return mediaFile;
}


/**
 * Checking device has camera hardware or not
 * */
private boolean isDeviceSupportCamera() {
	if (getApplicationContext().getPackageManager().hasSystemFeature(
			PackageManager.FEATURE_CAMERA)) {
		// this device has a camera
		return true;
	} else {
		// no camera on this device
		return false;
	}
}
	
private void captureImage() 
{
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

		intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

		// start the image capture Intent
		startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add__expense, menu);
		return true;
	}

}
