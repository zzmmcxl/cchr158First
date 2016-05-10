package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, OnClickListener, OnLongClickListener, ActionMenuView.ActionMenuChildView {
   private static final int MAX_ICON_SIZE = 32;
   private static final String TAG = "ActionMenuItemView";
   private boolean mAllowTextWithIcon;
   private boolean mExpandedFormat;
   private ListPopupWindow.ForwardingListener mForwardingListener;
   private Drawable mIcon;
   private MenuItemImpl mItemData;
   private MenuBuilder.ItemInvoker mItemInvoker;
   private int mMaxIconSize;
   private int mMinWidth;
   private ActionMenuItemView.PopupCallback mPopupCallback;
   private int mSavedPaddingLeft;
   private CharSequence mTitle;

   public ActionMenuItemView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ActionMenuItemView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ActionMenuItemView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      Resources var4 = var1.getResources();
      this.mAllowTextWithIcon = var4.getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
      TypedArray var5 = var1.obtainStyledAttributes(var2, R.styleable.ActionMenuItemView, var3, 0);
      this.mMinWidth = var5.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
      var5.recycle();
      this.mMaxIconSize = (int)(32.0F * var4.getDisplayMetrics().density + 0.5F);
      this.setOnClickListener(this);
      this.setOnLongClickListener(this);
      this.mSavedPaddingLeft = -1;
   }

   private void updateTextButtonVisibility() {
      boolean var3 = false;
      boolean var1;
      if(!TextUtils.isEmpty(this.mTitle)) {
         var1 = true;
      } else {
         var1 = false;
      }

      boolean var2;
      label25: {
         if(this.mIcon != null) {
            var2 = var3;
            if(!this.mItemData.showsTextAsAction()) {
               break label25;
            }

            if(!this.mAllowTextWithIcon) {
               var2 = var3;
               if(!this.mExpandedFormat) {
                  break label25;
               }
            }
         }

         var2 = true;
      }

      CharSequence var4;
      if(var1 & var2) {
         var4 = this.mTitle;
      } else {
         var4 = null;
      }

      this.setText(var4);
   }

   public MenuItemImpl getItemData() {
      return this.mItemData;
   }

   public boolean hasText() {
      return !TextUtils.isEmpty(this.getText());
   }

   public void initialize(MenuItemImpl var1, int var2) {
      this.mItemData = var1;
      this.setIcon(var1.getIcon());
      this.setTitle(var1.getTitleForItemView(this));
      this.setId(var1.getItemId());
      byte var3;
      if(var1.isVisible()) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      this.setVisibility(var3);
      this.setEnabled(var1.isEnabled());
      if(var1.hasSubMenu() && this.mForwardingListener == null) {
         this.mForwardingListener = new ActionMenuItemView.ActionMenuItemForwardingListener();
      }

   }

   public boolean needsDividerAfter() {
      return this.hasText();
   }

   public boolean needsDividerBefore() {
      return this.hasText() && this.mItemData.getIcon() == null;
   }

   public void onClick(View var1) {
      if(this.mItemInvoker != null) {
         this.mItemInvoker.invokeItem(this.mItemData);
      }

   }

   public void onConfigurationChanged(Configuration var1) {
      if(VERSION.SDK_INT >= 8) {
         super.onConfigurationChanged(var1);
      }

      this.mAllowTextWithIcon = this.getContext().getResources().getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
      this.updateTextButtonVisibility();
   }

   public boolean onLongClick(View var1) {
      if(this.hasText()) {
         return false;
      } else {
         int[] var8 = new int[2];
         Rect var7 = new Rect();
         this.getLocationOnScreen(var8);
         this.getWindowVisibleDisplayFrame(var7);
         Context var9 = this.getContext();
         int var2 = this.getWidth();
         int var4 = this.getHeight();
         int var5 = var8[1];
         int var6 = var4 / 2;
         int var3 = var8[0] + var2 / 2;
         var2 = var3;
         if(ViewCompat.getLayoutDirection(var1) == 0) {
            var2 = var9.getResources().getDisplayMetrics().widthPixels - var3;
         }

         Toast var10 = Toast.makeText(var9, this.mItemData.getTitle(), 0);
         if(var5 + var6 < var7.height()) {
            var10.setGravity(8388661, var2, var4);
         } else {
            var10.setGravity(81, 0, var4);
         }

         var10.show();
         return true;
      }
   }

   protected void onMeasure(int var1, int var2) {
      boolean var5 = this.hasText();
      if(var5 && this.mSavedPaddingLeft >= 0) {
         super.setPadding(this.mSavedPaddingLeft, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
      }

      super.onMeasure(var1, var2);
      int var3 = MeasureSpec.getMode(var1);
      var1 = MeasureSpec.getSize(var1);
      int var4 = this.getMeasuredWidth();
      if(var3 == Integer.MIN_VALUE) {
         var1 = Math.min(var1, this.mMinWidth);
      } else {
         var1 = this.mMinWidth;
      }

      if(var3 != 1073741824 && this.mMinWidth > 0 && var4 < var1) {
         super.onMeasure(MeasureSpec.makeMeasureSpec(var1, 1073741824), var2);
      }

      if(!var5 && this.mIcon != null) {
         super.setPadding((this.getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.mItemData.hasSubMenu() && this.mForwardingListener != null && this.mForwardingListener.onTouch(this, var1)?true:super.onTouchEvent(var1);
   }

   public boolean prefersCondensedTitle() {
      return true;
   }

   public void setCheckable(boolean var1) {
   }

   public void setChecked(boolean var1) {
   }

   public void setExpandedFormat(boolean var1) {
      if(this.mExpandedFormat != var1) {
         this.mExpandedFormat = var1;
         if(this.mItemData != null) {
            this.mItemData.actionFormatChanged();
         }
      }

   }

   public void setIcon(Drawable var1) {
      this.mIcon = var1;
      if(var1 != null) {
         int var6 = var1.getIntrinsicWidth();
         int var5 = var1.getIntrinsicHeight();
         int var4 = var5;
         int var3 = var6;
         float var2;
         if(var6 > this.mMaxIconSize) {
            var2 = (float)this.mMaxIconSize / (float)var6;
            var3 = this.mMaxIconSize;
            var4 = (int)((float)var5 * var2);
         }

         var6 = var4;
         var5 = var3;
         if(var4 > this.mMaxIconSize) {
            var2 = (float)this.mMaxIconSize / (float)var4;
            var6 = this.mMaxIconSize;
            var5 = (int)((float)var3 * var2);
         }

         var1.setBounds(0, 0, var5, var6);
      }

      this.setCompoundDrawables(var1, (Drawable)null, (Drawable)null, (Drawable)null);
      this.updateTextButtonVisibility();
   }

   public void setItemInvoker(MenuBuilder.ItemInvoker var1) {
      this.mItemInvoker = var1;
   }

   public void setPadding(int var1, int var2, int var3, int var4) {
      this.mSavedPaddingLeft = var1;
      super.setPadding(var1, var2, var3, var4);
   }

   public void setPopupCallback(ActionMenuItemView.PopupCallback var1) {
      this.mPopupCallback = var1;
   }

   public void setShortcut(boolean var1, char var2) {
   }

   public void setTitle(CharSequence var1) {
      this.mTitle = var1;
      this.setContentDescription(this.mTitle);
      this.updateTextButtonVisibility();
   }

   public boolean showsIcon() {
      return true;
   }

   private class ActionMenuItemForwardingListener extends ListPopupWindow.ForwardingListener {
      public ActionMenuItemForwardingListener() {
         super(ActionMenuItemView.this);
      }

      public ListPopupWindow getPopup() {
         return ActionMenuItemView.this.mPopupCallback != null?ActionMenuItemView.this.mPopupCallback.getPopup():null;
      }

      protected boolean onForwardingStarted() {
         boolean var2 = false;
         boolean var1 = var2;
         if(ActionMenuItemView.this.mItemInvoker != null) {
            var1 = var2;
            if(ActionMenuItemView.this.mItemInvoker.invokeItem(ActionMenuItemView.this.mItemData)) {
               ListPopupWindow var3 = this.getPopup();
               var1 = var2;
               if(var3 != null) {
                  var1 = var2;
                  if(var3.isShowing()) {
                     var1 = true;
                  }
               }
            }
         }

         return var1;
      }
   }

   public abstract static class PopupCallback {
      public abstract ListPopupWindow getPopup();
   }
}
