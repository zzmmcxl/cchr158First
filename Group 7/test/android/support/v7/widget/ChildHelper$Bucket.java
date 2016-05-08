package android.support.v7.widget;

class ChildHelper$Bucket {
   static final int BITS_PER_WORD = 64;
   static final long LAST_BIT = Long.MIN_VALUE;
   long mData = 0L;
   ChildHelper$Bucket next;

   private void ensureNext() {
      if(this.next == null) {
         this.next = new ChildHelper$Bucket();
      }

   }

   void clear(int var1) {
      if(var1 >= 64) {
         if(this.next != null) {
            this.next.clear(var1 - 64);
         }

      } else {
         this.mData &= ~(1L << var1);
      }
   }

   int countOnesBefore(int var1) {
      return this.next == null?(var1 >= 64?Long.bitCount(this.mData):Long.bitCount(this.mData & (1L << var1) - 1L)):(var1 < 64?Long.bitCount(this.mData & (1L << var1) - 1L):this.next.countOnesBefore(var1 - 64) + Long.bitCount(this.mData));
   }

   boolean get(int var1) {
      if(var1 >= 64) {
         this.ensureNext();
         return this.next.get(var1 - 64);
      } else {
         return (this.mData & 1L << var1) != 0L;
      }
   }

   void insert(int var1, boolean var2) {
      if(var1 >= 64) {
         this.ensureNext();
         this.next.insert(var1 - 64, var2);
      } else {
         boolean var3;
         if((this.mData & Long.MIN_VALUE) != 0L) {
            var3 = true;
         } else {
            var3 = false;
         }

         long var4 = (1L << var1) - 1L;
         this.mData = this.mData & var4 | (this.mData & ~var4) << 1;
         if(var2) {
            this.set(var1);
         } else {
            this.clear(var1);
         }

         if(var3 || this.next != null) {
            this.ensureNext();
            this.next.insert(0, var3);
            return;
         }
      }

   }

   boolean remove(int var1) {
      boolean var3;
      if(var1 >= 64) {
         this.ensureNext();
         var3 = this.next.remove(var1 - 64);
      } else {
         long var4 = 1L << var1;
         boolean var2;
         if((this.mData & var4) != 0L) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.mData &= ~var4;
         --var4;
         this.mData = this.mData & var4 | Long.rotateRight(this.mData & ~var4, 1);
         var3 = var2;
         if(this.next != null) {
            if(this.next.get(0)) {
               this.set(63);
            }

            this.next.remove(0);
            return var2;
         }
      }

      return var3;
   }

   void reset() {
      this.mData = 0L;
      if(this.next != null) {
         this.next.reset();
      }

   }

   void set(int var1) {
      if(var1 >= 64) {
         this.ensureNext();
         this.next.set(var1 - 64);
      } else {
         this.mData |= 1L << var1;
      }
   }

   public String toString() {
      return this.next == null?Long.toBinaryString(this.mData):this.next.toString() + "xx" + Long.toBinaryString(this.mData);
   }
}
