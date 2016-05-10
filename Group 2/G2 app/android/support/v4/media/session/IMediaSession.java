package android.support.v4.media.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public interface IMediaSession extends IInterface {
   void adjustVolume(int var1, int var2, String var3) throws RemoteException;

   void fastForward() throws RemoteException;

   Bundle getExtras() throws RemoteException;

   long getFlags() throws RemoteException;

   PendingIntent getLaunchPendingIntent() throws RemoteException;

   MediaMetadataCompat getMetadata() throws RemoteException;

   String getPackageName() throws RemoteException;

   PlaybackStateCompat getPlaybackState() throws RemoteException;

   List getQueue() throws RemoteException;

   CharSequence getQueueTitle() throws RemoteException;

   int getRatingType() throws RemoteException;

   String getTag() throws RemoteException;

   ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

   boolean isTransportControlEnabled() throws RemoteException;

   void next() throws RemoteException;

   void pause() throws RemoteException;

   void play() throws RemoteException;

   void playFromMediaId(String var1, Bundle var2) throws RemoteException;

   void playFromSearch(String var1, Bundle var2) throws RemoteException;

   void previous() throws RemoteException;

   void rate(RatingCompat var1) throws RemoteException;

   void registerCallbackListener(IMediaControllerCallback var1) throws RemoteException;

   void rewind() throws RemoteException;

   void seekTo(long var1) throws RemoteException;

   void sendCommand(String var1, Bundle var2, MediaSessionCompat.ResultReceiverWrapper var3) throws RemoteException;

   void sendCustomAction(String var1, Bundle var2) throws RemoteException;

   boolean sendMediaButton(KeyEvent var1) throws RemoteException;

   void setVolumeTo(int var1, int var2, String var3) throws RemoteException;

   void skipToQueueItem(long var1) throws RemoteException;

   void stop() throws RemoteException;

   void unregisterCallbackListener(IMediaControllerCallback var1) throws RemoteException;

   public abstract static class Stub extends Binder implements IMediaSession {
      private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
      static final int TRANSACTION_adjustVolume = 11;
      static final int TRANSACTION_fastForward = 21;
      static final int TRANSACTION_getExtras = 30;
      static final int TRANSACTION_getFlags = 9;
      static final int TRANSACTION_getLaunchPendingIntent = 8;
      static final int TRANSACTION_getMetadata = 26;
      static final int TRANSACTION_getPackageName = 6;
      static final int TRANSACTION_getPlaybackState = 27;
      static final int TRANSACTION_getQueue = 28;
      static final int TRANSACTION_getQueueTitle = 29;
      static final int TRANSACTION_getRatingType = 31;
      static final int TRANSACTION_getTag = 7;
      static final int TRANSACTION_getVolumeAttributes = 10;
      static final int TRANSACTION_isTransportControlEnabled = 5;
      static final int TRANSACTION_next = 19;
      static final int TRANSACTION_pause = 17;
      static final int TRANSACTION_play = 13;
      static final int TRANSACTION_playFromMediaId = 14;
      static final int TRANSACTION_playFromSearch = 15;
      static final int TRANSACTION_previous = 20;
      static final int TRANSACTION_rate = 24;
      static final int TRANSACTION_registerCallbackListener = 3;
      static final int TRANSACTION_rewind = 22;
      static final int TRANSACTION_seekTo = 23;
      static final int TRANSACTION_sendCommand = 1;
      static final int TRANSACTION_sendCustomAction = 25;
      static final int TRANSACTION_sendMediaButton = 2;
      static final int TRANSACTION_setVolumeTo = 12;
      static final int TRANSACTION_skipToQueueItem = 16;
      static final int TRANSACTION_stop = 18;
      static final int TRANSACTION_unregisterCallbackListener = 4;

      public Stub() {
         this.attachInterface(this, "android.support.v4.media.session.IMediaSession");
      }

      public static IMediaSession asInterface(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            return (IMediaSession)(var1 != null && var1 instanceof IMediaSession?(IMediaSession)var1:new IMediaSession.Proxy(var0));
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
            Bundle var24;
            if(var2.readInt() != 0) {
               var24 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var24 = null;
            }

            MediaSessionCompat.ResultReceiverWrapper var23;
            if(var2.readInt() != 0) {
               var23 = (MediaSessionCompat.ResultReceiverWrapper)MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(var2);
            } else {
               var23 = null;
            }

            this.sendCommand(var11, var24, var23);
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
            this.registerCallbackListener(IMediaControllerCallback.Stub.asInterface(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.unregisterCallbackListener(IMediaControllerCallback.Stub.asInterface(var2.readStrongBinder()));
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
            this.skipToQueueItem(var2.readLong());
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.pause();
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.stop();
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.next();
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.previous();
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.fastForward();
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.rewind();
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            this.seekTo(var2.readLong());
            var3.writeNoException();
            return true;
         case 24:
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
         case 25:
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
         case 26:
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
         case 27:
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
         case 28:
            var2.enforceInterface("android.support.v4.media.session.IMediaSession");
            List var15 = this.getQueue();
            var3.writeNoException();
            var3.writeTypedList(var15);
            return true;
         case 29:
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
         case 30:
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
         case 31:
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

   private static class Proxy implements IMediaSession {
      private IBinder mRemote;

      Proxy(IBinder var1) {
         this.mRemote = var1;
      }

      public void adjustVolume(int var1, int var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            var4.writeInt(var1);
            var4.writeInt(var2);
            var4.writeString(var3);
            this.mRemote.transact(11, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      public IBinder asBinder() {
         return this.mRemote;
      }

      public void fastForward() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(21, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

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
               this.mRemote.transact(30, var2, var3, 0);
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

         long var1;
         try {
            var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(9, var3, var4, 0);
            var4.readException();
            var1 = var4.readLong();
         } finally {
            var4.recycle();
            var3.recycle();
         }

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
               this.mRemote.transact(26, var2, var3, 0);
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

         String var3;
         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(6, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

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
               this.mRemote.transact(27, var2, var3, 0);
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

      public List getQueue() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         ArrayList var3;
         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(28, var1, var2, 0);
            var2.readException();
            var3 = var2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
         } finally {
            var2.recycle();
            var1.recycle();
         }

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
               this.mRemote.transact(29, var2, var3, 0);
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

         int var1;
         try {
            var2.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(31, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public String getTag() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(7, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

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

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(19, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void pause() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(17, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void play() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(13, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void playFromMediaId(String param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void playFromSearch(String param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void previous() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(20, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

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

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(22, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void seekTo(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            var3.writeLong(var1);
            this.mRemote.transact(23, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void sendCommand(String param1, Bundle param2, MediaSessionCompat.ResultReceiverWrapper param3) throws RemoteException {
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

         try {
            var4.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            var4.writeInt(var1);
            var4.writeInt(var2);
            var4.writeString(var3);
            this.mRemote.transact(12, var4, var5, 0);
            var5.readException();
         } finally {
            var5.recycle();
            var4.recycle();
         }

      }

      public void skipToQueueItem(long var1) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            var3.writeLong(var1);
            this.mRemote.transact(16, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }

      public void stop() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(18, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void unregisterCallbackListener(IMediaControllerCallback param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
