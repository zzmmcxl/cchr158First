package android.support.v4.media;

import android.os.Bundle;
import java.util.List;
import android.support.annotation.NonNull;

public abstract static class SubscriptionCallback
{
    public SubscriptionCallback() {
        super();
    }
    
    public void onChildrenLoaded(@NonNull final String s, final List<MediaItem> list) {
    }
    
    public void onChildrenLoaded(@NonNull final String s, final List<MediaItem> list, @NonNull final Bundle bundle) {
    }
    
    public void onError(@NonNull final String s) {
    }
    
    public void onError(@NonNull final String s, @NonNull final Bundle bundle) {
    }
}
