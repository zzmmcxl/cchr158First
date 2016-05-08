package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertController$1;
import android.support.v7.app.AlertController$2;
import android.support.v7.app.AlertController$3;
import android.support.v7.app.AlertController$4;
import android.support.v7.app.AlertController$5;
import android.support.v7.app.AlertController$ButtonHandler;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.appcompat.R$attr;
import android.support.v7.appcompat.R$id;
import android.support.v7.appcompat.R$styleable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

class AlertController {
   private ListAdapter mAdapter;
   private int mAlertDialogLayout;
   private final OnClickListener mButtonHandler = new AlertController$1(this);
   private Button mButtonNegative;
   private Message mButtonNegativeMessage;
   private CharSequence mButtonNegativeText;
   private Button mButtonNeutral;
   private Message mButtonNeutralMessage;
   private CharSequence mButtonNeutralText;
   private int mButtonPanelLayoutHint = 0;
   private int mButtonPanelSideLayout;
   private Button mButtonPositive;
   private Message mButtonPositiveMessage;
   private CharSequence mButtonPositiveText;
   private int mCheckedItem = -1;
   private final Context mContext;
   private View mCustomTitleView;
   private final AppCompatDialog mDialog;
   private Handler mHandler;
   private Drawable mIcon;
   private int mIconId = 0;
   private ImageView mIconView;
   private int mListItemLayout;
   private int mListLayout;
   private ListView mListView;
   private CharSequence mMessage;
   private TextView mMessageView;
   private int mMultiChoiceItemLayout;
   private NestedScrollView mScrollView;
   private int mSingleChoiceItemLayout;
   private CharSequence mTitle;
   private TextView mTitleView;
   private View mView;
   private int mViewLayoutResId;
   private int mViewSpacingBottom;
   private int mViewSpacingLeft;
   private int mViewSpacingRight;
   private boolean mViewSpacingSpecified = false;
   private int mViewSpacingTop;
   private final Window mWindow;

   public AlertController(Context var1, AppCompatDialog var2, Window var3) {
      this.mContext = var1;
      this.mDialog = var2;
      this.mWindow = var3;
      this.mHandler = new AlertController$ButtonHandler(var2);
      TypedArray var4 = var1.obtainStyledAttributes((AttributeSet)null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
      this.mAlertDialogLayout = var4.getResourceId(R$styleable.AlertDialog_android_layout, 0);
      this.mButtonPanelSideLayout = var4.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
      this.mListLayout = var4.getResourceId(R$styleable.AlertDialog_listLayout, 0);
      this.mMultiChoiceItemLayout = var4.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
      this.mSingleChoiceItemLayout = var4.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
      this.mListItemLayout = var4.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
      var4.recycle();
   }

   static boolean canTextInput(View var0) {
      if(var0.onCheckIsTextEditor()) {
         return true;
      } else if(!(var0 instanceof ViewGroup)) {
         return false;
      } else {
         ViewGroup var3 = (ViewGroup)var0;
         int var1 = var3.getChildCount();

         int var2;
         do {
            if(var1 <= 0) {
               return false;
            }

            var2 = var1 - 1;
            var1 = var2;
         } while(!canTextInput(var3.getChildAt(var2)));

         return true;
      }
   }

   private static void manageScrollIndicators(View var0, View var1, View var2) {
      byte var4 = 0;
      byte var3;
      if(var1 != null) {
         if(ViewCompat.canScrollVertically(var0, -1)) {
            var3 = 0;
         } else {
            var3 = 4;
         }

         var1.setVisibility(var3);
      }

      if(var2 != null) {
         if(ViewCompat.canScrollVertically(var0, 1)) {
            var3 = var4;
         } else {
            var3 = 4;
         }

         var2.setVisibility(var3);
      }

   }

   @Nullable
   private ViewGroup resolvePanel(@Nullable View var1, @Nullable View var2) {
      if(var1 == null) {
         var1 = var2;
         if(var2 instanceof ViewStub) {
            var1 = ((ViewStub)var2).inflate();
         }

         return (ViewGroup)var1;
      } else {
         if(var2 != null) {
            ViewParent var3 = var2.getParent();
            if(var3 instanceof ViewGroup) {
               ((ViewGroup)var3).removeView(var2);
            }
         }

         var2 = var1;
         if(var1 instanceof ViewStub) {
            var2 = ((ViewStub)var1).inflate();
         }

         return (ViewGroup)var2;
      }
   }

   private int selectContentView() {
      return this.mButtonPanelSideLayout == 0?this.mAlertDialogLayout:(this.mButtonPanelLayoutHint == 1?this.mButtonPanelSideLayout:this.mAlertDialogLayout);
   }

   private void setScrollIndicators(ViewGroup var1, View var2, int var3, int var4) {
      View var5 = this.mWindow.findViewById(R$id.scrollIndicatorUp);
      View var6 = this.mWindow.findViewById(R$id.scrollIndicatorDown);
      if(VERSION.SDK_INT >= 23) {
         ViewCompat.setScrollIndicators(var2, var3, var4);
         if(var5 != null) {
            var1.removeView(var5);
         }

         if(var6 != null) {
            var1.removeView(var6);
         }
      } else {
         var2 = var5;
         if(var5 != null) {
            var2 = var5;
            if((var3 & 1) == 0) {
               var1.removeView(var5);
               var2 = null;
            }
         }

         var5 = var6;
         if(var6 != null) {
            var5 = var6;
            if((var3 & 2) == 0) {
               var1.removeView(var6);
               var5 = null;
            }
         }

         if(var2 != null || var5 != null) {
            if(this.mMessage != null) {
               this.mScrollView.setOnScrollChangeListener(new AlertController$2(this, var2, var5));
               this.mScrollView.post(new AlertController$3(this, var2, var5));
               return;
            }

            if(this.mListView != null) {
               this.mListView.setOnScrollListener(new AlertController$4(this, var2, var5));
               this.mListView.post(new AlertController$5(this, var2, var5));
               return;
            }

            if(var2 != null) {
               var1.removeView(var2);
            }

            if(var5 != null) {
               var1.removeView(var5);
               return;
            }
         }
      }

   }

   private void setupButtons(ViewGroup var1) {
      boolean var3 = false;
      int var2 = 0;
      this.mButtonPositive = (Button)var1.findViewById(16908313);
      this.mButtonPositive.setOnClickListener(this.mButtonHandler);
      if(TextUtils.isEmpty(this.mButtonPositiveText)) {
         this.mButtonPositive.setVisibility(8);
      } else {
         this.mButtonPositive.setText(this.mButtonPositiveText);
         this.mButtonPositive.setVisibility(0);
         var2 = 0 | 1;
      }

      this.mButtonNegative = (Button)var1.findViewById(16908314);
      this.mButtonNegative.setOnClickListener(this.mButtonHandler);
      if(TextUtils.isEmpty(this.mButtonNegativeText)) {
         this.mButtonNegative.setVisibility(8);
      } else {
         this.mButtonNegative.setText(this.mButtonNegativeText);
         this.mButtonNegative.setVisibility(0);
         var2 |= 2;
      }

      this.mButtonNeutral = (Button)var1.findViewById(16908315);
      this.mButtonNeutral.setOnClickListener(this.mButtonHandler);
      if(TextUtils.isEmpty(this.mButtonNeutralText)) {
         this.mButtonNeutral.setVisibility(8);
      } else {
         this.mButtonNeutral.setText(this.mButtonNeutralText);
         this.mButtonNeutral.setVisibility(0);
         var2 |= 4;
      }

      if(var2 != 0) {
         var3 = true;
      }

      if(!var3) {
         var1.setVisibility(8);
      }

   }

   private void setupContent(ViewGroup var1) {
      this.mScrollView = (NestedScrollView)this.mWindow.findViewById(R$id.scrollView);
      this.mScrollView.setFocusable(false);
      this.mScrollView.setNestedScrollingEnabled(false);
      this.mMessageView = (TextView)var1.findViewById(16908299);
      if(this.mMessageView != null) {
         if(this.mMessage != null) {
            this.mMessageView.setText(this.mMessage);
         } else {
            this.mMessageView.setVisibility(8);
            this.mScrollView.removeView(this.mMessageView);
            if(this.mListView != null) {
               var1 = (ViewGroup)this.mScrollView.getParent();
               int var2 = var1.indexOfChild(this.mScrollView);
               var1.removeViewAt(var2);
               var1.addView(this.mListView, var2, new LayoutParams(-1, -1));
            } else {
               var1.setVisibility(8);
            }
         }
      }
   }

   private void setupCustomContent(ViewGroup var1) {
      boolean var2 = false;
      View var3;
      if(this.mView != null) {
         var3 = this.mView;
      } else if(this.mViewLayoutResId != 0) {
         var3 = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, var1, false);
      } else {
         var3 = null;
      }

      if(var3 != null) {
         var2 = true;
      }

      if(!var2 || !canTextInput(var3)) {
         this.mWindow.setFlags(131072, 131072);
      }

      if(var2) {
         FrameLayout var4 = (FrameLayout)this.mWindow.findViewById(R$id.custom);
         var4.addView(var3, new LayoutParams(-1, -1));
         if(this.mViewSpacingSpecified) {
            var4.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
         }

         if(this.mListView != null) {
            ((android.widget.LinearLayout.LayoutParams)var1.getLayoutParams()).weight = 0.0F;
         }

      } else {
         var1.setVisibility(8);
      }
   }

   private void setupTitle(ViewGroup var1) {
      boolean var2 = false;
      if(this.mCustomTitleView != null) {
         LayoutParams var3 = new LayoutParams(-1, -2);
         var1.addView(this.mCustomTitleView, 0, var3);
         this.mWindow.findViewById(R$id.title_template).setVisibility(8);
      } else {
         this.mIconView = (ImageView)this.mWindow.findViewById(16908294);
         if(!TextUtils.isEmpty(this.mTitle)) {
            var2 = true;
         }

         if(var2) {
            this.mTitleView = (TextView)this.mWindow.findViewById(R$id.alertTitle);
            this.mTitleView.setText(this.mTitle);
            if(this.mIconId != 0) {
               this.mIconView.setImageResource(this.mIconId);
            } else if(this.mIcon != null) {
               this.mIconView.setImageDrawable(this.mIcon);
            } else {
               this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
               this.mIconView.setVisibility(8);
            }
         } else {
            this.mWindow.findViewById(R$id.title_template).setVisibility(8);
            this.mIconView.setVisibility(8);
            var1.setVisibility(8);
         }
      }
   }

   private void setupView() {
      View var5 = this.mWindow.findViewById(R$id.parentPanel);
      View var8 = var5.findViewById(R$id.topPanel);
      View var6 = var5.findViewById(R$id.contentPanel);
      View var4 = var5.findViewById(R$id.buttonPanel);
      ViewGroup var16 = (ViewGroup)var5.findViewById(R$id.customPanel);
      this.setupCustomContent(var16);
      View var10 = var16.findViewById(R$id.topPanel);
      View var9 = var16.findViewById(R$id.contentPanel);
      View var7 = var16.findViewById(R$id.buttonPanel);
      ViewGroup var19 = this.resolvePanel(var10, var8);
      ViewGroup var18 = this.resolvePanel(var9, var6);
      ViewGroup var14 = this.resolvePanel(var7, var4);
      this.setupContent(var18);
      this.setupButtons(var14);
      this.setupTitle(var19);
      boolean var1;
      if(var16 != null && var16.getVisibility() != 8) {
         var1 = true;
      } else {
         var1 = false;
      }

      boolean var3;
      if(var19 != null && var19.getVisibility() != 8) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var2;
      if(var14 != null && var14.getVisibility() != 8) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(!var2 && var18 != null) {
         var4 = var18.findViewById(R$id.textSpacerNoButtons);
         if(var4 != null) {
            var4.setVisibility(0);
         }
      }

      if(var3 && this.mScrollView != null) {
         this.mScrollView.setClipToPadding(true);
      }

      if(!var1) {
         Object var15;
         if(this.mListView != null) {
            var15 = this.mListView;
         } else {
            var15 = this.mScrollView;
         }

         if(var15 != null) {
            byte var11;
            if(var3) {
               var11 = 1;
            } else {
               var11 = 0;
            }

            byte var13;
            if(var2) {
               var13 = 2;
            } else {
               var13 = 0;
            }

            this.setScrollIndicators(var18, (View)var15, var11 | var13, 3);
         }
      }

      ListView var17 = this.mListView;
      if(var17 != null && this.mAdapter != null) {
         var17.setAdapter(this.mAdapter);
         int var12 = this.mCheckedItem;
         if(var12 > -1) {
            var17.setItemChecked(var12, true);
            var17.setSelection(var12);
         }
      }

   }

   public Button getButton(int var1) {
      switch(var1) {
      case -3:
         return this.mButtonNeutral;
      case -2:
         return this.mButtonNegative;
      case -1:
         return this.mButtonPositive;
      default:
         return null;
      }
   }

   public int getIconAttributeResId(int var1) {
      TypedValue var2 = new TypedValue();
      this.mContext.getTheme().resolveAttribute(var1, var2, true);
      return var2.resourceId;
   }

   public ListView getListView() {
      return this.mListView;
   }

   public void installContent() {
      this.mDialog.supportRequestWindowFeature(1);
      int var1 = this.selectContentView();
      this.mDialog.setContentView(var1);
      this.setupView();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      return this.mScrollView != null && this.mScrollView.executeKeyEvent(var2);
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      return this.mScrollView != null && this.mScrollView.executeKeyEvent(var2);
   }

   public void setButton(int var1, CharSequence var2, android.content.DialogInterface.OnClickListener var3, Message var4) {
      Message var5 = var4;
      if(var4 == null) {
         var5 = var4;
         if(var3 != null) {
            var5 = this.mHandler.obtainMessage(var1, var3);
         }
      }

      switch(var1) {
      case -3:
         this.mButtonNeutralText = var2;
         this.mButtonNeutralMessage = var5;
         return;
      case -2:
         this.mButtonNegativeText = var2;
         this.mButtonNegativeMessage = var5;
         return;
      case -1:
         this.mButtonPositiveText = var2;
         this.mButtonPositiveMessage = var5;
         return;
      default:
         throw new IllegalArgumentException("Button does not exist");
      }
   }

   public void setButtonPanelLayoutHint(int var1) {
      this.mButtonPanelLayoutHint = var1;
   }

   public void setCustomTitle(View var1) {
      this.mCustomTitleView = var1;
   }

   public void setIcon(int var1) {
      this.mIcon = null;
      this.mIconId = var1;
      if(this.mIconView != null) {
         if(var1 == 0) {
            this.mIconView.setVisibility(8);
            return;
         }

         this.mIconView.setVisibility(0);
         this.mIconView.setImageResource(this.mIconId);
      }

   }

   public void setIcon(Drawable var1) {
      this.mIcon = var1;
      this.mIconId = 0;
      if(this.mIconView != null) {
         if(var1 == null) {
            this.mIconView.setVisibility(8);
            return;
         }

         this.mIconView.setVisibility(0);
         this.mIconView.setImageDrawable(var1);
      }

   }

   public void setMessage(CharSequence var1) {
      this.mMessage = var1;
      if(this.mMessageView != null) {
         this.mMessageView.setText(var1);
      }

   }

   public void setTitle(CharSequence var1) {
      this.mTitle = var1;
      if(this.mTitleView != null) {
         this.mTitleView.setText(var1);
      }

   }

   public void setView(int var1) {
      this.mView = null;
      this.mViewLayoutResId = var1;
      this.mViewSpacingSpecified = false;
   }

   public void setView(View var1) {
      this.mView = var1;
      this.mViewLayoutResId = 0;
      this.mViewSpacingSpecified = false;
   }

   public void setView(View var1, int var2, int var3, int var4, int var5) {
      this.mView = var1;
      this.mViewLayoutResId = 0;
      this.mViewSpacingSpecified = true;
      this.mViewSpacingLeft = var2;
      this.mViewSpacingTop = var3;
      this.mViewSpacingRight = var4;
      this.mViewSpacingBottom = var5;
   }
}
