package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import android.support.v4.media.MediaDescriptionCompatApi21;

class MediaDescriptionCompatApi23 extends MediaDescriptionCompatApi21 {
   public static Uri getMediaUri(Object var0) {
      return ((MediaDescription)var0).getMediaUri();
   }
}
