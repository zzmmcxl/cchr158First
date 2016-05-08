package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat$CompatCreator;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.os.ParcelableCompatCreatorHoneycombMR2Stub;

public final class ParcelableCompat {
   public static <T> Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> var0) {
      return (Creator)(VERSION.SDK_INT >= 13?ParcelableCompatCreatorHoneycombMR2Stub.instantiate(var0):new ParcelableCompat$CompatCreator(var0));
   }
}
