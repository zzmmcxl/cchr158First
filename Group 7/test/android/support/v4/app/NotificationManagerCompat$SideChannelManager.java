package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.Handler.Callback;
import android.support.v4.app.INotificationSideChannel$Stub;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationManagerCompat$ServiceConnectedEvent;
import android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord;
import android.support.v4.app.NotificationManagerCompat$Task;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class NotificationManagerCompat$SideChannelManager implements Callback, ServiceConnection {
   private static final String KEY_BINDER = "binder";
   private static final int MSG_QUEUE_TASK = 0;
   private static final int MSG_RETRY_LISTENER_QUEUE = 3;
   private static final int MSG_SERVICE_CONNECTED = 1;
   private static final int MSG_SERVICE_DISCONNECTED = 2;
   private Set<String> mCachedEnabledPackages = new HashSet();
   private final Context mContext;
   private final Handler mHandler;
   private final HandlerThread mHandlerThread;
   private final Map<ComponentName, NotificationManagerCompat$SideChannelManager$ListenerRecord> mRecordMap = new HashMap();

   public NotificationManagerCompat$SideChannelManager(Context var1) {
      this.mContext = var1;
      this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
      this.mHandlerThread.start();
      this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
   }

   private boolean ensureServiceBound(NotificationManagerCompat$SideChannelManager$ListenerRecord var1) {
      if(var1.bound) {
         return true;
      } else {
         Intent var2 = (new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL")).setComponent(var1.componentName);
         var1.bound = this.mContext.bindService(var2, this, NotificationManagerCompat.access$000());
         if(var1.bound) {
            var1.retryCount = 0;
         } else {
            Log.w("NotifManCompat", "Unable to bind to listener " + var1.componentName);
            this.mContext.unbindService(this);
         }

         return var1.bound;
      }
   }

   private void ensureServiceUnbound(NotificationManagerCompat$SideChannelManager$ListenerRecord var1) {
      if(var1.bound) {
         this.mContext.unbindService(this);
         var1.bound = false;
      }

      var1.service = null;
   }

   private void handleQueueTask(NotificationManagerCompat$Task var1) {
      this.updateListenerMap();
      Iterator var2 = this.mRecordMap.values().iterator();

      while(var2.hasNext()) {
         NotificationManagerCompat$SideChannelManager$ListenerRecord var3 = (NotificationManagerCompat$SideChannelManager$ListenerRecord)var2.next();
         var3.taskQueue.add(var1);
         this.processListenerQueue(var3);
      }

   }

   private void handleRetryListenerQueue(ComponentName var1) {
      NotificationManagerCompat$SideChannelManager$ListenerRecord var2 = (NotificationManagerCompat$SideChannelManager$ListenerRecord)this.mRecordMap.get(var1);
      if(var2 != null) {
         this.processListenerQueue(var2);
      }

   }

   private void handleServiceConnected(ComponentName var1, IBinder var2) {
      NotificationManagerCompat$SideChannelManager$ListenerRecord var3 = (NotificationManagerCompat$SideChannelManager$ListenerRecord)this.mRecordMap.get(var1);
      if(var3 != null) {
         var3.service = INotificationSideChannel$Stub.asInterface(var2);
         var3.retryCount = 0;
         this.processListenerQueue(var3);
      }

   }

   private void handleServiceDisconnected(ComponentName var1) {
      NotificationManagerCompat$SideChannelManager$ListenerRecord var2 = (NotificationManagerCompat$SideChannelManager$ListenerRecord)this.mRecordMap.get(var1);
      if(var2 != null) {
         this.ensureServiceUnbound(var2);
      }

   }

   private void processListenerQueue(NotificationManagerCompat$SideChannelManager$ListenerRecord var1) {
      if(Log.isLoggable("NotifManCompat", 3)) {
         Log.d("NotifManCompat", "Processing component " + var1.componentName + ", " + var1.taskQueue.size() + " queued tasks");
      }

      if(!var1.taskQueue.isEmpty()) {
         if(this.ensureServiceBound(var1) && var1.service != null) {
            while(true) {
               NotificationManagerCompat$Task var2 = (NotificationManagerCompat$Task)var1.taskQueue.peek();
               if(var2 != null) {
                  try {
                     if(Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + var2);
                     }

                     var2.send(var1.service);
                     var1.taskQueue.remove();
                     continue;
                  } catch (DeadObjectException var3) {
                     if(Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + var1.componentName);
                     }
                  } catch (RemoteException var4) {
                     Log.w("NotifManCompat", "RemoteException communicating with " + var1.componentName, var4);
                  }
               }

               if(!var1.taskQueue.isEmpty()) {
                  this.scheduleListenerRetry(var1);
                  return;
               }

               return;
            }
         } else {
            this.scheduleListenerRetry(var1);
         }
      }
   }

   private void scheduleListenerRetry(NotificationManagerCompat$SideChannelManager$ListenerRecord var1) {
      if(!this.mHandler.hasMessages(3, var1.componentName)) {
         ++var1.retryCount;
         if(var1.retryCount > 6) {
            Log.w("NotifManCompat", "Giving up on delivering " + var1.taskQueue.size() + " tasks to " + var1.componentName + " after " + var1.retryCount + " retries");
            var1.taskQueue.clear();
         } else {
            int var2 = (1 << var1.retryCount - 1) * 1000;
            if(Log.isLoggable("NotifManCompat", 3)) {
               Log.d("NotifManCompat", "Scheduling retry for " + var2 + " ms");
            }

            Message var3 = this.mHandler.obtainMessage(3, var1.componentName);
            this.mHandler.sendMessageDelayed(var3, (long)var2);
         }
      }
   }

   private void updateListenerMap() {
      Set var2 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
      if(!var2.equals(this.mCachedEnabledPackages)) {
         this.mCachedEnabledPackages = var2;
         List var3 = this.mContext.getPackageManager().queryIntentServices((new Intent()).setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
         HashSet var1 = new HashSet();
         Iterator var7 = var3.iterator();

         while(var7.hasNext()) {
            ResolveInfo var4 = (ResolveInfo)var7.next();
            if(var2.contains(var4.serviceInfo.packageName)) {
               ComponentName var5 = new ComponentName(var4.serviceInfo.packageName, var4.serviceInfo.name);
               if(var4.serviceInfo.permission != null) {
                  Log.w("NotifManCompat", "Permission present on component " + var5 + ", not adding listener record.");
               } else {
                  var1.add(var5);
               }
            }
         }

         Iterator var6 = var1.iterator();

         while(var6.hasNext()) {
            ComponentName var8 = (ComponentName)var6.next();
            if(!this.mRecordMap.containsKey(var8)) {
               if(Log.isLoggable("NotifManCompat", 3)) {
                  Log.d("NotifManCompat", "Adding listener record for " + var8);
               }

               this.mRecordMap.put(var8, new NotificationManagerCompat$SideChannelManager$ListenerRecord(var8));
            }
         }

         var6 = this.mRecordMap.entrySet().iterator();

         while(var6.hasNext()) {
            Entry var9 = (Entry)var6.next();
            if(!var1.contains(var9.getKey())) {
               if(Log.isLoggable("NotifManCompat", 3)) {
                  Log.d("NotifManCompat", "Removing listener record for " + var9.getKey());
               }

               this.ensureServiceUnbound((NotificationManagerCompat$SideChannelManager$ListenerRecord)var9.getValue());
               var6.remove();
            }
         }
      }

   }

   public boolean handleMessage(Message var1) {
      switch(var1.what) {
      case 0:
         this.handleQueueTask((NotificationManagerCompat$Task)var1.obj);
         return true;
      case 1:
         NotificationManagerCompat$ServiceConnectedEvent var2 = (NotificationManagerCompat$ServiceConnectedEvent)var1.obj;
         this.handleServiceConnected(var2.componentName, var2.iBinder);
         return true;
      case 2:
         this.handleServiceDisconnected((ComponentName)var1.obj);
         return true;
      case 3:
         this.handleRetryListenerQueue((ComponentName)var1.obj);
         return true;
      default:
         return false;
      }
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      if(Log.isLoggable("NotifManCompat", 3)) {
         Log.d("NotifManCompat", "Connected to service " + var1);
      }

      this.mHandler.obtainMessage(1, new NotificationManagerCompat$ServiceConnectedEvent(var1, var2)).sendToTarget();
   }

   public void onServiceDisconnected(ComponentName var1) {
      if(Log.isLoggable("NotifManCompat", 3)) {
         Log.d("NotifManCompat", "Disconnected from service " + var1);
      }

      this.mHandler.obtainMessage(2, var1).sendToTarget();
   }

   public void queueTask(NotificationManagerCompat$Task var1) {
      this.mHandler.obtainMessage(0, var1).sendToTarget();
   }
}
