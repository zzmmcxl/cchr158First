package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.TintTypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;

class AlertController {
   private ListAdapter mAdapter;
   private int mAlertDialogLayout;
   private final OnClickListener mButtonHandler = new OnClickListener() {
      public void onClick(View var1) {
         Message var2;
         if(var1 == AlertController.this.mButtonPositive && AlertController.this.mButtonPositiveMessage != null) {
            var2 = Message.obtain(AlertController.this.mButtonPositiveMessage);
         } else if(var1 == AlertController.this.mButtonNegative && AlertController.this.mButtonNegativeMessage != null) {
            var2 = Message.obtain(AlertController.this.mButtonNegativeMessage);
         } else if(var1 == AlertController.this.mButtonNeutral && AlertController.this.mButtonNeutralMessage != null) {
            var2 = Message.obtain(AlertController.this.mButtonNeutralMessage);
         } else {
            var2 = null;
         }

         if(var2 != null) {
            var2.sendToTarget();
         }

         AlertController.this.mHandler.obtainMessage(1, AlertController.this.mDialog).sendToTarget();
      }
   };
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
   private ScrollView mScrollView;
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
      this.mHandler = new AlertController.ButtonHandler(var2);
      TypedArray var4 = var1.obtainStyledAttributes((AttributeSet)null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
      this.mAlertDialogLayout = var4.getResourceId(R.styleable.AlertDialog_android_layout, 0);
      this.mButtonPanelSideLayout = var4.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
      this.mListLayout = var4.getResourceId(R.styleable.AlertDialog_listLayout, 0);
      this.mMultiChoiceItemLayout = var4.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
      this.mSingleChoiceItemLayout = var4.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
      this.mListItemLayout = var4.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
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

   private void centerButton(Button var1) {
      LayoutParams var2 = (LayoutParams)var1.getLayoutParams();
      var2.gravity = 1;
      var2.weight = 0.5F;
      var1.setLayoutParams(var2);
   }

   private int selectContentView() {
      return this.mButtonPanelSideLayout == 0?this.mAlertDialogLayout:(this.mButtonPanelLayoutHint == 1?this.mButtonPanelSideLayout:this.mAlertDialogLayout);
   }

   private boolean setupButtons() {
      int var1 = 0;
      this.mButtonPositive = (Button)this.mWindow.findViewById(16908313);
      this.mButtonPositive.setOnClickListener(this.mButtonHandler);
      if(TextUtils.isEmpty(this.mButtonPositiveText)) {
         this.mButtonPositive.setVisibility(8);
      } else {
         this.mButtonPositive.setText(this.mButtonPositiveText);
         this.mButtonPositive.setVisibility(0);
         var1 = 0 | 1;
      }

      this.mButtonNegative = (Button)this.mWindow.findViewById(16908314);
      this.mButtonNegative.setOnClickListener(this.mButtonHandler);
      if(TextUtils.isEmpty(this.mButtonNegativeText)) {
         this.mButtonNegative.setVisibility(8);
      } else {
         this.mButtonNegative.setText(this.mButtonNegativeText);
         this.mButtonNegative.setVisibility(0);
         var1 |= 2;
      }

      this.mButtonNeutral = (Button)this.mWindow.findViewById(16908315);
      this.mButtonNeutral.setOnClickListener(this.mButtonHandler);
      if(TextUtils.isEmpty(this.mButtonNeutralText)) {
         this.mButtonNeutral.setVisibility(8);
      } else {
         this.mButtonNeutral.setText(this.mButtonNeutralText);
         this.mButtonNeutral.setVisibility(0);
         var1 |= 4;
      }

      if(shouldCenterSingleButton(this.mContext)) {
         if(var1 == 1) {
            this.centerButton(this.mButtonPositive);
         } else if(var1 == 2) {
            this.centerButton(this.mButtonNegative);
         } else if(var1 == 4) {
            this.centerButton(this.mButtonNeutral);
         }
      }

      return var1 != 0;
   }

   private void setupContent(ViewGroup var1) {
      this.mScrollView = (ScrollView)this.mWindow.findViewById(R.id.scrollView);
      this.mScrollView.setFocusable(false);
      this.mMessageView = (TextView)this.mWindow.findViewById(16908299);
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
               var1.addView(this.mListView, var2, new android.view.ViewGroup.LayoutParams(-1, -1));
            } else {
               var1.setVisibility(8);
            }
         }
      }
   }

   private boolean setupTitle(ViewGroup var1) {
      boolean var2 = false;
      if(this.mCustomTitleView != null) {
         android.view.ViewGroup.LayoutParams var3 = new android.view.ViewGroup.LayoutParams(-1, -2);
         var1.addView(this.mCustomTitleView, 0, var3);
         this.mWindow.findViewById(R.id.title_template).setVisibility(8);
         return true;
      } else {
         this.mIconView = (ImageView)this.mWindow.findViewById(16908294);
         if(!TextUtils.isEmpty(this.mTitle)) {
            var2 = true;
         }

         if(var2) {
            this.mTitleView = (TextView)this.mWindow.findViewById(R.id.alertTitle);
            this.mTitleView.setText(this.mTitle);
            if(this.mIconId != 0) {
               this.mIconView.setImageResource(this.mIconId);
               return true;
            } else if(this.mIcon != null) {
               this.mIconView.setImageDrawable(this.mIcon);
               return true;
            } else {
               this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
               this.mIconView.setVisibility(8);
               return true;
            }
         } else {
            this.mWindow.findViewById(R.id.title_template).setVisibility(8);
            this.mIconView.setVisibility(8);
            var1.setVisibility(8);
            return false;
         }
      }
   }

   private void setupView() {
      this.setupContent((ViewGroup)this.mWindow.findViewById(R.id.contentPanel));
      boolean var2 = this.setupButtons();
      ViewGroup var3 = (ViewGroup)this.mWindow.findViewById(R.id.topPanel);
      TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(this.mContext, (AttributeSet)null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
      this.setupTitle(var3);
      View var8 = this.mWindow.findViewById(R.id.buttonPanel);
      if(!var2) {
         var8.setVisibility(8);
         var8 = this.mWindow.findViewById(R.id.textSpacerNoButtons);
         if(var8 != null) {
            var8.setVisibility(0);
         }
      }

      FrameLayout var5 = (FrameLayout)this.mWindow.findViewById(R.id.customPanel);
      if(this.mView != null) {
         var8 = this.mView;
      } else if(this.mViewLayoutResId != 0) {
         var8 = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, var5, false);
      } else {
         var8 = null;
      }

      boolean var1;
      if(var8 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      if(!var1 || !canTextInput(var8)) {
         this.mWindow.setFlags(131072, 131072);
      }

      if(var1) {
         FrameLayout var6 = (FrameLayout)this.mWindow.findViewById(R.id.custom);
         var6.addView(var8, new android.view.ViewGroup.LayoutParams(-1, -1));
         if(this.mViewSpacingSpecified) {
            var6.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
         }

         if(this.mListView != null) {
            ((LayoutParams)var5.getLayoutParams()).weight = 0.0F;
         }
      } else {
         var5.setVisibility(8);
      }

      ListView var9 = this.mListView;
      if(var9 != null && this.mAdapter != null) {
         var9.setAdapter(this.mAdapter);
         int var7 = this.mCheckedItem;
         if(var7 > -1) {
            var9.setItemChecked(var7, true);
            var9.setSelection(var7);
         }
      }

      var4.recycle();
   }

   private static boolean shouldCenterSingleButton(Context var0) {
      TypedValue var1 = new TypedValue();
      var0.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, var1, true);
      return var1.data != 0;
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

   public static class AlertParams {
      public ListAdapter mAdapter;
      public boolean mCancelable;
      public int mCheckedItem = -1;
      public boolean[] mCheckedItems;
      public final Context mContext;
      public Cursor mCursor;
      public View mCustomTitleView;
      public boolean mForceInverseBackground;
      public Drawable mIcon;
      public int mIconAttrId = 0;
      public int mIconId = 0;
      public final LayoutInflater mInflater;
      public String mIsCheckedColumn;
      public boolean mIsMultiChoice;
      public boolean mIsSingleChoice;
      public CharSequence[] mItems;
      public String mLabelColumn;
      public CharSequence mMessage;
      public android.content.DialogInterface.OnClickListener mNegativeButtonListener;
      public CharSequence mNegativeButtonText;
      public android.content.DialogInterface.OnClickListener mNeutralButtonListener;
      public CharSequence mNeutralButtonText;
      public OnCancelListener mOnCancelListener;
      public OnMultiChoiceClickListener mOnCheckboxClickListener;
      public android.content.DialogInterface.OnClickListener mOnClickListener;
      public OnDismissListener mOnDismissListener;
      public OnItemSelectedListener mOnItemSelectedListener;
      public OnKeyListener mOnKeyListener;
      public AlertController.OnPrepareListViewListener mOnPrepareListViewListener;
      public android.content.DialogInterface.OnClickListener mPositiveButtonListener;
      public CharSequence mPositiveButtonText;
      public boolean mRecycleOnMeasure = true;
      public CharSequence mTitle;
      public View mView;
      public int mViewLayoutResId;
      public int mViewSpacingBottom;
      public int mViewSpacingLeft;
      public int mViewSpacingRight;
      public boolean mViewSpacingSpecified = false;
      public int mViewSpacingTop;

      public AlertParams(Context var1) {
         this.mContext = var1;
         this.mCancelable = true;
         this.mInflater = (LayoutInflater)var1.getSystemService("layout_inflater");
      }

      private void createListView(final AlertController var1) {
         final ListView var4 = (ListView)this.mInflater.inflate(var1.mListLayout, (ViewGroup)null);
         Object var3;
         if(this.mIsMultiChoice) {
            if(this.mCursor == null) {
               var3 = new ArrayAdapter(this.mContext, var1.mMultiChoiceItemLayout, 16908308, this.mItems) {
                  public View getView(int var1, View var2, ViewGroup var3) {
                     var2 = super.getView(var1, var2, var3);
                     if(AlertParams.this.mCheckedItems != null && AlertParams.this.mCheckedItems[var1]) {
                        var4.setItemChecked(var1, true);
                     }

                     return var2;
                  }
               };
            } else {
               var3 = new CursorAdapter(this.mContext, this.mCursor, false) {
                  private final int mIsCheckedIndex;
                  private final int mLabelIndex;

                  {
                     Cursor var7 = this.getCursor();
                     this.mLabelIndex = var7.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                     this.mIsCheckedIndex = var7.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                  }

                  public void bindView(View var1x, Context var2, Cursor var3) {
                     boolean var5 = true;
                     ((CheckedTextView)var1x.findViewById(16908308)).setText(var3.getString(this.mLabelIndex));
                     ListView var6 = var4;
                     int var4x = var3.getPosition();
                     if(var3.getInt(this.mIsCheckedIndex) != 1) {
                        var5 = false;
                     }

                     var6.setItemChecked(var4x, var5);
                  }

                  public View newView(Context var1x, Cursor var2, ViewGroup var3) {
                     return AlertParams.this.mInflater.inflate(var1.mMultiChoiceItemLayout, var3, false);
                  }
               };
            }
         } else {
            int var2;
            if(this.mIsSingleChoice) {
               var2 = var1.mSingleChoiceItemLayout;
            } else {
               var2 = var1.mListItemLayout;
            }

            if(this.mCursor == null) {
               if(this.mAdapter != null) {
                  var3 = this.mAdapter;
               } else {
                  var3 = new AlertController.CheckedItemAdapter(this.mContext, var2, 16908308, this.mItems);
               }
            } else {
               var3 = new SimpleCursorAdapter(this.mContext, var2, this.mCursor, new String[]{this.mLabelColumn}, new int[]{16908308});
            }
         }

         if(this.mOnPrepareListViewListener != null) {
            this.mOnPrepareListViewListener.onPrepareListView(var4);
         }

         var1.mAdapter = (ListAdapter)var3;
         var1.mCheckedItem = this.mCheckedItem;
         if(this.mOnClickListener != null) {
            var4.setOnItemClickListener(new OnItemClickListener() {
               public void onItemClick(AdapterView var1x, View var2, int var3, long var4) {
                  AlertParams.this.mOnClickListener.onClick(var1.mDialog, var3);
                  if(!AlertParams.this.mIsSingleChoice) {
                     var1.mDialog.dismiss();
                  }

               }
            });
         } else if(this.mOnCheckboxClickListener != null) {
            var4.setOnItemClickListener(new OnItemClickListener() {
               public void onItemClick(AdapterView var1x, View var2, int var3, long var4x) {
                  if(AlertParams.this.mCheckedItems != null) {
                     AlertParams.this.mCheckedItems[var3] = var4.isItemChecked(var3);
                  }

                  AlertParams.this.mOnCheckboxClickListener.onClick(var1.mDialog, var3, var4.isItemChecked(var3));
               }
            });
         }

         if(this.mOnItemSelectedListener != null) {
            var4.setOnItemSelectedListener(this.mOnItemSelectedListener);
         }

         if(this.mIsSingleChoice) {
            var4.setChoiceMode(1);
         } else if(this.mIsMultiChoice) {
            var4.setChoiceMode(2);
         }

         var1.mListView = var4;
      }

      public void apply(AlertController var1) {
         if(this.mCustomTitleView != null) {
            var1.setCustomTitle(this.mCustomTitleView);
         } else {
            if(this.mTitle != null) {
               var1.setTitle(this.mTitle);
            }

            if(this.mIcon != null) {
               var1.setIcon(this.mIcon);
            }

            if(this.mIconId != 0) {
               var1.setIcon(this.mIconId);
            }

            if(this.mIconAttrId != 0) {
               var1.setIcon(var1.getIconAttributeResId(this.mIconAttrId));
            }
         }

         if(this.mMessage != null) {
            var1.setMessage(this.mMessage);
         }

         if(this.mPositiveButtonText != null) {
            var1.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, (Message)null);
         }

         if(this.mNegativeButtonText != null) {
            var1.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, (Message)null);
         }

         if(this.mNeutralButtonText != null) {
            var1.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, (Message)null);
         }

         if(this.mItems != null || this.mCursor != null || this.mAdapter != null) {
            this.createListView(var1);
         }

         if(this.mView != null) {
            if(!this.mViewSpacingSpecified) {
               var1.setView(this.mView);
               return;
            }

            var1.setView(this.mView, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
         } else if(this.mViewLayoutResId != 0) {
            var1.setView(this.mViewLayoutResId);
            return;
         }

      }
   }

   public interface OnPrepareListViewListener {
      void onPrepareListView(ListView var1);
   }

   private static final class ButtonHandler extends Handler {
      private static final int MSG_DISMISS_DIALOG = 1;
      private WeakReference mDialog;

      public ButtonHandler(DialogInterface var1) {
         this.mDialog = new WeakReference(var1);
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case -3:
         case -2:
         case -1:
            ((android.content.DialogInterface.OnClickListener)var1.obj).onClick((DialogInterface)this.mDialog.get(), var1.what);
            return;
         case 0:
         default:
            return;
         case 1:
            ((DialogInterface)var1.obj).dismiss();
         }
      }
   }

   private static class CheckedItemAdapter extends ArrayAdapter {
      public CheckedItemAdapter(Context var1, int var2, int var3, CharSequence[] var4) {
         super(var1, var2, var3, var4);
      }

      public long getItemId(int var1) {
         return (long)var1;
      }

      public boolean hasStableIds() {
         return true;
      }
   }
}
