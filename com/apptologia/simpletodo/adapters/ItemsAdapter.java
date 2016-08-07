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
import com.apptologia.simpletodo.ItemsActivity;
import com.apptologia.simpletodo.pojos.Items;
import java.util.ArrayList;

public class ItemsAdapter extends BaseAdapter {
    private static ImageView alarm_iv;
    private static ImageView check_iv;
    private static LayoutInflater inflater;
    private static ImageView sort_iv;
    public static boolean trashMode;
    private static ImageView trash_iv;
    private Context ctx;
    private ArrayList<Items> itemList;
    private Typeface typeFace;

    /* renamed from: com.apptologia.simpletodo.adapters.ItemsAdapter.1 */
    class C00551 implements OnClickListener {
        private final /* synthetic */ Items val$temp;

        C00551(Items items) {
            this.val$temp = items;
        }

        public void onClick(View v) {
            ((ItemsActivity) ItemsAdapter.this.ctx).deleteToDo(this.val$temp.getID());
        }
    }

    /* renamed from: com.apptologia.simpletodo.adapters.ItemsAdapter.2 */
    class C00562 implements OnClickListener {
        private final /* synthetic */ Items val$temp;

        C00562(Items items) {
            this.val$temp = items;
        }

        public void onClick(View v) {
            if (this.val$temp.getAlarm() == 0) {
                ((ItemsActivity) ItemsAdapter.this.ctx).setAlarm(this.val$temp.getID(), this.val$temp.getTitle(), 1);
            } else {
                ((ItemsActivity) ItemsAdapter.this.ctx).setAlarmUncheck(this.val$temp.getID());
            }
        }
    }

    /* renamed from: com.apptologia.simpletodo.adapters.ItemsAdapter.3 */
    class C00573 implements OnClickListener {
        private final /* synthetic */ Items val$temp;

        C00573(Items items) {
            this.val$temp = items;
        }

        public void onClick(View v) {
            if (this.val$temp.getChecked() == 0) {
                ((ItemsActivity) ItemsAdapter.this.ctx).updateCheck(this.val$temp.getID(), 1);
            } else {
                ((ItemsActivity) ItemsAdapter.this.ctx).updateCheck(this.val$temp.getID(), 0);
            }
        }
    }

    static {
        inflater = null;
    }

    public ItemsAdapter(Context ctx, ArrayList<Items> arrayList) {
        this.ctx = ctx;
        this.itemList = arrayList;
        inflater = (LayoutInflater) ctx.getSystemService("layout_inflater");
        this.typeFace = Typeface.createFromAsset(ctx.getAssets(), "fonts/yourcustomfont.otf");
    }

    public int getCount() {
        return this.itemList.size();
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
            vi = inflater.inflate(C0054R.layout.items_row, null);
        }
        TextView title = (TextView) vi.findViewById(C0054R.id.title_tv);
        check_iv = (ImageView) vi.findViewById(C0054R.id.check_iv);
        alarm_iv = (ImageView) vi.findViewById(C0054R.id.alarm_iv);
        sort_iv = (ImageView) vi.findViewById(C0054R.id.sort_iv);
        trash_iv = (ImageView) vi.findViewById(C0054R.id.trash_iv);
        Items temp = (Items) this.itemList.get(position);
        if (trashMode) {
            trash_iv.setVisibility(0);
            alarm_iv.setVisibility(8);
            sort_iv.setVisibility(8);
        } else {
            trash_iv.setVisibility(8);
            alarm_iv.setVisibility(0);
            sort_iv.setVisibility(0);
        }
        trash_iv.setOnClickListener(new C00551(temp));
        alarm_iv.setOnClickListener(new C00562(temp));
        check_iv.setOnClickListener(new C00573(temp));
        title.setText(temp.getTitle());
        if (temp.getChecked() == 0) {
            title.setPaintFlags(title.getPaintFlags() & -17);
            check_iv.setImageResource(C0054R.drawable.ic_unchecked);
        } else {
            title.setPaintFlags(title.getPaintFlags() | 16);
            check_iv.setImageResource(C0054R.drawable.ic_checked);
        }
        if (temp.getAlarm() == 0) {
            alarm_iv.setImageResource(C0054R.drawable.ic_alarm_unchecked);
        } else {
            alarm_iv.setImageResource(C0054R.drawable.ic_alarm_checked);
        }
        title.setTypeface(this.typeFace);
        return vi;
    }
}
