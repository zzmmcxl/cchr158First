package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Build.VERSION;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$styleable;
import android.support.v7.widget.AppCompatPopupWindow;
import android.support.v7.widget.ListPopupWindow$1;
import android.support.v7.widget.ListPopupWindow$2;
import android.support.v7.widget.ListPopupWindow$3;
import android.support.v7.widget.ListPopupWindow$DropDownListView;
import android.support.v7.widget.ListPopupWindow$ListSelectorHider;
import android.support.v7.widget.ListPopupWindow$PopupDataSetObserver;
import android.support.v7.widget.ListPopupWindow$PopupScrollListener;
import android.support.v7.widget.ListPopupWindow$PopupTouchInterceptor;
import android.support.v7.widget.ListPopupWindow$ResizePopupRunnable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.KeyEvent.DispatcherState;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ListPopupWindow {
   private static final boolean DEBUG = false;
   private static final int EXPAND_LIST_TIMEOUT = 250;
   public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
   public static final int INPUT_METHOD_NEEDED = 1;
   public static final int INPUT_METHOD_NOT_NEEDED = 2;
   public static final int MATCH_PARENT = -1;
   public static final int POSITION_PROMPT_ABOVE = 0;
   public static final int POSITION_PROMPT_BELOW = 1;
   private static final String TAG = "ListPopupWindow";
   public static final int WRAP_CONTENT = -2;
   private static Method sClipToWindowEnabledMethod;
   private static Method sGetMaxAvailableHeightMethod;
   private ListAdapter mAdapter;
   private Context mContext;
   private boolean mDropDownAlwaysVisible;
   private View mDropDownAnchorView;
   private int mDropDownGravity;
   private int mDropDownHeight;
   private int mDropDownHorizontalOffset;
   private ListPopupWindow$DropDownListView mDropDownList;
   private Drawable mDropDownListHighlight;
   private int mDropDownVerticalOffset;
   private boolean mDropDownVerticalOffsetSet;
   private int mDropDownWidth;
   private int mDropDownWindowLayoutType;
   private boolean mForceIgnoreOutsideTouch;
   private final Handler mHandler;
   private final ListPopupWindow$ListSelectorHider mHideSelector;
   private OnItemClickListener mItemClickListener;
   private OnItemSelectedListener mItemSelectedListener;
   private int mLayoutDirection;
   int mListItemExpandMaximum;
   private boolean mModal;
   private DataSetObserver mObserver;
   private PopupWindow mPopup;
   private int mPromptPosition;
   private View mPromptView;
   private final ListPopupWindow$ResizePopupRunnable mResizePopupRunnable;
   private final ListPopupWindow$PopupScrollListener mScrollListener;
   private Runnable mShowDropDownRunnable;
   private Rect mTempRect;
   private final ListPopupWindow$PopupTouchInterceptor mTouchInterceptor;

   static {
      try {
         sClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
      } catch (NoSuchMethodException var2) {
         Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
      }

      try {
         sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
      } catch (NoSuchMethodException var1) {
         Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
      }
   }

   public ListPopupWindow(Context var1) {
      this(var1, (AttributeSet)null, R$attr.listPopupWindowStyle);
   }

   public ListPopupWindow(Context var1, AttributeSet var2) {
      this(var1, var2, R$attr.listPopupWindowStyle);
   }

   public ListPopupWindow(Context var1, AttributeSet var2, int var3) {
      this(var1, var2, var3, 0);
   }

   public ListPopupWindow(Context var1, AttributeSet var2, int var3, int var4) {
      this.mDropDownHeight = -2;
      this.mDropDownWidth = -2;
      this.mDropDownWindowLayoutType = 1002;
      this.mDropDownGravity = 0;
      this.mDropDownAlwaysVisible = false;
      this.mForceIgnoreOutsideTouch = false;
      this.mListItemExpandMaximum = Integer.MAX_VALUE;
      this.mPromptPosition = 0;
      this.mResizePopupRunnable = new ListPopupWindow$ResizePopupRunnable(this, (ListPopupWindow$1)null);
      this.mTouchInterceptor = new ListPopupWindow$PopupTouchInterceptor(this, (ListPopupWindow$1)null);
      this.mScrollListener = new ListPopupWindow$PopupScrollListener(this, (ListPopupWindow$1)null);
      this.mHideSelector = new ListPopupWindow$ListSelectorHider(this, (ListPopupWindow$1)null);
      this.mTempRect = new Rect();
      this.mContext = var1;
      this.mHandler = new Handler(var1.getMainLooper());
      TypedArray var5 = var1.obtainStyledAttributes(var2, R$styleable.ListPopupWindow, var3, var4);
      this.mDropDownHorizontalOffset = var5.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
      this.mDropDownVerticalOffset = var5.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
      if(this.mDropDownVerticalOffset != 0) {
         this.mDropDownVerticalOffsetSet = true;
      }

      var5.recycle();
      this.mPopup = new AppCompatPopupWindow(var1, var2, var3);
      this.mPopup.setInputMethodMode(1);
      this.mLayoutDirection = TextUtilsCompat.getLayoutDirectionFromLocale(this.mContext.getResources().getConfiguration().locale);
   }

   private int buildDropDown() {
      byte var2 = 0;
      int var1 = 0;
      boolean var5;
      int var10;
      LayoutParams var13;
      if(this.mDropDownList == null) {
         Context var9 = this.mContext;
         this.mShowDropDownRunnable = new ListPopupWindow$2(this);
         if(!this.mModal) {
            var5 = true;
         } else {
            var5 = false;
         }

         this.mDropDownList = new ListPopupWindow$DropDownListView(var9, var5);
         if(this.mDropDownListHighlight != null) {
            this.mDropDownList.setSelector(this.mDropDownListHighlight);
         }

         this.mDropDownList.setAdapter(this.mAdapter);
         this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
         this.mDropDownList.setFocusable(true);
         this.mDropDownList.setFocusableInTouchMode(true);
         this.mDropDownList.setOnItemSelectedListener(new ListPopupWindow$3(this));
         this.mDropDownList.setOnScrollListener(this.mScrollListener);
         if(this.mItemSelectedListener != null) {
            this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
         }

         ListPopupWindow$DropDownListView var7 = this.mDropDownList;
         View var8 = this.mPromptView;
         Object var6 = var7;
         if(var8 != null) {
            var6 = new LinearLayout(var9);
            ((LinearLayout)var6).setOrientation(1);
            LayoutParams var15 = new LayoutParams(-1, 0, 1.0F);
            switch(this.mPromptPosition) {
            case 0:
               ((LinearLayout)var6).addView(var8);
               ((LinearLayout)var6).addView(var7, var15);
               break;
            case 1:
               ((LinearLayout)var6).addView(var7, var15);
               ((LinearLayout)var6).addView(var8);
               break;
            default:
               Log.e("ListPopupWindow", "Invalid hint position " + this.mPromptPosition);
            }

            if(this.mDropDownWidth >= 0) {
               var1 = Integer.MIN_VALUE;
               var10 = this.mDropDownWidth;
            } else {
               var1 = 0;
               var10 = 0;
            }

            var8.measure(MeasureSpec.makeMeasureSpec(var10, var1), 0);
            var13 = (LayoutParams)var8.getLayoutParams();
            var1 = var8.getMeasuredHeight() + var13.topMargin + var13.bottomMargin;
         }

         this.mPopup.setContentView((View)var6);
      } else {
         ViewGroup var11 = (ViewGroup)this.mPopup.getContentView();
         View var12 = this.mPromptView;
         var1 = var2;
         if(var12 != null) {
            var13 = (LayoutParams)var12.getLayoutParams();
            var1 = var12.getMeasuredHeight() + var13.topMargin + var13.bottomMargin;
         }
      }

      int var3 = 0;
      Drawable var14 = this.mPopup.getBackground();
      if(var14 != null) {
         var14.getPadding(this.mTempRect);
         var10 = this.mTempRect.top + this.mTempRect.bottom;
         var3 = var10;
         if(!this.mDropDownVerticalOffsetSet) {
            this.mDropDownVerticalOffset = -this.mTempRect.top;
            var3 = var10;
         }
      } else {
         this.mTempRect.setEmpty();
      }

      if(this.mPopup.getInputMethodMode() == 2) {
         var5 = true;
      } else {
         var5 = false;
      }

      int var4 = this.getMaxAvailableHeight(this.getAnchorView(), this.mDropDownVerticalOffset, var5);
      if(!this.mDropDownAlwaysVisible && this.mDropDownHeight != -1) {
         int var10001;
         switch(this.mDropDownWidth) {
         case -2:
            var10001 = this.mTempRect.left + this.mTempRect.right;
            var10 = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - var10001, Integer.MIN_VALUE);
            break;
         case -1:
            var10001 = this.mTempRect.left + this.mTempRect.right;
            var10 = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - var10001, 1073741824);
            break;
         default:
            var10 = MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
         }

         var4 = this.mDropDownList.measureHeightOfChildrenCompat(var10, 0, -1, var4 - var1, -1);
         var10 = var1;
         if(var4 > 0) {
            var10 = var1 + var3;
         }

         return var4 + var10;
      } else {
         return var4 + var3;
      }
   }

   private int getMaxAvailableHeight(View var1, int var2, boolean var3) {
      if(sGetMaxAvailableHeightMethod != null) {
         try {
            int var4 = ((Integer)sGetMaxAvailableHeightMethod.invoke(this.mPopup, new Object[]{var1, Integer.valueOf(var2), Boolean.valueOf(var3)})).intValue();
            return var4;
         } catch (Exception var6) {
            Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
         }
      }

      return this.mPopup.getMaxAvailableHeight(var1, var2);
   }

   private static boolean isConfirmKey(int var0) {
      return var0 == 66 || var0 == 23;
   }

   private void removePromptView() {
      if(this.mPromptView != null) {
         ViewParent var1 = this.mPromptView.getParent();
         if(var1 instanceof ViewGroup) {
            ((ViewGroup)var1).removeView(this.mPromptView);
         }
      }

   }

   private void setPopupClipToScreenEnabled(boolean var1) {
      if(sClipToWindowEnabledMethod != null) {
         try {
            sClipToWindowEnabledMethod.invoke(this.mPopup, new Object[]{Boolean.valueOf(var1)});
         } catch (Exception var3) {
            Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            return;
         }
      }

   }

   public void clearListSelection() {
      ListPopupWindow$DropDownListView var1 = this.mDropDownList;
      if(var1 != null) {
         ListPopupWindow$DropDownListView.access$502(var1, true);
         var1.requestLayout();
      }

   }

   public OnTouchListener createDragToOpenListener(View var1) {
      return new ListPopupWindow$1(this, var1);
   }

   public void dismiss() {
      this.mPopup.dismiss();
      this.removePromptView();
      this.mPopup.setContentView((View)null);
      this.mDropDownList = null;
      this.mHandler.removeCallbacks(this.mResizePopupRunnable);
   }

   public View getAnchorView() {
      return this.mDropDownAnchorView;
   }

   public int getAnimationStyle() {
      return this.mPopup.getAnimationStyle();
   }

   public Drawable getBackground() {
      return this.mPopup.getBackground();
   }

   public int getHeight() {
      return this.mDropDownHeight;
   }

   public int getHorizontalOffset() {
      return this.mDropDownHorizontalOffset;
   }

   public int getInputMethodMode() {
      return this.mPopup.getInputMethodMode();
   }

   public ListView getListView() {
      return this.mDropDownList;
   }

   public int getPromptPosition() {
      return this.mPromptPosition;
   }

   public Object getSelectedItem() {
      return !this.isShowing()?null:this.mDropDownList.getSelectedItem();
   }

   public long getSelectedItemId() {
      return !this.isShowing()?Long.MIN_VALUE:this.mDropDownList.getSelectedItemId();
   }

   public int getSelectedItemPosition() {
      return !this.isShowing()?-1:this.mDropDownList.getSelectedItemPosition();
   }

   public View getSelectedView() {
      return !this.isShowing()?null:this.mDropDownList.getSelectedView();
   }

   public int getSoftInputMode() {
      return this.mPopup.getSoftInputMode();
   }

   public int getVerticalOffset() {
      return !this.mDropDownVerticalOffsetSet?0:this.mDropDownVerticalOffset;
   }

   public int getWidth() {
      return this.mDropDownWidth;
   }

   public boolean isDropDownAlwaysVisible() {
      return this.mDropDownAlwaysVisible;
   }

   public boolean isInputMethodNotNeeded() {
      return this.mPopup.getInputMethodMode() == 2;
   }

   public boolean isModal() {
      return this.mModal;
   }

   public boolean isShowing() {
      return this.mPopup.isShowing();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(this.isShowing() && var1 != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(var1))) {
         int var6 = this.mDropDownList.getSelectedItemPosition();
         boolean var5;
         if(!this.mPopup.isAboveAnchor()) {
            var5 = true;
         } else {
            var5 = false;
         }

         ListAdapter var8 = this.mAdapter;
         int var3 = Integer.MAX_VALUE;
         int var4 = Integer.MIN_VALUE;
         if(var8 != null) {
            boolean var7 = var8.areAllItemsEnabled();
            if(var7) {
               var3 = 0;
            } else {
               var3 = this.mDropDownList.lookForSelectablePosition(0, true);
            }

            if(var7) {
               var4 = var8.getCount() - 1;
            } else {
               var4 = this.mDropDownList.lookForSelectablePosition(var8.getCount() - 1, false);
            }
         }

         if(var5 && var1 == 19 && var6 <= var3 || !var5 && var1 == 20 && var6 >= var4) {
            this.clearListSelection();
            this.mPopup.setInputMethodMode(1);
            this.show();
            return true;
         }

         ListPopupWindow$DropDownListView.access$502(this.mDropDownList, false);
         if(this.mDropDownList.onKeyDown(var1, var2)) {
            this.mPopup.setInputMethodMode(2);
            this.mDropDownList.requestFocusFromTouch();
            this.show();
            switch(var1) {
            case 19:
            case 20:
            case 23:
            case 66:
               return true;
            }
         } else if(var5 && var1 == 20) {
            if(var6 == var4) {
               return true;
            }
         } else if(!var5 && var1 == 19 && var6 == var3) {
            return true;
         }
      }

      return false;
   }

   public boolean onKeyPreIme(int var1, KeyEvent var2) {
      if(var1 == 4 && this.isShowing()) {
         View var3 = this.mDropDownAnchorView;
         DispatcherState var4;
         if(var2.getAction() == 0 && var2.getRepeatCount() == 0) {
            var4 = var3.getKeyDispatcherState();
            if(var4 != null) {
               var4.startTracking(var2, this);
            }

            return true;
         }

         if(var2.getAction() == 1) {
            var4 = var3.getKeyDispatcherState();
            if(var4 != null) {
               var4.handleUpEvent(var2);
            }

            if(var2.isTracking() && !var2.isCanceled()) {
               this.dismiss();
               return true;
            }
         }
      }

      return false;
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      if(this.isShowing() && this.mDropDownList.getSelectedItemPosition() >= 0) {
         boolean var3 = this.mDropDownList.onKeyUp(var1, var2);
         if(var3 && isConfirmKey(var1)) {
            this.dismiss();
         }

         return var3;
      } else {
         return false;
      }
   }

   public boolean performItemClick(int var1) {
      if(this.isShowing()) {
         if(this.mItemClickListener != null) {
            ListPopupWindow$DropDownListView var2 = this.mDropDownList;
            View var3 = var2.getChildAt(var1 - var2.getFirstVisiblePosition());
            ListAdapter var4 = var2.getAdapter();
            this.mItemClickListener.onItemClick(var2, var3, var1, var4.getItemId(var1));
         }

         return true;
      } else {
         return false;
      }
   }

   public void postShow() {
      this.mHandler.post(this.mShowDropDownRunnable);
   }

   public void setAdapter(ListAdapter var1) {
      if(this.mObserver == null) {
         this.mObserver = new ListPopupWindow$PopupDataSetObserver(this, (ListPopupWindow$1)null);
      } else if(this.mAdapter != null) {
         this.mAdapter.unregisterDataSetObserver(this.mObserver);
      }

      this.mAdapter = var1;
      if(this.mAdapter != null) {
         var1.registerDataSetObserver(this.mObserver);
      }

      if(this.mDropDownList != null) {
         this.mDropDownList.setAdapter(this.mAdapter);
      }

   }

   public void setAnchorView(View var1) {
      this.mDropDownAnchorView = var1;
   }

   public void setAnimationStyle(int var1) {
      this.mPopup.setAnimationStyle(var1);
   }

   public void setBackgroundDrawable(Drawable var1) {
      this.mPopup.setBackgroundDrawable(var1);
   }

   public void setContentWidth(int var1) {
      Drawable var2 = this.mPopup.getBackground();
      if(var2 != null) {
         var2.getPadding(this.mTempRect);
         this.mDropDownWidth = this.mTempRect.left + this.mTempRect.right + var1;
      } else {
         this.setWidth(var1);
      }
   }

   public void setDropDownAlwaysVisible(boolean var1) {
      this.mDropDownAlwaysVisible = var1;
   }

   public void setDropDownGravity(int var1) {
      this.mDropDownGravity = var1;
   }

   public void setForceIgnoreOutsideTouch(boolean var1) {
      this.mForceIgnoreOutsideTouch = var1;
   }

   public void setHeight(int var1) {
      this.mDropDownHeight = var1;
   }

   public void setHorizontalOffset(int var1) {
      this.mDropDownHorizontalOffset = var1;
   }

   public void setInputMethodMode(int var1) {
      this.mPopup.setInputMethodMode(var1);
   }

   void setListItemExpandMax(int var1) {
      this.mListItemExpandMaximum = var1;
   }

   public void setListSelector(Drawable var1) {
      this.mDropDownListHighlight = var1;
   }

   public void setModal(boolean var1) {
      this.mModal = var1;
      this.mPopup.setFocusable(var1);
   }

   public void setOnDismissListener(OnDismissListener var1) {
      this.mPopup.setOnDismissListener(var1);
   }

   public void setOnItemClickListener(OnItemClickListener var1) {
      this.mItemClickListener = var1;
   }

   public void setOnItemSelectedListener(OnItemSelectedListener var1) {
      this.mItemSelectedListener = var1;
   }

   public void setPromptPosition(int var1) {
      this.mPromptPosition = var1;
   }

   public void setPromptView(View var1) {
      boolean var2 = this.isShowing();
      if(var2) {
         this.removePromptView();
      }

      this.mPromptView = var1;
      if(var2) {
         this.show();
      }

   }

   public void setSelection(int var1) {
      ListPopupWindow$DropDownListView var2 = this.mDropDownList;
      if(this.isShowing() && var2 != null) {
         ListPopupWindow$DropDownListView.access$502(var2, false);
         var2.setSelection(var1);
         if(VERSION.SDK_INT >= 11 && var2.getChoiceMode() != 0) {
            var2.setItemChecked(var1, true);
         }
      }

   }

   public void setSoftInputMode(int var1) {
      this.mPopup.setSoftInputMode(var1);
   }

   public void setVerticalOffset(int var1) {
      this.mDropDownVerticalOffset = var1;
      this.mDropDownVerticalOffsetSet = true;
   }

   public void setWidth(int var1) {
      this.mDropDownWidth = var1;
   }

   public void setWindowLayoutType(int var1) {
      this.mDropDownWindowLayoutType = var1;
   }

   public void show() {
      boolean var6 = true;
      boolean var7 = false;
      byte var4 = -1;
      int var2 = this.buildDropDown();
      boolean var8 = this.isInputMethodNotNeeded();
      PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
      int var1;
      PopupWindow var9;
      if(this.mPopup.isShowing()) {
         if(this.mDropDownWidth == -1) {
            var1 = -1;
         } else if(this.mDropDownWidth == -2) {
            var1 = this.getAnchorView().getWidth();
         } else {
            var1 = this.mDropDownWidth;
         }

         if(this.mDropDownHeight == -1) {
            if(!var8) {
               var2 = -1;
            }

            byte var3;
            if(var8) {
               var9 = this.mPopup;
               if(this.mDropDownWidth == -1) {
                  var3 = -1;
               } else {
                  var3 = 0;
               }

               var9.setWidth(var3);
               this.mPopup.setHeight(0);
            } else {
               var9 = this.mPopup;
               if(this.mDropDownWidth == -1) {
                  var3 = -1;
               } else {
                  var3 = 0;
               }

               var9.setWidth(var3);
               this.mPopup.setHeight(-1);
            }
         } else if(this.mDropDownHeight != -2) {
            var2 = this.mDropDownHeight;
         }

         var9 = this.mPopup;
         var6 = var7;
         if(!this.mForceIgnoreOutsideTouch) {
            var6 = var7;
            if(!this.mDropDownAlwaysVisible) {
               var6 = true;
            }
         }

         var9.setOutsideTouchable(var6);
         var9 = this.mPopup;
         View var10 = this.getAnchorView();
         int var11 = this.mDropDownHorizontalOffset;
         int var5 = this.mDropDownVerticalOffset;
         if(var1 < 0) {
            var1 = -1;
         }

         if(var2 < 0) {
            var2 = var4;
         }

         var9.update(var10, var11, var5, var1, var2);
      } else {
         if(this.mDropDownWidth == -1) {
            var1 = -1;
         } else if(this.mDropDownWidth == -2) {
            var1 = this.getAnchorView().getWidth();
         } else {
            var1 = this.mDropDownWidth;
         }

         if(this.mDropDownHeight == -1) {
            var2 = -1;
         } else if(this.mDropDownHeight != -2) {
            var2 = this.mDropDownHeight;
         }

         this.mPopup.setWidth(var1);
         this.mPopup.setHeight(var2);
         this.setPopupClipToScreenEnabled(true);
         var9 = this.mPopup;
         if(this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
            var6 = false;
         }

         var9.setOutsideTouchable(var6);
         this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
         PopupWindowCompat.showAsDropDown(this.mPopup, this.getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
         this.mDropDownList.setSelection(-1);
         if(!this.mModal || this.mDropDownList.isInTouchMode()) {
            this.clearListSelection();
         }

         if(!this.mModal) {
            this.mHandler.post(this.mHideSelector);
            return;
         }
      }

   }
}
