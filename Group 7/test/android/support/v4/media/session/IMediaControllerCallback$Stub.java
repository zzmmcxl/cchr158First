package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaControllerCallback$Stub$Proxy;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;

public abstract class IMediaControllerCallback$Stub extends Binder implements IMediaControllerCallback {
   private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
   static final int TRANSACTION_onEvent = 1;
   static final int TRANSACTION_onExtrasChanged = 7;
   static final int TRANSACTION_onMetadataChanged = 4;
   static final int TRANSACTION_onPlaybackStateChanged = 3;
   static final int TRANSACTION_onQueueChanged = 5;
   static final int TRANSACTION_onQueueTitleChanged = 6;
   static final int TRANSACTION_onSessionDestroyed = 2;
   static final int TRANSACTION_onVolumeInfoChanged = 8;

   public IMediaControllerCallback$Stub() {
      this.attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
   }

   public static IMediaControllerCallback asInterface(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1 = var0.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
         return (IMediaControllerCallback)(var1 != null && var1 instanceof IMediaControllerCallback?(IMediaControllerCallback)var1:new IMediaControllerCallback$Stub$Proxy(var0));
      }
   }

   public IBinder asBinder() {
      return this;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      Bundle var7;
      switch(var1) {
      case 1:
         var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
         String var6 = var2.readString();
         if(var2.readInt() != 0) {
            var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var7 = null;
         }

         this.onEvent(var6, var7);
         return true;
      case 2:
         var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
         this.onSessionDestroyed();
         return true;
      case 3:
         var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
         PlaybackStateCompat var10;
         if(var2.readInt() != 0) {
            var10 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(var2);
         } else {
            var10 = null;
         }

         this.onPlaybackStateChanged(var10);
         return true;
      case 4:
         var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
         MediaMetadataCompat var9;
         if(var2.readInt() != 0) {
            var9 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(var2);
         } else {
            var9 = null;
         }

         this.onMetadataChanged(var9);
         return true;
      case 5:
         var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
         this.onQueueChanged(var2.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR));
         return true;
      case 6:
         var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
         CharSequence var8;
         if(var2.readInt() != 0) {
            var8 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var2);
         } else {
            var8 = null;
         }

         this.onQueueTitleChanged(var8);
         return true;
      case 7:
         var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
         if(var2.readInt() != 0) {
            var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var7 = null;
         }

         this.onExtrasChanged(var7);
         return true;
      case 8:
         var2.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
         ParcelableVolumeInfo var5;
         if(var2.readInt() != 0) {
            var5 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(var2);
         } else {
            var5 = null;
         }

         this.onVolumeInfoChanged(var5);
         return true;
      case 1598968902:
         var3.writeString("android.support.v4.media.session.IMediaControllerCallback");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
