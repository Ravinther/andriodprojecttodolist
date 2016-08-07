package com.apptologia.simpletodo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.apptologia.simpletodo.pojos.Items;
import com.apptologia.simpletodo.pojos.ToDoList;
import com.apptologia.simpletodo.utils.Utils;
import java.util.ArrayList;
import java.util.Calendar;

public class Database extends SQLiteOpenHelper {
    private static String CREATED_AT = null;
    private static String CREATE_TABLE_ITEM = null;
    private static String CREATE_TABLE_TODOLIST = null;
    private static final String DATABASE_NAME = "todolist_database";
    private static final int DATABASE_VERSION = 1;
    private static String ID = null;
    private static String ITEM_ALARM = null;
    private static String ITEM_CHECKED = null;
    private static String ITEM_LIST_ID = null;
    private static String ITEM_NAME = null;
    private static String ITEM_SORT_ID = null;
    private static final String TABLE_NAME_todolists = "todolists_lists";
    private static final String TABLE_NAME_todos = "todos_lists";
    private static String TODO_LIST_DETAIL;
    private static String TODO_LIST_NAME;
    private static String TODO_LIST_TYPE;

    static {
        ID = "_id";
        CREATED_AT = "created_at";
        TODO_LIST_NAME = "todo_list_name";
        TODO_LIST_TYPE = "todo_list_type";
        TODO_LIST_DETAIL = "todo_list_detail";
        ITEM_NAME = "item_name";
        ITEM_LIST_ID = "item_list_id";
        ITEM_SORT_ID = "item_sort_id";
        ITEM_ALARM = "item_alarm";
        ITEM_CHECKED = "item_checked";
        CREATE_TABLE_TODOLIST = "CREATE TABLE todolists_lists(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TODO_LIST_NAME + " TEXT," + TODO_LIST_DETAIL + " TEXT," + TODO_LIST_TYPE + " TEXT," + CREATED_AT + " TEXT" + ")";
        CREATE_TABLE_ITEM = "CREATE TABLE todos_lists(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + ITEM_LIST_ID + " INTEGER," + ITEM_NAME + " TEXT," + ITEM_SORT_ID + " INTEGER," + ITEM_CHECKED + " INTEGER," + ITEM_ALARM + " INTEGER," + CREATED_AT + " TEXT" + ")";
    }

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TODOLIST);
        db.execSQL(CREATE_TABLE_ITEM);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS todolists_lists");
        db.execSQL("DROP TABLE IF EXISTS todos_lists");
    }

    public void addToDoList(String name, String detail) {
        String str = "";
        str = getDateAsFormattedString();
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TODO_LIST_NAME, name);
        values.put(TODO_LIST_TYPE, "");
        values.put(CREATED_AT, str);
        values.put(TODO_LIST_DETAIL, detail);
        db.insert(TABLE_NAME_todolists, null, values);
        db.close();
    }

    public void deleteToDoList(int id) {
        getWritableDatabase().delete(TABLE_NAME_todolists, ID + "=" + id, null);
    }

    public String getDateAsFormattedString() {
        Calendar c = Calendar.getInstance();
        String month = String.valueOf(c.get(2) + DATABASE_VERSION);
        String day = String.valueOf(c.get(5));
        return new StringBuilder(String.valueOf(day)).append(".").append(month).append(".").append(String.valueOf(c.get(DATABASE_VERSION))).toString();
    }

    public ArrayList<ToDoList> getToDoLists() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM todolists_lists", null);
        ArrayList<ToDoList> ToDoLists = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                ToDoLists.add(new ToDoList(cursor.getInt(0), cursor.getString(DATABASE_VERSION), cursor.getString(2), cursor.getString(4), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        db.close();
        return ToDoLists;
    }

    public void addItem(String name, int listid, Context ctx) {
        String check = "unchecked";
        String created_at = "";
        int sortid = Integer.valueOf(Utils.getPrefValue(ctx, "sortid", "0")).intValue();
        created_at = getDateAsFormattedString();
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ITEM_NAME, name);
        values.put(ITEM_SORT_ID, Integer.valueOf(sortid));
        values.put(ITEM_CHECKED, Integer.valueOf(0));
        values.put(ITEM_ALARM, Integer.valueOf(0));
        values.put(CREATED_AT, created_at);
        values.put(ITEM_LIST_ID, Integer.valueOf(listid));
        db.insert(TABLE_NAME_todos, null, values);
        Utils.savePrefs(ctx, "sortid", String.valueOf(sortid + DATABASE_VERSION));
        db.close();
    }

    public void deleteToDos(int id) {
        getWritableDatabase().delete(TABLE_NAME_todos, ID + "=" + id, null);
    }

    public ArrayList<Items> getToDos(int listID) {
        String query = "SELECT * FROM todos_lists WHERE " + ITEM_LIST_ID + "=" + listID + " ORDER BY " + ITEM_SORT_ID + " ASC";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<Items> ItemsList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                ItemsList.add(new Items(cursor.getInt(0), cursor.getInt(DATABASE_VERSION), cursor.getString(2), cursor.getInt(3), cursor.getString(6), cursor.getInt(4), cursor.getInt(5)));
            } while (cursor.moveToNext());
        }
        db.close();
        return ItemsList;
    }

    public void updateSortID(Integer newID, int rowid) {
        getWritableDatabase().execSQL("UPDATE todos_lists SET " + ITEM_SORT_ID + "=" + newID + " WHERE " + ID + " = " + rowid);
    }

    public void updateCheck(Integer newID, int rowid) {
        getWritableDatabase().execSQL("UPDATE todos_lists SET " + ITEM_CHECKED + "=" + newID + " WHERE " + ID + " = " + rowid);
    }

    public void updateAlarm(Integer newID, int rowid) {
        getWritableDatabase().execSQL("UPDATE todos_lists SET " + ITEM_ALARM + "=" + newID + " WHERE " + ID + " = " + rowid);
    }

    public int getRowCount() {
        Log.d("buraya", "kadar");
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM todolists_lists", null);
        int rowCount = cursor.getCount();
        db.close();
        cursor.close();
        return rowCount;
    }

    public boolean isListEmpty() {
        Log.d("buraya", "kadar");
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM todolists_lists", null);
        int rowCount = cursor.getCount();
        db.close();
        cursor.close();
        if (rowCount <= 0) {
            return true;
        }
        return false;
    }

    public boolean isItemsEmpty(int listid) {
        Log.d("buraya", "kadar");
        String countQuery = "SELECT  * FROM todos_lists WHERE " + ITEM_LIST_ID + "=" + listid;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int rowCount = cursor.getCount();
        db.close();
        cursor.close();
        if (rowCount <= 0) {
            return true;
        }
        return false;
    }
}
