package android.support.design.widget;

import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Parcelable;
import android.util.SparseArray;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

protected static class SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    SparseArray<Parcelable> behaviorStates;
    
    static {
        CREATOR = ParcelableCompat.<SavedState>newCreator((ParcelableCompatCreatorCallbacks<SavedState>)new ParcelableCompatCreatorCallbacks<SavedState>() {
            CoordinatorLayout$SavedState$1() {
                super();
            }
            
            @Override
            public SavedState createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
            
            @Override
            public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                return this.createFromParcel(parcel, classLoader);
            }
            
            @Override
            public SavedState[] newArray(final int n) {
                return new SavedState[n];
            }
            
            @Override
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        });
    }
    
    public SavedState(final Parcel parcel, final ClassLoader classLoader) {
        super(parcel);
        final int int1 = parcel.readInt();
        final int[] array = new int[int1];
        parcel.readIntArray(array);
        final Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        this.behaviorStates = (SparseArray<Parcelable>)new SparseArray(int1);
        for (int i = 0; i < int1; ++i) {
            this.behaviorStates.append(array[i], (Object)parcelableArray[i]);
        }
    }
    
    public SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        int size;
        if (behaviorStates != null) {
            size = behaviorStates.size();
        }
        else {
            size = 0;
        }
        parcel.writeInt(size);
        final int[] array = new int[size];
        final Parcelable[] array2 = new Parcelable[size];
        for (int i = 0; i < size; ++i) {
            array[i] = behaviorStates.keyAt(i);
            array2[i] = (Parcelable)behaviorStates.valueAt(i);
        }
        parcel.writeIntArray(array);
        parcel.writeParcelableArray(array2, n);
    }
}
