package android.support.v4.media.session;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat$Token$1;
import android.support.v4.media.session.MediaSessionCompatApi21;

public final class MediaSessionCompat$Token implements Parcelable {
   public static final Creator<MediaSessionCompat$Token> CREATOR = new MediaSessionCompat$Token$1();
   private final Object mInner;

   MediaSessionCompat$Token(Object var1) {
      this.mInner = var1;
   }

   public static MediaSessionCompat$Token fromToken(Object var0) {
      return var0 != null && VERSION.SDK_INT >= 21?new MediaSessionCompat$Token(MediaSessionCompatApi21.verifyToken(var0)):null;
   }

   public int describeContents() {
      return 0;
   }

   public Object getToken() {
      return this.mInner;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(VERSION.SDK_INT >= 21) {
         var1.writeParcelable((Parcelable)this.mInner, var2);
      } else {
         var1.writeStrongBinder((IBinder)this.mInner);
      }
   }
}
