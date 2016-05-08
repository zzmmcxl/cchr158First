package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback$Stub;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.IMediaSession$Stub$Proxy;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

public abstract class IMediaSession$Stub extends Binder implements IMediaSession {
   private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
   static final int TRANSACTION_adjustVolume = 11;
   static final int TRANSACTION_fastForward = 22;
   static final int TRANSACTION_getExtras = 31;
   static final int TRANSACTION_getFlags = 9;
   static final int TRANSACTION_getLaunchPendingIntent = 8;
   static final int TRANSACTION_getMetadata = 27;
   static final int TRANSACTION_getPackageName = 6;
   static final int TRANSACTION_getPlaybackState = 28;
   static final int TRANSACTION_getQueue = 29;
   static final int TRANSACTION_getQueueTitle = 30;
   static final int TRANSACTION_getRatingType = 32;
   static final int TRANSACTION_getTag = 7;
   static final int TRANSACTION_getVolumeAttributes = 10;
   static final int TRANSACTION_isTransportControlEnabled = 5;
   static final int TRANSACTION_next = 20;
   static final int TRANSACTION_pause = 18;
   static final int TRANSACTION_play = 13;
   static final int TRANSACTION_playFromMediaId = 14;
   static final int TRANSACTION_playFromSearch = 15;
   static final int TRANSACTION_playFromUri = 16;
   static final int TRANSACTION_previous = 21;
   static final int TRANSACTION_rate = 25;
   static final int TRANSACTION_registerCallbackListener = 3;
   static final int TRANSACTION_rewind = 23;
   static final int TRANSACTION_seekTo = 24;
   static final int TRANSACTION_sendCommand = 1;
   static final int TRANSACTION_sendCustomAction = 26;
   static final int TRANSACTION_sendMediaButton = 2;
   static final int TRANSACTION_setVolumeTo = 12;
   static final int TRANSACTION_skipToQueueItem = 17;
   static final int TRANSACTION_stop = 19;
   static final int TRANSACTION_unregisterCallbackListener = 4;

   public IMediaSession$Stub() {
      this.attachInterface(this, "android.support.v4.media.session.IMediaSession");
   }

   public static IMediaSession asInterface(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1 = var0.queryLocalInterface("android.support.v4.media.session.IMediaSession");
         return (IMediaSession)(var1 != null && var1 instanceof IMediaSession?(IMediaSession)var1:new IMediaSession$Stub$Proxy(var0));
      }
   }

   public IBinder asBinder() {
      return this;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      byte var6 = 0;
      byte var5 = 0;
      boolean var7;
      String var10;
      byte var12;
      Bundle var13;
      String var21;
      switch(var1) {
      case 1:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         String var11 = var2.readString();
         Bundle var25;
         if(var2.readInt() != 0) {
            var25 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var25 = null;
         }

         MediaSessionCompat$ResultReceiverWrapper var24;
         if(var2.readInt() != 0) {
            var24 = (MediaSessionCompat$ResultReceiverWrapper)MediaSessionCompat$ResultReceiverWrapper.CREATOR.createFromParcel(var2);
         } else {
            var24 = null;
         }

         this.sendCommand(var11, var25, var24);
         var3.writeNoException();
         return true;
      case 2:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         KeyEvent var22;
         if(var2.readInt() != 0) {
            var22 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(var2);
         } else {
            var22 = null;
         }

         var7 = this.sendMediaButton(var22);
         var3.writeNoException();
         var12 = var5;
         if(var7) {
            var12 = 1;
         }

         var3.writeInt(var12);
         return true;
      case 3:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.registerCallbackListener(IMediaControllerCallback$Stub.asInterface(var2.readStrongBinder()));
         var3.writeNoException();
         return true;
      case 4:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.unregisterCallbackListener(IMediaControllerCallback$Stub.asInterface(var2.readStrongBinder()));
         var3.writeNoException();
         return true;
      case 5:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         var7 = this.isTransportControlEnabled();
         var3.writeNoException();
         var12 = var6;
         if(var7) {
            var12 = 1;
         }

         var3.writeInt(var12);
         return true;
      case 6:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         var21 = this.getPackageName();
         var3.writeNoException();
         var3.writeString(var21);
         return true;
      case 7:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         var21 = this.getTag();
         var3.writeNoException();
         var3.writeString(var21);
         return true;
      case 8:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         PendingIntent var20 = this.getLaunchPendingIntent();
         var3.writeNoException();
         if(var20 != null) {
            var3.writeInt(1);
            var20.writeToParcel(var3, 1);
            return true;
         }

         var3.writeInt(0);
         return true;
      case 9:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         long var8 = this.getFlags();
         var3.writeNoException();
         var3.writeLong(var8);
         return true;
      case 10:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         ParcelableVolumeInfo var19 = this.getVolumeAttributes();
         var3.writeNoException();
         if(var19 != null) {
            var3.writeInt(1);
            var19.writeToParcel(var3, 1);
            return true;
         }

         var3.writeInt(0);
         return true;
      case 11:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.adjustVolume(var2.readInt(), var2.readInt(), var2.readString());
         var3.writeNoException();
         return true;
      case 12:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.setVolumeTo(var2.readInt(), var2.readInt(), var2.readString());
         var3.writeNoException();
         return true;
      case 13:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.play();
         var3.writeNoException();
         return true;
      case 14:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         var10 = var2.readString();
         if(var2.readInt() != 0) {
            var13 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var13 = null;
         }

         this.playFromMediaId(var10, var13);
         var3.writeNoException();
         return true;
      case 15:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         var10 = var2.readString();
         if(var2.readInt() != 0) {
            var13 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var13 = null;
         }

         this.playFromSearch(var10, var13);
         var3.writeNoException();
         return true;
      case 16:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         Uri var23;
         if(var2.readInt() != 0) {
            var23 = (Uri)Uri.CREATOR.createFromParcel(var2);
         } else {
            var23 = null;
         }

         if(var2.readInt() != 0) {
            var13 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var13 = null;
         }

         this.playFromUri(var23, var13);
         var3.writeNoException();
         return true;
      case 17:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.skipToQueueItem(var2.readLong());
         var3.writeNoException();
         return true;
      case 18:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.pause();
         var3.writeNoException();
         return true;
      case 19:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.stop();
         var3.writeNoException();
         return true;
      case 20:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.next();
         var3.writeNoException();
         return true;
      case 21:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.previous();
         var3.writeNoException();
         return true;
      case 22:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.fastForward();
         var3.writeNoException();
         return true;
      case 23:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.rewind();
         var3.writeNoException();
         return true;
      case 24:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         this.seekTo(var2.readLong());
         var3.writeNoException();
         return true;
      case 25:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         RatingCompat var18;
         if(var2.readInt() != 0) {
            var18 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(var2);
         } else {
            var18 = null;
         }

         this.rate(var18);
         var3.writeNoException();
         return true;
      case 26:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         var10 = var2.readString();
         if(var2.readInt() != 0) {
            var13 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var13 = null;
         }

         this.sendCustomAction(var10, var13);
         var3.writeNoException();
         return true;
      case 27:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         MediaMetadataCompat var17 = this.getMetadata();
         var3.writeNoException();
         if(var17 != null) {
            var3.writeInt(1);
            var17.writeToParcel(var3, 1);
            return true;
         }

         var3.writeInt(0);
         return true;
      case 28:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         PlaybackStateCompat var16 = this.getPlaybackState();
         var3.writeNoException();
         if(var16 != null) {
            var3.writeInt(1);
            var16.writeToParcel(var3, 1);
            return true;
         }

         var3.writeInt(0);
         return true;
      case 29:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         List var15 = this.getQueue();
         var3.writeNoException();
         var3.writeTypedList(var15);
         return true;
      case 30:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         CharSequence var14 = this.getQueueTitle();
         var3.writeNoException();
         if(var14 != null) {
            var3.writeInt(1);
            TextUtils.writeToParcel(var14, var3, 1);
            return true;
         }

         var3.writeInt(0);
         return true;
      case 31:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         var13 = this.getExtras();
         var3.writeNoException();
         if(var13 != null) {
            var3.writeInt(1);
            var13.writeToParcel(var3, 1);
            return true;
         }

         var3.writeInt(0);
         return true;
      case 32:
         var2.enforceInterface("android.support.v4.media.session.IMediaSession");
         var1 = this.getRatingType();
         var3.writeNoException();
         var3.writeInt(var1);
         return true;
      case 1598968902:
         var3.writeString("android.support.v4.media.session.IMediaSession");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
