package android.support.v4.media.session;

import android.support.v4.media.RatingCompat;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

static class TransportControlsBase extends TransportControls
{
    private IMediaSession mBinder;
    
    public TransportControlsBase(final IMediaSession mBinder) {
        super();
        this.mBinder = mBinder;
    }
    
    @Override
    public void fastForward() {
        try {
            mBinder.fastForward();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in fastForward. " + ex);
        }
    }
    
    @Override
    public void pause() {
        try {
            mBinder.pause();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in pause. " + ex);
        }
    }
    
    @Override
    public void play() {
        try {
            mBinder.play();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in play. " + ex);
        }
    }
    
    @Override
    public void playFromMediaId(final String s, final Bundle bundle) {
        try {
            mBinder.playFromMediaId(s, bundle);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in playFromMediaId. " + ex);
        }
    }
    
    @Override
    public void playFromSearch(final String s, final Bundle bundle) {
        try {
            mBinder.playFromSearch(s, bundle);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in playFromSearch. " + ex);
        }
    }
    
    @Override
    public void playFromUri(final Uri uri, final Bundle bundle) {
        try {
            mBinder.playFromUri(uri, bundle);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in playFromUri. " + ex);
        }
    }
    
    @Override
    public void rewind() {
        try {
            mBinder.rewind();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in rewind. " + ex);
        }
    }
    
    @Override
    public void seekTo(final long n) {
        try {
            mBinder.seekTo(n);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in seekTo. " + ex);
        }
    }
    
    @Override
    public void sendCustomAction(final PlaybackStateCompat.CustomAction customAction, final Bundle bundle) {
        this.sendCustomAction(customAction.getAction(), bundle);
    }
    
    @Override
    public void sendCustomAction(final String s, final Bundle bundle) {
        try {
            mBinder.sendCustomAction(s, bundle);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in sendCustomAction. " + ex);
        }
    }
    
    @Override
    public void setRating(final RatingCompat ratingCompat) {
        try {
            mBinder.rate(ratingCompat);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in setRating. " + ex);
        }
    }
    
    @Override
    public void skipToNext() {
        try {
            mBinder.next();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in skipToNext. " + ex);
        }
    }
    
    @Override
    public void skipToPrevious() {
        try {
            mBinder.previous();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in skipToPrevious. " + ex);
        }
    }
    
    @Override
    public void skipToQueueItem(final long n) {
        try {
            mBinder.skipToQueueItem(n);
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in skipToQueueItem. " + ex);
        }
    }
    
    @Override
    public void stop() {
        try {
            mBinder.stop();
        }
        catch (RemoteException ex) {
            Log.e("MediaControllerCompat", "Dead object in stop. " + ex);
        }
    }
}
