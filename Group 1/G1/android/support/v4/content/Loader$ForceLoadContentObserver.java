package android.support.v4.content;

import android.os.Handler;
import android.database.ContentObserver;

public final class ForceLoadContentObserver extends ContentObserver
{
    final /* synthetic */ Loader this$0;
    
    public ForceLoadContentObserver(final Loader this$0) {
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
