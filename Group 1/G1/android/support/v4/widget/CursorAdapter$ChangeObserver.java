package android.support.v4.widget;

import android.os.Handler;
import android.database.ContentObserver;

private class ChangeObserver extends ContentObserver
{
    final /* synthetic */ CursorAdapter this$0;
    
    public ChangeObserver(final CursorAdapter this$0) {
        this$0 = this$0;
        super(new Handler());
    }
    
    public boolean deliverSelfNotifications() {
        return true;
    }
    
    public void onChange(final boolean b) {
        this$0.onContentChanged();
    }
}
