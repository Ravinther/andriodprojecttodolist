package com.apptologia.simpletodo.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.apptologia.simpletodo.service.ScheduleService.ServiceBinder;
import java.util.Calendar;

public class ScheduleClient {
    private ScheduleService mBoundService;
    private ServiceConnection mConnection;
    private Context mContext;
    private boolean mIsBound;

    /* renamed from: com.apptologia.simpletodo.service.ScheduleClient.1 */
    class C00591 implements ServiceConnection {
        C00591() {
        }

        public void onServiceConnected(ComponentName className, IBinder service) {
            ScheduleClient.this.mBoundService = ((ServiceBinder) service).getService();
        }

        public void onServiceDisconnected(ComponentName className) {
            ScheduleClient.this.mBoundService = null;
        }
    }

    public ScheduleClient(Context context) {
        this.mConnection = new C00591();
        this.mContext = context;
    }

    public void doBindService() {
        this.mContext.bindService(new Intent(this.mContext, ScheduleService.class), this.mConnection, 1);
        this.mIsBound = true;
    }

    public void setAlarmForNotification(Calendar c, String name, int id) {
        Log.d("asdasd", String.valueOf(name));
        this.mBoundService.setAlarm(c, name, id);
    }

    public void doUnbindService() {
        if (this.mIsBound) {
            this.mContext.unbindService(this.mConnection);
            this.mIsBound = false;
        }
    }
}
