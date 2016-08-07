package com.apptologia.simpletodo.utils;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.apptologia.simpletodo.C0054R;
import com.apptologia.simpletodo.ItemsActivity;
import com.apptologia.simpletodo.MainActivity;
import com.apptologia.simpletodo.database.Database;
import com.apptologia.simpletodo.service.ScheduleClient;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import java.util.Calendar;
import java.util.Locale;

public class UiUtils {
    private static String date;
    private static int mDay;
    private static int mHour;
    private static int mMinute;
    private static int mMonth;
    private static int mYear;
    private static String starttime;
    private static Typeface typeFace;

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.10 */
    class AnonymousClass10 implements OnClickListener {
        private final /* synthetic */ Dialog val$dialog;

        AnonymousClass10(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.11 */
    class AnonymousClass11 implements OnClickListener {
        private final /* synthetic */ Context val$ctx;
        private final /* synthetic */ TextView val$time_tv;

        /* renamed from: com.apptologia.simpletodo.utils.UiUtils.11.1 */
        class C00601 implements OnTimeSetListener {
            private final /* synthetic */ TextView val$time_tv;

            C00601(TextView textView) {
                this.val$time_tv = textView;
            }

            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar calNow = Calendar.getInstance();
                Calendar calSet = (Calendar) calNow.clone();
                calSet.set(11, hourOfDay);
                calSet.set(12, minute);
                calSet.set(13, 0);
                calSet.set(14, 0);
                if (calSet.compareTo(calNow) <= 0) {
                    calSet.add(5, 1);
                }
                if (calSet.getTime().getMinutes() < 10) {
                    this.val$time_tv.setText(new StringBuilder(String.valueOf(String.valueOf(calSet.getTime().getHours()))).append(":0").append(String.valueOf(calSet.getTime().getMinutes())).toString());
                    UiUtils.starttime = new StringBuilder(String.valueOf(String.valueOf(calSet.getTime().getHours()))).append(":0").append(String.valueOf(calSet.getTime().getMinutes())).toString();
                    return;
                }
                this.val$time_tv.setText(new StringBuilder(String.valueOf(String.valueOf(calSet.getTime().getHours()))).append(":").append(String.valueOf(calSet.getTime().getMinutes())).toString());
                UiUtils.starttime = new StringBuilder(String.valueOf(String.valueOf(calSet.getTime().getHours()))).append(":").append(String.valueOf(calSet.getTime().getMinutes())).toString();
            }
        }

        AnonymousClass11(Context context, TextView textView) {
            this.val$ctx = context;
            this.val$time_tv = textView;
        }

        public void onClick(View v) {
            new TimePickerDialog(this.val$ctx, new C00601(this.val$time_tv), UiUtils.mHour, UiUtils.mMinute, true).show();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.12 */
    class AnonymousClass12 implements OnClickListener {
        private final /* synthetic */ Context val$ctx;
        private final /* synthetic */ TextView val$date_tv;

        /* renamed from: com.apptologia.simpletodo.utils.UiUtils.12.1 */
        class C00611 implements OnDateSetListener {
            private final /* synthetic */ Calendar val$c;
            private final /* synthetic */ TextView val$date_tv;

            C00611(Calendar calendar, TextView textView) {
                this.val$c = calendar;
                this.val$date_tv = textView;
            }

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String month = this.val$c.getDisplayName(monthOfYear, 2, Locale.getDefault());
                UiUtils.date = String.valueOf(dayOfMonth) + ":" + String.valueOf(monthOfYear) + ":" + String.valueOf(year);
                this.val$date_tv.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear + 1) + "-" + String.valueOf(year));
            }
        }

        AnonymousClass12(Context context, TextView textView) {
            this.val$ctx = context;
            this.val$date_tv = textView;
        }

        public void onClick(View v) {
            Calendar c = Calendar.getInstance();
            UiUtils.mYear = c.get(1);
            UiUtils.mMonth = c.get(2);
            UiUtils.mDay = c.get(5);
            new DatePickerDialog(this.val$ctx, new C00611(c, this.val$date_tv), UiUtils.mYear, UiUtils.mMonth, UiUtils.mDay).show();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.13 */
    class AnonymousClass13 implements OnClickListener {
        private final /* synthetic */ int val$alarmsituation;
        private final /* synthetic */ Context val$ctx;
        private final /* synthetic */ Database val$db;
        private final /* synthetic */ Dialog val$dialog;
        private final /* synthetic */ int val$id;
        private final /* synthetic */ String val$name;
        private final /* synthetic */ ScheduleClient val$scheduleClient;

        AnonymousClass13(Context context, ScheduleClient scheduleClient, String str, int i, Database database, int i2, Dialog dialog) {
            this.val$ctx = context;
            this.val$scheduleClient = scheduleClient;
            this.val$name = str;
            this.val$id = i;
            this.val$db = database;
            this.val$alarmsituation = i2;
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            if (UiUtils.date.equals("") || UiUtils.starttime.equals("")) {
                Toast.makeText(this.val$ctx, "Please select time and date", 0).show();
            } else {
                Calendar calendar = Calendar.getInstance();
                String[] parts = UiUtils.starttime.split(":");
                String[] parts2 = UiUtils.date.split(":");
                String hour = parts[0];
                String minute = parts[1];
                String day = parts2[0];
                String month = parts2[1];
                String year = parts2[2];
                calendar.set(11, Integer.valueOf(hour).intValue());
                calendar.set(12, Integer.valueOf(minute).intValue());
                calendar.set(13, 0);
                calendar.set(2, Integer.valueOf(month).intValue());
                calendar.set(1, Integer.valueOf(year).intValue());
                calendar.set(5, Integer.valueOf(day).intValue());
                this.val$scheduleClient.setAlarmForNotification(calendar, this.val$name, this.val$id);
            }
            this.val$db.updateAlarm(Integer.valueOf(this.val$alarmsituation), this.val$id);
            ((ItemsActivity) this.val$ctx).listChanged();
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.14 */
    class AnonymousClass14 implements OnClickListener {
        private final /* synthetic */ Dialog val$dialog;

        AnonymousClass14(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.1 */
    class C00621 implements OnClickListener {
        private final /* synthetic */ Context val$ctx;
        private final /* synthetic */ Database val$db;
        private final /* synthetic */ EditText val$detail_et;
        private final /* synthetic */ Dialog val$dialog;
        private final /* synthetic */ EditText val$title_et;

        C00621(EditText editText, EditText editText2, Database database, Context context, Dialog dialog) {
            this.val$title_et = editText;
            this.val$detail_et = editText2;
            this.val$db = database;
            this.val$ctx = context;
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            if (this.val$title_et.getText().toString().equals("") || this.val$detail_et.getText().toString().equals("")) {
                Toast.makeText(this.val$ctx, "You must fill all areas", 0).show();
                return;
            }
            this.val$db.addToDoList(this.val$title_et.getText().toString(), this.val$detail_et.getText().toString());
            ((MainActivity) this.val$ctx).listChanged();
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.2 */
    class C00632 implements OnClickListener {
        private final /* synthetic */ Dialog val$dialog;

        C00632(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.3 */
    class C00643 implements OnClickListener {
        private final /* synthetic */ Context val$ctx;
        private final /* synthetic */ Database val$db;
        private final /* synthetic */ Dialog val$dialog;
        private final /* synthetic */ int val$id;

        C00643(Database database, int i, Context context, Dialog dialog) {
            this.val$db = database;
            this.val$id = i;
            this.val$ctx = context;
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            this.val$db.deleteToDoList(this.val$id);
            ((MainActivity) this.val$ctx).listChanged();
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.4 */
    class C00654 implements OnClickListener {
        private final /* synthetic */ Dialog val$dialog;

        C00654(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.5 */
    class C00665 implements OnClickListener {
        private final /* synthetic */ Context val$ctx;
        private final /* synthetic */ Dialog val$dialog;
        private final /* synthetic */ int val$max;
        private final /* synthetic */ int val$which;

        C00665(int i, Context context, int i2, Dialog dialog) {
            this.val$which = i;
            this.val$ctx = context;
            this.val$max = i2;
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            switch (this.val$which) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    Utils.savePrefs(this.val$ctx, "rateme_counter", String.valueOf(this.val$max + 1));
                    break;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    Utils.savePrefs(this.val$ctx, "rateme_counter", String.valueOf(this.val$max + 1));
                    break;
            }
            ((MainActivity) this.val$ctx).rateMe();
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.6 */
    class C00676 implements OnClickListener {
        private final /* synthetic */ Dialog val$dialog;

        C00676(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.7 */
    class C00687 implements OnClickListener {
        private final /* synthetic */ Context val$ctx;
        private final /* synthetic */ Database val$db;
        private final /* synthetic */ Dialog val$dialog;
        private final /* synthetic */ EditText val$title_et;

        C00687(EditText editText, Database database, Context context, Dialog dialog) {
            this.val$title_et = editText;
            this.val$db = database;
            this.val$ctx = context;
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            if (this.val$title_et.getText().toString().equals("")) {
                Toast.makeText(this.val$ctx, "You must fill all areas", 0).show();
                return;
            }
            this.val$db.addItem(this.val$title_et.getText().toString(), Integer.valueOf(Utils.getPrefValue(this.val$ctx, "listid", "-1")).intValue(), this.val$ctx);
            ((ItemsActivity) this.val$ctx).listChanged();
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.8 */
    class C00698 implements OnClickListener {
        private final /* synthetic */ Dialog val$dialog;

        C00698(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.apptologia.simpletodo.utils.UiUtils.9 */
    class C00709 implements OnClickListener {
        private final /* synthetic */ Context val$ctx;
        private final /* synthetic */ Database val$db;
        private final /* synthetic */ Dialog val$dialog;
        private final /* synthetic */ int val$id;

        C00709(Database database, int i, Context context, Dialog dialog) {
            this.val$db = database;
            this.val$id = i;
            this.val$ctx = context;
            this.val$dialog = dialog;
        }

        public void onClick(View v) {
            this.val$db.deleteToDos(this.val$id);
            ((ItemsActivity) this.val$ctx).listChanged();
            this.val$dialog.cancel();
        }
    }

    public static Dialog addTodoListDialog(Context ctx, Database db) {
        Dialog dialog = new Dialog(ctx);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0054R.layout.customdialog);
        typeFace = Typeface.createFromAsset(ctx.getAssets(), "fonts/yourcustomfont.otf");
        TextView textView = (TextView) dialog.findViewById(C0054R.id.textView);
        EditText title_et = (EditText) dialog.findViewById(C0054R.id.titleEdittext);
        EditText detail_et = (EditText) dialog.findViewById(C0054R.id.detailEdittext);
        Button save_btn = (Button) dialog.findViewById(C0054R.id.btnsave);
        Button cancel_btn = (Button) dialog.findViewById(C0054R.id.btncancel);
        save_btn.setTypeface(typeFace);
        cancel_btn.setTypeface(typeFace);
        textView.setTypeface(typeFace);
        save_btn.setOnClickListener(new C00621(title_et, detail_et, db, ctx, dialog));
        cancel_btn.setOnClickListener(new C00632(dialog));
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog removeToDoListDialog(Context ctx, Database db, int id) {
        Dialog dialog = new Dialog(ctx);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0054R.layout.customdialog_remove_list);
        typeFace = Typeface.createFromAsset(ctx.getAssets(), "fonts/yourcustomfont.otf");
        TextView textView = (TextView) dialog.findViewById(C0054R.id.textView);
        Button save_btn = (Button) dialog.findViewById(C0054R.id.btnsave);
        Button cancel_btn = (Button) dialog.findViewById(C0054R.id.btncancel);
        save_btn.setTypeface(typeFace);
        cancel_btn.setTypeface(typeFace);
        textView.setTypeface(typeFace);
        save_btn.setOnClickListener(new C00643(db, id, ctx, dialog));
        cancel_btn.setOnClickListener(new C00654(dialog));
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog ratemeDialog(Context ctx, int which, int max) {
        Dialog dialog = new Dialog(ctx);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0054R.layout.customdialog_rateme);
        typeFace = Typeface.createFromAsset(ctx.getAssets(), "fonts/yourcustomfont.otf");
        TextView textView = (TextView) dialog.findViewById(C0054R.id.textView);
        Button save_btn = (Button) dialog.findViewById(C0054R.id.btnsave);
        Button cancel_btn = (Button) dialog.findViewById(C0054R.id.btncancel);
        save_btn.setTypeface(typeFace);
        cancel_btn.setTypeface(typeFace);
        textView.setTypeface(typeFace);
        save_btn.setOnClickListener(new C00665(which, ctx, max, dialog));
        cancel_btn.setOnClickListener(new C00676(dialog));
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog addItemDialog(Context ctx, Database db) {
        Dialog dialog = new Dialog(ctx);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0054R.layout.customdialog_additem);
        typeFace = Typeface.createFromAsset(ctx.getAssets(), "fonts/yourcustomfont.otf");
        TextView textView = (TextView) dialog.findViewById(C0054R.id.textView);
        EditText title_et = (EditText) dialog.findViewById(C0054R.id.titleEdittext);
        Button save_btn = (Button) dialog.findViewById(C0054R.id.btnsave);
        Button cancel_btn = (Button) dialog.findViewById(C0054R.id.btncancel);
        save_btn.setTypeface(typeFace);
        cancel_btn.setTypeface(typeFace);
        textView.setTypeface(typeFace);
        save_btn.setOnClickListener(new C00687(title_et, db, ctx, dialog));
        cancel_btn.setOnClickListener(new C00698(dialog));
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog removeToDoDialog(Context ctx, Database db, int id) {
        Dialog dialog = new Dialog(ctx);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0054R.layout.customdialog_remove_list);
        typeFace = Typeface.createFromAsset(ctx.getAssets(), "fonts/yourcustomfont.otf");
        TextView textView = (TextView) dialog.findViewById(C0054R.id.textView);
        Button save_btn = (Button) dialog.findViewById(C0054R.id.btnsave);
        Button cancel_btn = (Button) dialog.findViewById(C0054R.id.btncancel);
        save_btn.setTypeface(typeFace);
        cancel_btn.setTypeface(typeFace);
        textView.setTypeface(typeFace);
        save_btn.setOnClickListener(new C00709(db, id, ctx, dialog));
        cancel_btn.setOnClickListener(new AnonymousClass10(dialog));
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog timedatepickerDialog(Context ctx, Database db, int id, ScheduleClient scheduleClient, String name, int alarmsituation) {
        Dialog dialog = new Dialog(ctx);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0054R.layout.customdialog_timedatepicker);
        typeFace = Typeface.createFromAsset(ctx.getAssets(), "fonts/yourcustomfont.otf");
        TextView textView = (TextView) dialog.findViewById(C0054R.id.textView);
        TextView time_tv = (TextView) dialog.findViewById(C0054R.id.time_tv);
        TextView date_tv = (TextView) dialog.findViewById(C0054R.id.date_tv);
        Button save_btn = (Button) dialog.findViewById(C0054R.id.btnsave);
        Button cancel_btn = (Button) dialog.findViewById(C0054R.id.btncancel);
        save_btn.setTypeface(typeFace);
        cancel_btn.setTypeface(typeFace);
        textView.setTypeface(typeFace);
        time_tv.setClickable(true);
        date_tv.setClickable(true);
        time_tv.setOnClickListener(new AnonymousClass11(ctx, time_tv));
        date_tv.setOnClickListener(new AnonymousClass12(ctx, date_tv));
        save_btn.setOnClickListener(new AnonymousClass13(ctx, scheduleClient, name, id, db, alarmsituation, dialog));
        cancel_btn.setOnClickListener(new AnonymousClass14(dialog));
        dialog.setCancelable(false);
        return dialog;
    }
}
