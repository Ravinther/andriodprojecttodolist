package com.apptologia.simpletodo;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.apptologia.simpletodo.adapters.ItemsAdapter;
import com.apptologia.simpletodo.database.Database;
import com.apptologia.simpletodo.pojos.Items;
import com.apptologia.simpletodo.service.ScheduleClient;
import com.apptologia.simpletodo.utils.UiUtils;
import com.apptologia.simpletodo.utils.Utils;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.DragSortListView.DropListener;
import java.util.ArrayList;

public class ItemsActivity extends Activity implements DropListener {
    private AdView adView;
    private ItemsAdapter adapter;
    private Button addList_btn;
    private TextView addList_tv;
    private Context ctx;
    private Database db;
    private boolean deleteMode;
    private InterstitialAd interstitial;
    private DragSortListView listView;
    private LinearLayout listemptyView;
    private TextView noList_tv;
    private ScheduleClient scheduleClient;
    TimePickerDialog timePickerDialog;
    private TextView title_tv;
    private Typeface typeFace;

    /* renamed from: com.apptologia.simpletodo.ItemsActivity.1 */
    class C04831 extends AdListener {
        C04831() {
        }

        public void onAdLoaded() {
            if (ItemsActivity.this.interstitial.isLoaded()) {
                ItemsActivity.this.interstitial.show();
                Log.d("interstital", "shown");
            }
        }
    }

    public ItemsActivity() {
        this.ctx = this;
        this.deleteMode = false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().addFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        setContentView(C0054R.layout.items);
        this.adView = (AdView) findViewById(C0054R.id.adView);
        AdRequest adRequest = new Builder().build();
        this.adView.loadAd(adRequest);
        if (Utils.adCounter(this.ctx, "banner", 10)) {
            this.adView.loadAd(adRequest);
        } else {
            this.adView.setVisibility(8);
        }
        this.interstitial = new InterstitialAd(this);
        this.interstitial.setAdUnitId(getString(C0054R.string.admob_interstital_id));
        AdRequest adRequest1 = new Builder().build();
        if (Utils.adManagement(this.ctx, "interstitial", 5)) {
            this.interstitial.loadAd(adRequest1);
            this.interstitial.setAdListener(new C04831());
        }
        this.scheduleClient = new ScheduleClient(getApplicationContext());
        this.scheduleClient.doBindService();
        this.typeFace = Typeface.createFromAsset(getAssets(), "fonts/yourcustomfont.otf");
        this.listView = (DragSortListView) findViewById(C0054R.id.listView);
        this.listemptyView = (LinearLayout) findViewById(C0054R.id.listemptyview);
        this.listView.setDropListener(this);
        this.noList_tv = (TextView) findViewById(C0054R.id.nolist_tv);
        this.addList_tv = (TextView) findViewById(C0054R.id.addlist_tv);
        this.title_tv = (TextView) findViewById(C0054R.id.title_tv);
        this.addList_btn = (Button) findViewById(C0054R.id.addlist_btn);
        this.title_tv.setText(getIntent().getExtras().getString("name"));
        this.noList_tv.setTypeface(this.typeFace);
        this.addList_tv.setTypeface(this.typeFace);
        this.addList_btn.setTypeface(this.typeFace);
        this.title_tv.setTypeface(this.typeFace);
        this.db = new Database(getApplicationContext());
        listChanged();
    }

    public void controlList(boolean bool) {
        if (bool) {
            this.listView.setVisibility(8);
            this.listemptyView.setVisibility(0);
            return;
        }
        this.listView.setVisibility(0);
        this.listemptyView.setVisibility(8);
    }

    public void addNewItem(View v) {
        UiUtils.addItemDialog(this.ctx, this.db).show();
        eventTracker("addItem");
    }

    public void listChanged() {
        this.adapter = new ItemsAdapter(this.ctx, this.db.getToDos(Integer.valueOf(Utils.getPrefValue(this.ctx, "listid", "-1")).intValue()));
        this.adapter.notifyDataSetChanged();
        this.listView.setAdapter(this.adapter);
        controlList(this.db.isItemsEmpty(Integer.valueOf(Utils.getPrefValue(this.ctx, "listid", "-1")).intValue()));
    }

    public void deleteToDo(int id) {
        UiUtils.removeToDoDialog(this.ctx, this.db, id).show();
        eventTracker("itemDelete");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0054R.menu.main, menu);
        return true;
    }

    public void drop(int from, int to) {
        Log.d("drop", String.valueOf(from));
        Log.d("drop", String.valueOf(to));
        ArrayList<Items> temp = this.db.getToDos(Integer.valueOf(Utils.getPrefValue(this.ctx, "listid", "-1")).intValue());
        int tempstart = from;
        int tempend = to;
        int i;
        if (from < to) {
            Log.d("yukar\u00ef\u00bf\u00bddan asagiya", "evet");
            this.db.updateSortID(Integer.valueOf(((Items) temp.get(tempend)).getSortID()), ((Items) temp.get(tempstart)).getID());
            for (i = from; i <= to - 1; i++) {
                this.db.updateSortID(Integer.valueOf(((Items) temp.get(i)).getSortID()), ((Items) temp.get(i + 1)).getID());
            }
        } else if (from > to) {
            Log.d("yukar\u00ef\u00bf\u00bddan asagiya", "hayir");
            this.db.updateSortID(Integer.valueOf(((Items) temp.get(tempend)).getSortID()), ((Items) temp.get(tempstart)).getID());
            for (i = from; i >= to + 1; i--) {
                this.db.updateSortID(Integer.valueOf(((Items) temp.get(i)).getSortID()), ((Items) temp.get(i - 1)).getID());
            }
        }
        listChanged();
        eventTracker("listdragged");
    }

    public void deleteMode(View v) {
        if (this.deleteMode) {
            this.deleteMode = false;
            ItemsAdapter.trashMode = this.deleteMode;
        } else {
            this.deleteMode = true;
            ItemsAdapter.trashMode = this.deleteMode;
        }
        listChanged();
    }

    public void updateCheck(int id, int situation) {
        this.db.updateCheck(Integer.valueOf(situation), id);
        listChanged();
        eventTracker("itemchecked");
    }

    public void setAlarm(int id, String name, int alarmsituation) {
        UiUtils.timedatepickerDialog(this.ctx, this.db, id, this.scheduleClient, name, alarmsituation).show();
        eventTracker("alarmset");
    }

    public void setAlarmUncheck(int id) {
        this.db.updateAlarm(Integer.valueOf(0), id);
        ((ItemsActivity) this.ctx).listChanged();
        listChanged();
        ((AlarmManager) getSystemService("alarm")).cancel(PendingIntent.getService(this.ctx, id, new Intent(this.ctx, MainActivity.class), 0));
        eventTracker("alarmunset");
    }

    protected void onStart() {
        super.onStart();
        EasyTracker.getInstance(this).activityStart(this);
    }

    protected void onStop() {
        super.onStop();
        EasyTracker.getInstance(this).activityStop(this);
    }

    public void eventTracker(String evnt) {
        EasyTracker.getInstance(this).send(MapBuilder.createEvent("ui_action", "button_press", evnt, null).build());
    }
}
