package android.support.v4.widget;

import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.database.Cursor;
import android.content.Context;

public class SimpleCursorAdapter extends ResourceCursorAdapter
{
    private CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;
    protected int[] mTo;
    private ViewBinder mViewBinder;
    
    public SimpleCursorAdapter(final Context context, final int n, final Cursor cursor, final String[] mOriginalFrom, final int[] mTo) {
        super(context, n, cursor);
        mStringConversionColumn = -1;
        mTo = mTo;
        this.findColumns(mOriginalFrom = mOriginalFrom);
    }
    
    public SimpleCursorAdapter(final Context context, final int n, final Cursor cursor, final String[] mOriginalFrom, final int[] mTo, final int n2) {
        super(context, n, cursor, n2);
        mStringConversionColumn = -1;
        mTo = mTo;
        this.findColumns(mOriginalFrom = mOriginalFrom);
    }
    
    private void findColumns(final String[] array) {
        if (this.mCursor != null) {
            final int length = array.length;
            if (mFrom == null || mFrom.length != length) {
                mFrom = new int[length];
            }
            for (int i = 0; i < length; ++i) {
                mFrom[i] = this.mCursor.getColumnIndexOrThrow(array[i]);
            }
        }
        else {
            mFrom = null;
        }
    }
    
    @Override
    public void bindView(final View view, final Context context, final Cursor cursor) {
        final ViewBinder mViewBinder = this.mViewBinder;
        final int length = mTo.length;
        final int[] mFrom = this.mFrom;
        final int[] mTo = this.mTo;
        for (int i = 0; i < length; ++i) {
            final View viewById = view.findViewById(mTo[i]);
            if (viewById != null) {
                boolean setViewValue = false;
                if (mViewBinder != null) {
                    setViewValue = mViewBinder.setViewValue(viewById, cursor, mFrom[i]);
                }
                if (!setViewValue) {
                    String string = cursor.getString(mFrom[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (viewById instanceof TextView) {
                        this.setViewText((TextView)viewById, string);
                    }
                    else {
                        if (!(viewById instanceof ImageView)) {
                            throw new IllegalStateException(((ImageView)viewById).getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
                        }
                        this.setViewImage((ImageView)viewById, string);
                    }
                }
            }
        }
    }
    
    public void changeCursorAndColumns(final Cursor cursor, final String[] mOriginalFrom, final int[] mTo) {
        this.mOriginalFrom = mOriginalFrom;
        this.mTo = mTo;
        super.changeCursor(cursor);
        this.findColumns(this.mOriginalFrom);
    }
    
    @Override
    public CharSequence convertToString(final Cursor cursor) {
        if (mCursorToStringConverter != null) {
            return mCursorToStringConverter.convertToString(cursor);
        }
        if (mStringConversionColumn > -1) {
            return cursor.getString(mStringConversionColumn);
        }
        return super.convertToString(cursor);
    }
    
    public CursorToStringConverter getCursorToStringConverter() {
        return mCursorToStringConverter;
    }
    
    public int getStringConversionColumn() {
        return mStringConversionColumn;
    }
    
    public ViewBinder getViewBinder() {
        return mViewBinder;
    }
    
    public void setCursorToStringConverter(final CursorToStringConverter mCursorToStringConverter) {
        this.mCursorToStringConverter = mCursorToStringConverter;
    }
    
    public void setStringConversionColumn(final int mStringConversionColumn) {
        this.mStringConversionColumn = mStringConversionColumn;
    }
    
    public void setViewBinder(final ViewBinder mViewBinder) {
        this.mViewBinder = mViewBinder;
    }
    
    public void setViewImage(final ImageView imageView, final String s) {
        try {
            imageView.setImageResource(Integer.parseInt(s));
        }
        catch (NumberFormatException ex) {
            imageView.setImageURI(Uri.parse(s));
        }
    }
    
    public void setViewText(final TextView textView, final String text) {
        textView.setText((CharSequence)text);
    }
    
    @Override
    public Cursor swapCursor(final Cursor cursor) {
        final Cursor swapCursor = super.swapCursor(cursor);
        this.findColumns(mOriginalFrom);
        return swapCursor;
    }
}
