package android.support.v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.RemoteControlClient.OnGetPlaybackPositionListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.support.v4.media.TransportMediatorCallback;
import android.support.v4.media.TransportMediatorJellybeanMR2$1;
import android.support.v4.media.TransportMediatorJellybeanMR2$2;
import android.support.v4.media.TransportMediatorJellybeanMR2$3;
import android.support.v4.media.TransportMediatorJellybeanMR2$4;
import android.support.v4.media.TransportMediatorJellybeanMR2$5;
import android.support.v4.media.TransportMediatorJellybeanMR2$6;
import android.view.View;
import android.view.ViewTreeObserver.OnWindowAttachListener;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;

class TransportMediatorJellybeanMR2 {
   OnAudioFocusChangeListener mAudioFocusChangeListener = new TransportMediatorJellybeanMR2$4(this);
   boolean mAudioFocused;
   final AudioManager mAudioManager;
   final Context mContext;
   boolean mFocused;
   final OnGetPlaybackPositionListener mGetPlaybackPositionListener = new TransportMediatorJellybeanMR2$5(this);
   final Intent mIntent;
   final BroadcastReceiver mMediaButtonReceiver = new TransportMediatorJellybeanMR2$3(this);
   PendingIntent mPendingIntent;
   int mPlayState = 0;
   final OnPlaybackPositionUpdateListener mPlaybackPositionUpdateListener = new TransportMediatorJellybeanMR2$6(this);
   final String mReceiverAction;
   final IntentFilter mReceiverFilter;
   RemoteControlClient mRemoteControl;
   final View mTargetView;
   final TransportMediatorCallback mTransportCallback;
   final OnWindowAttachListener mWindowAttachListener = new TransportMediatorJellybeanMR2$1(this);
   final OnWindowFocusChangeListener mWindowFocusListener = new TransportMediatorJellybeanMR2$2(this);

   public TransportMediatorJellybeanMR2(Context var1, AudioManager var2, View var3, TransportMediatorCallback var4) {
      this.mContext = var1;
      this.mAudioManager = var2;
      this.mTargetView = var3;
      this.mTransportCallback = var4;
      this.mReceiverAction = var1.getPackageName() + ":transport:" + System.identityHashCode(this);
      this.mIntent = new Intent(this.mReceiverAction);
      this.mIntent.setPackage(var1.getPackageName());
      this.mReceiverFilter = new IntentFilter();
      this.mReceiverFilter.addAction(this.mReceiverAction);
      this.mTargetView.getViewTreeObserver().addOnWindowAttachListener(this.mWindowAttachListener);
      this.mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusListener);
   }

   public void destroy() {
      this.windowDetached();
      this.mTargetView.getViewTreeObserver().removeOnWindowAttachListener(this.mWindowAttachListener);
      this.mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusListener);
   }

   void dropAudioFocus() {
      if(this.mAudioFocused) {
         this.mAudioFocused = false;
         this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
      }

   }

   void gainFocus() {
      if(!this.mFocused) {
         this.mFocused = true;
         this.mAudioManager.registerMediaButtonEventReceiver(this.mPendingIntent);
         this.mAudioManager.registerRemoteControlClient(this.mRemoteControl);
         if(this.mPlayState == 3) {
            this.takeAudioFocus();
         }
      }

   }

   public Object getRemoteControlClient() {
      return this.mRemoteControl;
   }

   void loseFocus() {
      this.dropAudioFocus();
      if(this.mFocused) {
         this.mFocused = false;
         this.mAudioManager.unregisterRemoteControlClient(this.mRemoteControl);
         this.mAudioManager.unregisterMediaButtonEventReceiver(this.mPendingIntent);
      }

   }

   public void pausePlaying() {
      if(this.mPlayState == 3) {
         this.mPlayState = 2;
         this.mRemoteControl.setPlaybackState(2);
      }

      this.dropAudioFocus();
   }

   public void refreshState(boolean var1, long var2, int var4) {
      if(this.mRemoteControl != null) {
         RemoteControlClient var7 = this.mRemoteControl;
         byte var6;
         if(var1) {
            var6 = 3;
         } else {
            var6 = 1;
         }

         float var5;
         if(var1) {
            var5 = 1.0F;
         } else {
            var5 = 0.0F;
         }

         var7.setPlaybackState(var6, var2, var5);
         this.mRemoteControl.setTransportControlFlags(var4);
      }

   }

   public void startPlaying() {
      if(this.mPlayState != 3) {
         this.mPlayState = 3;
         this.mRemoteControl.setPlaybackState(3);
      }

      if(this.mFocused) {
         this.takeAudioFocus();
      }

   }

   public void stopPlaying() {
      if(this.mPlayState != 1) {
         this.mPlayState = 1;
         this.mRemoteControl.setPlaybackState(1);
      }

      this.dropAudioFocus();
   }

   void takeAudioFocus() {
      if(!this.mAudioFocused) {
         this.mAudioFocused = true;
         this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
      }

   }

   void windowAttached() {
      this.mContext.registerReceiver(this.mMediaButtonReceiver, this.mReceiverFilter);
      this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, 268435456);
      this.mRemoteControl = new RemoteControlClient(this.mPendingIntent);
      this.mRemoteControl.setOnGetPlaybackPositionListener(this.mGetPlaybackPositionListener);
      this.mRemoteControl.setPlaybackPositionUpdateListener(this.mPlaybackPositionUpdateListener);
   }

   void windowDetached() {
      this.loseFocus();
      if(this.mPendingIntent != null) {
         this.mContext.unregisterReceiver(this.mMediaButtonReceiver);
         this.mPendingIntent.cancel();
         this.mPendingIntent = null;
         this.mRemoteControl = null;
      }

   }
}
