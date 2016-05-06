package android.support.v4.widget;

import android.database.DataSetObserver;

private class MyDataSetObserver extends DataSetObserver
{
    final /* synthetic */ CursorAdapter this$0;
    
    private MyDataSetObserver(final CursorAdapter this$0) {
        this$0 = this$0;
        super();
    }
    
    MyDataSetObserver(final CursorAdapter cursorAdapter, final CursorAdapter$1 object) {
        this(cursorAdapter);
    }
    
    public void onChanged() {
        mDataValid = true;
        this$0.notifyDataSetChanged();
    }
    
    public void onInvalidated() {
        mDataValid = false;
        this$0.notifyDataSetInvalidated();
    }
}
