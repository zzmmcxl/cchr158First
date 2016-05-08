package android.support.v4.media;

public class MediaBrowserServiceCompat$Result<T> {
   private Object mDebug;
   private boolean mDetachCalled;
   private int mFlags;
   private boolean mSendResultCalled;

   MediaBrowserServiceCompat$Result(Object var1) {
      this.mDebug = var1;
   }

   public void detach() {
      if(this.mDetachCalled) {
         throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
      } else if(this.mSendResultCalled) {
         throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
      } else {
         this.mDetachCalled = true;
      }
   }

   boolean isDone() {
      return this.mDetachCalled || this.mSendResultCalled;
   }

   void onResultSent(T var1, int var2) {
   }

   public void sendResult(T var1) {
      if(this.mSendResultCalled) {
         throw new IllegalStateException("sendResult() called twice for: " + this.mDebug);
      } else {
         this.mSendResultCalled = true;
         this.onResultSent(var1, this.mFlags);
      }
   }

   void setFlags(int var1) {
      this.mFlags = var1;
   }
}
