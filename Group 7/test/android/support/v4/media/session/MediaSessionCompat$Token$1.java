package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat$Token;

final class MediaSessionCompat$Token$1 implements Creator<MediaSessionCompat$Token> {
   public MediaSessionCompat$Token createFromParcel(Parcel var1) {
      Object var2;
      if(VERSION.SDK_INT >= 21) {
         var2 = var1.readParcelable((ClassLoader)null);
      } else {
         var2 = var1.readStrongBinder();
      }

      return new MediaSessionCompat$Token(var2);
   }

   public MediaSessionCompat$Token[] newArray(int var1) {
      return new MediaSessionCompat$Token[var1];
   }
}
