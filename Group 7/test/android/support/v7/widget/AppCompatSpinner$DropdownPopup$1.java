package android.support.v7.widget;

import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatSpinner$DropdownPopup;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AppCompatSpinner$DropdownPopup$1 implements OnItemClickListener {
   AppCompatSpinner$DropdownPopup$1(AppCompatSpinner$DropdownPopup var1, AppCompatSpinner var2) {
      this.this$1 = var1;
      this.val$this$0 = var2;
   }

   public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
      this.this$1.this$0.setSelection(var3);
      if(this.this$1.this$0.getOnItemClickListener() != null) {
         this.this$1.this$0.performItemClick(var2, var3, AppCompatSpinner$DropdownPopup.access$200(this.this$1).getItemId(var3));
      }

      this.this$1.dismiss();
   }
}
