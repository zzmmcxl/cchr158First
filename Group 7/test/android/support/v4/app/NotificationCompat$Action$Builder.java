package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat$1;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompat$Action$Extender;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.RemoteInput;
import java.util.ArrayList;

public final class NotificationCompat$Action$Builder {
   private final Bundle mExtras;
   private final int mIcon;
   private final PendingIntent mIntent;
   private ArrayList<RemoteInput> mRemoteInputs;
   private final CharSequence mTitle;

   public NotificationCompat$Action$Builder(int var1, CharSequence var2, PendingIntent var3) {
      this(var1, var2, var3, new Bundle());
   }

   private NotificationCompat$Action$Builder(int var1, CharSequence var2, PendingIntent var3, Bundle var4) {
      this.mIcon = var1;
      this.mTitle = NotificationCompat$Builder.limitCharSequenceLength(var2);
      this.mIntent = var3;
      this.mExtras = var4;
   }

   public NotificationCompat$Action$Builder(NotificationCompat$Action var1) {
      this(var1.icon, var1.title, var1.actionIntent, new Bundle(NotificationCompat$Action.access$300(var1)));
   }

   public NotificationCompat$Action$Builder addExtras(Bundle var1) {
      if(var1 != null) {
         this.mExtras.putAll(var1);
      }

      return this;
   }

   public NotificationCompat$Action$Builder addRemoteInput(RemoteInput var1) {
      if(this.mRemoteInputs == null) {
         this.mRemoteInputs = new ArrayList();
      }

      this.mRemoteInputs.add(var1);
      return this;
   }

   public NotificationCompat$Action build() {
      RemoteInput[] var1;
      if(this.mRemoteInputs != null) {
         var1 = (RemoteInput[])this.mRemoteInputs.toArray(new RemoteInput[this.mRemoteInputs.size()]);
      } else {
         var1 = null;
      }

      return new NotificationCompat$Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, var1, (NotificationCompat$1)null);
   }

   public NotificationCompat$Action$Builder extend(NotificationCompat$Action$Extender var1) {
      var1.extend(this);
      return this;
   }

   public Bundle getExtras() {
      return this.mExtras;
   }
}
