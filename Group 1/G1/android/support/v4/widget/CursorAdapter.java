package android.support.v4.widget;

import android.os.Handler;
import android.database.ContentObserver;
import android.widget.Filter;
import android.view.ViewGroup;
import android.view.View;
import android.widget.FilterQueryProvider;
import android.database.DataSetObserver;
import android.database.Cursor;
import android.content.Context;
import android.widget.Filterable;
import android.widget.BaseAdapter;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilterClient
{
    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected ChangeObserver mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected CursorFilter mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;
    
    public CursorAdapter(final Context context, final Cursor cursor) {
        super();
        this.init(context, cursor, 1);
    }
    
    public CursorAdapter(final Context context, final Cursor cursor, final int n) {
        super();
        this.init(context, cursor, n);
    }
    
    public CursorAdapter(final Context context, final Cursor cursor, final boolean b) {
        super();
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 2;
        }
        this.init(context, cursor, n);
    }
    
    public abstract void bindView(final View p0, final Context p1, final Cursor p2);
    
    public void changeCursor(final Cursor cursor) {
        final Cursor swapCursor = this.swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }
    
    public CharSequence convertToString(final Cursor cursor) {
        if (cursor == null) {
            return "";
        }
        return cursor.toString();
    }
    
    public int getCount() {
        if (mDataValid && mCursor != null) {
            return mCursor.getCount();
        }
        return 0;
    }
    
    public Cursor getCursor() {
        return mCursor;
    }
    
    public View getDropDownView(final int n, final View view, final ViewGroup viewGroup) {
        if (mDataValid) {
            mCursor.moveToPosition(n);
            View dropDownView;
            if (view == null) {
                dropDownView = this.newDropDownView(mContext, mCursor, viewGroup);
            }
            else {
                dropDownView = view;
            }
            this.bindView(dropDownView, mContext, mCursor);
            return dropDownView;
        }
        return null;
    }
    
    public Filter getFilter() {
        if (mCursorFilter == null) {
            mCursorFilter = new CursorFilter((CursorFilter.CursorFilterClient)this);
        }
        return mCursorFilter;
    }
    
    public FilterQueryProvider getFilterQueryProvider() {
        return mFilterQueryProvider;
    }
    
    public Object getItem(final int n) {
        if (mDataValid && mCursor != null) {
            mCursor.moveToPosition(n);
            return mCursor;
        }
        return null;
    }
    
    public long getItemId(final int n) {
        long long1 = 0L;
        if (mDataValid && mCursor != null && mCursor.moveToPosition(n)) {
            long1 = mCursor.getLong(mRowIDColumn);
        }
        return long1;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        if (!mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!mCursor.moveToPosition(n)) {
            throw new IllegalStateException("couldn't move cursor to position " + n);
        }
        View view2;
        if (view == null) {
            view2 = this.newView(mContext, mCursor, viewGroup);
        }
        else {
            view2 = view;
        }
        this.bindView(view2, mContext, mCursor);
        return view2;
    }
    
    public boolean hasStableIds() {
        return true;
    }
    
    void init(final Context mContext, final Cursor mCursor, int n) {
        boolean b = true;
        if ((n & 0x1) == (b ? 1 : 0)) {
            n |= 0x2;
            mAutoRequery = b;
        }
        else {
            mAutoRequery = false;
        }
        if (mCursor == null) {
            b = false;
        }
        this.mCursor = mCursor;
        mDataValid = b;
        this.mContext = mContext;
        int columnIndexOrThrow;
        if (b) {
            columnIndexOrThrow = mCursor.getColumnIndexOrThrow("_id");
        }
        else {
            columnIndexOrThrow = -1;
        }
        mRowIDColumn = columnIndexOrThrow;
        if ((n & 0x2) == 0x2) {
            mChangeObserver = new ChangeObserver();
            mDataSetObserver = new MyDataSetObserver(this);
        }
        else {
            mChangeObserver = null;
            mDataSetObserver = null;
        }
        if (b) {
            if (mChangeObserver != null) {
                mCursor.registerContentObserver((ContentObserver)mChangeObserver);
            }
            if (mDataSetObserver != null) {
                mCursor.registerDataSetObserver(mDataSetObserver);
            }
        }
    }
    
    @Deprecated
    protected void init(final Context context, final Cursor cursor, final boolean b) {
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 2;
        }
        this.init(context, cursor, n);
    }
    
    public View newDropDownView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        return this.newView(context, cursor, viewGroup);
    }
    
    public abstract View newView(final Context p0, final Cursor p1, final ViewGroup p2);
    
    protected void onContentChanged() {
        if (mAutoRequery && mCursor != null && !mCursor.isClosed()) {
            mDataValid = mCursor.requery();
        }
    }
    
    public Cursor runQueryOnBackgroundThread(final CharSequence charSequence) {
        if (mFilterQueryProvider != null) {
            return mFilterQueryProvider.runQuery(charSequence);
        }
        return mCursor;
    }
    
    public void setFilterQueryProvider(final FilterQueryProvider mFilterQueryProvider) {
        this.mFilterQueryProvider = mFilterQueryProvider;
    }
    
    public Cursor swapCursor(final Cursor mCursor) {
        if (mCursor == this.mCursor) {
            return null;
        }
        final Cursor mCursor2 = this.mCursor;
        if (mCursor2 != null) {
            if (mChangeObserver != null) {
                mCursor2.unregisterContentObserver((ContentObserver)mChangeObserver);
            }
            if (mDataSetObserver != null) {
                mCursor2.unregisterDataSetObserver(mDataSetObserver);
            }
        }
        if ((this.mCursor = mCursor) != null) {
            if (mChangeObserver != null) {
                mCursor.registerContentObserver((ContentObserver)mChangeObserver);
            }
            if (mDataSetObserver != null) {
                mCursor.registerDataSetObserver(mDataSetObserver);
            }
            mRowIDColumn = mCursor.getColumnIndexOrThrow("_id");
            mDataValid = true;
            this.notifyDataSetChanged();
            return mCursor2;
        }
        mRowIDColumn = -1;
        mDataValid = false;
        this.notifyDataSetInvalidated();
        return mCursor2;
    }
}
