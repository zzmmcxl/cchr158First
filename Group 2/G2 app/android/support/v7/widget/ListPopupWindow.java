package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.AppCompatPopupWindow;
import android.support.v7.internal.widget.ListViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.KeyEvent.DispatcherState;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.AbsListView.OnScrollListener;
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
   private ListAdapter mAdapter;
   private Context mContext;
   private boolean mDropDownAlwaysVisible;
   private View mDropDownAnchorView;
   private int mDropDownGravity;
   private int mDropDownHeight;
   private int mDropDownHorizontalOffset;
   private ListPopupWindow.DropDownListView mDropDownList;
   private Drawable mDropDownListHighlight;
   private int mDropDownVerticalOffset;
   private boolean mDropDownVerticalOffsetSet;
   private int mDropDownWidth;
   private boolean mForceIgnoreOutsideTouch;
   private Handler mHandler;
   private final ListPopupWindow.ListSelectorHider mHideSelector;
   private OnItemClickListener mItemClickListener;
   private OnItemSelectedListener mItemSelectedListener;
   private int mLayoutDirection;
   int mListItemExpandMaximum;
   private boolean mModal;
   private DataSetObserver mObserver;
   private PopupWindow mPopup;
   private int mPromptPosition;
   private View mPromptView;
   private final ListPopupWindow.ResizePopupRunnable mResizePopupRunnable;
   private final ListPopupWindow.PopupScrollListener mScrollListener;
   private Runnable mShowDropDownRunnable;
   private Rect mTempRect;
   private final ListPopupWindow.PopupTouchInterceptor mTouchInterceptor;

   static {
      try {
         sClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
      } catch (NoSuchMethodException var1) {
         Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
      }
   }

   public ListPopupWindow(Context var1) {
      this(var1, (AttributeSet)null, R.attr.listPopupWindowStyle);
   }

   public ListPopupWindow(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.listPopupWindowStyle);
   }

   public ListPopupWindow(Context var1, AttributeSet var2, int var3) {
      this(var1, var2, var3, 0);
   }

   public ListPopupWindow(Context var1, AttributeSet var2, int var3, int var4) {
      this.mDropDownHeight = -2;
      this.mDropDownWidth = -2;
      this.mDropDownGravity = 0;
      this.mDropDownAlwaysVisible = false;
      this.mForceIgnoreOutsideTouch = false;
      this.mListItemExpandMaximum = Integer.MAX_VALUE;
      this.mPromptPosition = 0;
      this.mResizePopupRunnable = new ListPopupWindow.ResizePopupRunnable(null);
      this.mTouchInterceptor = new ListPopupWindow.PopupTouchInterceptor(null);
      this.mScrollListener = new ListPopupWindow.PopupScrollListener(null);
      this.mHideSelector = new ListPopupWindow.ListSelectorHider(null);
      this.mHandler = new Handler();
      this.mTempRect = new Rect();
      this.mContext = var1;
      TypedArray var5 = var1.obtainStyledAttributes(var2, R.styleable.ListPopupWindow, var3, var4);
      this.mDropDownHorizontalOffset = var5.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
      this.mDropDownVerticalOffset = var5.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
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
      LayoutParams var13;
      if(this.mDropDownList == null) {
         Context var9 = this.mContext;
         this.mShowDropDownRunnable = new Runnable() {
            public void run() {
               View var1 = ListPopupWindow.this.getAnchorView();
               if(var1 != null && var1.getWindowToken() != null) {
                  ListPopupWindow.this.show();
               }

            }
         };
         boolean var5;
         if(!this.mModal) {
            var5 = true;
         } else {
            var5 = false;
         }

         this.mDropDownList = new ListPopupWindow.DropDownListView(var9, var5);
         if(this.mDropDownListHighlight != null) {
            this.mDropDownList.setSelector(this.mDropDownListHighlight);
         }

         this.mDropDownList.setAdapter(this.mAdapter);
         this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
         this.mDropDownList.setFocusable(true);
         this.mDropDownList.setFocusableInTouchMode(true);
         this.mDropDownList.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView var1, View var2, int var3, long var4) {
               if(var3 != -1) {
                  ListPopupWindow.DropDownListView var6 = ListPopupWindow.this.mDropDownList;
                  if(var6 != null) {
                     var6.mListSelectionHidden = false;
                  }
               }

            }

            public void onNothingSelected(AdapterView var1) {
            }
         });
         this.mDropDownList.setOnScrollListener(this.mScrollListener);
         if(this.mItemSelectedListener != null) {
            this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
         }

         ListPopupWindow.DropDownListView var7 = this.mDropDownList;
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

            var8.measure(MeasureSpec.makeMeasureSpec(this.mDropDownWidth, Integer.MIN_VALUE), 0);
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
      int var10;
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
         ;
      }

      int var4 = this.mPopup.getMaxAvailableHeight(this.getAnchorView(), this.mDropDownVerticalOffset);
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
      ListPopupWindow.DropDownListView var1 = this.mDropDownList;
      if(var1 != null) {
         var1.mListSelectionHidden = true;
         var1.requestLayout();
      }

   }

   public OnTouchListener createDragToOpenListener(final View var1) {
      return new ListPopupWindow.ForwardingListener(var1) {
         public ListPopupWindow getPopup() {
            return ListPopupWindow.this;
         }
      };
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

         this.mDropDownList.mListSelectionHidden = false;
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
            ListPopupWindow.DropDownListView var2 = this.mDropDownList;
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
         this.mObserver = new ListPopupWindow.PopupDataSetObserver(null);
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
      ListPopupWindow.DropDownListView var2 = this.mDropDownList;
      if(this.isShowing() && var2 != null) {
         var2.mListSelectionHidden = false;
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

   public void show() {
      boolean var5 = true;
      boolean var6 = false;
      byte var3 = -1;
      int var2 = this.buildDropDown();
      byte var1 = 0;
      byte var4 = 0;
      boolean var7 = this.isInputMethodNotNeeded();
      PopupWindow var8;
      if(this.mPopup.isShowing()) {
         int var9;
         if(this.mDropDownWidth == -1) {
            var9 = -1;
         } else if(this.mDropDownWidth == -2) {
            var9 = this.getAnchorView().getWidth();
         } else {
            var9 = this.mDropDownWidth;
         }

         if(this.mDropDownHeight == -1) {
            if(!var7) {
               var2 = -1;
            }

            if(var7) {
               var8 = this.mPopup;
               if(this.mDropDownWidth != -1) {
                  var3 = 0;
               }

               var8.setWindowLayoutMode(var3, 0);
            } else {
               var8 = this.mPopup;
               if(this.mDropDownWidth == -1) {
                  var3 = -1;
               } else {
                  var3 = 0;
               }

               var8.setWindowLayoutMode(var3, -1);
            }
         } else if(this.mDropDownHeight != -2) {
            var2 = this.mDropDownHeight;
         }

         var8 = this.mPopup;
         var5 = var6;
         if(!this.mForceIgnoreOutsideTouch) {
            var5 = var6;
            if(!this.mDropDownAlwaysVisible) {
               var5 = true;
            }
         }

         var8.setOutsideTouchable(var5);
         this.mPopup.update(this.getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, var9, var2);
      } else {
         if(this.mDropDownWidth == -1) {
            var1 = -1;
         } else if(this.mDropDownWidth == -2) {
            this.mPopup.setWidth(this.getAnchorView().getWidth());
         } else {
            this.mPopup.setWidth(this.mDropDownWidth);
         }

         byte var10;
         if(this.mDropDownHeight == -1) {
            var10 = -1;
         } else if(this.mDropDownHeight == -2) {
            this.mPopup.setHeight(var2);
            var10 = var4;
         } else {
            this.mPopup.setHeight(this.mDropDownHeight);
            var10 = var4;
         }

         this.mPopup.setWindowLayoutMode(var1, var10);
         this.setPopupClipToScreenEnabled(true);
         var8 = this.mPopup;
         if(this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
            var5 = false;
         }

         var8.setOutsideTouchable(var5);
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

   private static class DropDownListView extends ListViewCompat {
      private ViewPropertyAnimatorCompat mClickAnimation;
      private boolean mDrawsInPressedState;
      private boolean mHijackFocus;
      private boolean mListSelectionHidden;
      private ListViewAutoScrollHelper mScrollHelper;

      public DropDownListView(Context var1, boolean var2) {
         super(var1, (AttributeSet)null, R.attr.dropDownListViewStyle);
         this.mHijackFocus = var2;
         this.setCacheColorHint(0);
      }

      private void clearPressedItem() {
         this.mDrawsInPressedState = false;
         this.setPressed(false);
         this.drawableStateChanged();
         if(this.mClickAnimation != null) {
            this.mClickAnimation.cancel();
            this.mClickAnimation = null;
         }

      }

      private void clickPressedItem(View var1, int var2) {
         this.performItemClick(var1, var2, this.getItemIdAtPosition(var2));
      }

      private void setPressedItem(View var1, int var2, float var3, float var4) {
         this.mDrawsInPressedState = true;
         this.setPressed(true);
         this.layoutChildren();
         this.setSelection(var2);
         this.positionSelectorLikeTouchCompat(var2, var1, var3, var4);
         this.setSelectorEnabled(false);
         this.refreshDrawableState();
      }

      public boolean hasFocus() {
         return this.mHijackFocus || super.hasFocus();
      }

      public boolean hasWindowFocus() {
         return this.mHijackFocus || super.hasWindowFocus();
      }

      public boolean isFocused() {
         return this.mHijackFocus || super.isFocused();
      }

      public boolean isInTouchMode() {
         return this.mHijackFocus && this.mListSelectionHidden || super.isInTouchMode();
      }

      public boolean onForwardedEvent(MotionEvent var1, int var2) {
         boolean var7 = true;
         boolean var8 = true;
         boolean var3 = false;
         int var4 = MotionEventCompat.getActionMasked(var1);
         boolean var10;
         switch(var4) {
         case 1:
            var7 = false;
         case 2:
            int var5 = var1.findPointerIndex(var2);
            if(var5 < 0) {
               var7 = false;
               var10 = var3;
            } else {
               var2 = (int)var1.getX(var5);
               int var6 = (int)var1.getY(var5);
               var5 = this.pointToPosition(var2, var6);
               if(var5 == -1) {
                  var10 = true;
               } else {
                  View var9 = this.getChildAt(var5 - this.getFirstVisiblePosition());
                  this.setPressedItem(var9, var5, (float)var2, (float)var6);
                  var8 = true;
                  var10 = var3;
                  var7 = var8;
                  if(var4 == 1) {
                     this.clickPressedItem(var9, var5);
                     var10 = var3;
                     var7 = var8;
                  }
               }
            }
            break;
         case 3:
            var7 = false;
            var10 = var3;
            break;
         default:
            var7 = var8;
            var10 = var3;
         }

         if(!var7 || var10) {
            this.clearPressedItem();
         }

         if(var7) {
            if(this.mScrollHelper == null) {
               this.mScrollHelper = new ListViewAutoScrollHelper(this);
            }

            this.mScrollHelper.setEnabled(true);
            this.mScrollHelper.onTouch(this, var1);
         } else if(this.mScrollHelper != null) {
            this.mScrollHelper.setEnabled(false);
            return var7;
         }

         return var7;
      }

      protected boolean touchModeDrawsInPressedStateCompat() {
         return this.mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat();
      }
   }

   public abstract static class ForwardingListener implements OnTouchListener {
      private int mActivePointerId;
      private Runnable mDisallowIntercept;
      private boolean mForwarding;
      private final int mLongPressTimeout;
      private final float mScaledTouchSlop;
      private final View mSrc;
      private final int mTapTimeout;
      private final int[] mTmpLocation = new int[2];
      private Runnable mTriggerLongPress;
      private boolean mWasLongPress;

      public ForwardingListener(View var1) {
         this.mSrc = var1;
         this.mScaledTouchSlop = (float)ViewConfiguration.get(var1.getContext()).getScaledTouchSlop();
         this.mTapTimeout = ViewConfiguration.getTapTimeout();
         this.mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
      }

      private void clearCallbacks() {
         if(this.mTriggerLongPress != null) {
            this.mSrc.removeCallbacks(this.mTriggerLongPress);
         }

         if(this.mDisallowIntercept != null) {
            this.mSrc.removeCallbacks(this.mDisallowIntercept);
         }

      }

      private void onLongPress() {
         this.clearCallbacks();
         View var3 = this.mSrc;
         if(var3.isEnabled() && !var3.isLongClickable() && this.onForwardingStarted()) {
            var3.getParent().requestDisallowInterceptTouchEvent(true);
            long var1 = SystemClock.uptimeMillis();
            MotionEvent var4 = MotionEvent.obtain(var1, var1, 3, 0.0F, 0.0F, 0);
            var3.onTouchEvent(var4);
            var4.recycle();
            this.mForwarding = true;
            this.mWasLongPress = true;
         }
      }

      private boolean onTouchForwarded(MotionEvent var1) {
         boolean var3 = true;
         View var5 = this.mSrc;
         ListPopupWindow var6 = this.getPopup();
         if(var6 != null && var6.isShowing()) {
            ListPopupWindow.DropDownListView var9 = var6.mDropDownList;
            if(var9 != null && var9.isShown()) {
               MotionEvent var7 = MotionEvent.obtainNoHistory(var1);
               this.toGlobalMotionEvent(var5, var7);
               this.toLocalMotionEvent(var9, var7);
               boolean var4 = var9.onForwardedEvent(var7, this.mActivePointerId);
               var7.recycle();
               int var2 = MotionEventCompat.getActionMasked(var1);
               boolean var8;
               if(var2 != 1 && var2 != 3) {
                  var8 = true;
               } else {
                  var8 = false;
               }

               if(!var4 || !var8) {
                  var3 = false;
               }

               return var3;
            }
         }

         return false;
      }

      private boolean onTouchObserved(MotionEvent var1) {
         View var3 = this.mSrc;
         if(var3.isEnabled()) {
            switch(MotionEventCompat.getActionMasked(var1)) {
            case 0:
               this.mActivePointerId = var1.getPointerId(0);
               this.mWasLongPress = false;
               if(this.mDisallowIntercept == null) {
                  this.mDisallowIntercept = new ListPopupWindow.DisallowIntercept(null);
               }

               var3.postDelayed(this.mDisallowIntercept, (long)this.mTapTimeout);
               if(this.mTriggerLongPress == null) {
                  this.mTriggerLongPress = new ListPopupWindow.TriggerLongPress(null);
               }

               var3.postDelayed(this.mTriggerLongPress, (long)this.mLongPressTimeout);
               return false;
            case 1:
            case 3:
               this.clearCallbacks();
               return false;
            case 2:
               int var2 = var1.findPointerIndex(this.mActivePointerId);
               if(var2 >= 0 && !pointInView(var3, var1.getX(var2), var1.getY(var2), this.mScaledTouchSlop)) {
                  this.clearCallbacks();
                  var3.getParent().requestDisallowInterceptTouchEvent(true);
                  return true;
               }
               break;
            default:
               return false;
            }
         }

         return false;
      }

      private static boolean pointInView(View var0, float var1, float var2, float var3) {
         return var1 >= -var3 && var2 >= -var3 && var1 < (float)(var0.getRight() - var0.getLeft()) + var3 && var2 < (float)(var0.getBottom() - var0.getTop()) + var3;
      }

      private boolean toGlobalMotionEvent(View var1, MotionEvent var2) {
         int[] var3 = this.mTmpLocation;
         var1.getLocationOnScreen(var3);
         var2.offsetLocation((float)var3[0], (float)var3[1]);
         return true;
      }

      private boolean toLocalMotionEvent(View var1, MotionEvent var2) {
         int[] var3 = this.mTmpLocation;
         var1.getLocationOnScreen(var3);
         var2.offsetLocation((float)(-var3[0]), (float)(-var3[1]));
         return true;
      }

      public abstract ListPopupWindow getPopup();

      protected boolean onForwardingStarted() {
         ListPopupWindow var1 = this.getPopup();
         if(var1 != null && !var1.isShowing()) {
            var1.show();
         }

         return true;
      }

      protected boolean onForwardingStopped() {
         ListPopupWindow var1 = this.getPopup();
         if(var1 != null && var1.isShowing()) {
            var1.dismiss();
         }

         return true;
      }

      public boolean onTouch(View var1, MotionEvent var2) {
         boolean var5 = false;
         boolean var6 = this.mForwarding;
         boolean var3;
         if(var6) {
            if(this.mWasLongPress) {
               var3 = this.onTouchForwarded(var2);
            } else if(!this.onTouchForwarded(var2) && this.onForwardingStopped()) {
               var3 = false;
            } else {
               var3 = true;
            }
         } else {
            boolean var4;
            if(this.onTouchObserved(var2) && this.onForwardingStarted()) {
               var4 = true;
            } else {
               var4 = false;
            }

            var3 = var4;
            if(var4) {
               long var7 = SystemClock.uptimeMillis();
               MotionEvent var9 = MotionEvent.obtain(var7, var7, 3, 0.0F, 0.0F, 0);
               this.mSrc.onTouchEvent(var9);
               var9.recycle();
               var3 = var4;
            }
         }

         this.mForwarding = var3;
         if(!var3) {
            var3 = var5;
            if(!var6) {
               return var3;
            }
         }

         var3 = true;
         return var3;
      }
   }

   private class DisallowIntercept implements Runnable {
      private DisallowIntercept() {
      }

      // $FF: synthetic method
      DisallowIntercept(Object var2) {
         this();
      }

      public void run() {
         ListPopupWindow.super.mSrc.getParent().requestDisallowInterceptTouchEvent(true);
      }
   }

   private class TriggerLongPress implements Runnable {
      private TriggerLongPress() {
      }

      // $FF: synthetic method
      TriggerLongPress(Object var2) {
         this();
      }

      public void run() {
         ListPopupWindow.super.onLongPress();
      }
   }

   private class ListSelectorHider implements Runnable {
      private ListSelectorHider() {
      }

      // $FF: synthetic method
      ListSelectorHider(Object var2) {
         this();
      }

      public void run() {
         ListPopupWindow.this.clearListSelection();
      }
   }

   private class PopupDataSetObserver extends DataSetObserver {
      private PopupDataSetObserver() {
      }

      // $FF: synthetic method
      PopupDataSetObserver(Object var2) {
         this();
      }

      public void onChanged() {
         if(ListPopupWindow.this.isShowing()) {
            ListPopupWindow.this.show();
         }

      }

      public void onInvalidated() {
         ListPopupWindow.this.dismiss();
      }
   }

   private class PopupScrollListener implements OnScrollListener {
      private PopupScrollListener() {
      }

      // $FF: synthetic method
      PopupScrollListener(Object var2) {
         this();
      }

      public void onScroll(AbsListView var1, int var2, int var3, int var4) {
      }

      public void onScrollStateChanged(AbsListView var1, int var2) {
         if(var2 == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
            ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
            ListPopupWindow.this.mResizePopupRunnable.run();
         }

      }
   }

   private class PopupTouchInterceptor implements OnTouchListener {
      private PopupTouchInterceptor() {
      }

      // $FF: synthetic method
      PopupTouchInterceptor(Object var2) {
         this();
      }

      public boolean onTouch(View var1, MotionEvent var2) {
         int var3 = var2.getAction();
         int var4 = (int)var2.getX();
         int var5 = (int)var2.getY();
         if(var3 == 0 && ListPopupWindow.this.mPopup != null && ListPopupWindow.this.mPopup.isShowing() && var4 >= 0 && var4 < ListPopupWindow.this.mPopup.getWidth() && var5 >= 0 && var5 < ListPopupWindow.this.mPopup.getHeight()) {
            ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250L);
         } else if(var3 == 1) {
            ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
         }

         return false;
      }
   }

   private class ResizePopupRunnable implements Runnable {
      private ResizePopupRunnable() {
      }

      // $FF: synthetic method
      ResizePopupRunnable(Object var2) {
         this();
      }

      public void run() {
         if(ListPopupWindow.this.mDropDownList != null && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
            ListPopupWindow.this.mPopup.setInputMethodMode(2);
            ListPopupWindow.this.show();
         }

      }
   }
}
