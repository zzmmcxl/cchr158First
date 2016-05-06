package android.support.v7.app;

import android.os.Message;
import android.content.DialogInterface;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.SimpleCursorAdapter;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.widget.ListView;
import android.content.DialogInterface$OnKeyListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import android.view.LayoutInflater;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.database.Cursor;
import android.content.Context;
import android.widget.ListAdapter;

public static class AlertParams
{
    public ListAdapter mAdapter;
    public boolean mCancelable;
    public int mCheckedItem;
    public boolean[] mCheckedItems;
    public final Context mContext;
    public Cursor mCursor;
    public View mCustomTitleView;
    public boolean mForceInverseBackground;
    public Drawable mIcon;
    public int mIconAttrId;
    public int mIconId;
    public final LayoutInflater mInflater;
    public String mIsCheckedColumn;
    public boolean mIsMultiChoice;
    public boolean mIsSingleChoice;
    public CharSequence[] mItems;
    public String mLabelColumn;
    public CharSequence mMessage;
    public DialogInterface$OnClickListener mNegativeButtonListener;
    public CharSequence mNegativeButtonText;
    public DialogInterface$OnClickListener mNeutralButtonListener;
    public CharSequence mNeutralButtonText;
    public DialogInterface$OnCancelListener mOnCancelListener;
    public DialogInterface$OnMultiChoiceClickListener mOnCheckboxClickListener;
    public DialogInterface$OnClickListener mOnClickListener;
    public DialogInterface$OnDismissListener mOnDismissListener;
    public AdapterView$OnItemSelectedListener mOnItemSelectedListener;
    public DialogInterface$OnKeyListener mOnKeyListener;
    public OnPrepareListViewListener mOnPrepareListViewListener;
    public DialogInterface$OnClickListener mPositiveButtonListener;
    public CharSequence mPositiveButtonText;
    public boolean mRecycleOnMeasure;
    public CharSequence mTitle;
    public View mView;
    public int mViewLayoutResId;
    public int mViewSpacingBottom;
    public int mViewSpacingLeft;
    public int mViewSpacingRight;
    public boolean mViewSpacingSpecified;
    public int mViewSpacingTop;
    
    public AlertParams(final Context mContext) {
        super();
        this.mIconId = 0;
        this.mIconAttrId = 0;
        this.mViewSpacingSpecified = false;
        this.mCheckedItem = -1;
        this.mRecycleOnMeasure = true;
        this.mContext = mContext;
        this.mCancelable = true;
        this.mInflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
    }
    
    private void createListView(final AlertController alertController) {
        final ListView listView = (ListView)mInflater.inflate(AlertController.access$1100(alertController), (ViewGroup)null);
        Object mAdapter;
        if (mIsMultiChoice) {
            if (mCursor == null) {
                mAdapter = new ArrayAdapter<CharSequence>(mContext, AlertController.access$1200(alertController), 16908308, mItems) {
                    final /* synthetic */ AlertParams this$0;
                    final /* synthetic */ ListView val$listView;
                    
                    AlertController$AlertParams$1(final Context context, final int n, final int n2, final CharSequence[] array) {
                        this$0 = this$0;
                        super(context, n, n2, (Object[])array);
                    }
                    
                    public View getView(final int n, final View view, final ViewGroup viewGroup) {
                        final View view2 = super.getView(n, view, viewGroup);
                        if (mCheckedItems != null && mCheckedItems[n]) {
                            listView.setItemChecked(n, true);
                        }
                        return view2;
                    }
                };
            }
            else {
                mAdapter = new CursorAdapter(mContext, mCursor, false) {
                    private final int mIsCheckedIndex;
                    private final int mLabelIndex;
                    final /* synthetic */ AlertParams this$0;
                    final /* synthetic */ AlertController val$dialog;
                    final /* synthetic */ ListView val$listView;
                    
                    AlertController$AlertParams$2(final Context context, final Cursor cursor, final boolean b) {
                        this$0 = this$0;
                        super(context, cursor, b);
                    }
                    
                    {
                        final Cursor cursor2 = this.getCursor();
                        mLabelIndex = cursor2.getColumnIndexOrThrow(mLabelColumn);
                        mIsCheckedIndex = cursor2.getColumnIndexOrThrow(mIsCheckedColumn);
                    }
                    
                    public void bindView(final View view, final Context context, final Cursor cursor) {
                        boolean b = true;
                        ((CheckedTextView)view.findViewById(16908308)).setText((CharSequence)cursor.getString(mLabelIndex));
                        final ListView val$listView = listView;
                        final int position = cursor.getPosition();
                        if (cursor.getInt(mIsCheckedIndex) != (b ? 1 : 0)) {
                            b = false;
                        }
                        val$listView.setItemChecked(position, b);
                    }
                    
                    public View newView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
                        return mInflater.inflate(AlertController.access$1200(alertController), viewGroup, false);
                    }
                };
            }
        }
        else {
            int n;
            if (mIsSingleChoice) {
                n = AlertController.access$1300(alertController);
            }
            else {
                n = AlertController.access$1400(alertController);
            }
            if (mCursor != null) {
                mAdapter = new SimpleCursorAdapter(mContext, n, mCursor, new String[] { mLabelColumn }, new int[] { 16908308 });
            }
            else if (this.mAdapter != null) {
                mAdapter = this.mAdapter;
            }
            else {
                mAdapter = new CheckedItemAdapter(mContext, n, 16908308, mItems);
            }
        }
        if (mOnPrepareListViewListener != null) {
            mOnPrepareListViewListener.onPrepareListView(listView);
        }
        AlertController.access$1502(alertController, (ListAdapter)mAdapter);
        AlertController.access$1602(alertController, mCheckedItem);
        if (mOnClickListener != null) {
            listView.setOnItemClickListener((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener() {
                final /* synthetic */ AlertParams this$0;
                final /* synthetic */ AlertController val$dialog;
                
                AlertController$AlertParams$3() {
                    this$0 = this$0;
                    super();
                }
                
                public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                    mOnClickListener.onClick((DialogInterface)AlertController.access$600(alertController), n);
                    if (!mIsSingleChoice) {
                        AlertController.access$600(alertController).dismiss();
                    }
                }
            });
        }
        else if (mOnCheckboxClickListener != null) {
            listView.setOnItemClickListener((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener() {
                final /* synthetic */ AlertParams this$0;
                final /* synthetic */ AlertController val$dialog;
                final /* synthetic */ ListView val$listView;
                
                AlertController$AlertParams$4() {
                    this$0 = this$0;
                    super();
                }
                
                public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                    if (mCheckedItems != null) {
                        mCheckedItems[n] = listView.isItemChecked(n);
                    }
                    mOnCheckboxClickListener.onClick((DialogInterface)AlertController.access$600(alertController), n, listView.isItemChecked(n));
                }
            });
        }
        if (mOnItemSelectedListener != null) {
            listView.setOnItemSelectedListener(mOnItemSelectedListener);
        }
        if (mIsSingleChoice) {
            listView.setChoiceMode(1);
        }
        else if (mIsMultiChoice) {
            listView.setChoiceMode(2);
        }
        AlertController.access$1002(alertController, listView);
    }
    
    public void apply(final AlertController alertController) {
        if (mCustomTitleView != null) {
            alertController.setCustomTitle(mCustomTitleView);
        }
        else {
            if (mTitle != null) {
                alertController.setTitle(mTitle);
            }
            if (mIcon != null) {
                alertController.setIcon(mIcon);
            }
            if (mIconId != 0) {
                alertController.setIcon(mIconId);
            }
            if (mIconAttrId != 0) {
                alertController.setIcon(alertController.getIconAttributeResId(mIconAttrId));
            }
        }
        if (mMessage != null) {
            alertController.setMessage(mMessage);
        }
        if (mPositiveButtonText != null) {
            alertController.setButton(-1, mPositiveButtonText, mPositiveButtonListener, null);
        }
        if (mNegativeButtonText != null) {
            alertController.setButton(-2, mNegativeButtonText, mNegativeButtonListener, null);
        }
        if (mNeutralButtonText != null) {
            alertController.setButton(-3, mNeutralButtonText, mNeutralButtonListener, null);
        }
        if (mItems != null || mCursor != null || mAdapter != null) {
            this.createListView(alertController);
        }
        if (mView != null) {
            if (!mViewSpacingSpecified) {
                alertController.setView(mView);
                return;
            }
            alertController.setView(mView, mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight, mViewSpacingBottom);
        }
        else if (mViewLayoutResId != 0) {
            alertController.setView(mViewLayoutResId);
        }
    }
}
