package android.support.v4.util;

public final class CircularArray {
   private int mCapacityBitmask;
   private Object[] mElements;
   private int mHead;
   private int mTail;

   public CircularArray() {
      this(8);
   }

   public CircularArray(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("capacity must be positive");
      } else {
         int var2 = var1;
         if(Integer.bitCount(var1) != 1) {
            var2 = 1 << Integer.highestOneBit(var1) + 1;
         }

         this.mCapacityBitmask = var2 - 1;
         this.mElements = (Object[])(new Object[var2]);
      }
   }

   private void doubleCapacity() {
      int var1 = this.mElements.length;
      int var2 = var1 - this.mHead;
      int var3 = var1 << 1;
      if(var3 < 0) {
         throw new RuntimeException("Max array capacity exceeded");
      } else {
         Object[] var4 = new Object[var3];
         System.arraycopy(this.mElements, this.mHead, var4, 0, var2);
         System.arraycopy(this.mElements, 0, var4, var2, this.mHead);
         this.mElements = (Object[])var4;
         this.mHead = 0;
         this.mTail = var1;
         this.mCapacityBitmask = var3 - 1;
      }
   }

   public void addFirst(Object var1) {
      this.mHead = this.mHead - 1 & this.mCapacityBitmask;
      this.mElements[this.mHead] = var1;
      if(this.mHead == this.mTail) {
         this.doubleCapacity();
      }

   }

   public void addLast(Object var1) {
      this.mElements[this.mTail] = var1;
      this.mTail = this.mTail + 1 & this.mCapacityBitmask;
      if(this.mTail == this.mHead) {
         this.doubleCapacity();
      }

   }

   public void clear() {
      this.removeFromStart(this.size());
   }

   public Object get(int var1) {
      if(var1 >= 0 && var1 < this.size()) {
         return this.mElements[this.mHead + var1 & this.mCapacityBitmask];
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   public Object getFirst() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         return this.mElements[this.mHead];
      }
   }

   public Object getLast() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         return this.mElements[this.mTail - 1 & this.mCapacityBitmask];
      }
   }

   public boolean isEmpty() {
      return this.mHead == this.mTail;
   }

   public Object popFirst() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         Object var1 = this.mElements[this.mHead];
         this.mElements[this.mHead] = null;
         this.mHead = this.mHead + 1 & this.mCapacityBitmask;
         return var1;
      }
   }

   public Object popLast() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         int var1 = this.mTail - 1 & this.mCapacityBitmask;
         Object var2 = this.mElements[var1];
         this.mElements[var1] = null;
         this.mTail = var1;
         return var2;
      }
   }

   public void removeFromEnd(int var1) {
      if(var1 > 0) {
         if(var1 > this.size()) {
            throw new ArrayIndexOutOfBoundsException();
         }

         int var2 = 0;
         if(var1 < this.mTail) {
            var2 = this.mTail - var1;
         }

         for(int var3 = var2; var3 < this.mTail; ++var3) {
            this.mElements[var3] = null;
         }

         var2 = this.mTail - var2;
         var1 -= var2;
         this.mTail -= var2;
         if(var1 > 0) {
            this.mTail = this.mElements.length;
            var2 = this.mTail - var1;

            for(var1 = var2; var1 < this.mTail; ++var1) {
               this.mElements[var1] = null;
            }

            this.mTail = var2;
            return;
         }
      }

   }

   public void removeFromStart(int var1) {
      if(var1 > 0) {
         if(var1 > this.size()) {
            throw new ArrayIndexOutOfBoundsException();
         }

         int var3 = this.mElements.length;
         int var2 = var3;
         if(var1 < var3 - this.mHead) {
            var2 = this.mHead + var1;
         }

         for(var3 = this.mHead; var3 < var2; ++var3) {
            this.mElements[var3] = null;
         }

         var3 = var2 - this.mHead;
         var2 = var1 - var3;
         this.mHead = this.mHead + var3 & this.mCapacityBitmask;
         if(var2 > 0) {
            for(var1 = 0; var1 < var2; ++var1) {
               this.mElements[var1] = null;
            }

            this.mHead = var2;
            return;
         }
      }

   }

   public int size() {
      return this.mTail - this.mHead & this.mCapacityBitmask;
   }
}
