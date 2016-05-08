package android.support.v7.util;

class MessageThreadUtil$SyncQueueItem {
   private static MessageThreadUtil$SyncQueueItem sPool;
   private static final Object sPoolLock = new Object();
   public int arg1;
   public int arg2;
   public int arg3;
   public int arg4;
   public int arg5;
   public Object data;
   private MessageThreadUtil$SyncQueueItem next;
   public int what;

   static MessageThreadUtil$SyncQueueItem obtainMessage(int var0, int var1, int var2) {
      return obtainMessage(var0, var1, var2, 0, 0, 0, (Object)null);
   }

   static MessageThreadUtil$SyncQueueItem obtainMessage(int param0, int param1, int param2, int param3, int param4, int param5, Object param6) {
      // $FF: Couldn't be decompiled
   }

   static MessageThreadUtil$SyncQueueItem obtainMessage(int var0, int var1, Object var2) {
      return obtainMessage(var0, var1, 0, 0, 0, 0, var2);
   }

   void recycle() {
      // $FF: Couldn't be decompiled
   }
}
