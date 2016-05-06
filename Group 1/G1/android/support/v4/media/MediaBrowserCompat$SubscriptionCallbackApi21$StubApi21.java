package android.support.v4.media;

import java.util.Iterator;
import java.util.ArrayList;
import android.os.Parcel;
import java.util.List;
import android.support.annotation.NonNull;

private class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback
{
    final /* synthetic */ SubscriptionCallbackApi21 this$0;
    
    private StubApi21(final SubscriptionCallbackApi21 this$0) {
        this$0 = this$0;
        super();
    }
    
    StubApi21(final SubscriptionCallbackApi21 subscriptionCallbackApi21, final MediaBrowserCompat$1 object) {
        this(subscriptionCallbackApi21);
    }
    
    @Override
    public void onChildrenLoaded(@NonNull final String s, final List<Parcel> list) {
        List<MediaItem> list2 = null;
        if (list != null) {
            list2 = new ArrayList<MediaItem>();
            for (final Parcel parcel : list) {
                parcel.setDataPosition(0);
                list2.add((MediaItem)MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
        }
        if (SubscriptionCallbackApi21.access$400(this$0) != null) {
            this$0.onChildrenLoaded(s, MediaBrowserCompatUtils.applyOptions(list2, SubscriptionCallbackApi21.access$400(this$0)), SubscriptionCallbackApi21.access$400(this$0));
            return;
        }
        this$0.onChildrenLoaded(s, list2);
    }
    
    @Override
    public void onError(@NonNull final String s) {
        if (SubscriptionCallbackApi21.access$400(this$0) != null) {
            this$0.onError(s, SubscriptionCallbackApi21.access$400(this$0));
            return;
        }
        this$0.onError(s);
    }
}
