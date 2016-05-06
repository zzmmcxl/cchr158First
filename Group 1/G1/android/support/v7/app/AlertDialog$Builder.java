package android.support.v7.app;

import android.content.DialogInterface$OnKeyListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.util.TypedValue;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.database.Cursor;
import android.content.DialogInterface$OnClickListener;
import android.widget.ListAdapter;
import android.view.ContextThemeWrapper;
import android.content.Context;

public static class Builder
{
    private final AlertController.AlertParams P;
    private int mTheme;
    
    public Builder(final Context context) {
        this(context, AlertDialog.resolveDialogTheme(context, 0));
    }
    
    public Builder(final Context context, final int mTheme) {
        super();
        this.P = new AlertController.AlertParams((Context)new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, mTheme)));
        this.mTheme = mTheme;
    }
    
    public AlertDialog create() {
        final AlertDialog alertDialog = new AlertDialog(P.mContext, mTheme, false);
        P.apply(AlertDialog.access$000(alertDialog));
        alertDialog.setCancelable(P.mCancelable);
        if (P.mCancelable) {
            alertDialog.setCanceledOnTouchOutside(true);
        }
        alertDialog.setOnCancelListener(P.mOnCancelListener);
        alertDialog.setOnDismissListener(P.mOnDismissListener);
        if (P.mOnKeyListener != null) {
            alertDialog.setOnKeyListener(P.mOnKeyListener);
        }
        return alertDialog;
    }
    
    public Context getContext() {
        return P.mContext;
    }
    
    public Builder setAdapter(final ListAdapter mAdapter, final DialogInterface$OnClickListener mOnClickListener) {
        P.mAdapter = mAdapter;
        P.mOnClickListener = mOnClickListener;
        return this;
    }
    
    public Builder setCancelable(final boolean mCancelable) {
        P.mCancelable = mCancelable;
        return this;
    }
    
    public Builder setCursor(final Cursor mCursor, final DialogInterface$OnClickListener mOnClickListener, final String mLabelColumn) {
        P.mCursor = mCursor;
        P.mLabelColumn = mLabelColumn;
        P.mOnClickListener = mOnClickListener;
        return this;
    }
    
    public Builder setCustomTitle(final View mCustomTitleView) {
        P.mCustomTitleView = mCustomTitleView;
        return this;
    }
    
    public Builder setIcon(final int mIconId) {
        P.mIconId = mIconId;
        return this;
    }
    
    public Builder setIcon(final Drawable mIcon) {
        P.mIcon = mIcon;
        return this;
    }
    
    public Builder setIconAttribute(final int n) {
        final TypedValue typedValue = new TypedValue();
        P.mContext.getTheme().resolveAttribute(n, typedValue, true);
        P.mIconId = typedValue.resourceId;
        return this;
    }
    
    public Builder setInverseBackgroundForced(final boolean mForceInverseBackground) {
        P.mForceInverseBackground = mForceInverseBackground;
        return this;
    }
    
    public Builder setItems(final int n, final DialogInterface$OnClickListener mOnClickListener) {
        P.mItems = P.mContext.getResources().getTextArray(n);
        P.mOnClickListener = mOnClickListener;
        return this;
    }
    
    public Builder setItems(final CharSequence[] mItems, final DialogInterface$OnClickListener mOnClickListener) {
        P.mItems = mItems;
        P.mOnClickListener = mOnClickListener;
        return this;
    }
    
    public Builder setMessage(final int n) {
        P.mMessage = P.mContext.getText(n);
        return this;
    }
    
    public Builder setMessage(final CharSequence mMessage) {
        P.mMessage = mMessage;
        return this;
    }
    
    public Builder setMultiChoiceItems(final int n, final boolean[] mCheckedItems, final DialogInterface$OnMultiChoiceClickListener mOnCheckboxClickListener) {
        P.mItems = P.mContext.getResources().getTextArray(n);
        P.mOnCheckboxClickListener = mOnCheckboxClickListener;
        P.mCheckedItems = mCheckedItems;
        P.mIsMultiChoice = true;
        return this;
    }
    
    public Builder setMultiChoiceItems(final Cursor mCursor, final String mIsCheckedColumn, final String mLabelColumn, final DialogInterface$OnMultiChoiceClickListener mOnCheckboxClickListener) {
        P.mCursor = mCursor;
        P.mOnCheckboxClickListener = mOnCheckboxClickListener;
        P.mIsCheckedColumn = mIsCheckedColumn;
        P.mLabelColumn = mLabelColumn;
        P.mIsMultiChoice = true;
        return this;
    }
    
    public Builder setMultiChoiceItems(final CharSequence[] mItems, final boolean[] mCheckedItems, final DialogInterface$OnMultiChoiceClickListener mOnCheckboxClickListener) {
        P.mItems = mItems;
        P.mOnCheckboxClickListener = mOnCheckboxClickListener;
        P.mCheckedItems = mCheckedItems;
        P.mIsMultiChoice = true;
        return this;
    }
    
    public Builder setNegativeButton(final int n, final DialogInterface$OnClickListener mNegativeButtonListener) {
        P.mNegativeButtonText = P.mContext.getText(n);
        P.mNegativeButtonListener = mNegativeButtonListener;
        return this;
    }
    
    public Builder setNegativeButton(final CharSequence mNegativeButtonText, final DialogInterface$OnClickListener mNegativeButtonListener) {
        P.mNegativeButtonText = mNegativeButtonText;
        P.mNegativeButtonListener = mNegativeButtonListener;
        return this;
    }
    
    public Builder setNeutralButton(final int n, final DialogInterface$OnClickListener mNeutralButtonListener) {
        P.mNeutralButtonText = P.mContext.getText(n);
        P.mNeutralButtonListener = mNeutralButtonListener;
        return this;
    }
    
    public Builder setNeutralButton(final CharSequence mNeutralButtonText, final DialogInterface$OnClickListener mNeutralButtonListener) {
        P.mNeutralButtonText = mNeutralButtonText;
        P.mNeutralButtonListener = mNeutralButtonListener;
        return this;
    }
    
    public Builder setOnCancelListener(final DialogInterface$OnCancelListener mOnCancelListener) {
        P.mOnCancelListener = mOnCancelListener;
        return this;
    }
    
    public Builder setOnDismissListener(final DialogInterface$OnDismissListener mOnDismissListener) {
        P.mOnDismissListener = mOnDismissListener;
        return this;
    }
    
    public Builder setOnItemSelectedListener(final AdapterView$OnItemSelectedListener mOnItemSelectedListener) {
        P.mOnItemSelectedListener = mOnItemSelectedListener;
        return this;
    }
    
    public Builder setOnKeyListener(final DialogInterface$OnKeyListener mOnKeyListener) {
        P.mOnKeyListener = mOnKeyListener;
        return this;
    }
    
    public Builder setPositiveButton(final int n, final DialogInterface$OnClickListener mPositiveButtonListener) {
        P.mPositiveButtonText = P.mContext.getText(n);
        P.mPositiveButtonListener = mPositiveButtonListener;
        return this;
    }
    
    public Builder setPositiveButton(final CharSequence mPositiveButtonText, final DialogInterface$OnClickListener mPositiveButtonListener) {
        P.mPositiveButtonText = mPositiveButtonText;
        P.mPositiveButtonListener = mPositiveButtonListener;
        return this;
    }
    
    public Builder setRecycleOnMeasureEnabled(final boolean mRecycleOnMeasure) {
        P.mRecycleOnMeasure = mRecycleOnMeasure;
        return this;
    }
    
    public Builder setSingleChoiceItems(final int n, final int mCheckedItem, final DialogInterface$OnClickListener mOnClickListener) {
        P.mItems = P.mContext.getResources().getTextArray(n);
        P.mOnClickListener = mOnClickListener;
        P.mCheckedItem = mCheckedItem;
        P.mIsSingleChoice = true;
        return this;
    }
    
    public Builder setSingleChoiceItems(final Cursor mCursor, final int mCheckedItem, final String mLabelColumn, final DialogInterface$OnClickListener mOnClickListener) {
        P.mCursor = mCursor;
        P.mOnClickListener = mOnClickListener;
        P.mCheckedItem = mCheckedItem;
        P.mLabelColumn = mLabelColumn;
        P.mIsSingleChoice = true;
        return this;
    }
    
    public Builder setSingleChoiceItems(final ListAdapter mAdapter, final int mCheckedItem, final DialogInterface$OnClickListener mOnClickListener) {
        P.mAdapter = mAdapter;
        P.mOnClickListener = mOnClickListener;
        P.mCheckedItem = mCheckedItem;
        P.mIsSingleChoice = true;
        return this;
    }
    
    public Builder setSingleChoiceItems(final CharSequence[] mItems, final int mCheckedItem, final DialogInterface$OnClickListener mOnClickListener) {
        P.mItems = mItems;
        P.mOnClickListener = mOnClickListener;
        P.mCheckedItem = mCheckedItem;
        P.mIsSingleChoice = true;
        return this;
    }
    
    public Builder setTitle(final int n) {
        P.mTitle = P.mContext.getText(n);
        return this;
    }
    
    public Builder setTitle(final CharSequence mTitle) {
        P.mTitle = mTitle;
        return this;
    }
    
    public Builder setView(final int mViewLayoutResId) {
        P.mView = null;
        P.mViewLayoutResId = mViewLayoutResId;
        P.mViewSpacingSpecified = false;
        return this;
    }
    
    public Builder setView(final View mView) {
        P.mView = mView;
        P.mViewLayoutResId = 0;
        P.mViewSpacingSpecified = false;
        return this;
    }
    
    public Builder setView(final View mView, final int mViewSpacingLeft, final int mViewSpacingTop, final int mViewSpacingRight, final int mViewSpacingBottom) {
        P.mView = mView;
        P.mViewLayoutResId = 0;
        P.mViewSpacingSpecified = true;
        P.mViewSpacingLeft = mViewSpacingLeft;
        P.mViewSpacingTop = mViewSpacingTop;
        P.mViewSpacingRight = mViewSpacingRight;
        P.mViewSpacingBottom = mViewSpacingBottom;
        return this;
    }
    
    public AlertDialog show() {
        final AlertDialog create = this.create();
        create.show();
        return create;
    }
}
