package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar$Tab;
import android.support.v7.appcompat.R$attr;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutCompat$LayoutParams;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.TintTypedArray;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class ScrollingTabContainerView$TabView extends LinearLayoutCompat implements OnLongClickListener {
   private final int[] BG_ATTRS;
   private View mCustomView;
   private ImageView mIconView;
   private ActionBar$Tab mTab;
   private TextView mTextView;

   public ScrollingTabContainerView$TabView(ScrollingTabContainerView var1, Context var2, ActionBar$Tab var3, boolean var4) {
      super(var2, (AttributeSet)null, R$attr.actionBarTabStyle);
      this.this$0 = var1;
      this.BG_ATTRS = new int[]{16842964};
      this.mTab = var3;
      TintTypedArray var5 = TintTypedArray.obtainStyledAttributes(var2, (AttributeSet)null, this.BG_ATTRS, R$attr.actionBarTabStyle, 0);
      if(var5.hasValue(0)) {
         this.setBackgroundDrawable(var5.getDrawable(0));
      }

      var5.recycle();
      if(var4) {
         this.setGravity(8388627);
      }

      this.update();
   }

   public void bindTab(ActionBar$Tab var1) {
      this.mTab = var1;
      this.update();
   }

   public ActionBar$Tab getTab() {
      return this.mTab;
   }

   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      super.onInitializeAccessibilityEvent(var1);
      var1.setClassName(ActionBar$Tab.class.getName());
   }

   public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
      super.onInitializeAccessibilityNodeInfo(var1);
      if(VERSION.SDK_INT >= 14) {
         var1.setClassName(ActionBar$Tab.class.getName());
      }

   }

   public boolean onLongClick(View var1) {
      int[] var6 = new int[2];
      this.getLocationOnScreen(var6);
      Context var5 = this.getContext();
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      int var4 = var5.getResources().getDisplayMetrics().widthPixels;
      Toast var7 = Toast.makeText(var5, this.mTab.getContentDescription(), 0);
      var7.setGravity(49, var6[0] + var2 / 2 - var4 / 2, var3);
      var7.show();
      return true;
   }

   public void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if(this.this$0.mMaxTabWidth > 0 && this.getMeasuredWidth() > this.this$0.mMaxTabWidth) {
         super.onMeasure(MeasureSpec.makeMeasureSpec(this.this$0.mMaxTabWidth, 1073741824), var2);
      }

   }

   public void setSelected(boolean var1) {
      boolean var2;
      if(this.isSelected() != var1) {
         var2 = true;
      } else {
         var2 = false;
      }

      super.setSelected(var1);
      if(var2 && var1) {
         this.sendAccessibilityEvent(4);
      }

   }

   public void update() {
      ActionBar$Tab var2 = this.mTab;
      View var3 = var2.getCustomView();
      if(var3 != null) {
         ViewParent var7 = var3.getParent();
         if(var7 != this) {
            if(var7 != null) {
               ((ViewGroup)var7).removeView(var3);
            }

            this.addView(var3);
         }

         this.mCustomView = var3;
         if(this.mTextView != null) {
            this.mTextView.setVisibility(8);
         }

         if(this.mIconView != null) {
            this.mIconView.setVisibility(8);
            this.mIconView.setImageDrawable((Drawable)null);
         }

      } else {
         if(this.mCustomView != null) {
            this.removeView(this.mCustomView);
            this.mCustomView = null;
         }

         Drawable var4 = var2.getIcon();
         CharSequence var8 = var2.getText();
         if(var4 != null) {
            if(this.mIconView == null) {
               ImageView var5 = new ImageView(this.getContext());
               LinearLayoutCompat$LayoutParams var6 = new LinearLayoutCompat$LayoutParams(-2, -2);
               var6.gravity = 16;
               var5.setLayoutParams(var6);
               this.addView(var5, 0);
               this.mIconView = var5;
            }

            this.mIconView.setImageDrawable(var4);
            this.mIconView.setVisibility(0);
         } else if(this.mIconView != null) {
            this.mIconView.setVisibility(8);
            this.mIconView.setImageDrawable((Drawable)null);
         }

         boolean var1;
         if(!TextUtils.isEmpty(var8)) {
            var1 = true;
         } else {
            var1 = false;
         }

         if(var1) {
            if(this.mTextView == null) {
               AppCompatTextView var9 = new AppCompatTextView(this.getContext(), (AttributeSet)null, R$attr.actionBarTabTextStyle);
               var9.setEllipsize(TruncateAt.END);
               LinearLayoutCompat$LayoutParams var10 = new LinearLayoutCompat$LayoutParams(-2, -2);
               var10.gravity = 16;
               var9.setLayoutParams(var10);
               this.addView(var9);
               this.mTextView = var9;
            }

            this.mTextView.setText(var8);
            this.mTextView.setVisibility(0);
         } else if(this.mTextView != null) {
            this.mTextView.setVisibility(8);
            this.mTextView.setText((CharSequence)null);
         }

         if(this.mIconView != null) {
            this.mIconView.setContentDescription(var2.getContentDescription());
         }

         if(!var1 && !TextUtils.isEmpty(var2.getContentDescription())) {
            this.setOnLongClickListener(this);
         } else {
            this.setOnLongClickListener((OnLongClickListener)null);
            this.setLongClickable(false);
         }
      }
   }
}
