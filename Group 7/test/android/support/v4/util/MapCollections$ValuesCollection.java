package android.support.v4.util;

import android.support.v4.util.MapCollections;
import android.support.v4.util.MapCollections$ArrayIterator;
import java.util.Collection;
import java.util.Iterator;

final class MapCollections$ValuesCollection implements Collection<V> {
   MapCollections$ValuesCollection(MapCollections var1) {
      this.this$0 = var1;
   }

   public boolean add(V var1) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(Collection<? extends V> var1) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      this.this$0.colClear();
   }

   public boolean contains(Object var1) {
      return this.this$0.colIndexOfValue(var1) >= 0;
   }

   public boolean containsAll(Collection<?> var1) {
      Iterator var2 = var1.iterator();

      do {
         if(!var2.hasNext()) {
            return true;
         }
      } while(this.contains(var2.next()));

      return false;
   }

   public boolean isEmpty() {
      return this.this$0.colGetSize() == 0;
   }

   public Iterator<V> iterator() {
      return new MapCollections$ArrayIterator(this.this$0, 1);
   }

   public boolean remove(Object var1) {
      int var2 = this.this$0.colIndexOfValue(var1);
      if(var2 >= 0) {
         this.this$0.colRemoveAt(var2);
         return true;
      } else {
         return false;
      }
   }

   public boolean removeAll(Collection<?> var1) {
      int var3 = this.this$0.colGetSize();
      boolean var6 = false;

      int var4;
      for(int var2 = 0; var2 < var3; var3 = var4) {
         var4 = var3;
         int var5 = var2;
         if(var1.contains(this.this$0.colGetEntry(var2, 1))) {
            this.this$0.colRemoveAt(var2);
            var5 = var2 - 1;
            var4 = var3 - 1;
            var6 = true;
         }

         var2 = var5 + 1;
      }

      return var6;
   }

   public boolean retainAll(Collection<?> var1) {
      int var3 = this.this$0.colGetSize();
      boolean var6 = false;

      int var4;
      for(int var2 = 0; var2 < var3; var3 = var4) {
         var4 = var3;
         int var5 = var2;
         if(!var1.contains(this.this$0.colGetEntry(var2, 1))) {
            this.this$0.colRemoveAt(var2);
            var5 = var2 - 1;
            var4 = var3 - 1;
            var6 = true;
         }

         var2 = var5 + 1;
      }

      return var6;
   }

   public int size() {
      return this.this$0.colGetSize();
   }

   public Object[] toArray() {
      return this.this$0.toArrayHelper(1);
   }

   public <T> T[] toArray(T[] var1) {
      return this.this$0.toArrayHelper(var1, 1);
   }
}
