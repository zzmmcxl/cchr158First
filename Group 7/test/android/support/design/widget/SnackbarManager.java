package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.SnackbarManager$1;
import android.support.design.widget.SnackbarManager$Callback;
import android.support.design.widget.SnackbarManager$SnackbarRecord;

class SnackbarManager {
   private static final int LONG_DURATION_MS = 2750;
   private static final int MSG_TIMEOUT = 0;
   private static final int SHORT_DURATION_MS = 1500;
   private static SnackbarManager sSnackbarManager;
   private SnackbarManager$SnackbarRecord mCurrentSnackbar;
   private final Handler mHandler = new Handler(Looper.getMainLooper(), new SnackbarManager$1(this));
   private final Object mLock = new Object();
   private SnackbarManager$SnackbarRecord mNextSnackbar;

   private boolean cancelSnackbarLocked(SnackbarManager$SnackbarRecord var1, int var2) {
      SnackbarManager$Callback var3 = (SnackbarManager$Callback)SnackbarManager$SnackbarRecord.access$200(var1).get();
      if(var3 != null) {
         this.mHandler.removeCallbacksAndMessages(var1);
         var3.dismiss(var2);
         return true;
      } else {
         return false;
      }
   }

   static SnackbarManager getInstance() {
      if(sSnackbarManager == null) {
         sSnackbarManager = new SnackbarManager();
      }

      return sSnackbarManager;
   }

   private void handleTimeout(SnackbarManager$SnackbarRecord param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean isCurrentSnackbarLocked(SnackbarManager$Callback var1) {
      return this.mCurrentSnackbar != null && this.mCurrentSnackbar.isSnackbar(var1);
   }

   private boolean isNextSnackbarLocked(SnackbarManager$Callback var1) {
      return this.mNextSnackbar != null && this.mNextSnackbar.isSnackbar(var1);
   }

   private void scheduleTimeoutLocked(SnackbarManager$SnackbarRecord var1) {
      if(SnackbarManager$SnackbarRecord.access$100(var1) != -2) {
         int var2 = 2750;
         if(SnackbarManager$SnackbarRecord.access$100(var1) > 0) {
            var2 = SnackbarManager$SnackbarRecord.access$100(var1);
         } else if(SnackbarManager$SnackbarRecord.access$100(var1) == -1) {
            var2 = 1500;
         }

         this.mHandler.removeCallbacksAndMessages(var1);
         this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, var1), (long)var2);
      }
   }

   private void showNextSnackbarLocked() {
      if(this.mNextSnackbar != null) {
         this.mCurrentSnackbar = this.mNextSnackbar;
         this.mNextSnackbar = null;
         SnackbarManager$Callback var1 = (SnackbarManager$Callback)SnackbarManager$SnackbarRecord.access$200(this.mCurrentSnackbar).get();
         if(var1 == null) {
            this.mCurrentSnackbar = null;
            return;
         }

         var1.show();
      }

   }

   public void cancelTimeout(SnackbarManager$Callback param1) {
      // $FF: Couldn't be decompiled
   }

   public void dismiss(SnackbarManager$Callback param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean isCurrent(SnackbarManager$Callback param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean isCurrentOrNext(SnackbarManager$Callback param1) {
      // $FF: Couldn't be decompiled
   }

   public void onDismissed(SnackbarManager$Callback param1) {
      // $FF: Couldn't be decompiled
   }

   public void onShown(SnackbarManager$Callback param1) {
      // $FF: Couldn't be decompiled
   }

   public void restoreTimeout(SnackbarManager$Callback param1) {
      // $FF: Couldn't be decompiled
   }

   public void show(int param1, SnackbarManager$Callback param2) {
      // $FF: Couldn't be decompiled
   }
}
