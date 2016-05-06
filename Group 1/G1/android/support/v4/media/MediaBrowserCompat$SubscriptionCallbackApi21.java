package android.support.v4.media;

import java.util.Iterator;
import java.util.ArrayList;
import android.os.Parcel;
import java.util.List;
import android.support.annotation.NonNull;
import android.os.Bundle;

static class SubscriptionCallbackApi21 extends SubscriptionCallback
{
    private Bundle mOptions;
    SubscriptionCallback mSubscriptionCallback;
    private final Object mSubscriptionCallbackObj;
    
    public SubscriptionCallbackApi21(final SubscriptionCallback mSubscriptionCallback, final Bundle mOptions) {
        super();
        this.mSubscriptionCallback = mSubscriptionCallback;
        this.mOptions = mOptions;
        this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback((MediaBrowserCompatApi21.SubscriptionCallback)new StubApi21(this));
    }
    
    static /* synthetic */ Object access$1800(final SubscriptionCallbackApi21 subscriptionCallbackApi21) {
        return subscriptionCallbackApi21.mSubscriptionCallbackObj;
    }
    
    static /* synthetic */ Bundle access$400(final SubscriptionCallbackApi21 subscriptionCallbackApi21) {
        return subscriptionCallbackApi21.mOptions;
    }
    
    @Override
    public void onChildrenLoaded(@NonNull final String s, final List<MediaItem> list) {
        mSubscriptionCallback.onChildrenLoaded(s, list);
    }
    
    @Override
    public void onChildrenLoaded(@NonNull final String s, final List<MediaItem> list, @NonNull final Bundle bundle) {
        mSubscriptionCallback.onChildrenLoaded(s, list, bundle);
    }
    
    @Override
    public void onError(@NonNull final String s) {
        mSubscriptionCallback.onError(s);
    }
    
    @Override
    public void onError(@NonNull final String s, @NonNull final Bundle bundle) {
        mSubscriptionCallback.onError(s, bundle);
    }
}
