package android.support.v4.app;

import android.os.Parcelable;
import java.util.Arrays;
import android.os.Bundle;

class BundleUtil
{
    BundleUtil() {
        super();
    }
    
    public static Bundle[] getBundleArrayFromBundle(final Bundle bundle, final String s) {
        final Parcelable[] parcelableArray = bundle.getParcelableArray(s);
        if (parcelableArray instanceof Bundle[] || parcelableArray == null) {
            return (Bundle[])parcelableArray;
        }
        final Bundle[] array = (Bundle[])Arrays.<Bundle, Bundle>copyOf((Bundle[])parcelableArray, ((Bundle[])parcelableArray).length, (Class<? extends Bundle[]>)Bundle[].class);
        bundle.putParcelableArray(s, (Parcelable[])array);
        return array;
    }
}
