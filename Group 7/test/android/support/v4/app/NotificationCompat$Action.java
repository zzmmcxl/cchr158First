package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat$Action$1;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompatBase$Action;
import android.support.v4.app.NotificationCompatBase$Action$Factory;
import android.support.v4.app.RemoteInput;

public class NotificationCompat$Action extends NotificationCompatBase$Action {
   public static final NotificationCompatBase$Action$Factory FACTORY = new NotificationCompat$Action$1();
   public PendingIntent actionIntent;
   public int icon;
   private final Bundle mExtras;
   private final RemoteInput[] mRemoteInputs;
   public CharSequence title;

   public NotificationCompat$Action(int var1, CharSequence var2, PendingIntent var3) {
      this(var1, var2, var3, new Bundle(), (RemoteInput[])null);
   }

   private NotificationCompat$Action(int var1, CharSequence var2, PendingIntent var3, Bundle var4, RemoteInput[] var5) {
      this.icon = var1;
      this.title = NotificationCompat$Builder.limitCharSequenceLength(var2);
      this.actionIntent = var3;
      if(var4 == null) {
         var4 = new Bundle();
      }

      this.mExtras = var4;
      this.mRemoteInputs = var5;
   }

   public PendingIntent getActionIntent() {
      return this.actionIntent;
   }

   public Bundle getExtras() {
      return this.mExtras;
   }

   public int getIcon() {
      return this.icon;
   }

   public RemoteInput[] getRemoteInputs() {
      return this.mRemoteInputs;
   }

   public CharSequence getTitle() {
      return this.title;
   }
}
