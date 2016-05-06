package android.support.v4.media;

import java.util.ArrayList;
import android.os.Bundle;
import java.util.List;

private static class Subscription
{
    private final List<SubscriptionCallback> mCallbacks;
    private final List<Bundle> mOptionsList;
    
    public Subscription() {
        super();
        this.mCallbacks = new ArrayList<SubscriptionCallback>();
        this.mOptionsList = new ArrayList<Bundle>();
    }
    
    public SubscriptionCallback getCallback(final Bundle bundle) {
        for (int i = 0; i < mOptionsList.size(); ++i) {
            if (MediaBrowserCompatUtils.areSameOptions(mOptionsList.get(i), bundle)) {
                return mCallbacks.get(i);
            }
        }
        return null;
    }
    
    public List<SubscriptionCallback> getCallbacks() {
        return mCallbacks;
    }
    
    public List<Bundle> getOptionsList() {
        return mOptionsList;
    }
    
    public boolean isEmpty() {
        return mCallbacks.isEmpty();
    }
    
    public boolean remove(final Bundle bundle) {
        for (int i = 0; i < mOptionsList.size(); ++i) {
            if (MediaBrowserCompatUtils.areSameOptions(mOptionsList.get(i), bundle)) {
                mCallbacks.remove(i);
                mOptionsList.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public void setCallbackForOptions(final SubscriptionCallback subscriptionCallback, final Bundle bundle) {
        for (int i = 0; i < mOptionsList.size(); ++i) {
            if (MediaBrowserCompatUtils.areSameOptions(mOptionsList.get(i), bundle)) {
                mCallbacks.set(i, subscriptionCallback);
                return;
            }
        }
        mCallbacks.add(subscriptionCallback);
        mOptionsList.add(bundle);
    }
}
