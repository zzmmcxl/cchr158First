package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction$1;
import android.support.v4.media.session.PlaybackStateCompatApi21$CustomAction;
import android.text.TextUtils;

public final class PlaybackStateCompat$CustomAction implements Parcelable {
   public static final Creator<PlaybackStateCompat$CustomAction> CREATOR = new PlaybackStateCompat$CustomAction$1();
   private final String mAction;
   private Object mCustomActionObj;
   private final Bundle mExtras;
   private final int mIcon;
   private final CharSequence mName;

   private PlaybackStateCompat$CustomAction(Parcel var1) {
      this.mAction = var1.readString();
      this.mName = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.mIcon = var1.readInt();
      this.mExtras = var1.readBundle();
   }

   private PlaybackStateCompat$CustomAction(String var1, CharSequence var2, int var3, Bundle var4) {
      this.mAction = var1;
      this.mName = var2;
      this.mIcon = var3;
      this.mExtras = var4;
   }

   public static PlaybackStateCompat$CustomAction fromCustomAction(Object var0) {
      if(var0 != null && VERSION.SDK_INT >= 21) {
         PlaybackStateCompat$CustomAction var1 = new PlaybackStateCompat$CustomAction(PlaybackStateCompatApi21$CustomAction.getAction(var0), PlaybackStateCompatApi21$CustomAction.getName(var0), PlaybackStateCompatApi21$CustomAction.getIcon(var0), PlaybackStateCompatApi21$CustomAction.getExtras(var0));
         var1.mCustomActionObj = var0;
         return var1;
      } else {
         return null;
      }
   }

   public int describeContents() {
      return 0;
   }

   public String getAction() {
      return this.mAction;
   }

   public Object getCustomAction() {
      if(this.mCustomActionObj == null && VERSION.SDK_INT >= 21) {
         this.mCustomActionObj = PlaybackStateCompatApi21$CustomAction.newInstance(this.mAction, this.mName, this.mIcon, this.mExtras);
         return this.mCustomActionObj;
      } else {
         return this.mCustomActionObj;
      }
   }

   public Bundle getExtras() {
      return this.mExtras;
   }

   public int getIcon() {
      return this.mIcon;
   }

   public CharSequence getName() {
      return this.mName;
   }

   public String toString() {
      return "Action:mName=\'" + this.mName + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.mAction);
      TextUtils.writeToParcel(this.mName, var1, var2);
      var1.writeInt(this.mIcon);
      var1.writeBundle(this.mExtras);
   }
}
