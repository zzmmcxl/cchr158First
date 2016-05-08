package android.support.v4.media;

import android.os.Parcel;
import android.support.annotation.NonNull;
import java.util.List;

interface MediaBrowserCompatApi21$SubscriptionCallback {
   void onChildrenLoaded(@NonNull String var1, List<Parcel> var2);

   void onError(@NonNull String var1);
}
