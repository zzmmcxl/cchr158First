package android.support.v7.widget;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow$DropDownListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class ListPopupWindow$3 implements OnItemSelectedListener {
   ListPopupWindow$3(ListPopupWindow var1) {
      this.this$0 = var1;
   }

   public void onItemSelected(AdapterView<?> var1, View var2, int var3, long var4) {
      if(var3 != -1) {
         ListPopupWindow$DropDownListView var6 = ListPopupWindow.access$600(this.this$0);
         if(var6 != null) {
            ListPopupWindow$DropDownListView.access$502(var6, false);
         }
      }

   }

   public void onNothingSelected(AdapterView<?> var1) {
   }
}
