package com.example.manager;

import com.example.expense_manager.R;
import com.example.expense_manager.Splash;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Notification.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

public class Reciever extends BroadcastReceiver {

	private NotificationManager nm;

	@SuppressLint("NewApi")
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		
		nm = (NotificationManager) arg0
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification.Builder builder = new Builder(arg0.getApplicationContext());
		builder.setSmallIcon(R.drawable.expensemanager);
		builder.setContentInfo("Expense Reminder : ");
		builder.setContentText("Your Expense Reminder");
		builder.setContentTitle("Expense Reminding");
		builder.setTicker("Expense Notification");
		Intent openIntent = new Intent(arg0.getApplicationContext(),
				Splash.class);
		PendingIntent pi = PendingIntent.getActivity(
				arg0.getApplicationContext(), 0, openIntent, 1);
		builder.setContentIntent(pi);

		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH) {

			Notification notification = builder.build();
			notification.flags = Notification.FLAG_AUTO_CANCEL;

			nm.notify(0, notification);

		} else {

			Notification notification = builder.getNotification();
			notification.flags = Notification.FLAG_AUTO_CANCEL;

			nm.notify(0, notification);
		}

	}

}
