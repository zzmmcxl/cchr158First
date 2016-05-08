package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.widget.CursorAdapter;

class CursorAdapter$ChangeObserver extends ContentObserver {
   public CursorAdapter$ChangeObserver(CursorAdapter var1) {
      super(new Handler());
      this.this$0 = var1;
   }

   public boolean deliverSelfNotifications() {
      return true;
   }

   public void onChange(boolean var1) {
      this.this$0.onContentChanged();
   }
}
