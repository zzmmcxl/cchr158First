package android.support.v7.app;

import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.view.View;
import android.database.Cursor;
import android.content.Context;
import android.widget.ListView;
import android.widget.CursorAdapter;

class AlertController$AlertParams$2 extends CursorAdapter {
    private final int mIsCheckedIndex;
    private final int mLabelIndex;
    final /* synthetic */ AlertParams this$0;
    final /* synthetic */ AlertController val$dialog;
    final /* synthetic */ ListView val$listView;
    
    AlertController$AlertParams$2(final AlertParams this$0, final Context context, final Cursor cursor, final boolean b, final ListView val$listView, final AlertController val$dialog) {
        this$0 = this$0;
        val$listView = val$listView;
        val$dialog = val$dialog;
        super(context, cursor, b);
    }
    
    {
        final Cursor cursor2 = this.getCursor();
        mLabelIndex = cursor2.getColumnIndexOrThrow(mLabelColumn);
        mIsCheckedIndex = cursor2.getColumnIndexOrThrow(mIsCheckedColumn);
    }
    
    public void bindView(final View view, final Context context, final Cursor cursor) {
        boolean b = true;
        ((CheckedTextView)view.findViewById(16908308)).setText((CharSequence)cursor.getString(mLabelIndex));
        final ListView val$listView = this.val$listView;
        final int position = cursor.getPosition();
        if (cursor.getInt(mIsCheckedIndex) != (b ? 1 : 0)) {
            b = false;
        }
        val$listView.setItemChecked(position, b);
    }
    
    public View newView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        return mInflater.inflate(AlertController.access$1200(val$dialog), viewGroup, false);
    }
}