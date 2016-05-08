package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.design.R$layout;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout$Tab;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar$Tab;
import android.support.v7.widget.AppCompatDrawableManager;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

class TabLayout$TabView extends LinearLayout implements OnLongClickListener {
   private ImageView mCustomIconView;
   private TextView mCustomTextView;
   private View mCustomView;
   private int mDefaultMaxLines;
   private ImageView mIconView;
   private TabLayout$Tab mTab;
   private TextView mTextView;

   public TabLayout$TabView(TabLayout var1, Context var2) {
      super(var2);
      this.this$0 = var1;
      this.mDefaultMaxLines = 2;
      if(TabLayout.access$900(var1) != 0) {
         this.setBackgroundDrawable(AppCompatDrawableManager.get().getDrawable(var2, TabLayout.access$900(var1)));
      }

      ViewCompat.setPaddingRelative(this, TabLayout.access$1000(var1), TabLayout.access$1100(var1), TabLayout.access$1200(var1), TabLayout.access$1300(var1));
      this.setGravity(17);
      this.setOrientation(1);
      this.setClickable(true);
   }

   private float approximateLineWidth(Layout var1, int var2, float var3) {
      return var1.getLineWidth(var2) * (var3 / var1.getPaint().getTextSize());
   }

   private void reset() {
      this.setTab((TabLayout$Tab)null);
      this.setSelected(false);
   }

   private void setTab(@Nullable TabLayout$Tab var1) {
      if(var1 != this.mTab) {
         this.mTab = var1;
         this.update();
      }

   }

   private void updateTextAndIcon(@Nullable TextView var1, @Nullable ImageView var2) {
      Drawable var6;
      if(this.mTab != null) {
         var6 = this.mTab.getIcon();
      } else {
         var6 = null;
      }

      CharSequence var7;
      if(this.mTab != null) {
         var7 = this.mTab.getText();
      } else {
         var7 = null;
      }

      CharSequence var8;
      if(this.mTab != null) {
         var8 = this.mTab.getContentDescription();
      } else {
         var8 = null;
      }

      if(var2 != null) {
         if(var6 != null) {
            var2.setImageDrawable(var6);
            var2.setVisibility(0);
            this.setVisibility(0);
         } else {
            var2.setVisibility(8);
            var2.setImageDrawable((Drawable)null);
         }

         var2.setContentDescription(var8);
      }

      boolean var3;
      if(!TextUtils.isEmpty(var7)) {
         var3 = true;
      } else {
         var3 = false;
      }

      if(var1 != null) {
         if(var3) {
            var1.setText(var7);
            var1.setVisibility(0);
            this.setVisibility(0);
         } else {
            var1.setVisibility(8);
            var1.setText((CharSequence)null);
         }

         var1.setContentDescription(var8);
      }

      if(var2 != null) {
         MarginLayoutParams var9 = (MarginLayoutParams)var2.getLayoutParams();
         byte var5 = 0;
         int var4 = var5;
         if(var3) {
            var4 = var5;
            if(var2.getVisibility() == 0) {
               var4 = TabLayout.access$2100(this.this$0, 8);
            }
         }

         if(var4 != var9.bottomMargin) {
            var9.bottomMargin = var4;
            var2.requestLayout();
         }
      }

      if(!var3 && !TextUtils.isEmpty(var8)) {
         this.setOnLongClickListener(this);
      } else {
         this.setOnLongClickListener((OnLongClickListener)null);
         this.setLongClickable(false);
      }
   }

   public TabLayout$Tab getTab() {
      return this.mTab;
   }

   @TargetApi(14)
   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      super.onInitializeAccessibilityEvent(var1);
      var1.setClassName(ActionBar$Tab.class.getName());
   }

   @TargetApi(14)
   public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
      super.onInitializeAccessibilityNodeInfo(var1);
      var1.setClassName(ActionBar$Tab.class.getName());
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
      int var5 = MeasureSpec.getSize(var1);
      int var6 = MeasureSpec.getMode(var1);
      int var7 = TabLayout.access$1400(this.this$0);
      if(var7 > 0 && (var6 == 0 || var5 > var7)) {
         var1 = MeasureSpec.makeMeasureSpec(TabLayout.access$1500(this.this$0), Integer.MIN_VALUE);
      }

      super.onMeasure(var1, var2);
      if(this.mTextView != null) {
         this.getResources();
         float var4 = TabLayout.access$1600(this.this$0);
         var6 = this.mDefaultMaxLines;
         float var3;
         if(this.mIconView != null && this.mIconView.getVisibility() == 0) {
            var5 = 1;
            var3 = var4;
         } else {
            var5 = var6;
            var3 = var4;
            if(this.mTextView != null) {
               var5 = var6;
               var3 = var4;
               if(this.mTextView.getLineCount() > 1) {
                  var3 = TabLayout.access$1700(this.this$0);
                  var5 = var6;
               }
            }
         }

         var4 = this.mTextView.getTextSize();
         int var8 = this.mTextView.getLineCount();
         var6 = TextViewCompat.getMaxLines(this.mTextView);
         if(var3 != var4 || var6 >= 0 && var5 != var6) {
            boolean var11 = true;
            boolean var10 = var11;
            if(TabLayout.access$1800(this.this$0) == 1) {
               var10 = var11;
               if(var3 > var4) {
                  var10 = var11;
                  if(var8 == 1) {
                     label66: {
                        Layout var9 = this.mTextView.getLayout();
                        if(var9 != null) {
                           var10 = var11;
                           if(this.approximateLineWidth(var9, 0, var3) <= (float)var9.getWidth()) {
                              break label66;
                           }
                        }

                        var10 = false;
                     }
                  }
               }
            }

            if(var10) {
               this.mTextView.setTextSize(0, var3);
               this.mTextView.setMaxLines(var5);
               super.onMeasure(var1, var2);
            }
         }
      }

   }

   public boolean performClick() {
      boolean var1 = super.performClick();
      if(this.mTab != null) {
         this.mTab.select();
         var1 = true;
      }

      return var1;
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
         if(this.mTextView != null) {
            this.mTextView.setSelected(var1);
         }

         if(this.mIconView != null) {
            this.mIconView.setSelected(var1);
         }
      }

   }

   final void update() {
      TabLayout$Tab var1 = this.mTab;
      View var3;
      if(var1 != null) {
         var3 = var1.getCustomView();
      } else {
         var3 = null;
      }

      if(var3 != null) {
         ViewParent var2 = var3.getParent();
         if(var2 != this) {
            if(var2 != null) {
               ((ViewGroup)var2).removeView(var3);
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

         this.mCustomTextView = (TextView)var3.findViewById(16908308);
         if(this.mCustomTextView != null) {
            this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mCustomTextView);
         }

         this.mCustomIconView = (ImageView)var3.findViewById(16908294);
      } else {
         if(this.mCustomView != null) {
            this.removeView(this.mCustomView);
            this.mCustomView = null;
         }

         this.mCustomTextView = null;
         this.mCustomIconView = null;
      }

      if(this.mCustomView == null) {
         if(this.mIconView == null) {
            ImageView var4 = (ImageView)LayoutInflater.from(this.getContext()).inflate(R$layout.design_layout_tab_icon, this, false);
            this.addView(var4, 0);
            this.mIconView = var4;
         }

         if(this.mTextView == null) {
            TextView var5 = (TextView)LayoutInflater.from(this.getContext()).inflate(R$layout.design_layout_tab_text, this, false);
            this.addView(var5);
            this.mTextView = var5;
            this.mDefaultMaxLines = TextViewCompat.getMaxLines(this.mTextView);
         }

         this.mTextView.setTextAppearance(this.getContext(), TabLayout.access$1900(this.this$0));
         if(TabLayout.access$2000(this.this$0) != null) {
            this.mTextView.setTextColor(TabLayout.access$2000(this.this$0));
         }

         this.updateTextAndIcon(this.mTextView, this.mIconView);
      } else if(this.mCustomTextView != null || this.mCustomIconView != null) {
         this.updateTextAndIcon(this.mCustomTextView, this.mCustomIconView);
         return;
      }

   }
}
