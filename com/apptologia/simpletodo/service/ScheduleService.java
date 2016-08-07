package com.apptologia.simpletodo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.apptologia.simpletodo.service.task.AlarmTask;
import java.util.Calendar;

public class ScheduleService extends Service {
    private final IBinder mBinder;

    public class ServiceBinder extends Binder {
        ScheduleService getService() {
            return ScheduleService.this;
        }
    }

    public ScheduleService() {
        this.mBinder = new ServiceBinder();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("ScheduleService", "Received start id " + startId + ": " + intent);
        return 1;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void setAlarm(Calendar c, String name, int id) {
        new AlarmTask(this, c, name, id).run();
    }
}
