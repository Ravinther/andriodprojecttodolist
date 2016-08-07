package com.apptologia.simpletodo.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.apptologia.simpletodo.C0054R;
import com.apptologia.simpletodo.MainActivity;
import com.apptologia.simpletodo.pojos.ToDoList;
import java.util.ArrayList;

public class ToDoListsAdapter extends BaseAdapter {
    private static LayoutInflater inflater;
    private Context ctx;
    private ArrayList<ToDoList> toDoLists;
    private Typeface typeFace;

    /* renamed from: com.apptologia.simpletodo.adapters.ToDoListsAdapter.1 */
    class C00581 implements OnClickListener {
        private final /* synthetic */ ToDoList val$temp;

        C00581(ToDoList toDoList) {
            this.val$temp = toDoList;
        }

        public void onClick(View v) {
            ((MainActivity) ToDoListsAdapter.this.ctx).deleteToDoList(this.val$temp.getID());
        }
    }

    static {
        inflater = null;
    }

    public ToDoListsAdapter(Context ctx, ArrayList<ToDoList> arrayList) {
        this.ctx = ctx;
        this.toDoLists = arrayList;
        inflater = (LayoutInflater) ctx.getSystemService("layout_inflater");
        this.typeFace = Typeface.createFromAsset(ctx.getAssets(), "fonts/yourcustomfont.otf");
    }

    public int getCount() {
        return this.toDoLists.size();
    }

    public Object getItem(int position) {
        return Integer.valueOf(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null) {
            vi = inflater.inflate(C0054R.layout.todolists_row, null);
        }
        TextView title = (TextView) vi.findViewById(C0054R.id.title_tv);
        TextView detail = (TextView) vi.findViewById(C0054R.id.detail_tv);
        TextView created_at = (TextView) vi.findViewById(C0054R.id.date_tv);
        ImageView trash = (ImageView) vi.findViewById(C0054R.id.trash_iv);
        trash.setTag(Integer.valueOf(position));
        ToDoList temp = (ToDoList) this.toDoLists.get(position);
        title.setText(temp.getTitle());
        detail.setText(temp.getDetail());
        created_at.setText(temp.getCreatedTime());
        title.setTypeface(this.typeFace);
        trash.setOnClickListener(new C00581(temp));
        return vi;
    }
}
