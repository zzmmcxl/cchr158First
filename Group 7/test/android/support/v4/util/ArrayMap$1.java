package android.support.v4.util;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.MapCollections;
import java.util.Map;

class ArrayMap$1 extends MapCollections<K, V> {
   ArrayMap$1(ArrayMap var1) {
      this.this$0 = var1;
   }

   protected void colClear() {
      this.this$0.clear();
   }

   protected Object colGetEntry(int var1, int var2) {
      return this.this$0.mArray[(var1 << 1) + var2];
   }

   protected Map<K, V> colGetMap() {
      return this.this$0;
   }

   protected int colGetSize() {
      return this.this$0.mSize;
   }

   protected int colIndexOfKey(Object var1) {
      return this.this$0.indexOfKey(var1);
   }

   protected int colIndexOfValue(Object var1) {
      return this.this$0.indexOfValue(var1);
   }

   protected void colPut(K var1, V var2) {
      this.this$0.put(var1, var2);
   }

   protected void colRemoveAt(int var1) {
      this.this$0.removeAt(var1);
   }

   protected V colSetValue(int var1, V var2) {
      return this.this$0.setValueAt(var1, var2);
   }
}
