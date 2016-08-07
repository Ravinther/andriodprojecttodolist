package com.apptologia.simpletodo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.apptologia.simpletodo.adapters.ToDoListsAdapter;
import com.apptologia.simpletodo.database.Database;
import com.apptologia.simpletodo.pojos.ToDoList;
import com.apptologia.simpletodo.utils.UiUtils;
import com.apptologia.simpletodo.utils.Utils;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity implements OnItemClickListener {
    private AdView adView;
    private ToDoListsAdapter adapter;
    private Button addList_btn;
    private TextView addList_tv;
    private TextView appName_tv;
    private Context ctx;
    private Database db;
    private ListView listView;
    private LinearLayout listemptyView;
    private TextView noList_tv;
    private TextView title_tv;
    private Typeface typeFace;

    public MainActivity() {
        this.ctx = this;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().addFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        setContentView(C0054R.layout.activity_main);
        AdView adView = (AdView) findViewById(C0054R.id.adView);
        AdRequest adRequest = new Builder().build();
        if (Utils.adManagement(this.ctx, "banner", 10)) {
            adView.loadAd(adRequest);
        } else {
            adView.setVisibility(8);
        }
        Utils.rateMeCounter(this.ctx, 5, 9, 13);
        this.typeFace = Typeface.createFromAsset(getAssets(), "fonts/yourcustomfont.otf");
        this.listView = (ListView) findViewById(C0054R.id.listView);
        this.listemptyView = (LinearLayout) findViewById(C0054R.id.listemptyview);
        this.appName_tv = (TextView) findViewById(C0054R.id.appname_tv);
        this.noList_tv = (TextView) findViewById(C0054R.id.nolist_tv);
        this.addList_tv = (TextView) findViewById(C0054R.id.addlist_tv);
        this.title_tv = (TextView) findViewById(C0054R.id.title_tv);
        this.addList_btn = (Button) findViewById(C0054R.id.addlist_btn);
        this.appName_tv.setTypeface(this.typeFace);
        this.noList_tv.setTypeface(this.typeFace);
        this.addList_tv.setTypeface(this.typeFace);
        this.addList_btn.setTypeface(this.typeFace);
        this.title_tv.setTypeface(this.typeFace);
        this.db = new Database(getApplicationContext());
        this.listView.setOnItemClickListener(this);
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

    public void addNewList(View v) {
        UiUtils.addTodoListDialog(this.ctx, this.db).show();
        eventTracker("listadded");
    }

    public void listChanged() {
        this.adapter = new ToDoListsAdapter(this.ctx, this.db.getToDoLists());
        this.adapter.notifyDataSetChanged();
        this.listView.setAdapter(this.adapter);
        controlList(this.db.isListEmpty());
    }

    public void deleteToDoList(int id) {
        UiUtils.removeToDoListDialog(this.ctx, this.db, id).show();
        eventTracker("listdeleted");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0054R.menu.main, menu);
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
        Intent i = new Intent(this, ItemsActivity.class);
        Utils.savePrefs(this.ctx, "listid", String.valueOf(((ToDoList) this.db.getToDoLists().get(arg2)).getID()));
        i.putExtra("name", ((ToDoList) this.db.getToDoLists().get(arg2)).getTitle());
        eventTracker("listclicked:" + ((ToDoList) this.db.getToDoLists().get(arg2)).getTitle());
        startActivity(i);
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

    public void rateMe() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
    }
}
