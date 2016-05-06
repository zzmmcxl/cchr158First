package android.support.design.widget;

import android.support.annotation.NonNull;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;
import android.os.Parcel;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

public static class SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<SavedState> CREATOR;
    public Bundle menuState;
    
    static {
        CREATOR = ParcelableCompat.<SavedState>newCreator((ParcelableCompatCreatorCallbacks<SavedState>)new ParcelableCompatCreatorCallbacks<SavedState>() {
            NavigationView$SavedState$1() {
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
        this.menuState = parcel.readBundle(classLoader);
    }
    
    public SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public void writeToParcel(@NonNull final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeBundle(menuState);
    }
}
