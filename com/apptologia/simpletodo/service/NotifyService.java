package com.apptologia.simpletodo.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.apptologia.simpletodo.C0054R;
import com.apptologia.simpletodo.MainActivity;

public class NotifyService extends Service {
    public static final String INTENT_NOTIFY = "com.emin.ayar.service.INTENT_NOTIFY";
    private static final int NOTIFICATION = 123;
    private final IBinder mBinder;
    private NotificationManager mNM;

    public class ServiceBinder extends Binder {
        NotifyService getService() {
            return NotifyService.this;
        }
    }

    public NotifyService() {
        this.mBinder = new ServiceBinder();
    }

    public void onCreate() {
        Log.i("NotifyService", "onCreate()");
        this.mNM = (NotificationManager) getSystemService("notification");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);
        if (intent.getBooleanExtra(INTENT_NOTIFY, false)) {
            showNotification(intent.getStringExtra("medicinename"), intent.getIntExtra("id", -1));
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    private void showNotification(String name, int id) {
        CharSequence title = "Reminder!!";
        CharSequence text = "Hey don't forget this !! : " + name;
        Notification notification = new Notification(C0054R.drawable.ic_launcher, text, System.currentTimeMillis());
        Uri alarmSound = RingtoneManager.getDefaultUri(4);
        if (alarmSound == null) {
            alarmSound = RingtoneManager.getDefaultUri(1);
            if (alarmSound == null) {
                alarmSound = RingtoneManager.getDefaultUri(2);
            }
        }
        notification.sound = alarmSound;
        notification.defaults |= 2;
        notification.flags |= 16;
        notification.setLatestEventInfo(this, title, text, PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0));
        notification.flags |= 16;
        this.mNM.notify(id, notification);
        stopSelf();
    }
}
