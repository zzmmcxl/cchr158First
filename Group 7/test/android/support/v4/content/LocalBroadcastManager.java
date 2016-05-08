package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager$1;
import android.support.v4.content.LocalBroadcastManager$BroadcastRecord;
import android.support.v4.content.LocalBroadcastManager$ReceiverRecord;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
   private static final boolean DEBUG = false;
   static final int MSG_EXEC_PENDING_BROADCASTS = 1;
   private static final String TAG = "LocalBroadcastManager";
   private static LocalBroadcastManager mInstance;
   private static final Object mLock = new Object();
   private final HashMap<String, ArrayList<LocalBroadcastManager$ReceiverRecord>> mActions = new HashMap();
   private final Context mAppContext;
   private final Handler mHandler;
   private final ArrayList<LocalBroadcastManager$BroadcastRecord> mPendingBroadcasts = new ArrayList();
   private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap();

   private LocalBroadcastManager(Context var1) {
      this.mAppContext = var1;
      this.mHandler = new LocalBroadcastManager$1(this, var1.getMainLooper());
   }

   private void executePendingBroadcasts() {
      // $FF: Couldn't be decompiled
   }

   public static LocalBroadcastManager getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public void registerReceiver(BroadcastReceiver param1, IntentFilter param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean sendBroadcast(Intent param1) {
      // $FF: Couldn't be decompiled
   }

   public void sendBroadcastSync(Intent var1) {
      if(this.sendBroadcast(var1)) {
         this.executePendingBroadcasts();
      }

   }

   public void unregisterReceiver(BroadcastReceiver param1) {
      // $FF: Couldn't be decompiled
   }
}
