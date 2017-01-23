package com.programmingtalents.android.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button simple_notification_btn, big_txt_notification_btn, big_picture_notification_btn, action_notificaion_btn, heads_up_notification_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        simple_notification_btn= (Button)findViewById(R.id.simple_notification);
        big_txt_notification_btn= (Button)findViewById(R.id.big_txt_notification);
        big_picture_notification_btn= (Button)findViewById(R.id.big_picture_notification);
        action_notificaion_btn= (Button)findViewById(R.id.action_btn_notification);
        heads_up_notification_btn= (Button)findViewById(R.id.headsup_notification);
        simple_notification_btn.setOnClickListener(this);
        big_txt_notification_btn.setOnClickListener(this);
        big_picture_notification_btn.setOnClickListener(this);
        action_notificaion_btn.setOnClickListener(this);
        heads_up_notification_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.simple_notification:
                NotificationCompat.Builder mBuilder1 = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher).setContentTitle("This is title")
                        .setContentText("This is message body.");
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(1, mBuilder1.build());
                break;
            case R.id.big_txt_notification:
                Bitmap icon1 = BitmapFactory.decodeResource(getResources(),
                        R.mipmap.ic_launcher);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                        this).setAutoCancel(true)
                        .setContentTitle("Big Text Style")
                        .setSmallIcon(R.mipmap.ic_launcher).setLargeIcon(icon1)
                        .setContentText("Hello World!");

                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
                bigText.bigText("Android is a Linux-based operating system designed primarily for touchscreen mobile devices such as smartphones and tablet computers. Initially developed by Android, Inc., which Google backed financially and later bought in 2005,[12] Android was unveiled in 2007 along with the founding of the Open Handset Alliance: a consortium of hardware, software, and telecommunication companies devoted to advancing open standards for mobile devices.[13] The first Android-powered phone was sold in October 2008");
                bigText.setBigContentTitle("Android");
                bigText.setSummaryText("By: Amit");
                mBuilder.setStyle(bigText);

                // Creates an explicit intent for an Activity in your app
                Intent resultIntent = new Intent(this, NextClass.class);

                // The stack builder object will contain an artificial back stack for
                // the
                // started Activity.
                // This ensures that navigating backward from the Activity leads out of
                // your application to the Home screen.
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

                // Adds the back stack for the Intent (but not the Intent itself)
                stackBuilder.addParentStack(MainActivity.class);

                // Adds the Intent that starts the Activity to the top of the stack
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(resultPendingIntent);

                NotificationManager mNotificationManager1 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                // mId allows you to update the notification later on.
                mNotificationManager1.notify(100, mBuilder.build());

                break;
            case R.id.big_picture_notification:
                Bitmap icon = BitmapFactory.decodeResource(getResources(),
                        R.mipmap.ic_launcher);

                NotificationCompat.Builder mBuilder2 = new NotificationCompat.Builder(
                        this).setAutoCancel(true)
                        .setContentTitle("Big Picture Style notification")
                        .setSmallIcon(R.mipmap.ic_launcher).setLargeIcon(icon)
                        .setContentText("Hello World!");

                NotificationCompat.BigPictureStyle bigPicStyle = new NotificationCompat.BigPictureStyle();
                bigPicStyle.bigPicture(icon);
                bigPicStyle.setBigContentTitle("Amit Saxena");
                mBuilder2.setStyle(bigPicStyle);

                // Creates an explicit intent for an Activity in your app
                Intent resultIntent1 = new Intent(this, NextClass.class);

                // The stack builder object will contain an artificial back stack for
                // the
                // started Activity.
                // This ensures that navigating backward from the Activity leads out of
                // your application to the Home screen.
                TaskStackBuilder stackBuilder1 = TaskStackBuilder.create(this);

                // Adds the back stack for the Intent (but not the Intent itself)
                stackBuilder1.addParentStack(NextClass.class);

                // Adds the Intent that starts the Activity to the top of the stack
                stackBuilder1.addNextIntent(resultIntent1);
                PendingIntent resultPendingIntent1 = stackBuilder1.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder2.setContentIntent(resultPendingIntent1);

                NotificationManager mNotificationManager2 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                // mId allows you to update the notification later on.
                mNotificationManager2.notify(100, mBuilder2.build());

                break;
            case R.id.action_btn_notification:
                Intent dismissIntent1 = new Intent(this, NextClass.class);
                dismissIntent1.setAction("ACTION_DISMISS");
                PendingIntent nDismiss = PendingIntent.getService(this, 0, dismissIntent1, 0);
                NotificationCompat.Builder builder3 =
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Ping Notification")
                                .setContentText("Tomorrow will be your birthday.")
                                .setDefaults(Notification.DEFAULT_ALL) // must requires VIBRATE permission
                                .addAction(R.drawable.cancel,
                                        getString(R.string.dismiss), nDismiss);
               NotificationManager notificationManager2 =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager2.notify(0, builder3.build());
                break;
            case R.id.headsup_notification:
                //build notification
                Intent dismissIntent = new Intent(this, NextClass.class);
                dismissIntent.setAction("ACTION_DISMISS");
                PendingIntent piDismiss = PendingIntent.getService(this, 0, dismissIntent, 0);
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Ping Notification")
                                .setContentText("Tomorrow will be your birthday.")
                                .setDefaults(Notification.DEFAULT_ALL) // must requires VIBRATE permission
                                .setPriority(NotificationCompat.PRIORITY_HIGH)
                                .addAction(R.drawable.cancel,
                                        getString(R.string.dismiss), piDismiss);

                //must give priority to High, Max which will considered as heads-up notification

//set intents and pending intents to call service on click of "dismiss" action button of notification


//set intents and pending intents to call service on click of "snooze" action button of notification

// Gets an instance of the NotificationManager service
                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//to post your notification to the notification bar with a id. If a notification with same id already exists, it will get replaced with updated information.
                notificationManager.notify(0, builder.build());
                break;
        }
    }
}
