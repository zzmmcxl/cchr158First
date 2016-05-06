package android.support.v4.media;

import android.os.Parcel;
import java.util.List;
import android.support.annotation.NonNull;

interface SubscriptionCallback
{
    void onChildrenLoaded(@NonNull final String p0, final List<Parcel> p1);
    
    void onError(@NonNull final String p0);
}
