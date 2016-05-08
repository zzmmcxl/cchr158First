package android.support.v4.util;

import android.support.v4.util.ContainerHelpers;
import android.support.v4.util.MapCollections;
import java.util.Iterator;
import java.util.Map.Entry;

final class MapCollections$MapIterator implements Iterator<Entry<K, V>>, Entry<K, V> {
   int mEnd;
   boolean mEntryValid;
   int mIndex;

   MapCollections$MapIterator(MapCollections var1) {
      this.this$0 = var1;
      this.mEntryValid = false;
      this.mEnd = var1.colGetSize() - 1;
      this.mIndex = -1;
   }

   public final boolean equals(Object var1) {
      boolean var2 = true;
      if(!this.mEntryValid) {
         throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      } else if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var3 = (Entry)var1;
         if(!ContainerHelpers.equal(var3.getKey(), this.this$0.colGetEntry(this.mIndex, 0)) || !ContainerHelpers.equal(var3.getValue(), this.this$0.colGetEntry(this.mIndex, 1))) {
            var2 = false;
         }

         return var2;
      }
   }

   public K getKey() {
      if(!this.mEntryValid) {
         throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      } else {
         return this.this$0.colGetEntry(this.mIndex, 0);
      }
   }

   public V getValue() {
      if(!this.mEntryValid) {
         throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      } else {
         return this.this$0.colGetEntry(this.mIndex, 1);
      }
   }

   public boolean hasNext() {
      return this.mIndex < this.mEnd;
   }

   public final int hashCode() {
      int var2 = 0;
      if(!this.mEntryValid) {
         throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      } else {
         Object var3 = this.this$0.colGetEntry(this.mIndex, 0);
         Object var4 = this.this$0.colGetEntry(this.mIndex, 1);
         int var1;
         if(var3 == null) {
            var1 = 0;
         } else {
            var1 = var3.hashCode();
         }

         if(var4 != null) {
            var2 = var4.hashCode();
         }

         return var2 ^ var1;
      }
   }

   public Entry<K, V> next() {
      ++this.mIndex;
      this.mEntryValid = true;
      return this;
   }

   public void remove() {
      if(!this.mEntryValid) {
         throw new IllegalStateException();
      } else {
         this.this$0.colRemoveAt(this.mIndex);
         --this.mIndex;
         --this.mEnd;
         this.mEntryValid = false;
      }
   }

   public V setValue(V var1) {
      if(!this.mEntryValid) {
         throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      } else {
         return this.this$0.colSetValue(this.mIndex, var1);
      }
   }

   public final String toString() {
      return this.getKey() + "=" + this.getValue();
   }
}
