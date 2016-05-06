package android.support.v4.media;

import android.view.KeyEvent;
import android.os.SystemClock;

public abstract class TransportPerformer
{
    static final int AUDIOFOCUS_GAIN = 1;
    static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    static final int AUDIOFOCUS_LOSS = -1;
    static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
    static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;
    
    public TransportPerformer() {
        super();
    }
    
    public void onAudioFocusChange(final int n) {
        int n2 = 0;
        switch (n) {
            case -1:
                n2 = 127;
                break;
        }
        if (n2 != 0) {
            final long uptimeMillis = SystemClock.uptimeMillis();
            this.onMediaButtonDown(n2, new KeyEvent(uptimeMillis, uptimeMillis, 0, n2, 0));
            this.onMediaButtonUp(n2, new KeyEvent(uptimeMillis, uptimeMillis, 1, n2, 0));
        }
    }
    
    public int onGetBufferPercentage() {
        return 100;
    }
    
    public abstract long onGetCurrentPosition();
    
    public abstract long onGetDuration();
    
    public int onGetTransportControlFlags() {
        return 60;
    }
    
    public abstract boolean onIsPlaying();
    
    public boolean onMediaButtonDown(final int n, final KeyEvent keyEvent) {
        switch (n) {
            default:
                return true;
            case 126:
                this.onStart();
                return true;
            case 127:
                this.onPause();
                return true;
            case 86:
                this.onStop();
                return true;
            case 79:
            case 85:
                if (this.onIsPlaying()) {
                    this.onPause();
                    return true;
                }
                this.onStart();
                return true;
        }
    }
    
    public boolean onMediaButtonUp(final int n, final KeyEvent keyEvent) {
        return true;
    }
    
    public abstract void onPause();
    
    public abstract void onSeekTo(final long p0);
    
    public abstract void onStart();
    
    public abstract void onStop();
}
