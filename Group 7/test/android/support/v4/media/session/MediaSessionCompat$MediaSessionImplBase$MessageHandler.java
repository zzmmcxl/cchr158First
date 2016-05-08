package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command;
import android.view.KeyEvent;

class MediaSessionCompat$MediaSessionImplBase$MessageHandler extends Handler {
   private static final int KEYCODE_MEDIA_PAUSE = 127;
   private static final int KEYCODE_MEDIA_PLAY = 126;
   private static final int MSG_ADJUST_VOLUME = 16;
   private static final int MSG_COMMAND = 15;
   private static final int MSG_CUSTOM_ACTION = 13;
   private static final int MSG_FAST_FORWARD = 9;
   private static final int MSG_MEDIA_BUTTON = 14;
   private static final int MSG_NEXT = 7;
   private static final int MSG_PAUSE = 5;
   private static final int MSG_PLAY = 1;
   private static final int MSG_PLAY_MEDIA_ID = 2;
   private static final int MSG_PLAY_SEARCH = 3;
   private static final int MSG_PLAY_URI = 18;
   private static final int MSG_PREVIOUS = 8;
   private static final int MSG_RATE = 12;
   private static final int MSG_REWIND = 10;
   private static final int MSG_SEEK_TO = 11;
   private static final int MSG_SET_VOLUME = 17;
   private static final int MSG_SKIP_TO_ITEM = 4;
   private static final int MSG_STOP = 6;

   public MediaSessionCompat$MediaSessionImplBase$MessageHandler(MediaSessionCompat$MediaSessionImplBase var1, Looper var2) {
      super(var2);
      this.this$0 = var1;
   }

   private void onMediaButtonEvent(KeyEvent var1, MediaSessionCompat$Callback var2) {
      boolean var5 = true;
      if(var1 != null && var1.getAction() == 0) {
         long var6;
         if(MediaSessionCompat$MediaSessionImplBase.access$2800(this.this$0) == null) {
            var6 = 0L;
         } else {
            var6 = MediaSessionCompat$MediaSessionImplBase.access$2800(this.this$0).getActions();
         }

         switch(var1.getKeyCode()) {
         case 79:
         case 85:
            boolean var3;
            if(MediaSessionCompat$MediaSessionImplBase.access$2800(this.this$0) != null && MediaSessionCompat$MediaSessionImplBase.access$2800(this.this$0).getState() == 3) {
               var3 = true;
            } else {
               var3 = false;
            }

            boolean var4;
            if((516L & var6) != 0L) {
               var4 = true;
            } else {
               var4 = false;
            }

            if((514L & var6) == 0L) {
               var5 = false;
            }

            if(var3 && var5) {
               var2.onPause();
               return;
            }

            if(!var3 && var4) {
               var2.onPlay();
               return;
            }
            break;
         case 86:
            if((1L & var6) != 0L) {
               var2.onStop();
               return;
            }
            break;
         case 87:
            if((32L & var6) != 0L) {
               var2.onSkipToNext();
               return;
            }
            break;
         case 88:
            if((16L & var6) != 0L) {
               var2.onSkipToPrevious();
               return;
            }
            break;
         case 89:
            if((8L & var6) != 0L) {
               var2.onRewind();
               return;
            }
            break;
         case 90:
            if((64L & var6) != 0L) {
               var2.onFastForward();
               return;
            }
            break;
         case 126:
            if((4L & var6) != 0L) {
               var2.onPlay();
               return;
            }
            break;
         case 127:
            if((2L & var6) != 0L) {
               var2.onPause();
               return;
            }
            break;
         default:
            return;
         }
      }

   }

   public void handleMessage(Message var1) {
      MediaSessionCompat$Callback var2 = MediaSessionCompat$MediaSessionImplBase.access$2700(this.this$0);
      if(var2 != null) {
         switch(var1.what) {
         case 1:
            var2.onPlay();
            return;
         case 2:
            var2.onPlayFromMediaId((String)var1.obj, var1.getData());
            return;
         case 3:
            var2.onPlayFromSearch((String)var1.obj, var1.getData());
            return;
         case 4:
            var2.onSkipToQueueItem(((Long)var1.obj).longValue());
            return;
         case 5:
            var2.onPause();
            return;
         case 6:
            var2.onStop();
            return;
         case 7:
            var2.onSkipToNext();
            return;
         case 8:
            var2.onSkipToPrevious();
            return;
         case 9:
            var2.onFastForward();
            return;
         case 10:
            var2.onRewind();
            return;
         case 11:
            var2.onSeekTo(((Long)var1.obj).longValue());
            return;
         case 12:
            var2.onSetRating((RatingCompat)var1.obj);
            return;
         case 13:
            var2.onCustomAction((String)var1.obj, var1.getData());
            return;
         case 14:
            KeyEvent var5 = (KeyEvent)var1.obj;
            Intent var3 = new Intent("android.intent.action.MEDIA_BUTTON");
            var3.putExtra("android.intent.extra.KEY_EVENT", var5);
            if(!var2.onMediaButtonEvent(var3)) {
               this.onMediaButtonEvent(var5, var2);
               return;
            }
            break;
         case 15:
            MediaSessionCompat$MediaSessionImplBase$Command var4 = (MediaSessionCompat$MediaSessionImplBase$Command)var1.obj;
            var2.onCommand(var4.command, var4.extras, var4.stub);
            return;
         case 16:
            MediaSessionCompat$MediaSessionImplBase.access$1700(this.this$0, ((Integer)var1.obj).intValue(), 0);
            return;
         case 17:
            MediaSessionCompat$MediaSessionImplBase.access$1800(this.this$0, ((Integer)var1.obj).intValue(), 0);
            return;
         case 18:
            var2.onPlayFromUri((Uri)var1.obj, var1.getData());
            return;
         default:
            return;
         }
      }

   }

   public void post(int var1) {
      this.post(var1, (Object)null);
   }

   public void post(int var1, Object var2) {
      this.obtainMessage(var1, var2).sendToTarget();
   }

   public void post(int var1, Object var2, int var3) {
      this.obtainMessage(var1, var3, 0, var2).sendToTarget();
   }

   public void post(int var1, Object var2, Bundle var3) {
      Message var4 = this.obtainMessage(var1, var2);
      var4.setData(var3);
      var4.sendToTarget();
   }
}
