package android.support.v4.media.session;

import android.media.MediaDescription;
import android.media.session.MediaSession.QueueItem;

class MediaSessionCompatApi21$QueueItem {
   public static Object createItem(Object var0, long var1) {
      return new QueueItem((MediaDescription)var0, var1);
   }

   public static Object getDescription(Object var0) {
      return ((QueueItem)var0).getDescription();
   }

   public static long getQueueId(Object var0) {
      return ((QueueItem)var0).getQueueId();
   }
}
