package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertController$AlertParams;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.AdapterView.OnItemSelectedListener;

public class AlertDialog$Builder {
   private final AlertController$AlertParams P;
   private int mTheme;

   public AlertDialog$Builder(Context var1) {
      this(var1, AlertDialog.resolveDialogTheme(var1, 0));
   }

   public AlertDialog$Builder(Context var1, int var2) {
      this.P = new AlertController$AlertParams(new ContextThemeWrapper(var1, AlertDialog.resolveDialogTheme(var1, var2)));
      this.mTheme = var2;
   }

   public AlertDialog create() {
      AlertDialog var1 = new AlertDialog(this.P.mContext, this.mTheme, false);
      this.P.apply(AlertDialog.access$000(var1));
      var1.setCancelable(this.P.mCancelable);
      if(this.P.mCancelable) {
         var1.setCanceledOnTouchOutside(true);
      }

      var1.setOnCancelListener(this.P.mOnCancelListener);
      var1.setOnDismissListener(this.P.mOnDismissListener);
      if(this.P.mOnKeyListener != null) {
         var1.setOnKeyListener(this.P.mOnKeyListener);
      }

      return var1;
   }

   public Context getContext() {
      return this.P.mContext;
   }

   public AlertDialog$Builder setAdapter(ListAdapter var1, OnClickListener var2) {
      this.P.mAdapter = var1;
      this.P.mOnClickListener = var2;
      return this;
   }

   public AlertDialog$Builder setCancelable(boolean var1) {
      this.P.mCancelable = var1;
      return this;
   }

   public AlertDialog$Builder setCursor(Cursor var1, OnClickListener var2, String var3) {
      this.P.mCursor = var1;
      this.P.mLabelColumn = var3;
      this.P.mOnClickListener = var2;
      return this;
   }

   public AlertDialog$Builder setCustomTitle(View var1) {
      this.P.mCustomTitleView = var1;
      return this;
   }

   public AlertDialog$Builder setIcon(int var1) {
      this.P.mIconId = var1;
      return this;
   }

   public AlertDialog$Builder setIcon(Drawable var1) {
      this.P.mIcon = var1;
      return this;
   }

   public AlertDialog$Builder setIconAttribute(int var1) {
      TypedValue var2 = new TypedValue();
      this.P.mContext.getTheme().resolveAttribute(var1, var2, true);
      this.P.mIconId = var2.resourceId;
      return this;
   }

   public AlertDialog$Builder setInverseBackgroundForced(boolean var1) {
      this.P.mForceInverseBackground = var1;
      return this;
   }

   public AlertDialog$Builder setItems(int var1, OnClickListener var2) {
      this.P.mItems = this.P.mContext.getResources().getTextArray(var1);
      this.P.mOnClickListener = var2;
      return this;
   }

   public AlertDialog$Builder setItems(CharSequence[] var1, OnClickListener var2) {
      this.P.mItems = var1;
      this.P.mOnClickListener = var2;
      return this;
   }

   public AlertDialog$Builder setMessage(int var1) {
      this.P.mMessage = this.P.mContext.getText(var1);
      return this;
   }

   public AlertDialog$Builder setMessage(CharSequence var1) {
      this.P.mMessage = var1;
      return this;
   }

   public AlertDialog$Builder setMultiChoiceItems(int var1, boolean[] var2, OnMultiChoiceClickListener var3) {
      this.P.mItems = this.P.mContext.getResources().getTextArray(var1);
      this.P.mOnCheckboxClickListener = var3;
      this.P.mCheckedItems = var2;
      this.P.mIsMultiChoice = true;
      return this;
   }

   public AlertDialog$Builder setMultiChoiceItems(Cursor var1, String var2, String var3, OnMultiChoiceClickListener var4) {
      this.P.mCursor = var1;
      this.P.mOnCheckboxClickListener = var4;
      this.P.mIsCheckedColumn = var2;
      this.P.mLabelColumn = var3;
      this.P.mIsMultiChoice = true;
      return this;
   }

   public AlertDialog$Builder setMultiChoiceItems(CharSequence[] var1, boolean[] var2, OnMultiChoiceClickListener var3) {
      this.P.mItems = var1;
      this.P.mOnCheckboxClickListener = var3;
      this.P.mCheckedItems = var2;
      this.P.mIsMultiChoice = true;
      return this;
   }

   public AlertDialog$Builder setNegativeButton(int var1, OnClickListener var2) {
      this.P.mNegativeButtonText = this.P.mContext.getText(var1);
      this.P.mNegativeButtonListener = var2;
      return this;
   }

   public AlertDialog$Builder setNegativeButton(CharSequence var1, OnClickListener var2) {
      this.P.mNegativeButtonText = var1;
      this.P.mNegativeButtonListener = var2;
      return this;
   }

   public AlertDialog$Builder setNeutralButton(int var1, OnClickListener var2) {
      this.P.mNeutralButtonText = this.P.mContext.getText(var1);
      this.P.mNeutralButtonListener = var2;
      return this;
   }

   public AlertDialog$Builder setNeutralButton(CharSequence var1, OnClickListener var2) {
      this.P.mNeutralButtonText = var1;
      this.P.mNeutralButtonListener = var2;
      return this;
   }

   public AlertDialog$Builder setOnCancelListener(OnCancelListener var1) {
      this.P.mOnCancelListener = var1;
      return this;
   }

   public AlertDialog$Builder setOnDismissListener(OnDismissListener var1) {
      this.P.mOnDismissListener = var1;
      return this;
   }

   public AlertDialog$Builder setOnItemSelectedListener(OnItemSelectedListener var1) {
      this.P.mOnItemSelectedListener = var1;
      return this;
   }

   public AlertDialog$Builder setOnKeyListener(OnKeyListener var1) {
      this.P.mOnKeyListener = var1;
      return this;
   }

   public AlertDialog$Builder setPositiveButton(int var1, OnClickListener var2) {
      this.P.mPositiveButtonText = this.P.mContext.getText(var1);
      this.P.mPositiveButtonListener = var2;
      return this;
   }

   public AlertDialog$Builder setPositiveButton(CharSequence var1, OnClickListener var2) {
      this.P.mPositiveButtonText = var1;
      this.P.mPositiveButtonListener = var2;
      return this;
   }

   public AlertDialog$Builder setRecycleOnMeasureEnabled(boolean var1) {
      this.P.mRecycleOnMeasure = var1;
      return this;
   }

   public AlertDialog$Builder setSingleChoiceItems(int var1, int var2, OnClickListener var3) {
      this.P.mItems = this.P.mContext.getResources().getTextArray(var1);
      this.P.mOnClickListener = var3;
      this.P.mCheckedItem = var2;
      this.P.mIsSingleChoice = true;
      return this;
   }

   public AlertDialog$Builder setSingleChoiceItems(Cursor var1, int var2, String var3, OnClickListener var4) {
      this.P.mCursor = var1;
      this.P.mOnClickListener = var4;
      this.P.mCheckedItem = var2;
      this.P.mLabelColumn = var3;
      this.P.mIsSingleChoice = true;
      return this;
   }

   public AlertDialog$Builder setSingleChoiceItems(ListAdapter var1, int var2, OnClickListener var3) {
      this.P.mAdapter = var1;
      this.P.mOnClickListener = var3;
      this.P.mCheckedItem = var2;
      this.P.mIsSingleChoice = true;
      return this;
   }

   public AlertDialog$Builder setSingleChoiceItems(CharSequence[] var1, int var2, OnClickListener var3) {
      this.P.mItems = var1;
      this.P.mOnClickListener = var3;
      this.P.mCheckedItem = var2;
      this.P.mIsSingleChoice = true;
      return this;
   }

   public AlertDialog$Builder setTitle(int var1) {
      this.P.mTitle = this.P.mContext.getText(var1);
      return this;
   }

   public AlertDialog$Builder setTitle(CharSequence var1) {
      this.P.mTitle = var1;
      return this;
   }

   public AlertDialog$Builder setView(int var1) {
      this.P.mView = null;
      this.P.mViewLayoutResId = var1;
      this.P.mViewSpacingSpecified = false;
      return this;
   }

   public AlertDialog$Builder setView(View var1) {
      this.P.mView = var1;
      this.P.mViewLayoutResId = 0;
      this.P.mViewSpacingSpecified = false;
      return this;
   }

   public AlertDialog$Builder setView(View var1, int var2, int var3, int var4, int var5) {
      this.P.mView = var1;
      this.P.mViewLayoutResId = 0;
      this.P.mViewSpacingSpecified = true;
      this.P.mViewSpacingLeft = var2;
      this.P.mViewSpacingTop = var3;
      this.P.mViewSpacingRight = var4;
      this.P.mViewSpacingBottom = var5;
      return this;
   }

   public AlertDialog show() {
      AlertDialog var1 = this.create();
      var1.show();
      return var1;
   }
}
