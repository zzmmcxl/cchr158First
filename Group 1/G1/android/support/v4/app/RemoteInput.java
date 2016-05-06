package android.support.v4.app;

import android.util.Log;
import android.content.Intent;
import android.os.Build$VERSION;
import android.os.Bundle;

public final class RemoteInput extends RemoteInputCompatBase.RemoteInput
{
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final Factory FACTORY;
    private static final Impl IMPL;
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    private static final String TAG = "RemoteInput";
    private final boolean mAllowFreeFormInput;
    private final CharSequence[] mChoices;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;
    
    static {
        if (Build$VERSION.SDK_INT >= 20) {
            IMPL = (Impl)new ImplApi20();
        }
        else if (Build$VERSION.SDK_INT >= 16) {
            IMPL = (Impl)new ImplJellybean();
        }
        else {
            IMPL = (Impl)new ImplBase();
        }
        FACTORY = new Factory() {
            RemoteInput$1() {
                super();
            }
            
            public RemoteInput build(final String s, final CharSequence charSequence, final CharSequence[] array, final boolean b, final Bundle bundle) {
                return new RemoteInput(s, charSequence, array, b, bundle, null);
            }
            
            @Override
            public /* bridge */ RemoteInputCompatBase.RemoteInput build(final String s, final CharSequence charSequence, final CharSequence[] array, final boolean b, final Bundle bundle) {
                return this.build(s, charSequence, array, b, bundle);
            }
            
            public RemoteInput[] newArray(final int n) {
                return new RemoteInput[n];
            }
            
            @Override
            public /* bridge */ RemoteInputCompatBase.RemoteInput[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    private RemoteInput(final String mResultKey, final CharSequence mLabel, final CharSequence[] mChoices, final boolean mAllowFreeFormInput, final Bundle mExtras) {
        super();
        mResultKey = mResultKey;
        mLabel = mLabel;
        mChoices = mChoices;
        mAllowFreeFormInput = mAllowFreeFormInput;
        mExtras = mExtras;
    }
    
    RemoteInput(final String s, final CharSequence charSequence, final CharSequence[] array, final boolean b, final Bundle bundle, final RemoteInput$1 factory) {
        this(s, charSequence, array, b, bundle);
    }
    
    public static void addResultsToIntent(final RemoteInput[] array, final Intent intent, final Bundle bundle) {
        IMPL.addResultsToIntent(array, intent, bundle);
    }
    
    public static Bundle getResultsFromIntent(final Intent intent) {
        return IMPL.getResultsFromIntent(intent);
    }
    
    public boolean getAllowFreeFormInput() {
        return mAllowFreeFormInput;
    }
    
    public CharSequence[] getChoices() {
        return mChoices;
    }
    
    public Bundle getExtras() {
        return mExtras;
    }
    
    public CharSequence getLabel() {
        return mLabel;
    }
    
    public String getResultKey() {
        return mResultKey;
    }
}
