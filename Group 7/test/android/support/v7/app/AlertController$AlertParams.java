package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v7.app.AlertController;
import android.support.v7.app.AlertController$AlertParams$1;
import android.support.v7.app.AlertController$AlertParams$2;
import android.support.v7.app.AlertController$AlertParams$3;
import android.support.v7.app.AlertController$AlertParams$4;
import android.support.v7.app.AlertController$AlertParams$OnPrepareListViewListener;
import android.support.v7.app.AlertController$CheckedItemAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemSelectedListener;

public class AlertController$AlertParams {
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
   public OnClickListener mNegativeButtonListener;
   public CharSequence mNegativeButtonText;
   public OnClickListener mNeutralButtonListener;
   public CharSequence mNeutralButtonText;
   public OnCancelListener mOnCancelListener;
   public OnMultiChoiceClickListener mOnCheckboxClickListener;
   public OnClickListener mOnClickListener;
   public OnDismissListener mOnDismissListener;
   public OnItemSelectedListener mOnItemSelectedListener;
   public OnKeyListener mOnKeyListener;
   public AlertController$AlertParams$OnPrepareListViewListener mOnPrepareListViewListener;
   public OnClickListener mPositiveButtonListener;
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

   public AlertController$AlertParams(Context var1) {
      this.mContext = var1;
      this.mCancelable = true;
      this.mInflater = (LayoutInflater)var1.getSystemService("layout_inflater");
   }

   private void createListView(AlertController var1) {
      ListView var4 = (ListView)this.mInflater.inflate(AlertController.access$1100(var1), (ViewGroup)null);
      Object var3;
      if(this.mIsMultiChoice) {
         if(this.mCursor == null) {
            var3 = new AlertController$AlertParams$1(this, this.mContext, AlertController.access$1200(var1), 16908308, this.mItems, var4);
         } else {
            var3 = new AlertController$AlertParams$2(this, this.mContext, this.mCursor, false, var4, var1);
         }
      } else {
         int var2;
         if(this.mIsSingleChoice) {
            var2 = AlertController.access$1300(var1);
         } else {
            var2 = AlertController.access$1400(var1);
         }

         if(this.mCursor != null) {
            var3 = new SimpleCursorAdapter(this.mContext, var2, this.mCursor, new String[]{this.mLabelColumn}, new int[]{16908308});
         } else if(this.mAdapter != null) {
            var3 = this.mAdapter;
         } else {
            var3 = new AlertController$CheckedItemAdapter(this.mContext, var2, 16908308, this.mItems);
         }
      }

      if(this.mOnPrepareListViewListener != null) {
         this.mOnPrepareListViewListener.onPrepareListView(var4);
      }

      AlertController.access$1502(var1, (ListAdapter)var3);
      AlertController.access$1602(var1, this.mCheckedItem);
      if(this.mOnClickListener != null) {
         var4.setOnItemClickListener(new AlertController$AlertParams$3(this, var1));
      } else if(this.mOnCheckboxClickListener != null) {
         var4.setOnItemClickListener(new AlertController$AlertParams$4(this, var4, var1));
      }

      if(this.mOnItemSelectedListener != null) {
         var4.setOnItemSelectedListener(this.mOnItemSelectedListener);
      }

      if(this.mIsSingleChoice) {
         var4.setChoiceMode(1);
      } else if(this.mIsMultiChoice) {
         var4.setChoiceMode(2);
      }

      AlertController.access$1002(var1, var4);
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
