package android.support.v4.media;

import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewTreeObserver$OnWindowFocusChangeListener;
import android.view.ViewTreeObserver$OnWindowAttachListener;
import android.view.View;
import android.media.RemoteControlClient;
import android.content.IntentFilter;
import android.media.RemoteControlClient$OnPlaybackPositionUpdateListener;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.media.RemoteControlClient$OnGetPlaybackPositionListener;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager$OnAudioFocusChangeListener;

class TransportMediatorJellybeanMR2
{
    AudioManager$OnAudioFocusChangeListener mAudioFocusChangeListener;
    boolean mAudioFocused;
    final AudioManager mAudioManager;
    final Context mContext;
    boolean mFocused;
    final RemoteControlClient$OnGetPlaybackPositionListener mGetPlaybackPositionListener;
    final Intent mIntent;
    final BroadcastReceiver mMediaButtonReceiver;
    PendingIntent mPendingIntent;
    int mPlayState;
    final RemoteControlClient$OnPlaybackPositionUpdateListener mPlaybackPositionUpdateListener;
    final String mReceiverAction;
    final IntentFilter mReceiverFilter;
    RemoteControlClient mRemoteControl;
    final View mTargetView;
    final TransportMediatorCallback mTransportCallback;
    final ViewTreeObserver$OnWindowAttachListener mWindowAttachListener;
    final ViewTreeObserver$OnWindowFocusChangeListener mWindowFocusListener;
    
    public TransportMediatorJellybeanMR2(final Context mContext, final AudioManager mAudioManager, final View mTargetView, final TransportMediatorCallback mTransportCallback) {
        super();
        mWindowAttachListener = (ViewTreeObserver$OnWindowAttachListener)new ViewTreeObserver$OnWindowAttachListener() {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
            
            TransportMediatorJellybeanMR2$1() {
                this$0 = this$0;
                super();
            }
            
            public void onWindowAttached() {
                this$0.windowAttached();
            }
            
            public void onWindowDetached() {
                this$0.windowDetached();
            }
        };
        mWindowFocusListener = (ViewTreeObserver$OnWindowFocusChangeListener)new ViewTreeObserver$OnWindowFocusChangeListener() {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
            
            TransportMediatorJellybeanMR2$2() {
                this$0 = this$0;
                super();
            }
            
            public void onWindowFocusChanged(final boolean b) {
                if (b) {
                    this$0.gainFocus();
                    return;
                }
                this$0.loseFocus();
            }
        };
        mMediaButtonReceiver = new BroadcastReceiver() {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
            
            TransportMediatorJellybeanMR2$3() {
                this$0 = this$0;
                super();
            }
            
            public void onReceive(final Context context, final Intent intent) {
                try {
                    mTransportCallback.handleKey((KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
                }
                catch (ClassCastException ex) {
                    Log.w("TransportController", (Throwable)ex);
                }
            }
        };
        mAudioFocusChangeListener = (AudioManager$OnAudioFocusChangeListener)new AudioManager$OnAudioFocusChangeListener() {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
            
            TransportMediatorJellybeanMR2$4() {
                this$0 = this$0;
                super();
            }
            
            public void onAudioFocusChange(final int n) {
                mTransportCallback.handleAudioFocusChange(n);
            }
        };
        mGetPlaybackPositionListener = (RemoteControlClient$OnGetPlaybackPositionListener)new RemoteControlClient$OnGetPlaybackPositionListener() {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
            
            TransportMediatorJellybeanMR2$5() {
                this$0 = this$0;
                super();
            }
            
            public long onGetPlaybackPosition() {
                return mTransportCallback.getPlaybackPosition();
            }
        };
        mPlaybackPositionUpdateListener = (RemoteControlClient$OnPlaybackPositionUpdateListener)new RemoteControlClient$OnPlaybackPositionUpdateListener() {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;
            
            TransportMediatorJellybeanMR2$6() {
                this$0 = this$0;
                super();
            }
            
            public void onPlaybackPositionUpdate(final long n) {
                mTransportCallback.playbackPositionUpdate(n);
            }
        };
        mPlayState = 0;
        mContext = mContext;
        mAudioManager = mAudioManager;
        mTargetView = mTargetView;
        mTransportCallback = mTransportCallback;
        mReceiverAction = mContext.getPackageName() + ":transport:" + System.identityHashCode((Object)this);
        (mIntent = new Intent(mReceiverAction)).setPackage(mContext.getPackageName());
        (mReceiverFilter = new IntentFilter()).addAction(mReceiverAction);
        mTargetView.getViewTreeObserver().addOnWindowAttachListener(mWindowAttachListener);
        mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(mWindowFocusListener);
    }
    
    public void destroy() {
        this.windowDetached();
        mTargetView.getViewTreeObserver().removeOnWindowAttachListener(mWindowAttachListener);
        mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(mWindowFocusListener);
    }
    
    void dropAudioFocus() {
        if (mAudioFocused) {
            mAudioFocused = false;
            mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }
    
    void gainFocus() {
        if (!mFocused) {
            mFocused = true;
            mAudioManager.registerMediaButtonEventReceiver(mPendingIntent);
            mAudioManager.registerRemoteControlClient(mRemoteControl);
            if (mPlayState == 3) {
                this.takeAudioFocus();
            }
        }
    }
    
    public Object getRemoteControlClient() {
        return mRemoteControl;
    }
    
    void loseFocus() {
        this.dropAudioFocus();
        if (mFocused) {
            mFocused = false;
            mAudioManager.unregisterRemoteControlClient(mRemoteControl);
            mAudioManager.unregisterMediaButtonEventReceiver(mPendingIntent);
        }
    }
    
    public void pausePlaying() {
        if (mPlayState == 3) {
            mPlayState = 2;
            mRemoteControl.setPlaybackState(2);
        }
        this.dropAudioFocus();
    }
    
    public void refreshState(final boolean b, final long n, final int transportControlFlags) {
        if (mRemoteControl != null) {
            final RemoteControlClient mRemoteControl = this.mRemoteControl;
            int n2;
            if (b) {
                n2 = 3;
            }
            else {
                n2 = 1;
            }
            float n3;
            if (b) {
                n3 = 1.0f;
            }
            else {
                n3 = 0.0f;
            }
            mRemoteControl.setPlaybackState(n2, n, n3);
            this.mRemoteControl.setTransportControlFlags(transportControlFlags);
        }
    }
    
    public void startPlaying() {
        if (mPlayState != 3) {
            mPlayState = 3;
            mRemoteControl.setPlaybackState(3);
        }
        if (mFocused) {
            this.takeAudioFocus();
        }
    }
    
    public void stopPlaying() {
        if (mPlayState != 1) {
            mPlayState = 1;
            mRemoteControl.setPlaybackState(1);
        }
        this.dropAudioFocus();
    }
    
    void takeAudioFocus() {
        if (!mAudioFocused) {
            mAudioFocused = true;
            mAudioManager.requestAudioFocus(mAudioFocusChangeListener, 3, 1);
        }
    }
    
    void windowAttached() {
        mContext.registerReceiver(mMediaButtonReceiver, mReceiverFilter);
        mPendingIntent = PendingIntent.getBroadcast(mContext, 0, mIntent, 268435456);
        (mRemoteControl = new RemoteControlClient(mPendingIntent)).setOnGetPlaybackPositionListener(mGetPlaybackPositionListener);
        mRemoteControl.setPlaybackPositionUpdateListener(mPlaybackPositionUpdateListener);
    }
    
    void windowDetached() {
        this.loseFocus();
        if (mPendingIntent != null) {
            mContext.unregisterReceiver(mMediaButtonReceiver);
            mPendingIntent.cancel();
            mPendingIntent = null;
            mRemoteControl = null;
        }
    }
}
