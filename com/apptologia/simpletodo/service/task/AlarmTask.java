package com.apptologia.simpletodo.service.task;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.apptologia.simpletodo.service.NotifyService;
import java.util.Calendar;

public class AlarmTask implements Runnable {
    private final AlarmManager am;
    private final Context context;
    private final Calendar date;
    private final int id;
    private String medicineName;

    public AlarmTask(Context context, Calendar date, String name, int id) {
        this.context = context;
        this.am = (AlarmManager) context.getSystemService("alarm");
        this.date = date;
        this.medicineName = name;
        this.id = id;
    }

    public void run() {
        Intent intent = new Intent(this.context, NotifyService.class);
        intent.putExtra(NotifyService.INTENT_NOTIFY, true);
        intent.putExtra("id", this.id);
        intent.putExtra("medicinename", this.medicineName);
        this.am.set(1, this.date.getTimeInMillis(), PendingIntent.getService(this.context, this.id, intent, 0));
    }
}
