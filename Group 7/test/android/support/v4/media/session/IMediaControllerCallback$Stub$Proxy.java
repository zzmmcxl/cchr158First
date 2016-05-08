package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.List;

class IMediaControllerCallback$Stub$Proxy implements IMediaControllerCallback {
   private IBinder mRemote;

   IMediaControllerCallback$Stub$Proxy(IBinder var1) {
      this.mRemote = var1;
   }

   public IBinder asBinder() {
      return this.mRemote;
   }

   public String getInterfaceDescriptor() {
      return "android.support.v4.media.session.IMediaControllerCallback";
   }

   public void onEvent(String param1, Bundle param2) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void onExtrasChanged(Bundle param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void onMetadataChanged(MediaMetadataCompat param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void onPlaybackStateChanged(PlaybackStateCompat param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void onQueueChanged(List<MediaSessionCompat$QueueItem> var1) throws RemoteException {
      Parcel var2 = Parcel.obtain();
      boolean var4 = false;

      try {
         var4 = true;
         var2.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
         var2.writeTypedList(var1);
         this.mRemote.transact(5, var2, (Parcel)null, 1);
         var4 = false;
      } finally {
         if(var4) {
            var2.recycle();
         }
      }

      var2.recycle();
   }

   public void onQueueTitleChanged(CharSequence param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void onSessionDestroyed() throws RemoteException {
      Parcel var1 = Parcel.obtain();
      boolean var4 = false;

      try {
         var4 = true;
         var1.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
         this.mRemote.transact(2, var1, (Parcel)null, 1);
         var4 = false;
      } finally {
         if(var4) {
            var1.recycle();
         }
      }

      var1.recycle();
   }

   public void onVolumeInfoChanged(ParcelableVolumeInfo param1) throws RemoteException {
      // $FF: Couldn't be decompiled
   }
}
