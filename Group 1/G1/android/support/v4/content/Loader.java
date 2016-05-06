package android.support.v4.content;

import android.os.Handler;
import android.database.ContentObserver;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.support.v4.util.DebugUtils;
import android.content.Context;

public class Loader<D>
{
    boolean mAbandoned;
    boolean mContentChanged;
    Context mContext;
    int mId;
    OnLoadCompleteListener<D> mListener;
    OnLoadCanceledListener<D> mOnLoadCanceledListener;
    boolean mProcessingChange;
    boolean mReset;
    boolean mStarted;
    
    public Loader(final Context context) {
        super();
        mStarted = false;
        mAbandoned = false;
        mReset = true;
        mContentChanged = false;
        mProcessingChange = false;
        mContext = context.getApplicationContext();
    }
    
    public void abandon() {
        mAbandoned = true;
        this.onAbandon();
    }
    
    public boolean cancelLoad() {
        return this.onCancelLoad();
    }
    
    public void commitContentChanged() {
        mProcessingChange = false;
    }
    
    public String dataToString(final D n) {
        final StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(n, sb);
        sb.append("}");
        return sb.toString();
    }
    
    public void deliverCancellation() {
        if (mOnLoadCanceledListener != null) {
            mOnLoadCanceledListener.onLoadCanceled(this);
        }
    }
    
    public void deliverResult(final D n) {
        if (mListener != null) {
            mListener.onLoadComplete(this, n);
        }
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mId=");
        printWriter.print(mId);
        printWriter.print(" mListener=");
        printWriter.println(mListener);
        if (mStarted || mContentChanged || mProcessingChange) {
            printWriter.print(s);
            printWriter.print("mStarted=");
            printWriter.print(mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(mProcessingChange);
        }
        if (mAbandoned || mReset) {
            printWriter.print(s);
            printWriter.print("mAbandoned=");
            printWriter.print(mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(mReset);
        }
    }
    
    public void forceLoad() {
        this.onForceLoad();
    }
    
    public Context getContext() {
        return mContext;
    }
    
    public int getId() {
        return mId;
    }
    
    public boolean isAbandoned() {
        return mAbandoned;
    }
    
    public boolean isReset() {
        return mReset;
    }
    
    public boolean isStarted() {
        return mStarted;
    }
    
    protected void onAbandon() {
    }
    
    protected boolean onCancelLoad() {
        return false;
    }
    
    public void onContentChanged() {
        if (mStarted) {
            this.forceLoad();
            return;
        }
        mContentChanged = true;
    }
    
    protected void onForceLoad() {
    }
    
    protected void onReset() {
    }
    
    protected void onStartLoading() {
    }
    
    protected void onStopLoading() {
    }
    
    public void registerListener(final int mId, final OnLoadCompleteListener<D> mListener) {
        if (this.mListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mListener = mListener;
        this.mId = mId;
    }
    
    public void registerOnLoadCanceledListener(final OnLoadCanceledListener<D> mOnLoadCanceledListener) {
        if (this.mOnLoadCanceledListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mOnLoadCanceledListener = mOnLoadCanceledListener;
    }
    
    public void reset() {
        this.onReset();
        mReset = true;
        mStarted = false;
        mAbandoned = false;
        mContentChanged = false;
        mProcessingChange = false;
    }
    
    public void rollbackContentChanged() {
        if (mProcessingChange) {
            mContentChanged = true;
        }
    }
    
    public final void startLoading() {
        mStarted = true;
        mReset = false;
        mAbandoned = false;
        this.onStartLoading();
    }
    
    public void stopLoading() {
        mStarted = false;
        this.onStopLoading();
    }
    
    public boolean takeContentChanged() {
        final boolean mContentChanged = this.mContentChanged;
        this.mContentChanged = false;
        mProcessingChange |= mContentChanged;
        return mContentChanged;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(mId);
        sb.append("}");
        return sb.toString();
    }
    
    public void unregisterListener(final OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (mListener == null) {
            throw new IllegalStateException("No listener register");
        }
        if (mListener != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        mListener = null;
    }
    
    public void unregisterOnLoadCanceledListener(final OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (mOnLoadCanceledListener == null) {
            throw new IllegalStateException("No listener register");
        }
        if (mOnLoadCanceledListener != onLoadCanceledListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        mOnLoadCanceledListener = null;
    }
}
