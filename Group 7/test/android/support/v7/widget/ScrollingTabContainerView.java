package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.ActionBar$Tab;
import android.support.v7.appcompat.R$attr;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutCompat$LayoutParams;
import android.support.v7.widget.ScrollingTabContainerView$1;
import android.support.v7.widget.ScrollingTabContainerView$TabAdapter;
import android.support.v7.widget.ScrollingTabContainerView$TabClickListener;
import android.support.v7.widget.ScrollingTabContainerView$TabView;
import android.support.v7.widget.ScrollingTabContainerView$VisibilityAnimListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class ScrollingTabContainerView extends HorizontalScrollView implements OnItemSelectedListener {
   private static final int FADE_DURATION = 200;
   private static final String TAG = "ScrollingTabContainerView";
   private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
   private boolean mAllowCollapse;
   private int mContentHeight;
   int mMaxTabWidth;
   private int mSelectedTabIndex;
   int mStackedTabMaxWidth;
   private ScrollingTabContainerView$TabClickListener mTabClickListener;
   private LinearLayoutCompat mTabLayout;
   Runnable mTabSelector;
   private Spinner mTabSpinner;
   protected final ScrollingTabContainerView$VisibilityAnimListener mVisAnimListener = new ScrollingTabContainerView$VisibilityAnimListener(this);
   protected ViewPropertyAnimatorCompat mVisibilityAnim;

   public ScrollingTabContainerView(Context var1) {
      super(var1);
      this.setHorizontalScrollBarEnabled(false);
      ActionBarPolicy var2 = ActionBarPolicy.get(var1);
      this.setContentHeight(var2.getTabContainerHeight());
      this.mStackedTabMaxWidth = var2.getStackedTabMaxWidth();
      this.mTabLayout = this.createTabLayout();
      this.addView(this.mTabLayout, new LayoutParams(-2, -1));
   }

   private Spinner createSpinner() {
      AppCompatSpinner var1 = new AppCompatSpinner(this.getContext(), (AttributeSet)null, R$attr.actionDropDownStyle);
      var1.setLayoutParams(new LinearLayoutCompat$LayoutParams(-2, -1));
      var1.setOnItemSelectedListener(this);
      return var1;
   }

   private LinearLayoutCompat createTabLayout() {
      LinearLayoutCompat var1 = new LinearLayoutCompat(this.getContext(), (AttributeSet)null, R$attr.actionBarTabBarStyle);
      var1.setMeasureWithLargestChildEnabled(true);
      var1.setGravity(17);
      var1.setLayoutParams(new LinearLayoutCompat$LayoutParams(-2, -1));
      return var1;
   }

   private ScrollingTabContainerView$TabView createTabView(ActionBar$Tab var1, boolean var2) {
      ScrollingTabContainerView$TabView var3 = new ScrollingTabContainerView$TabView(this, this.getContext(), var1, var2);
      if(var2) {
         var3.setBackgroundDrawable((Drawable)null);
         var3.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, this.mContentHeight));
         return var3;
      } else {
         var3.setFocusable(true);
         if(this.mTabClickListener == null) {
            this.mTabClickListener = new ScrollingTabContainerView$TabClickListener(this, (ScrollingTabContainerView$1)null);
         }

         var3.setOnClickListener(this.mTabClickListener);
         return var3;
      }
   }

   private boolean isCollapsed() {
      return this.mTabSpinner != null && this.mTabSpinner.getParent() == this;
   }

   private void performCollapse() {
      if(!this.isCollapsed()) {
         if(this.mTabSpinner == null) {
            this.mTabSpinner = this.createSpinner();
         }

         this.removeView(this.mTabLayout);
         this.addView(this.mTabSpinner, new LayoutParams(-2, -1));
         if(this.mTabSpinner.getAdapter() == null) {
            this.mTabSpinner.setAdapter(new ScrollingTabContainerView$TabAdapter(this, (ScrollingTabContainerView$1)null));
         }

         if(this.mTabSelector != null) {
            this.removeCallbacks(this.mTabSelector);
            this.mTabSelector = null;
         }

         this.mTabSpinner.setSelection(this.mSelectedTabIndex);
      }
   }

   private boolean performExpand() {
      if(!this.isCollapsed()) {
         return false;
      } else {
         this.removeView(this.mTabSpinner);
         this.addView(this.mTabLayout, new LayoutParams(-2, -1));
         this.setTabSelected(this.mTabSpinner.getSelectedItemPosition());
         return false;
      }
   }

   public void addTab(ActionBar$Tab var1, int var2, boolean var3) {
      ScrollingTabContainerView$TabView var4 = this.createTabView(var1, false);
      this.mTabLayout.addView(var4, var2, new LinearLayoutCompat$LayoutParams(0, -1, 1.0F));
      if(this.mTabSpinner != null) {
         ((ScrollingTabContainerView$TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
      }

      if(var3) {
         var4.setSelected(true);
      }

      if(this.mAllowCollapse) {
         this.requestLayout();
      }

   }

   public void addTab(ActionBar$Tab var1, boolean var2) {
      ScrollingTabContainerView$TabView var3 = this.createTabView(var1, false);
      this.mTabLayout.addView(var3, new LinearLayoutCompat$LayoutParams(0, -1, 1.0F));
      if(this.mTabSpinner != null) {
         ((ScrollingTabContainerView$TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
      }

      if(var2) {
         var3.setSelected(true);
      }

      if(this.mAllowCollapse) {
         this.requestLayout();
      }

   }

   public void animateToTab(int var1) {
      View var2 = this.mTabLayout.getChildAt(var1);
      if(this.mTabSelector != null) {
         this.removeCallbacks(this.mTabSelector);
      }

      this.mTabSelector = new ScrollingTabContainerView$1(this, var2);
      this.post(this.mTabSelector);
   }

   public void animateToVisibility(int var1) {
      if(this.mVisibilityAnim != null) {
         this.mVisibilityAnim.cancel();
      }

      ViewPropertyAnimatorCompat var2;
      if(var1 == 0) {
         if(this.getVisibility() != 0) {
            ViewCompat.setAlpha(this, 0.0F);
         }

         var2 = ViewCompat.animate(this).alpha(1.0F);
         var2.setDuration(200L);
         var2.setInterpolator(sAlphaInterpolator);
         var2.setListener(this.mVisAnimListener.withFinalVisibility(var2, var1));
         var2.start();
      } else {
         var2 = ViewCompat.animate(this).alpha(0.0F);
         var2.setDuration(200L);
         var2.setInterpolator(sAlphaInterpolator);
         var2.setListener(this.mVisAnimListener.withFinalVisibility(var2, var1));
         var2.start();
      }
   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      if(this.mTabSelector != null) {
         this.post(this.mTabSelector);
      }

   }

   protected void onConfigurationChanged(Configuration var1) {
      if(VERSION.SDK_INT >= 8) {
         super.onConfigurationChanged(var1);
      }

      ActionBarPolicy var2 = ActionBarPolicy.get(this.getContext());
      this.setContentHeight(var2.getTabContainerHeight());
      this.mStackedTabMaxWidth = var2.getStackedTabMaxWidth();
   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mTabSelector != null) {
         this.removeCallbacks(this.mTabSelector);
      }

   }

   public void onItemSelected(AdapterView<?> var1, View var2, int var3, long var4) {
      ((ScrollingTabContainerView$TabView)var2).getTab().select();
   }

   public void onMeasure(int var1, int var2) {
      var2 = MeasureSpec.getMode(var1);
      boolean var4;
      if(var2 == 1073741824) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.setFillViewport(var4);
      int var3 = this.mTabLayout.getChildCount();
      if(var3 <= 1 || var2 != 1073741824 && var2 != Integer.MIN_VALUE) {
         this.mMaxTabWidth = -1;
      } else {
         if(var3 > 2) {
            this.mMaxTabWidth = (int)((float)MeasureSpec.getSize(var1) * 0.4F);
         } else {
            this.mMaxTabWidth = MeasureSpec.getSize(var1) / 2;
         }

         this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
      }

      var3 = MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
      boolean var5;
      if(!var4 && this.mAllowCollapse) {
         var5 = true;
      } else {
         var5 = false;
      }

      if(var5) {
         this.mTabLayout.measure(0, var3);
         if(this.mTabLayout.getMeasuredWidth() > MeasureSpec.getSize(var1)) {
            this.performCollapse();
         } else {
            this.performExpand();
         }
      } else {
         this.performExpand();
      }

      var2 = this.getMeasuredWidth();
      super.onMeasure(var1, var3);
      var1 = this.getMeasuredWidth();
      if(var4 && var2 != var1) {
         this.setTabSelected(this.mSelectedTabIndex);
      }

   }

   public void onNothingSelected(AdapterView<?> var1) {
   }

   public void removeAllTabs() {
      this.mTabLayout.removeAllViews();
      if(this.mTabSpinner != null) {
         ((ScrollingTabContainerView$TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
      }

      if(this.mAllowCollapse) {
         this.requestLayout();
      }

   }

   public void removeTabAt(int var1) {
      this.mTabLayout.removeViewAt(var1);
      if(this.mTabSpinner != null) {
         ((ScrollingTabContainerView$TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
      }

      if(this.mAllowCollapse) {
         this.requestLayout();
      }

   }

   public void setAllowCollapse(boolean var1) {
      this.mAllowCollapse = var1;
   }

   public void setContentHeight(int var1) {
      this.mContentHeight = var1;
      this.requestLayout();
   }

   public void setTabSelected(int var1) {
      this.mSelectedTabIndex = var1;
      int var3 = this.mTabLayout.getChildCount();

      for(int var2 = 0; var2 < var3; ++var2) {
         View var5 = this.mTabLayout.getChildAt(var2);
         boolean var4;
         if(var2 == var1) {
            var4 = true;
         } else {
            var4 = false;
         }

         var5.setSelected(var4);
         if(var4) {
            this.animateToTab(var1);
         }
      }

      if(this.mTabSpinner != null && var1 >= 0) {
         this.mTabSpinner.setSelection(var1);
      }

   }

   public void updateTab(int var1) {
      ((ScrollingTabContainerView$TabView)this.mTabLayout.getChildAt(var1)).update();
      if(this.mTabSpinner != null) {
         ((ScrollingTabContainerView$TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
      }

      if(this.mAllowCollapse) {
         this.requestLayout();
      }

   }
}
