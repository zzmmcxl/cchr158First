package android.support.v4.content;

import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.content.Loader;

public final class Loader$ForceLoadContentObserver extends ContentObserver {
   public Loader$ForceLoadContentObserver(Loader var1) {
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
