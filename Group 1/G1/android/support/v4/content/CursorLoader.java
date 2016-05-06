package android.support.v4.content;

import android.database.ContentObserver;
import android.support.v4.os.OperationCanceledException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.content.Context;
import android.net.Uri;
import android.support.v4.os.CancellationSignal;
import android.database.Cursor;

public class CursorLoader extends AsyncTaskLoader<Cursor>
{
    CancellationSignal mCancellationSignal;
    Cursor mCursor;
    final ForceLoadContentObserver mObserver;
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;
    Uri mUri;
    
    public CursorLoader(final Context context) {
        super(context);
        mObserver = (Loader)this.new ForceLoadContentObserver();
    }
    
    public CursorLoader(final Context context, final Uri mUri, final String[] mProjection, final String mSelection, final String[] mSelectionArgs, final String mSortOrder) {
        super(context);
        mObserver = (Loader)this.new ForceLoadContentObserver();
        mUri = mUri;
        mProjection = mProjection;
        mSelection = mSelection;
        mSelectionArgs = mSelectionArgs;
        mSortOrder = mSortOrder;
    }
    
    @Override
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            if (mCancellationSignal != null) {
                mCancellationSignal.cancel();
            }
        }
    }
    
    @Override
    public void deliverResult(final Cursor mCursor) {
        if (this.isReset()) {
            if (mCursor != null) {
                mCursor.close();
            }
        }
        else {
            final Cursor mCursor2 = this.mCursor;
            this.mCursor = mCursor;
            if (this.isStarted()) {
                super.deliverResult(mCursor);
            }
            if (mCursor2 != null && mCursor2 != mCursor && !mCursor2.isClosed()) {
                mCursor2.close();
            }
        }
    }
    
    @Override
    public /* bridge */ void deliverResult(final Object o) {
        this.deliverResult((Cursor)o);
    }
    
    @Override
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.dump(s, fileDescriptor, printWriter, array);
        printWriter.print(s);
        printWriter.print("mUri=");
        printWriter.println(mUri);
        printWriter.print(s);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString((Object[])mProjection));
        printWriter.print(s);
        printWriter.print("mSelection=");
        printWriter.println(mSelection);
        printWriter.print(s);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString((Object[])mSelectionArgs));
        printWriter.print(s);
        printWriter.print("mSortOrder=");
        printWriter.println(mSortOrder);
        printWriter.print(s);
        printWriter.print("mCursor=");
        printWriter.println(mCursor);
        printWriter.print(s);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }
    
    public String[] getProjection() {
        return mProjection;
    }
    
    public String getSelection() {
        return mSelection;
    }
    
    public String[] getSelectionArgs() {
        return mSelectionArgs;
    }
    
    public String getSortOrder() {
        return mSortOrder;
    }
    
    public Uri getUri() {
        return mUri;
    }
    
    @Override
    public Cursor loadInBackground() {
        synchronized (this) {
            if (this.isLoadInBackgroundCanceled()) {
                throw new OperationCanceledException();
            }
        }
        mCancellationSignal = new CancellationSignal();
        // monitorexit(this)
        Cursor query;
        try {
            query = ContentResolverCompat.query(this.getContext().getContentResolver(), mUri, mProjection, mSelection, mSelectionArgs, mSortOrder, mCancellationSignal);
            Label_0095: {
                if (query == null) {
                    break Label_0095;
                }
                try {
                    query.getCount();
                    query.registerContentObserver((ContentObserver)mObserver);
                    // monitorenter(this)
                    final CursorLoader cursorLoader = this;
                    final CancellationSignal cancellationSignal = null;
                    mCancellationSignal = cancellationSignal;
                    return query;
                }
                catch (RuntimeException ex) {
                    query.close();
                    throw ex;
                }
            }
        }
        finally {
            synchronized (this) {
                mCancellationSignal = null;
            }
            // monitorexit(this)
        }
        try {
            final CursorLoader cursorLoader = this;
            final CancellationSignal cancellationSignal = null;
            mCancellationSignal = cancellationSignal;
            return query;
        }
        finally {}
    }
    
    @Override
    public /* bridge */ Object loadInBackground() {
        return this.loadInBackground();
    }
    
    @Override
    public void onCanceled(final Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }
    
    @Override
    public /* bridge */ void onCanceled(final Object o) {
        this.onCanceled((Cursor)o);
    }
    
    @Override
    protected void onReset() {
        super.onReset();
        this.onStopLoading();
        if (mCursor != null && !mCursor.isClosed()) {
            mCursor.close();
        }
        mCursor = null;
    }
    
    @Override
    protected void onStartLoading() {
        if (mCursor != null) {
            this.deliverResult(mCursor);
        }
        if (this.takeContentChanged() || mCursor == null) {
            this.forceLoad();
        }
    }
    
    @Override
    protected void onStopLoading() {
        this.cancelLoad();
    }
    
    public void setProjection(final String[] mProjection) {
        this.mProjection = mProjection;
    }
    
    public void setSelection(final String mSelection) {
        this.mSelection = mSelection;
    }
    
    public void setSelectionArgs(final String[] mSelectionArgs) {
        this.mSelectionArgs = mSelectionArgs;
    }
    
    public void setSortOrder(final String mSortOrder) {
        this.mSortOrder = mSortOrder;
    }
    
    public void setUri(final Uri mUri) {
        this.mUri = mUri;
    }
}
