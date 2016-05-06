package android.support.design.internal;

import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.SparseArray;

public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable
{
    public static final Parcelable$Creator<ParcelableSparseArray> CREATOR;
    
    static {
        CREATOR = ParcelableCompat.<ParcelableSparseArray>newCreator((ParcelableCompatCreatorCallbacks<ParcelableSparseArray>)new ParcelableCompatCreatorCallbacks<ParcelableSparseArray>() {
            ParcelableSparseArray$1() {
                super();
            }
            
            @Override
            public ParcelableSparseArray createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                return new ParcelableSparseArray(parcel, classLoader);
            }
            
            @Override
            public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                return this.createFromParcel(parcel, classLoader);
            }
            
            @Override
            public ParcelableSparseArray[] newArray(final int n) {
                return new ParcelableSparseArray[n];
            }
            
            @Override
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        });
    }
    
    public ParcelableSparseArray() {
        super();
    }
    
    public ParcelableSparseArray(final Parcel parcel, final ClassLoader classLoader) {
        super();
        final int int1 = parcel.readInt();
        final int[] array = new int[int1];
        parcel.readIntArray(array);
        final Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        for (int i = 0; i < int1; ++i) {
            this.put(array[i], (Object)parcelableArray[i]);
        }
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int size = this.size();
        final int[] array = new int[size];
        final Parcelable[] array2 = new Parcelable[size];
        for (int i = 0; i < size; ++i) {
            array[i] = this.keyAt(i);
            array2[i] = (Parcelable)this.valueAt(i);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(array);
        parcel.writeParcelableArray(array2, n);
    }
}
