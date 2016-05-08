package android.support.v7.app;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AlertController;
import android.support.v7.app.AlertController$AlertParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

class AlertController$AlertParams$2 extends CursorAdapter {
   private final int mIsCheckedIndex;
   private final int mLabelIndex;

   AlertController$AlertParams$2(AlertController$AlertParams var1, Context var2, Cursor var3, boolean var4, ListView var5, AlertController var6) {
      super(var2, var3, var4);
      this.this$0 = var1;
      this.val$listView = var5;
      this.val$dialog = var6;
      Cursor var7 = this.getCursor();
      this.mLabelIndex = var7.getColumnIndexOrThrow(this.this$0.mLabelColumn);
      this.mIsCheckedIndex = var7.getColumnIndexOrThrow(this.this$0.mIsCheckedColumn);
   }

   public void bindView(View var1, Context var2, Cursor var3) {
      boolean var5 = true;
      ((CheckedTextView)var1.findViewById(16908308)).setText(var3.getString(this.mLabelIndex));
      ListView var6 = this.val$listView;
      int var4 = var3.getPosition();
      if(var3.getInt(this.mIsCheckedIndex) != 1) {
         var5 = false;
      }

      var6.setItemChecked(var4, var5);
   }

   public View newView(Context var1, Cursor var2, ViewGroup var3) {
      return this.this$0.mInflater.inflate(AlertController.access$1200(this.val$dialog), var3, false);
   }
}
