package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.AbsSpinnerCompat;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

class SpinnerCompat extends AbsSpinnerCompat implements OnClickListener {
   private static final int MAX_ITEMS_MEASURED = 15;
   public static final int MODE_DIALOG = 0;
   public static final int MODE_DROPDOWN = 1;
   private static final int MODE_THEME = -1;
   private static final String TAG = "Spinner";
   private boolean mDisableChildrenWhenDisabled;
   int mDropDownWidth;
   private ListPopupWindow.ForwardingListener mForwardingListener;
   private int mGravity;
   private SpinnerCompat.SpinnerPopup mPopup;
   private SpinnerCompat.DropDownAdapter mTempAdapter;
   private Rect mTempRect;
   private final TintManager mTintManager;

   SpinnerCompat(Context var1) {
      this(var1, (AttributeSet)null);
   }

   SpinnerCompat(Context var1, int var2) {
      this(var1, (AttributeSet)null, R.attr.spinnerStyle, var2);
   }

   SpinnerCompat(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.spinnerStyle);
   }

   SpinnerCompat(Context var1, AttributeSet var2, int var3) {
      this(var1, var2, var3, -1);
   }

   SpinnerCompat(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3);
      this.mTempRect = new Rect();
      TintTypedArray var6 = TintTypedArray.obtainStyledAttributes(var1, var2, R.styleable.Spinner, var3, 0);
      if(var6.hasValue(R.styleable.Spinner_android_background)) {
         this.setBackgroundDrawable(var6.getDrawable(R.styleable.Spinner_android_background));
      }

      int var5 = var4;
      if(var4 == -1) {
         var5 = var6.getInt(R.styleable.Spinner_spinnerMode, 0);
      }

      switch(var5) {
      case 0:
         this.mPopup = new SpinnerCompat.DialogPopup(null);
         break;
      case 1:
         final SpinnerCompat.DropdownPopup var7 = new SpinnerCompat.DropdownPopup(var1, var2, var3);
         this.mDropDownWidth = var6.getLayoutDimension(R.styleable.Spinner_android_dropDownWidth, -2);
         var7.setBackgroundDrawable(var6.getDrawable(R.styleable.Spinner_android_popupBackground));
         this.mPopup = var7;
         this.mForwardingListener = new ListPopupWindow.ForwardingListener(this) {
            public ListPopupWindow getPopup() {
               return var7;
            }

            public boolean onForwardingStarted() {
               if(!SpinnerCompat.this.mPopup.isShowing()) {
                  SpinnerCompat.this.mPopup.show();
               }

               return true;
            }
         };
      }

      this.mGravity = var6.getInt(R.styleable.Spinner_android_gravity, 17);
      this.mPopup.setPromptText(var6.getString(R.styleable.Spinner_prompt));
      this.mDisableChildrenWhenDisabled = var6.getBoolean(R.styleable.Spinner_disableChildrenWhenDisabled, false);
      var6.recycle();
      if(this.mTempAdapter != null) {
         this.mPopup.setAdapter(this.mTempAdapter);
         this.mTempAdapter = null;
      }

      this.mTintManager = var6.getTintManager();
   }

   private View makeView(int var1, boolean var2) {
      View var3;
      if(!this.mDataChanged) {
         var3 = this.mRecycler.get(var1);
         if(var3 != null) {
            this.setUpChild(var3, var2);
            return var3;
         }
      }

      var3 = this.mAdapter.getView(var1, (View)null, this);
      this.setUpChild(var3, var2);
      return var3;
   }

   private void setUpChild(View var1, boolean var2) {
      LayoutParams var6 = var1.getLayoutParams();
      LayoutParams var5 = var6;
      if(var6 == null) {
         var5 = this.generateDefaultLayoutParams();
      }

      if(var2) {
         this.addViewInLayout(var1, 0, var5);
      }

      var1.setSelected(this.hasFocus());
      if(this.mDisableChildrenWhenDisabled) {
         var1.setEnabled(this.isEnabled());
      }

      int var3 = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, var5.height);
      var1.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, var5.width), var3);
      var3 = this.mSpinnerPadding.top + (this.getMeasuredHeight() - this.mSpinnerPadding.bottom - this.mSpinnerPadding.top - var1.getMeasuredHeight()) / 2;
      int var4 = var1.getMeasuredHeight();
      var1.layout(0, var3, 0 + var1.getMeasuredWidth(), var3 + var4);
   }

   public int getBaseline() {
      byte var2 = -1;
      Object var5 = null;
      View var4;
      if(this.getChildCount() > 0) {
         var4 = this.getChildAt(0);
      } else {
         var4 = (View)var5;
         if(this.mAdapter != null) {
            var4 = (View)var5;
            if(this.mAdapter.getCount() > 0) {
               var4 = this.makeView(0, false);
               this.mRecycler.put(0, var4);
            }
         }
      }

      int var1 = var2;
      if(var4 != null) {
         int var3 = var4.getBaseline();
         var1 = var2;
         if(var3 >= 0) {
            var1 = var4.getTop() + var3;
         }
      }

      return var1;
   }

   public int getDropDownHorizontalOffset() {
      return this.mPopup.getHorizontalOffset();
   }

   public int getDropDownVerticalOffset() {
      return this.mPopup.getVerticalOffset();
   }

   public int getDropDownWidth() {
      return this.mDropDownWidth;
   }

   public Drawable getPopupBackground() {
      return this.mPopup.getBackground();
   }

   public CharSequence getPrompt() {
      return this.mPopup.getHintText();
   }

   void layout(int var1, boolean var2) {
      int var3 = this.mSpinnerPadding.left;
      int var4 = this.getRight() - this.getLeft() - this.mSpinnerPadding.left - this.mSpinnerPadding.right;
      if(this.mDataChanged) {
         this.handleDataChanged();
      }

      if(this.mItemCount == 0) {
         this.resetList();
      } else {
         if(this.mNextSelectedPosition >= 0) {
            this.setSelectedPositionInt(this.mNextSelectedPosition);
         }

         this.recycleAllViews();
         this.removeAllViewsInLayout();
         this.mFirstPosition = this.mSelectedPosition;
         if(this.mAdapter != null) {
            View var7 = this.makeView(this.mSelectedPosition, true);
            int var5 = var7.getMeasuredWidth();
            var1 = var3;
            int var6 = ViewCompat.getLayoutDirection(this);
            switch(GravityCompat.getAbsoluteGravity(this.mGravity, var6) & 7) {
            case 1:
               var1 = var4 / 2 + var3 - var5 / 2;
               break;
            case 5:
               var1 = var3 + var4 - var5;
            }

            var7.offsetLeftAndRight(var1);
         }

         this.mRecycler.clear();
         this.invalidate();
         this.checkSelectionChanged();
         this.mDataChanged = false;
         this.mNeedSync = false;
         this.setNextSelectedPositionInt(this.mSelectedPosition);
      }
   }

   int measureContentWidth(SpinnerAdapter var1, Drawable var2) {
      int var4;
      if(var1 == null) {
         var4 = 0;
      } else {
         int var3 = 0;
         View var11 = null;
         int var5 = 0;
         int var8 = MeasureSpec.makeMeasureSpec(0, 0);
         int var9 = MeasureSpec.makeMeasureSpec(0, 0);
         var4 = Math.max(0, this.getSelectedItemPosition());
         int var10 = Math.min(var1.getCount(), var4 + 15);

         int var6;
         for(var4 = Math.max(0, var4 - (15 - (var10 - var4))); var4 < var10; var5 = var6) {
            int var7 = var1.getItemViewType(var4);
            var6 = var5;
            if(var7 != var5) {
               var6 = var7;
               var11 = null;
            }

            var11 = var1.getView(var4, var11, this);
            if(var11.getLayoutParams() == null) {
               var11.setLayoutParams(new LayoutParams(-2, -2));
            }

            var11.measure(var8, var9);
            var3 = Math.max(var3, var11.getMeasuredWidth());
            ++var4;
         }

         var4 = var3;
         if(var2 != null) {
            var2.getPadding(this.mTempRect);
            return var3 + this.mTempRect.left + this.mTempRect.right;
         }
      }

      return var4;
   }

   public void onClick(DialogInterface var1, int var2) {
      this.setSelection(var2);
      var1.dismiss();
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mPopup != null && this.mPopup.isShowing()) {
         this.mPopup.dismiss();
      }

   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.mInLayout = true;
      this.layout(0, false);
      this.mInLayout = false;
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(this.mPopup != null && MeasureSpec.getMode(var1) == Integer.MIN_VALUE) {
         this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.measureContentWidth(this.getAdapter(), this.getBackground())), MeasureSpec.getSize(var1)), this.getMeasuredHeight());
      }

   }

   public void onRestoreInstanceState(Parcelable var1) {
      SpinnerCompat.SavedState var2 = (SpinnerCompat.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      if(var2.showDropdown) {
         ViewTreeObserver var3 = this.getViewTreeObserver();
         if(var3 != null) {
            var3.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
               public void onGlobalLayout() {
                  if(!SpinnerCompat.this.mPopup.isShowing()) {
                     SpinnerCompat.this.mPopup.show();
                  }

                  ViewTreeObserver var1 = SpinnerCompat.this.getViewTreeObserver();
                  if(var1 != null) {
                     var1.removeGlobalOnLayoutListener(this);
                  }

               }
            });
         }
      }

   }

   public Parcelable onSaveInstanceState() {
      SpinnerCompat.SavedState var2 = new SpinnerCompat.SavedState(super.onSaveInstanceState());
      boolean var1;
      if(this.mPopup != null && this.mPopup.isShowing()) {
         var1 = true;
      } else {
         var1 = false;
      }

      var2.showDropdown = var1;
      return var2;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.mForwardingListener != null && this.mForwardingListener.onTouch(this, var1)?true:super.onTouchEvent(var1);
   }

   public boolean performClick() {
      boolean var2 = super.performClick();
      boolean var1 = var2;
      if(!var2) {
         var2 = true;
         var1 = var2;
         if(!this.mPopup.isShowing()) {
            this.mPopup.show();
            var1 = var2;
         }
      }

      return var1;
   }

   public void setAdapter(SpinnerAdapter var1) {
      super.setAdapter(var1);
      this.mRecycler.clear();
      if(this.getContext().getApplicationInfo().targetSdkVersion >= 21 && var1 != null && var1.getViewTypeCount() != 1) {
         throw new IllegalArgumentException("Spinner adapter view type count must be 1");
      } else if(this.mPopup != null) {
         this.mPopup.setAdapter(new SpinnerCompat.DropDownAdapter(var1));
      } else {
         this.mTempAdapter = new SpinnerCompat.DropDownAdapter(var1);
      }
   }

   public void setDropDownHorizontalOffset(int var1) {
      this.mPopup.setHorizontalOffset(var1);
   }

   public void setDropDownVerticalOffset(int var1) {
      this.mPopup.setVerticalOffset(var1);
   }

   public void setDropDownWidth(int var1) {
      if(!(this.mPopup instanceof SpinnerCompat.DropdownPopup)) {
         Log.e("Spinner", "Cannot set dropdown width for MODE_DIALOG, ignoring");
      } else {
         this.mDropDownWidth = var1;
      }
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      if(this.mDisableChildrenWhenDisabled) {
         int var3 = this.getChildCount();

         for(int var2 = 0; var2 < var3; ++var2) {
            this.getChildAt(var2).setEnabled(var1);
         }
      }

   }

   public void setGravity(int var1) {
      if(this.mGravity != var1) {
         int var2 = var1;
         if((var1 & 7) == 0) {
            var2 = var1 | 8388611;
         }

         this.mGravity = var2;
         this.requestLayout();
      }

   }

   public void setOnItemClickListener(AdapterViewCompat.OnItemClickListener var1) {
      throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
   }

   void setOnItemClickListenerInt(AdapterViewCompat.OnItemClickListener var1) {
      super.setOnItemClickListener(var1);
   }

   public void setPopupBackgroundDrawable(Drawable var1) {
      if(!(this.mPopup instanceof SpinnerCompat.DropdownPopup)) {
         Log.e("Spinner", "setPopupBackgroundDrawable: incompatible spinner mode; ignoring...");
      } else {
         ((SpinnerCompat.DropdownPopup)this.mPopup).setBackgroundDrawable(var1);
      }
   }

   public void setPopupBackgroundResource(int var1) {
      this.setPopupBackgroundDrawable(this.mTintManager.getDrawable(var1));
   }

   public void setPrompt(CharSequence var1) {
      this.mPopup.setPromptText(var1);
   }

   public void setPromptId(int var1) {
      this.setPrompt(this.getContext().getText(var1));
   }

   private class DialogPopup implements SpinnerCompat.SpinnerPopup, OnClickListener {
      private ListAdapter mListAdapter;
      private AlertDialog mPopup;
      private CharSequence mPrompt;

      private DialogPopup() {
      }

      // $FF: synthetic method
      DialogPopup(Object var2) {
         this();
      }

      public void dismiss() {
         if(this.mPopup != null) {
            this.mPopup.dismiss();
            this.mPopup = null;
         }

      }

      public Drawable getBackground() {
         return null;
      }

      public CharSequence getHintText() {
         return this.mPrompt;
      }

      public int getHorizontalOffset() {
         return 0;
      }

      public int getVerticalOffset() {
         return 0;
      }

      public boolean isShowing() {
         return this.mPopup != null?this.mPopup.isShowing():false;
      }

      public void onClick(DialogInterface var1, int var2) {
         SpinnerCompat.this.setSelection(var2);
         if(SpinnerCompat.this.mOnItemClickListener != null) {
            SpinnerCompat.this.performItemClick((View)null, var2, this.mListAdapter.getItemId(var2));
         }

         this.dismiss();
      }

      public void setAdapter(ListAdapter var1) {
         this.mListAdapter = var1;
      }

      public void setBackgroundDrawable(Drawable var1) {
         Log.e("Spinner", "Cannot set popup background for MODE_DIALOG, ignoring");
      }

      public void setHorizontalOffset(int var1) {
         Log.e("Spinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
      }

      public void setPromptText(CharSequence var1) {
         this.mPrompt = var1;
      }

      public void setVerticalOffset(int var1) {
         Log.e("Spinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
      }

      public void show() {
         if(this.mListAdapter != null) {
            Builder var1 = new Builder(SpinnerCompat.this.getContext());
            if(this.mPrompt != null) {
               var1.setTitle(this.mPrompt);
            }

            this.mPopup = var1.setSingleChoiceItems(this.mListAdapter, SpinnerCompat.this.getSelectedItemPosition(), this).create();
            this.mPopup.show();
         }
      }
   }

   private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
      private SpinnerAdapter mAdapter;
      private ListAdapter mListAdapter;

      public DropDownAdapter(SpinnerAdapter var1) {
         this.mAdapter = var1;
         if(var1 instanceof ListAdapter) {
            this.mListAdapter = (ListAdapter)var1;
         }

      }

      public boolean areAllItemsEnabled() {
         ListAdapter var1 = this.mListAdapter;
         return var1 != null?var1.areAllItemsEnabled():true;
      }

      public int getCount() {
         return this.mAdapter == null?0:this.mAdapter.getCount();
      }

      public View getDropDownView(int var1, View var2, ViewGroup var3) {
         return this.mAdapter == null?null:this.mAdapter.getDropDownView(var1, var2, var3);
      }

      public Object getItem(int var1) {
         return this.mAdapter == null?null:this.mAdapter.getItem(var1);
      }

      public long getItemId(int var1) {
         return this.mAdapter == null?-1L:this.mAdapter.getItemId(var1);
      }

      public int getItemViewType(int var1) {
         return 0;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         return this.getDropDownView(var1, var2, var3);
      }

      public int getViewTypeCount() {
         return 1;
      }

      public boolean hasStableIds() {
         return this.mAdapter != null && this.mAdapter.hasStableIds();
      }

      public boolean isEmpty() {
         return this.getCount() == 0;
      }

      public boolean isEnabled(int var1) {
         ListAdapter var2 = this.mListAdapter;
         return var2 != null?var2.isEnabled(var1):true;
      }

      public void registerDataSetObserver(DataSetObserver var1) {
         if(this.mAdapter != null) {
            this.mAdapter.registerDataSetObserver(var1);
         }

      }

      public void unregisterDataSetObserver(DataSetObserver var1) {
         if(this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(var1);
         }

      }
   }

   private class DropdownPopup extends ListPopupWindow implements SpinnerCompat.SpinnerPopup {
      private ListAdapter mAdapter;
      private CharSequence mHintText;

      public DropdownPopup(Context var2, AttributeSet var3, int var4) {
         super(var2, var3, var4);
         this.setAnchorView(SpinnerCompat.this);
         this.setModal(true);
         this.setPromptPosition(0);
         this.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView var1, View var2, int var3, long var4) {
               SpinnerCompat.this.setSelection(var3);
               if(SpinnerCompat.this.mOnItemClickListener != null) {
                  SpinnerCompat.this.performItemClick(var2, var3, DropdownPopup.this.mAdapter.getItemId(var3));
               }

               DropdownPopup.this.dismiss();
            }
         });
      }

      void computeContentWidth() {
         Drawable var8 = this.getBackground();
         int var1 = 0;
         if(var8 != null) {
            var8.getPadding(SpinnerCompat.this.mTempRect);
            if(ViewUtils.isLayoutRtl(SpinnerCompat.this)) {
               var1 = SpinnerCompat.this.mTempRect.right;
            } else {
               var1 = -SpinnerCompat.this.mTempRect.left;
            }
         } else {
            Rect var9 = SpinnerCompat.this.mTempRect;
            SpinnerCompat.this.mTempRect.right = 0;
            var9.left = 0;
         }

         int var5 = SpinnerCompat.this.getPaddingLeft();
         int var6 = SpinnerCompat.this.getPaddingRight();
         int var7 = SpinnerCompat.this.getWidth();
         if(SpinnerCompat.this.mDropDownWidth == -2) {
            int var3 = SpinnerCompat.this.measureContentWidth((SpinnerAdapter)this.mAdapter, this.getBackground());
            int var4 = SpinnerCompat.this.getContext().getResources().getDisplayMetrics().widthPixels - SpinnerCompat.this.mTempRect.left - SpinnerCompat.this.mTempRect.right;
            int var2 = var3;
            if(var3 > var4) {
               var2 = var4;
            }

            this.setContentWidth(Math.max(var2, var7 - var5 - var6));
         } else if(SpinnerCompat.this.mDropDownWidth == -1) {
            this.setContentWidth(var7 - var5 - var6);
         } else {
            this.setContentWidth(SpinnerCompat.this.mDropDownWidth);
         }

         if(ViewUtils.isLayoutRtl(SpinnerCompat.this)) {
            var1 += var7 - var6 - this.getWidth();
         } else {
            var1 += var5;
         }

         this.setHorizontalOffset(var1);
      }

      public CharSequence getHintText() {
         return this.mHintText;
      }

      public void setAdapter(ListAdapter var1) {
         super.setAdapter(var1);
         this.mAdapter = var1;
      }

      public void setPromptText(CharSequence var1) {
         this.mHintText = var1;
      }

      public void show(int var1, int var2) {
         boolean var3 = this.isShowing();
         this.computeContentWidth();
         this.setInputMethodMode(2);
         super.show();
         this.getListView().setChoiceMode(1);
         this.setSelection(SpinnerCompat.this.getSelectedItemPosition());
         if(!var3) {
            ViewTreeObserver var4 = SpinnerCompat.this.getViewTreeObserver();
            if(var4 != null) {
               final OnGlobalLayoutListener var5 = new OnGlobalLayoutListener() {
                  public void onGlobalLayout() {
                     DropdownPopup.this.computeContentWidth();
                     SpinnerCompat.DropdownPopup.super.show();
                  }
               };
               var4.addOnGlobalLayoutListener(var5);
               this.setOnDismissListener(new OnDismissListener() {
                  public void onDismiss() {
                     ViewTreeObserver var1 = SpinnerCompat.this.getViewTreeObserver();
                     if(var1 != null) {
                        var1.removeGlobalOnLayoutListener(var5);
                     }

                  }
               });
               return;
            }
         }

      }
   }

   static class SavedState extends AbsSpinnerCompat.SavedState {
      public static final Creator CREATOR = new Creator() {
         public SpinnerCompat.SavedState createFromParcel(Parcel var1) {
            return new SpinnerCompat.SavedState(var1, null);
         }

         public SpinnerCompat.SavedState[] newArray(int var1) {
            return new SpinnerCompat.SavedState[var1];
         }
      };
      boolean showDropdown;

      private SavedState(Parcel var1) {
         super(var1);
         boolean var2;
         if(var1.readByte() != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.showDropdown = var2;
      }

      // $FF: synthetic method
      SavedState(Parcel var1, Object var2) {
         this(var1);
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         byte var3;
         if(this.showDropdown) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeByte((byte)var3);
      }
   }

   private interface SpinnerPopup {
      void dismiss();

      Drawable getBackground();

      CharSequence getHintText();

      int getHorizontalOffset();

      int getVerticalOffset();

      boolean isShowing();

      void setAdapter(ListAdapter var1);

      void setBackgroundDrawable(Drawable var1);

      void setHorizontalOffset(int var1);

      void setPromptText(CharSequence var1);

      void setVerticalOffset(int var1);

      void show();
   }
}
