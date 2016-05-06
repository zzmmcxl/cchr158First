package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;
import android.net.Uri;
import android.content.Intent;
import android.os.ResultReceiver;
import android.os.Bundle;
import android.os.Build$VERSION;

public abstract static class Callback
{
    final Object mCallbackObj;
    
    public Callback() {
        super();
        if (Build$VERSION.SDK_INT >= 23) {
            this.mCallbackObj = MediaSessionCompatApi23.createCallback((MediaSessionCompatApi23.Callback)new StubApi23(this));
            return;
        }
        if (Build$VERSION.SDK_INT >= 21) {
            this.mCallbackObj = MediaSessionCompatApi21.createCallback((MediaSessionCompatApi21.Callback)new StubApi21(this));
            return;
        }
        this.mCallbackObj = null;
    }
    
    public void onCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
    }
    
    public void onCustomAction(final String s, final Bundle bundle) {
    }
    
    public void onFastForward() {
    }
    
    public boolean onMediaButtonEvent(final Intent intent) {
        return false;
    }
    
    public void onPause() {
    }
    
    public void onPlay() {
    }
    
    public void onPlayFromMediaId(final String s, final Bundle bundle) {
    }
    
    public void onPlayFromSearch(final String s, final Bundle bundle) {
    }
    
    public void onPlayFromUri(final Uri uri, final Bundle bundle) {
    }
    
    public void onRewind() {
    }
    
    public void onSeekTo(final long n) {
    }
    
    public void onSetRating(final RatingCompat ratingCompat) {
    }
    
    public void onSkipToNext() {
    }
    
    public void onSkipToPrevious() {
    }
    
    public void onSkipToQueueItem(final long n) {
    }
    
    public void onStop() {
    }
}
