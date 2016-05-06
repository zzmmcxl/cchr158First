package android.support.v4.media.session;

import android.media.Rating;
import android.content.Intent;
import android.os.ResultReceiver;
import android.os.Bundle;
import android.media.session.MediaSession$Callback;

static class CallbackProxy<T extends Callback> extends MediaSession$Callback
{
    protected final T mCallback;
    
    public CallbackProxy(final T mCallback) {
        super();
        this.mCallback = mCallback;
    }
    
    public void onCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        ((Callback)mCallback).onCommand(s, bundle, resultReceiver);
    }
    
    public void onCustomAction(final String s, final Bundle bundle) {
        ((Callback)mCallback).onCustomAction(s, bundle);
    }
    
    public void onFastForward() {
        ((Callback)mCallback).onFastForward();
    }
    
    public boolean onMediaButtonEvent(final Intent intent) {
        return ((Callback)mCallback).onMediaButtonEvent(intent) || super.onMediaButtonEvent(intent);
    }
    
    public void onPause() {
        ((Callback)mCallback).onPause();
    }
    
    public void onPlay() {
        ((Callback)mCallback).onPlay();
    }
    
    public void onPlayFromMediaId(final String s, final Bundle bundle) {
        ((Callback)mCallback).onPlayFromMediaId(s, bundle);
    }
    
    public void onPlayFromSearch(final String s, final Bundle bundle) {
        ((Callback)mCallback).onPlayFromSearch(s, bundle);
    }
    
    public void onRewind() {
        ((Callback)mCallback).onRewind();
    }
    
    public void onSeekTo(final long n) {
        ((MediaSessionCompatApi18.Callback)mCallback).onSeekTo(n);
    }
    
    public void onSetRating(final Rating rating) {
        ((MediaSessionCompatApi19.Callback)mCallback).onSetRating(rating);
    }
    
    public void onSkipToNext() {
        ((Callback)mCallback).onSkipToNext();
    }
    
    public void onSkipToPrevious() {
        ((Callback)mCallback).onSkipToPrevious();
    }
    
    public void onSkipToQueueItem(final long n) {
        ((Callback)mCallback).onSkipToQueueItem(n);
    }
    
    public void onStop() {
        ((Callback)mCallback).onStop();
    }
}
