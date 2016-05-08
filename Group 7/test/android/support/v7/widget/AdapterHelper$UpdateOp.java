package android.support.v7.widget;

class AdapterHelper$UpdateOp {
   static final int ADD = 1;
   static final int MOVE = 8;
   static final int POOL_SIZE = 30;
   static final int REMOVE = 2;
   static final int UPDATE = 4;
   int cmd;
   int itemCount;
   Object payload;
   int positionStart;

   AdapterHelper$UpdateOp(int var1, int var2, int var3, Object var4) {
      this.cmd = var1;
      this.positionStart = var2;
      this.itemCount = var3;
      this.payload = var4;
   }

   String cmdToString() {
      switch(this.cmd) {
      case 1:
         return "add";
      case 2:
         return "rm";
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         return "??";
      case 4:
         return "up";
      case 8:
         return "mv";
      }
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null || this.getClass() != var1.getClass()) {
            return false;
         }

         AdapterHelper$UpdateOp var2 = (AdapterHelper$UpdateOp)var1;
         if(this.cmd != var2.cmd) {
            return false;
         }

         if(this.cmd != 8 || Math.abs(this.itemCount - this.positionStart) != 1 || this.itemCount != var2.positionStart || this.positionStart != var2.itemCount) {
            if(this.itemCount != var2.itemCount) {
               return false;
            }

            if(this.positionStart != var2.positionStart) {
               return false;
            }

            if(this.payload != null) {
               if(!this.payload.equals(var2.payload)) {
                  return false;
               }
            } else if(var2.payload != null) {
               return false;
            }
         }
      }

      return true;
   }

   public int hashCode() {
      return (this.cmd * 31 + this.positionStart) * 31 + this.itemCount;
   }

   public String toString() {
      return Integer.toHexString(System.identityHashCode(this)) + "[" + this.cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
   }
}
