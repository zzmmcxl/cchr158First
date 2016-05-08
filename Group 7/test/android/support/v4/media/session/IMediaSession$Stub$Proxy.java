package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

class IMediaSession$Stub$Proxy implements IMediaSession {
   private IBinder mRemote;

   IMediaSession$Stub$Proxy(IBinder var1) {
      this.mRemote = var1;
   }

   public void adjustVolume(int var1, int var2, String var3) throws RemoteException {
      Parcel var4 = Parcel.obtain();
      Parcel var5 = Parcel.obtain();
      boolean var7 = false;

      try {
         var7 = true;
         var4.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         var4.writeInt(var1);
         var4.writeInt(var2);
         var4.writeString(var3);
         this.mRemote.transact(11, var4, var5, 0);
         var5.readException();
         var7 = false;
      } finally {
         if(var7) {
            var5.recycle();
            var4.recycle();
         }
      }

      var5.recycle();
      var4.recycle();
   }

   public IBinder asBinder() {
      return this.mRemote;
   }

   public void fastForward() throws RemoteException {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();
      boolean var5 = false;

      try {
         var5 = true;
         var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(22, var1, var2, 0);
         var2.readException();
         var5 = false;
      } finally {
         if(var5) {
            var2.recycle();
            var1.recycle();
         }
      }

      var2.recycle();
      var1.recycle();
   }

   public Bundle getExtras() throws RemoteException {
      Parcel var2 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();
      boolean var5 = false;

      Bundle var1;
      label36: {
         try {
            var5 = true;
            var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(31, var2, var3, 0);
            var3.readException();
            if(var3.readInt() != 0) {
               var1 = (Bundle)Bundle.CREATOR.createFromParcel(var3);
               var5 = false;
               break label36;
            }

            var5 = false;
         } finally {
            if(var5) {
               var3.recycle();
               var2.recycle();
            }
         }

         var1 = null;
      }

      var3.recycle();
      var2.recycle();
      return var1;
   }

   public long getFlags() throws RemoteException {
      Parcel var3 = Parcel.obtain();
      Parcel var4 = Parcel.obtain();
      boolean var7 = false;

      long var1;
      try {
         var7 = true;
         var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(9, var3, var4, 0);
         var4.readException();
         var1 = var4.readLong();
         var7 = false;
      } finally {
         if(var7) {
            var4.recycle();
            var3.recycle();
         }
      }

      var4.recycle();
      var3.recycle();
      return var1;
   }

   public String getInterfaceDescriptor() {
      return "android.support.v4.media.session.IMediaSession";
   }

   public PendingIntent getLaunchPendingIntent() throws RemoteException {
      Parcel var2 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();
      boolean var5 = false;

      PendingIntent var1;
      label36: {
         try {
            var5 = true;
            var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(8, var2, var3, 0);
            var3.readException();
            if(var3.readInt() != 0) {
               var1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var3);
               var5 = false;
               break label36;
            }

            var5 = false;
         } finally {
            if(var5) {
               var3.recycle();
               var2.recycle();
            }
         }

         var1 = null;
      }

      var3.recycle();
      var2.recycle();
      return var1;
   }

   public MediaMetadataCompat getMetadata() throws RemoteException {
      Parcel var2 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();
      boolean var5 = false;

      MediaMetadataCompat var1;
      label36: {
         try {
            var5 = true;
            var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(27, var2, var3, 0);
            var3.readException();
            if(var3.readInt() != 0) {
               var1 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(var3);
               var5 = false;
               break label36;
            }

            var5 = false;
         } finally {
            if(var5) {
               var3.recycle();
               var2.recycle();
            }
         }

         var1 = null;
      }

      var3.recycle();
      var2.recycle();
      return var1;
   }

   public String getPackageName() throws RemoteException {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();
      boolean var5 = false;

      String var3;
      try {
         var5 = true;
         var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(6, var1, var2, 0);
         var2.readException();
         var3 = var2.readString();
         var5 = false;
      } finally {
         if(var5) {
            var2.recycle();
            var1.recycle();
         }
      }

      var2.recycle();
      var1.recycle();
      return var3;
   }

   public PlaybackStateCompat getPlaybackState() throws RemoteException {
      Parcel var2 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();
      boolean var5 = false;

      PlaybackStateCompat var1;
      label36: {
         try {
            var5 = true;
            var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(28, var2, var3, 0);
            var3.readException();
            if(var3.readInt() != 0) {
               var1 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(var3);
               var5 = false;
               break label36;
            }

            var5 = false;
         } finally {
            if(var5) {
               var3.recycle();
               var2.recycle();
            }
         }

         var1 = null;
      }

      var3.recycle();
      var2.recycle();
      return var1;
   }

   public List<MediaSessionCompat$QueueItem> getQueue() throws RemoteException {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();
      boolean var5 = false;

      ArrayList var3;
      try {
         var5 = true;
         var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(29, var1, var2, 0);
         var2.readException();
         var3 = var2.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR);
         var5 = false;
      } finally {
         if(var5) {
            var2.recycle();
            var1.recycle();
         }
      }

      var2.recycle();
      var1.recycle();
      return var3;
   }

   public CharSequence getQueueTitle() throws RemoteException {
      Parcel var2 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();
      boolean var5 = false;

      CharSequence var1;
      label36: {
         try {
            var5 = true;
            var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(30, var2, var3, 0);
            var3.readException();
            if(var3.readInt() != 0) {
               var1 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var3);
               var5 = false;
               break label36;
            }

            var5 = false;
         } finally {
            if(var5) {
               var3.recycle();
               var2.recycle();
            }
         }

         var1 = null;
      }

      var3.recycle();
      var2.recycle();
      return var1;
   }

   public int getRatingType() throws RemoteException {
      Parcel var2 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();
      boolean var6 = false;

      int var1;
      try {
         var6 = true;
         var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(32, var2, var3, 0);
         var3.readException();
         var1 = var3.readInt();
         var6 = false;
      } finally {
         if(var6) {
            var3.recycle();
            var2.recycle();
         }
      }

      var3.recycle();
      var2.recycle();
      return var1;
   }

   public String getTag() throws RemoteException {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();
      boolean var5 = false;

      String var3;
      try {
         var5 = true;
         var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(7, var1, var2, 0);
         var2.readException();
         var3 = var2.readString();
         var5 = false;
      } finally {
         if(var5) {
            var2.recycle();
            var1.recycle();
         }
      }

      var2.recycle();
      var1.recycle();
      return var3;
   }

   public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
      Parcel var2 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();
      boolean var5 = false;

      ParcelableVolumeInfo var1;
      label36: {
         try {
            var5 = true;
            var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(10, var2, var3, 0);
            var3.readException();
            if(var3.readInt() != 0) {
               var1 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(var3);
               var5 = false;
               break label36;
            }

            var5 = false;
         } finally {
            if(var5) {
               var3.recycle();
               var2.recycle();
            }
         }

         var1 = null;
      }

      var3.recycle();
      var2.recycle();
      return var1;
   }

   public boolean isTransportControlEnabled() throws RemoteException {
      boolean var2 = false;
      Parcel var3 = Parcel.obtain();
      Parcel var4 = Parcel.obtain();
      boolean var7 = false;

      int var1;
      try {
         var7 = true;
         var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(5, var3, var4, 0);
         var4.readException();
         var1 = var4.readInt();
         var7 = false;
      } finally {
         if(var7) {
            var4.recycle();
            var3.recycle();
         }
      }

      if(var1 != 0) {
         var2 = true;
      }

      var4.recycle();
      var3.recycle();
      return var2;
   }

   public void next() throws RemoteException {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();
      boolean var5 = false;

      try {
         var5 = true;
         var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(20, var1, var2, 0);
         var2.readException();
         var5 = false;
      } finally {
         if(var5) {
            var2.recycle();
            var1.recycle();
         }
      }

      var2.recycle();
      var1.recycle();
   }

   public void pause() throws RemoteException {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();
      boolean var5 = false;

      try {
         var5 = true;
         var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(18, var1, var2, 0);
         var2.readException();
         var5 = false;
      } finally {
         if(var5) {
            var2.recycle();
            var1.recycle();
         }
      }

      var2.recycle();
      var1.recycle();
   }

   public void play() throws RemoteException {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();
      boolean var5 = false;

      try {
         var5 = true;
         var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(13, var1, var2, 0);
         var2.readException();
         var5 = false;
      } finally {
         if(var5) {
            var2.recycle();
            var1.recycle();
         }
      }

      var2.recycle();
      var1.recycle();
   }

   public void playFromMediaId(String param1, Bundle param2) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void playFromSearch(String param1, Bundle param2) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void playFromUri(Uri param1, Bundle param2) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void previous() throws RemoteException {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();
      boolean var5 = false;

      try {
         var5 = true;
         var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(21, var1, var2, 0);
         var2.readException();
         var5 = false;
      } finally {
         if(var5) {
            var2.recycle();
            var1.recycle();
         }
      }

      var2.recycle();
      var1.recycle();
   }

   public void rate(RatingCompat param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void registerCallbackListener(IMediaControllerCallback param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void rewind() throws RemoteException {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();
      boolean var5 = false;

      try {
         var5 = true;
         var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(23, var1, var2, 0);
         var2.readException();
         var5 = false;
      } finally {
         if(var5) {
            var2.recycle();
            var1.recycle();
         }
      }

      var2.recycle();
      var1.recycle();
   }

   public void seekTo(long var1) throws RemoteException {
      Parcel var3 = Parcel.obtain();
      Parcel var4 = Parcel.obtain();
      boolean var7 = false;

      try {
         var7 = true;
         var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         var3.writeLong(var1);
         this.mRemote.transact(24, var3, var4, 0);
         var4.readException();
         var7 = false;
      } finally {
         if(var7) {
            var4.recycle();
            var3.recycle();
         }
      }

      var4.recycle();
      var3.recycle();
   }

   public void sendCommand(String param1, Bundle param2, MediaSessionCompat$ResultReceiverWrapper param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void sendCustomAction(String param1, Bundle param2) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public boolean sendMediaButton(KeyEvent param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void setVolumeTo(int var1, int var2, String var3) throws RemoteException {
      Parcel var4 = Parcel.obtain();
      Parcel var5 = Parcel.obtain();
      boolean var7 = false;

      try {
         var7 = true;
         var4.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         var4.writeInt(var1);
         var4.writeInt(var2);
         var4.writeString(var3);
         this.mRemote.transact(12, var4, var5, 0);
         var5.readException();
         var7 = false;
      } finally {
         if(var7) {
            var5.recycle();
            var4.recycle();
         }
      }

      var5.recycle();
      var4.recycle();
   }

   public void skipToQueueItem(long var1) throws RemoteException {
      Parcel var3 = Parcel.obtain();
      Parcel var4 = Parcel.obtain();
      boolean var7 = false;

      try {
         var7 = true;
         var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         var3.writeLong(var1);
         this.mRemote.transact(17, var3, var4, 0);
         var4.readException();
         var7 = false;
      } finally {
         if(var7) {
            var4.recycle();
            var3.recycle();
         }
      }

      var4.recycle();
      var3.recycle();
   }

   public void stop() throws RemoteException {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();
      boolean var5 = false;

      try {
         var5 = true;
         var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
         this.mRemote.transact(19, var1, var2, 0);
         var2.readException();
         var5 = false;
      } finally {
         if(var5) {
            var2.recycle();
            var1.recycle();
         }
      }

      var2.recycle();
      var1.recycle();
   }

   public void unregisterCallbackListener(IMediaControllerCallback param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }
}
