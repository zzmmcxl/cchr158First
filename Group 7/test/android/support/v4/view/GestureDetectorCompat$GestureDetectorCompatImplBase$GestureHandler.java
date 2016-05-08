package android.support.v4.view;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase;

class GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler extends Handler {
   GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(GestureDetectorCompat$GestureDetectorCompatImplBase var1) {
      this.this$0 = var1;
   }

   GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(GestureDetectorCompat$GestureDetectorCompatImplBase var1, Handler var2) {
      super(var2.getLooper());
      this.this$0 = var1;
   }

   public void handleMessage(Message var1) {
      switch(var1.what) {
      case 1:
         GestureDetectorCompat$GestureDetectorCompatImplBase.access$100(this.this$0).onShowPress(GestureDetectorCompat$GestureDetectorCompatImplBase.access$000(this.this$0));
         break;
      case 2:
         GestureDetectorCompat$GestureDetectorCompatImplBase.access$200(this.this$0);
         return;
      case 3:
         if(GestureDetectorCompat$GestureDetectorCompatImplBase.access$300(this.this$0) != null) {
            if(!GestureDetectorCompat$GestureDetectorCompatImplBase.access$400(this.this$0)) {
               GestureDetectorCompat$GestureDetectorCompatImplBase.access$300(this.this$0).onSingleTapConfirmed(GestureDetectorCompat$GestureDetectorCompatImplBase.access$000(this.this$0));
               return;
            }

            GestureDetectorCompat$GestureDetectorCompatImplBase.access$502(this.this$0, true);
            return;
         }
         break;
      default:
         throw new RuntimeException("Unknown message " + var1);
      }

   }
}
