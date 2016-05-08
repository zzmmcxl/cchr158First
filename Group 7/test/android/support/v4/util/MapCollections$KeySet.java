package android.support.v4.util;

import android.support.v4.util.MapCollections;
import android.support.v4.util.MapCollections$ArrayIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class MapCollections$KeySet implements Set<K> {
   MapCollections$KeySet(MapCollections var1) {
      this.this$0 = var1;
   }

   public boolean add(K var1) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(Collection<? extends K> var1) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      this.this$0.colClear();
   }

   public boolean contains(Object var1) {
      return this.this$0.colIndexOfKey(var1) >= 0;
   }

   public boolean containsAll(Collection<?> var1) {
      return MapCollections.containsAllHelper(this.this$0.colGetMap(), var1);
   }

   public boolean equals(Object var1) {
      return MapCollections.equalsSetHelper(this, var1);
   }

   public int hashCode() {
      int var2 = 0;

      for(int var1 = this.this$0.colGetSize() - 1; var1 >= 0; --var1) {
         Object var4 = this.this$0.colGetEntry(var1, 0);
         int var3;
         if(var4 == null) {
            var3 = 0;
         } else {
            var3 = var4.hashCode();
         }

         var2 += var3;
      }

      return var2;
   }

   public boolean isEmpty() {
      return this.this$0.colGetSize() == 0;
   }

   public Iterator<K> iterator() {
      return new MapCollections$ArrayIterator(this.this$0, 0);
   }

   public boolean remove(Object var1) {
      int var2 = this.this$0.colIndexOfKey(var1);
      if(var2 >= 0) {
         this.this$0.colRemoveAt(var2);
         return true;
      } else {
         return false;
      }
   }

   public boolean removeAll(Collection<?> var1) {
      return MapCollections.removeAllHelper(this.this$0.colGetMap(), var1);
   }

   public boolean retainAll(Collection<?> var1) {
      return MapCollections.retainAllHelper(this.this$0.colGetMap(), var1);
   }

   public int size() {
      return this.this$0.colGetSize();
   }

   public Object[] toArray() {
      return this.this$0.toArrayHelper(0);
   }

   public <T> T[] toArray(T[] var1) {
      return this.this$0.toArrayHelper(var1, 0);
   }
}
